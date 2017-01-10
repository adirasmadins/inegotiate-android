package com.google.gdata.client;

import com.google.common.net.HttpHeaders;
import com.google.gdata.client.AuthTokenFactory.AuthToken;
import com.google.gdata.client.GDataProtocol.Header;
import com.google.gdata.client.GDataProtocol.Parameter;
import com.google.gdata.client.batch.BatchInterruptedException;
import com.google.gdata.client.http.HttpGDataRequest.Factory;
import com.google.gdata.data.AbstractExtension;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Feed;
import com.google.gdata.data.IAtom;
import com.google.gdata.data.IEntry;
import com.google.gdata.data.IFeed;
import com.google.gdata.data.ILink;
import com.google.gdata.data.ParseSource;
import com.google.gdata.data.introspection.IServiceDocument;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.MetadataContext;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.Schema;
import com.google.gdata.model.batch.BatchUtils;
import com.google.gdata.model.transforms.atom.AtomVersionTransforms;
import com.google.gdata.model.transforms.atompub.AtompubVersionTransforms;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.Version;
import com.google.gdata.util.VersionRegistry;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.util.common.net.UriParameterMap;
import com.google.gdata.wireformats.AltFormat;
import com.google.gdata.wireformats.AltRegistry;
import com.google.gdata.wireformats.StreamProperties;
import com.google.gdata.wireformats.input.AtomDualParser;
import com.google.gdata.wireformats.input.AtomServiceDualParser;
import com.google.gdata.wireformats.input.InputParser;
import com.google.gdata.wireformats.input.InputProperties;
import com.google.gdata.wireformats.output.AtomDualGenerator;
import com.google.gdata.wireformats.output.AtomServiceDualGenerator;
import com.google.gdata.wireformats.output.OutputGenerator;
import com.google.gdata.wireformats.output.OutputProperties;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

public class Service {
    private static final AltRegistry BASE_REGISTRY;
    private static final Version CORE_VERSION;
    private static final String SERVICE_VERSION;
    private AltRegistry altRegistry;
    protected int connectTimeout;
    private ContentType contentType;
    protected ExtensionProfile extProfile;
    protected final MetadataRegistry metadataRegistry;
    private Version protocolVersion;
    int readTimeout;
    protected GDataRequestFactory requestFactory;
    private boolean strictValidation;

    protected abstract class ClientStreamProperties implements StreamProperties {
        protected final UriParameterMap queryMap;
        protected final GDataRequest req;

        protected ClientStreamProperties(GDataRequest req) {
            this.queryMap = Service.computeQueryMap(req);
            this.req = req;
        }

        protected ClientStreamProperties() {
            this.queryMap = UriParameterMap.EMPTY_MAP;
            this.req = null;
        }

        public GDataRequest getGDataRequest() {
            return this.req;
        }

        public Version getRequestVersion() {
            return Service.this.getProtocolVersion();
        }

        public AltRegistry getAltRegistry() {
            return Service.this.getAltRegistry();
        }

        public boolean isPartial() {
            return false;
        }

        public ExtensionProfile getExtensionProfile() {
            return Service.this.getExtensionProfile();
        }

        protected MetadataContext getMetadataContext() {
            return MetadataContext.forContext(getAltFormat(), null, Service.this.getProtocolVersion());
        }

        public Collection<String> getQueryParameterNames() {
            return this.queryMap.keySet();
        }

        public String getQueryParameter(String name) {
            return this.queryMap.getFirst(name);
        }

        protected AltFormat getAltFormat() {
            AltFormat altFormat = getAltRegistry().lookupName(this.queryMap.getFirst(Parameter.ALT));
            return altFormat != null ? altFormat : AltFormat.ATOM;
        }

        protected UriParameterMap getParameterMap() {
            return this.queryMap;
        }
    }

    protected class ClientInputProperties extends ClientStreamProperties implements InputProperties {
        private ElementMetadata<?, ?> elementMetadata;
        private final Class<?> expectType;
        protected final ContentType inputType;

        protected ClientInputProperties(GDataRequest req, Class<?> expectType) throws IOException, ServiceException {
            super(req);
            this.expectType = expectType;
            this.inputType = req.getResponseContentType();
            init();
        }

        protected ClientInputProperties(ContentType inputType, Class<?> expectType) throws IOException, ServiceException {
            super();
            this.expectType = expectType;
            this.inputType = inputType;
            init();
        }

        private void init() {
            if (Element.class.isAssignableFrom(this.expectType)) {
                this.elementMetadata = Service.this.getSchema().bind(Element.getDefaultKey(this.expectType.asSubclass(Element.class)), getMetadataContext());
                return;
            }
            this.elementMetadata = null;
        }

        public ContentType getContentType() {
            return this.inputType;
        }

        public Class<?> getRootType() {
            return this.expectType;
        }

        public ElementMetadata<?, ?> getRootMetadata() {
            return this.elementMetadata;
        }

        public boolean isPartial() {
            return getQueryParameter(Parameter.FIELDS) != null;
        }
    }

    public class ClientOutputProperties extends ClientStreamProperties implements OutputProperties {
        private ElementMetadata<?, ?> elementMetadata;
        protected final ContentType requestType;

        public ClientOutputProperties(GDataRequest req, Object source) {
            super(req);
            this.requestType = req.getRequestContentType();
            init(source);
        }

        public ClientOutputProperties(ContentType requestType, Object source) {
            super();
            this.requestType = requestType;
            init(source);
        }

        private void init(Object source) {
            if (source instanceof Element) {
                this.elementMetadata = Service.this.getSchema().bind(((Element) source).getElementKey(), getMetadataContext());
                return;
            }
            this.elementMetadata = null;
        }

        public ContentType getContentType() {
            return this.requestType;
        }

        public ElementMetadata<?, ?> getRootMetadata() {
            return this.elementMetadata;
        }

        public String getCallback() {
            return null;
        }
    }

    public interface GDataRequest {

        public enum RequestType {
            QUERY,
            INSERT,
            UPDATE,
            PATCH,
            DELETE,
            BATCH
        }

        void end();

        void execute() throws IOException, ServiceException;

        ParseSource getParseSource() throws IOException, ServiceException;

        ContentType getRequestContentType();

        OutputStream getRequestStream() throws IOException;

        URL getRequestUrl();

        ContentType getResponseContentType() throws IOException, ServiceException;

        DateTime getResponseDateHeader(String str);

        String getResponseHeader(String str);

        InputStream getResponseStream() throws IOException;

        void setConnectTimeout(int i);

        void setEtag(String str);

        void setHeader(String str, String str2);

        void setIfModifiedSince(DateTime dateTime);

        void setPrivateHeader(String str, String str2);

        void setReadTimeout(int i);
    }

    public interface GDataRequestFactory {
        GDataRequest getRequest(Query query, ContentType contentType) throws IOException, ServiceException;

        GDataRequest getRequest(RequestType requestType, URL url, ContentType contentType) throws IOException, ServiceException;

        void setAuthToken(AuthToken authToken);

        void setHeader(String str, String str2);

        void setPrivateHeader(String str, String str2);
    }

    public static class Versions {
        public static final Version V1;
        public static final Version V2;
        public static final Version V2_1;
        public static final Version V2_2;
        public static final Version V3;

        static {
            V1 = new Version(Service.class, 1, 0, new Version[0]);
            V2 = new Version(Service.class, 2, 0, new Version[0]);
            V2_1 = new Version(Service.class, 2, 1, new Version[0]);
            V2_2 = new Version(Service.class, 2, 2, new Version[0]);
            V3 = new Version(Service.class, 3, 0, new Version[0]);
        }

        private Versions() {
        }
    }

    static {
        SERVICE_VERSION = "GData-Java/" + Service.class.getPackage().getImplementationVersion() + "(gzip)";
        CORE_VERSION = initServiceVersion(Service.class, Versions.V1);
        BASE_REGISTRY = new AltRegistry();
        BASE_REGISTRY.register(AltFormat.ATOM, new AtomDualParser(), new AtomDualGenerator());
        BASE_REGISTRY.register(AltFormat.ATOM_SERVICE, new AtomServiceDualParser(), new AtomServiceDualGenerator());
        BASE_REGISTRY.register(AltFormat.APPLICATION_XML, null, new AtomDualGenerator(AltFormat.APPLICATION_XML));
        BASE_REGISTRY.lock();
    }

    protected static Version initServiceVersion(Class<? extends Service> serviceClass, Version defaultVersion) {
        VersionRegistry versionRegistry = VersionRegistry.ensureRegistry();
        Version v = null;
        try {
            v = versionRegistry.getVersion(serviceClass);
        } catch (IllegalStateException e) {
            try {
                v = VersionRegistry.getVersionFromProperty(serviceClass);
            } catch (SecurityException e2) {
            }
            if (v == null) {
                v = defaultVersion;
            }
            versionRegistry.addDefaultVersion(v, false);
        }
        return v;
    }

    public static Version getVersion() {
        return VersionRegistry.get().getVersion(Service.class);
    }

    private static Version initProtocolVersion(Class<? extends Service> serviceClass) {
        Class<? extends Service> checkClass = serviceClass;
        VersionRegistry registry = VersionRegistry.get();
        while (checkClass != Service.class) {
            try {
                return registry.getVersion(checkClass);
            } catch (IllegalStateException e) {
                checkClass = checkClass.getSuperclass();
            }
        }
        try {
            return getVersion();
        } catch (IllegalStateException e2) {
            return CORE_VERSION;
        }
    }

    public Service() {
        this.extProfile = new ExtensionProfile();
        this.requestFactory = new Factory();
        this.contentType = ContentType.ATOM;
        this.connectTimeout = -1;
        this.readTimeout = -1;
        this.altRegistry = BASE_REGISTRY;
        this.strictValidation = true;
        this.requestFactory.setHeader(HttpHeaders.USER_AGENT, getServiceVersion());
        this.protocolVersion = initProtocolVersion(getClass());
        new Feed().declareExtensions(this.extProfile);
        this.metadataRegistry = new MetadataRegistry();
        com.google.gdata.model.atom.Feed.registerMetadata(this.metadataRegistry);
        AtomVersionTransforms.addTransforms(this.metadataRegistry);
        AtompubVersionTransforms.addTransforms(this.metadataRegistry);
    }

    public static AltRegistry getDefaultAltRegistry() {
        return BASE_REGISTRY;
    }

    public Version getProtocolVersion() {
        return this.protocolVersion;
    }

    public void setProtocolVersion(Version v) {
        if (this.protocolVersion.getServiceClass().equals(v.getServiceClass())) {
            this.protocolVersion = v;
            return;
        }
        throw new IllegalArgumentException("Invalid service class, was: " + v.getServiceClass() + ", expected: " + this.protocolVersion.getServiceClass());
    }

    protected void startVersionScope() {
        VersionRegistry.get().setThreadVersion(this.protocolVersion);
    }

    protected void endVersionScope() {
        VersionRegistry.get().resetThreadVersion();
    }

    public String getServiceVersion() {
        return SERVICE_VERSION;
    }

    public ExtensionProfile getExtensionProfile() {
        return this.extProfile;
    }

    public void setExtensionProfile(ExtensionProfile v) {
        this.extProfile = v;
    }

    public MetadataRegistry getMetadataRegistry() {
        return this.metadataRegistry;
    }

    public Schema getSchema() {
        return this.metadataRegistry.createSchema();
    }

    public GDataRequestFactory getRequestFactory() {
        return this.requestFactory;
    }

    public void setRequestFactory(GDataRequestFactory requestFactory) {
        this.requestFactory = requestFactory;
    }

    public void setHeader(String header, String value) {
        getRequestFactory().setHeader(header, value);
    }

    public void setPrivateHeader(String header, String value) {
        getRequestFactory().setPrivateHeader(header, value);
    }

    public void setOAuthProxyHeaders(Map<String, String> headers) {
        for (String key : headers.keySet()) {
            setHeader(key, (String) headers.get(key));
        }
    }

    public void useSsl() {
        if (this.requestFactory instanceof Factory) {
            ((Factory) this.requestFactory).useSsl();
            return;
        }
        throw new UnsupportedOperationException("Not a http transport");
    }

    public void setAcceptLanguage(String acceptedLanguages) {
        this.requestFactory.setHeader(Header.ACCEPT_LANGUAGE, acceptedLanguages);
    }

    public GDataRequest createRequest(RequestType type, URL requestUrl, ContentType inputType) throws IOException, ServiceException {
        GDataRequest request = this.requestFactory.getRequest(type, requestUrl, inputType);
        setTimeouts(request);
        return request;
    }

    protected GDataRequest createRequest(Query query, ContentType inputType) throws IOException, ServiceException {
        GDataRequest request = this.requestFactory.getRequest(query, inputType);
        setTimeouts(request);
        return request;
    }

    public void setTimeouts(GDataRequest request) {
        if (this.connectTimeout >= 0) {
            request.setConnectTimeout(this.connectTimeout);
        }
        if (this.readTimeout >= 0) {
            request.setReadTimeout(this.readTimeout);
        }
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public void setConnectTimeout(int timeout) {
        if (timeout < 0) {
            throw new IllegalArgumentException("Timeout value cannot be negative");
        }
        this.connectTimeout = timeout;
    }

    public void setReadTimeout(int timeout) {
        if (timeout < 0) {
            throw new IllegalArgumentException("Timeout value cannot be negative");
        }
        this.readTimeout = timeout;
    }

    public AltRegistry getAltRegistry() {
        return this.altRegistry;
    }

    public void setAltRegistry(AltRegistry altRegistry) {
        this.altRegistry = altRegistry;
    }

    public boolean getStrictValidation() {
        return this.strictValidation;
    }

    public void setStrictValidation(boolean strictValidation) {
        this.strictValidation = strictValidation;
    }

    protected <T> Class<T> classOf(T object) {
        return object.getClass();
    }

    public <S extends IServiceDocument> S introspect(URL feedUrl, Class<S> serviceClass) throws IOException, ServiceException {
        String feedQuery = feedUrl.getQuery();
        String altParam = "alt=" + AltFormat.ATOM_SERVICE.getName();
        if (feedQuery == null || feedQuery.indexOf(altParam) == -1) {
            feedUrl = new URL(feedUrl.toString() + (feedQuery == null ? '?' : '&') + altParam);
        }
        GDataRequest request = createFeedRequest(feedUrl);
        try {
            startVersionScope();
            request.execute();
            IServiceDocument iServiceDocument = (IServiceDocument) parseResponseData(request, serviceClass);
            return iServiceDocument;
        } finally {
            endVersionScope();
            request.end();
        }
    }

    public <F extends IFeed> F getFeed(URL feedUrl, Class<F> feedClass, DateTime ifModifiedSince) throws IOException, ServiceException {
        return getFeed(createFeedRequest(feedUrl), (Class) feedClass, ifModifiedSince);
    }

    public <F extends IFeed> F getFeed(URL feedUrl, Class<F> feedClass, String etag) throws IOException, ServiceException {
        return getFeed(createFeedRequest(feedUrl), (Class) feedClass, etag);
    }

    public <F extends IFeed> F getFeed(URL feedUrl, Class<F> feedClass) throws IOException, ServiceException {
        return getFeed(feedUrl, (Class) feedClass, (String) null);
    }

    public <F extends IFeed> F getFeed(Query query, Class<F> feedClass) throws IOException, ServiceException {
        return getFeed(query, (Class) feedClass, (String) null);
    }

    public <F extends IFeed> F getFeed(Query query, Class<F> feedClass, DateTime ifModifiedSince) throws IOException, ServiceException {
        return getFeed(createFeedRequest(query), (Class) feedClass, ifModifiedSince);
    }

    public <F extends IFeed> F getFeed(Query query, Class<F> feedClass, String etag) throws IOException, ServiceException {
        return getFeed(createFeedRequest(query), (Class) feedClass, etag);
    }

    private <F extends IFeed> F getFeed(GDataRequest request, Class<F> feedClass, DateTime ifModifiedSince) throws IOException, ServiceException {
        try {
            startVersionScope();
            request.setIfModifiedSince(ifModifiedSince);
            request.execute();
            IFeed iFeed = (IFeed) parseResponseData(request, feedClass);
            return iFeed;
        } finally {
            endVersionScope();
            request.end();
        }
    }

    private <F extends IFeed> F getFeed(GDataRequest request, Class<F> feedClass, String etag) throws IOException, ServiceException {
        try {
            startVersionScope();
            request.setEtag(etag);
            request.execute();
            IFeed iFeed = (IFeed) parseResponseData(request, feedClass);
            return iFeed;
        } finally {
            endVersionScope();
            request.end();
        }
    }

    public GDataRequest createFeedRequest(URL feedUrl) throws IOException, ServiceException {
        return createRequest(RequestType.QUERY, feedUrl, this.contentType);
    }

    public <F extends IFeed> F query(Query query, Class<F> feedClass) throws IOException, ServiceException {
        return query(query, (Class) feedClass, (String) null);
    }

    public <F extends IFeed> F query(Query query, Class<F> feedClass, DateTime ifModifiedSince) throws IOException, ServiceException {
        return getFeed(query, (Class) feedClass, ifModifiedSince);
    }

    public <F extends IFeed> F query(Query query, Class<F> feedClass, String etag) throws IOException, ServiceException {
        return getFeed(query, (Class) feedClass, etag);
    }

    public GDataRequest createFeedRequest(Query query) throws IOException, ServiceException {
        return createRequest(query, this.contentType);
    }

    public <E extends IEntry> E getEntry(URL entryUrl, Class<E> entryClass) throws IOException, ServiceException {
        return getEntry(entryUrl, (Class) entryClass, (String) null);
    }

    public <E extends IEntry> E getEntry(URL entryUrl, Class<E> entryClass, DateTime ifModifiedSince) throws IOException, ServiceException {
        GDataRequest request = createEntryRequest(entryUrl);
        try {
            startVersionScope();
            request.setIfModifiedSince(ifModifiedSince);
            request.execute();
            IEntry iEntry = (IEntry) parseResponseData(request, entryClass);
            return iEntry;
        } finally {
            endVersionScope();
            request.end();
        }
    }

    public <E extends IEntry> E getEntry(URL entryUrl, Class<E> entryClass, String etag) throws IOException, ServiceException {
        GDataRequest request = createEntryRequest(entryUrl);
        try {
            startVersionScope();
            request.setEtag(etag);
            request.execute();
            IEntry iEntry = (IEntry) parseResponseData(request, entryClass);
            return iEntry;
        } finally {
            endVersionScope();
            request.end();
        }
    }

    public GDataRequest createEntryRequest(URL entryUrl) throws IOException, ServiceException {
        return createRequest(RequestType.QUERY, entryUrl, this.contentType);
    }

    public <E extends IEntry> E insert(URL feedUrl, E entry) throws IOException, ServiceException {
        if (entry == null) {
            throw new NullPointerException("Must supply entry");
        }
        GDataRequest request = createInsertRequest(feedUrl);
        try {
            startVersionScope();
            writeRequestData(request, entry);
            request.execute();
            IEntry iEntry = (IEntry) parseResponseData(request, classOf(entry));
            return iEntry;
        } finally {
            endVersionScope();
            request.end();
        }
    }

    public <F extends IFeed> F batch(URL feedUrl, F inputFeed) throws IOException, ServiceException, BatchInterruptedException {
        GDataRequest request = createInsertRequest(feedUrl);
        try {
            startVersionScope();
            writeRequestData(request, inputFeed);
            request.execute();
            IFeed resultFeed = (IFeed) parseResponseData(request, classOf(inputFeed));
            int count = resultFeed.getEntries().size();
            BatchUtils.throwIfInterrupted(resultFeed);
            return resultFeed;
        } finally {
            endVersionScope();
            request.end();
        }
    }

    public GDataRequest createInsertRequest(URL feedUrl) throws IOException, ServiceException {
        return createRequest(RequestType.INSERT, feedUrl, this.contentType);
    }

    public GDataRequest createBatchRequest(URL feedUrl) throws IOException, ServiceException {
        return createRequest(RequestType.BATCH, feedUrl, this.contentType);
    }

    public <E extends IEntry> E update(URL entryUrl, E entry) throws IOException, ServiceException {
        String etag = entry.getEtag();
        if (GDataProtocol.isWeakEtag(etag)) {
            etag = null;
        }
        return update(entryUrl, entry, etag);
    }

    public <E extends IEntry> E update(URL entryUrl, E entry, String etag) throws IOException, ServiceException {
        GDataRequest request = createUpdateRequest(entryUrl);
        try {
            startVersionScope();
            request.setEtag(etag);
            writeRequestData(request, entry);
            request.execute();
            IEntry iEntry = (IEntry) parseResponseData(request, classOf(entry));
            return iEntry;
        } finally {
            endVersionScope();
            request.end();
        }
    }

    public GDataRequest createUpdateRequest(URL entryUrl) throws IOException, ServiceException {
        return createRequest(RequestType.UPDATE, entryUrl, this.contentType);
    }

    public <E extends IEntry> E patch(URL entryUrl, String fields, E entry) throws IOException, ServiceException {
        String etag = null;
        if (entry != null) {
            etag = entry.getEtag();
            if (GDataProtocol.isWeakEtag(etag)) {
                etag = null;
            }
        }
        return patch(entryUrl, fields, entry, etag);
    }

    public <E extends IEntry> E patch(URL entryUrl, String fields, E entry, String etag) throws IOException, ServiceException {
        GDataRequest request = createPatchRequest(entryUrl);
        try {
            startVersionScope();
            request.setEtag(etag);
            entry.setSelectedFields(fields);
            writeRequestData(request, entry);
            request.execute();
            IEntry iEntry = (IEntry) parseResponseData(request, classOf(entry));
            return iEntry;
        } finally {
            endVersionScope();
            request.end();
        }
    }

    public GDataRequest createPatchRequest(URL entryUrl) throws IOException, ServiceException {
        return createRequest(RequestType.PATCH, entryUrl, ContentType.APPLICATION_XML);
    }

    public void delete(URL resourceUrl) throws IOException, ServiceException {
        delete(resourceUrl, null);
    }

    public void delete(URI resourceUri) throws IOException, ServiceException {
        delete(resourceUri.toURL(), null);
    }

    public void delete(URL resourceUrl, String etag) throws IOException, ServiceException {
        GDataRequest request = createDeleteRequest(resourceUrl);
        try {
            startVersionScope();
            request.setEtag(etag);
            request.execute();
        } finally {
            request.end();
        }
    }

    public void delete(URI resourceUri, String etag) throws IOException, ServiceException {
        delete(resourceUri.toURL(), etag);
    }

    public GDataRequest createDeleteRequest(URL entryUrl) throws IOException, ServiceException {
        return createRequest(RequestType.DELETE, entryUrl, this.contentType);
    }

    @Deprecated
    public InputStream getStreamFromLink(ILink link) throws IOException, ServiceException {
        GDataRequest request = createLinkQueryRequest(link);
        request.execute();
        return request.getResponseStream();
    }

    public GDataRequest createLinkQueryRequest(ILink link) throws IOException, ServiceException {
        return createRequest(RequestType.QUERY, new URL(link.getHref()), null);
    }

    public void writeRequestData(GDataRequest req, Object source) throws IOException {
        writeRequestData(req, new ClientOutputProperties(req, source), source);
    }

    protected void writeRequestData(GDataRequest req, ClientOutputProperties outProps, Object source) throws IOException {
        AltFormat outputFormat = this.altRegistry.lookupType(outProps.getContentType());
        if (outputFormat == null) {
            outputFormat = this.altRegistry.lookupName(AltFormat.MEDIA.getName());
        }
        if (outputFormat == null) {
            throw new IllegalStateException("Unsupported request type: " + outProps.getContentType());
        }
        OutputGenerator<?> generator = this.altRegistry.getGenerator(outputFormat);
        if (generator.getSourceType().isAssignableFrom(source.getClass())) {
            OutputGenerator<Object> typedGenerator = generator;
            boolean disableValidation = !this.strictValidation || outputFormat.equals(AltFormat.APPLICATION_XML);
            if (disableValidation) {
                AbstractExtension.disableStrictValidation();
            }
            try {
                typedGenerator.generate(req.getRequestStream(), outProps, source);
                if (disableValidation) {
                    AbstractExtension.enableStrictValidation();
                }
            } catch (Throwable th) {
                if (disableValidation) {
                    AbstractExtension.enableStrictValidation();
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid source type: expected: " + generator.getSourceType() + " but got: " + source.getClass() + " for output format " + outputFormat);
        }
    }

    public <E> E parseResponseData(GDataRequest req, Class<E> resultType) throws IOException, ServiceException {
        return parseResponseData(req.getParseSource(), new ClientInputProperties(req, (Class) resultType), (Class) resultType);
    }

    protected <E> E parseResponseData(ParseSource source, ContentType responseType, Class<E> resultType) throws IOException, ServiceException {
        return parseResponseData(source, new ClientInputProperties(responseType, (Class) resultType), (Class) resultType);
    }

    private <E> E parseResponseData(ParseSource source, InputProperties inputProperties, Class<E> resultType) throws IOException, ServiceException {
        Preconditions.checkNotNull("resultType", resultType);
        AltFormat inputFormat = null;
        String alt = inputProperties.getQueryParameter(Parameter.ALT);
        if (alt != null) {
            inputFormat = this.altRegistry.lookupName(alt);
        }
        if (inputFormat == null) {
            inputFormat = this.altRegistry.lookupType(inputProperties.getContentType());
            if (inputFormat == null) {
                throw new ParseException("Unrecognized content type:" + inputProperties.getContentType());
            }
        }
        InputParser<?> inputParser = this.altRegistry.getParser(inputFormat);
        if (inputParser == null) {
            throw new ParseException("No parser for content type:" + inputFormat);
        } else if (inputParser.getResultType().isAssignableFrom(resultType)) {
            InputParser<E> typedParser = inputParser;
            boolean disableValidation = (this.strictValidation && (inputProperties.getQueryParameter(Parameter.FIELDS) == null || Element.class.isAssignableFrom(resultType))) ? false : true;
            if (disableValidation) {
                AbstractExtension.disableStrictValidation();
            }
            try {
                E result = typedParser.parse(source, inputProperties, resultType);
                if (result instanceof IAtom) {
                    ((IAtom) result).setService(this);
                }
                return result;
            } finally {
                if (disableValidation) {
                    AbstractExtension.enableStrictValidation();
                }
            }
        } else {
            throw new IllegalStateException("Input parser (" + inputParser + ") does not produce expected result type: " + resultType);
        }
    }

    private static UriParameterMap computeQueryMap(GDataRequest req) {
        String query = req.getRequestUrl().getQuery();
        if (query == null) {
            return UriParameterMap.EMPTY_MAP;
        }
        return UriParameterMap.parse(query);
    }
}
