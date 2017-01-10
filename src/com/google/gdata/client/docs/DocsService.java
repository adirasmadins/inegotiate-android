package com.google.gdata.client.docs;

import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.google.gdata.client.AuthTokenFactory;
import com.google.gdata.client.Service;
import com.google.gdata.client.Service.GDataRequestFactory;
import com.google.gdata.client.media.MediaService;
import com.google.gdata.data.acl.AclEntry;
import com.google.gdata.data.acl.AclFeed;
import com.google.gdata.data.acl.AclRole;
import com.google.gdata.data.acl.AclScope;
import com.google.gdata.data.batch.BatchUtils;
import com.google.gdata.data.docs.AudioEntry;
import com.google.gdata.data.docs.DocumentEntry;
import com.google.gdata.data.docs.DocumentExportEntry;
import com.google.gdata.data.docs.DocumentExportFeed;
import com.google.gdata.data.docs.DocumentListFeed;
import com.google.gdata.data.docs.FolderEntry;
import com.google.gdata.data.docs.MetadataFeed;
import com.google.gdata.data.docs.PdfEntry;
import com.google.gdata.data.docs.PresentationEntry;
import com.google.gdata.data.docs.QueryParameter;
import com.google.gdata.data.docs.RevisionFeed;
import com.google.gdata.data.docs.SpreadsheetEntry;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.Version;
import com.google.gdata.util.VersionRegistry;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class DocsService extends MediaService {
    public static final Version DEFAULT_VERSION;
    public static final String DOCS_SERVICE = "writely";
    public static final String DOCS_SERVICE_VERSION;

    public static final class Versions {
        public static final Version V1;
        public static final Version V2;
        public static final Version V3;

        static {
            V1 = new Version(DocsService.class, XMLStreamWriterImpl.DEFAULT_XML_VERSION, com.google.gdata.client.Service.Versions.V1);
            V2 = new Version(DocsService.class, "2.0", com.google.gdata.client.Service.Versions.V2);
            V3 = new Version(DocsService.class, "3.0", com.google.gdata.client.Service.Versions.V2);
        }

        private Versions() {
        }
    }

    static {
        DOCS_SERVICE_VERSION = "GDocs-Java/" + DocsService.class.getPackage().getImplementationVersion();
        DEFAULT_VERSION = Service.initServiceVersion(DocsService.class, Versions.V3);
    }

    public DocsService(String applicationName) {
        super(DOCS_SERVICE, applicationName);
        declareExtensions();
    }

    public DocsService(String applicationName, GDataRequestFactory requestFactory, AuthTokenFactory authTokenFactory) {
        super(applicationName, requestFactory, authTokenFactory);
        declareExtensions();
    }

    public DocsService(String applicationName, String protocol, String domainName) {
        super(DOCS_SERVICE, applicationName, protocol, domainName);
        declareExtensions();
    }

    public String getServiceVersion() {
        return DOCS_SERVICE_VERSION + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + super.getServiceVersion();
    }

    public static Version getVersion() {
        return VersionRegistry.get().getVersion(DocsService.class);
    }

    private void declareExtensions() {
        new AclFeed().declareExtensions(this.extProfile);
        new DocumentExportFeed().declareExtensions(this.extProfile);
        new MetadataFeed().declareExtensions(this.extProfile);
        new RevisionFeed().declareExtensions(this.extProfile);
        this.extProfile.setAutoExtending(true);
        new AudioEntry().declareExtensions(this.extProfile);
        new DocumentEntry().declareExtensions(this.extProfile);
        new DocumentListFeed().declareExtensions(this.extProfile);
        new FolderEntry().declareExtensions(this.extProfile);
        new PdfEntry().declareExtensions(this.extProfile);
        new PresentationEntry().declareExtensions(this.extProfile);
        new SpreadsheetEntry().declareExtensions(this.extProfile);
        BatchUtils.declareExtensions(this.extProfile);
    }

    public void addExtensions() {
        declareExtensions();
    }

    public AclEntry insert(URL aclFeedUrl, AclScope scope, AclRole role) throws IOException, ServiceException {
        AclEntry entry = new AclEntry();
        entry.setScope(scope);
        entry.setRole(role);
        return (AclEntry) insert(aclFeedUrl, entry);
    }

    public AclEntry update(URL aclFeedUrl, AclScope scope, AclRole role) throws IOException, ServiceException {
        URL entryUrl = makeEntryUrl(aclFeedUrl, scope);
        AclEntry entry = new AclEntry();
        entry.setScope(scope);
        entry.setRole(role);
        entry.setId(entryUrl.toExternalForm());
        return (AclEntry) update(entryUrl, entry);
    }

    public void delete(URL aclFeedUrl, AclScope scope) throws IOException, ServiceException {
        delete(makeEntryUrl(aclFeedUrl, scope));
    }

    private URL makeEntryUrl(URL aclFeedUrl, AclScope scope) throws IOException {
        try {
            return new URI(aclFeedUrl.getProtocol(), null, aclFeedUrl.getHost(), aclFeedUrl.getPort(), aclFeedUrl.getPath() + "/" + scope.toExternalForm(), null, null).toURL();
        } catch (URISyntaxException e) {
            throw new IOException();
        }
    }

    public DocumentExportEntry insert(URL exportFeedUrl, List<QueryParameter> params) throws IOException, ServiceException {
        DocumentExportEntry entry = new DocumentExportEntry();
        for (QueryParameter param : params) {
            entry.addQuery(param);
        }
        return (DocumentExportEntry) insert(exportFeedUrl, entry);
    }
}
