package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.ServiceConfigurationException;
import com.google.gdata.util.XmlParser;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import java.io.Reader;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.xml.sax.Attributes;

public class OpenSearchDescriptionDocument extends ExtensionPoint {
    protected boolean adultContent;
    protected String attribution;
    protected String contact;
    protected String description;
    protected String developer;
    protected String format;
    protected String image;
    protected String longName;
    protected String sampleSearch;
    protected String shortName;
    protected int syndicationRight;
    protected String tags;
    protected String url;

    public class Handler extends ExtensionHandler {

        private class AdultContentHandler extends ElementHandler {
            private AdultContentHandler() {
            }

            public void processEndElement() {
                if (!this.value.equals("false") && !this.value.equals("FALSE") && !this.value.equals("0") && !this.value.equals("no") && !this.value.equals("NO")) {
                    OpenSearchDescriptionDocument.this.adultContent = true;
                }
            }
        }

        private class AttributionHandler extends ElementHandler {
            private AttributionHandler() {
            }

            public void processEndElement() {
                OpenSearchDescriptionDocument.this.attribution = this.value;
            }
        }

        private class ContactHandler extends ElementHandler {
            private ContactHandler() {
            }

            public void processEndElement() {
                OpenSearchDescriptionDocument.this.contact = this.value;
            }
        }

        private class DescriptionHandler extends ElementHandler {
            private DescriptionHandler() {
            }

            public void processEndElement() {
                OpenSearchDescriptionDocument.this.description = this.value;
            }
        }

        private class DeveloperHandler extends ElementHandler {
            private DeveloperHandler() {
            }

            public void processEndElement() {
                OpenSearchDescriptionDocument.this.developer = this.value;
            }
        }

        private class FormatHandler extends ElementHandler {
            private FormatHandler() {
            }

            public void processEndElement() {
                OpenSearchDescriptionDocument.this.format = this.value;
            }
        }

        private class ImageHandler extends ElementHandler {
            private ImageHandler() {
            }

            public void processEndElement() {
                OpenSearchDescriptionDocument.this.image = this.value;
            }
        }

        private class LongNameHandler extends ElementHandler {
            private LongNameHandler() {
            }

            public void processEndElement() {
                OpenSearchDescriptionDocument.this.longName = this.value;
            }
        }

        private class SampleSearchHandler extends ElementHandler {
            private SampleSearchHandler() {
            }

            public void processEndElement() {
                OpenSearchDescriptionDocument.this.sampleSearch = this.value;
            }
        }

        private class ShortNameHandler extends ElementHandler {
            private ShortNameHandler() {
            }

            public void processEndElement() {
                OpenSearchDescriptionDocument.this.shortName = this.value;
            }
        }

        private class SyndicationRightHandler extends ElementHandler {
            private SyndicationRightHandler() {
            }

            public void processEndElement() {
                if (this.value.equalsIgnoreCase("open")) {
                    OpenSearchDescriptionDocument.this.syndicationRight = 0;
                } else if (this.value.equalsIgnoreCase("limited")) {
                    OpenSearchDescriptionDocument.this.syndicationRight = 1;
                } else if (this.value.equalsIgnoreCase("private")) {
                    OpenSearchDescriptionDocument.this.syndicationRight = 2;
                } else if (this.value.equalsIgnoreCase("closed")) {
                    OpenSearchDescriptionDocument.this.syndicationRight = 3;
                }
            }
        }

        private class TagsHandler extends ElementHandler {
            private TagsHandler() {
            }

            public void processEndElement() {
                OpenSearchDescriptionDocument.this.tags = this.value;
            }
        }

        private class UrlHandler extends ElementHandler {
            private UrlHandler() {
            }

            public void processEndElement() {
                OpenSearchDescriptionDocument.this.url = this.value;
            }
        }

        public Handler(ExtensionProfile extProfile) {
            super(OpenSearchDescriptionDocument.this, extProfile, OpenSearchDescriptionDocument.class);
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (!namespace.equals(Namespaces.getOpenSearchDescNs().getUri())) {
                return super.getChildHandler(namespace, localName, attrs);
            }
            if (localName.equals("Url")) {
                ensureNull(OpenSearchDescriptionDocument.this.url);
                return new UrlHandler();
            } else if (localName.equals("Format")) {
                ensureNull(OpenSearchDescriptionDocument.this.format);
                return new FormatHandler();
            } else if (localName.equals("ShortName")) {
                ensureNull(OpenSearchDescriptionDocument.this.shortName);
                return new ShortNameHandler();
            } else if (localName.equals("LongName")) {
                ensureNull(OpenSearchDescriptionDocument.this.longName);
                return new LongNameHandler();
            } else if (localName.equals("Description")) {
                ensureNull(OpenSearchDescriptionDocument.this.description);
                return new DescriptionHandler();
            } else if (localName.equals("Tags")) {
                ensureNull(OpenSearchDescriptionDocument.this.tags);
                return new TagsHandler();
            } else if (localName.equals("Image")) {
                ensureNull(OpenSearchDescriptionDocument.this.image);
                return new ImageHandler();
            } else if (localName.equals("SampleSearch")) {
                ensureNull(OpenSearchDescriptionDocument.this.sampleSearch);
                return new SampleSearchHandler();
            } else if (localName.equals("Developer")) {
                ensureNull(OpenSearchDescriptionDocument.this.developer);
                return new DeveloperHandler();
            } else if (localName.equals("Contact")) {
                ensureNull(OpenSearchDescriptionDocument.this.contact);
                return new ContactHandler();
            } else if (localName.equals("Attribution")) {
                ensureNull(OpenSearchDescriptionDocument.this.attribution);
                return new AttributionHandler();
            } else if (localName.equals("SyndicationRight")) {
                return new SyndicationRightHandler();
            } else {
                if (localName.equals("AdultContent")) {
                    return new AdultContentHandler();
                }
                return null;
            }
        }

        private void ensureNull(String s) throws ParseException {
            if (s != null) {
                throw new ParseException(CoreErrorDomain.ERR.duplicateValue);
            }
        }
    }

    public static class SyndicationRight {
        public static final int CLOSED = 3;
        public static final int LIMITED = 1;
        public static final int OPEN = 0;
        public static final int PRIVATE = 2;
    }

    public OpenSearchDescriptionDocument() {
        this.syndicationRight = 0;
        this.adultContent = false;
    }

    public OpenSearchDescriptionDocument(OpenSearchDescriptionDocument doc) {
        this.syndicationRight = 0;
        this.adultContent = false;
        this.url = doc.url;
        this.format = doc.format;
        this.shortName = doc.shortName;
        this.longName = doc.longName;
        this.description = doc.description;
        this.tags = doc.tags;
        this.image = doc.image;
        this.sampleSearch = doc.sampleSearch;
        this.developer = doc.developer;
        this.contact = doc.contact;
        this.attribution = doc.attribution;
        this.syndicationRight = doc.syndicationRight;
        this.adultContent = doc.adultContent;
    }

    public final String getUrl() {
        return this.url;
    }

    public void setUrl(String v) {
        this.url = v;
    }

    public final String getFormat() {
        return this.format;
    }

    public void setFormat(String v) {
        this.format = v;
    }

    public final String getShortName() {
        return this.shortName;
    }

    public void setShortName(String v) {
        this.shortName = v;
    }

    public final String getLongName() {
        return this.longName;
    }

    public void setLongName(String v) {
        this.longName = v;
    }

    public final String getDescription() {
        return this.description;
    }

    public void setDescription(String v) {
        this.description = v;
    }

    public final String getTags() {
        return this.tags;
    }

    public void setTags(String v) {
        this.tags = v;
    }

    public final String getImage() {
        return this.image;
    }

    public void setImage(String v) {
        this.image = v;
    }

    public final String getSampleSearch() {
        return this.sampleSearch;
    }

    public void setSampleSearch(String v) {
        this.sampleSearch = v;
    }

    public final String getDeveloper() {
        return this.developer;
    }

    public void setDeveloper(String v) {
        this.developer = v;
    }

    public final String getContact() {
        return this.contact;
    }

    public void setContact(String v) {
        this.contact = v;
    }

    public final String getAttribution() {
        return this.attribution;
    }

    public void setAttribution(String v) {
        this.attribution = v;
    }

    public final int getSyndicationRight() {
        return this.syndicationRight;
    }

    public void setSyndicationRight(int v) {
        this.syndicationRight = v;
    }

    public final boolean getAdultContent() {
        return this.adultContent;
    }

    public void setAdultContent(boolean v) {
        this.adultContent = v;
    }

    public void generate(XmlWriter w) throws IOException {
        String syndicationRightString;
        XmlNamespace openSearchDescNs = Namespaces.getOpenSearchDescNs();
        w.startElement(openSearchDescNs, "OpenSearchDescription", null, null);
        if (this.url != null) {
            w.simpleElement(openSearchDescNs, "Url", null, this.url);
        }
        if (this.format != null) {
            w.simpleElement(openSearchDescNs, "Format", null, this.format);
        }
        if (this.shortName != null) {
            w.simpleElement(openSearchDescNs, "ShortName", null, this.shortName);
        }
        if (this.longName != null) {
            w.simpleElement(openSearchDescNs, "LongName", null, this.longName);
        }
        if (this.description != null) {
            w.simpleElement(openSearchDescNs, "Description", null, this.description);
        }
        if (this.tags != null) {
            w.simpleElement(openSearchDescNs, "Tags", null, this.tags);
        }
        if (this.image != null) {
            w.simpleElement(openSearchDescNs, "Image", null, this.image);
        }
        if (this.sampleSearch != null) {
            w.simpleElement(openSearchDescNs, "SampleSearch", null, this.sampleSearch);
        }
        if (this.developer != null) {
            w.simpleElement(openSearchDescNs, "Developer", null, this.developer);
        }
        if (this.contact != null) {
            w.simpleElement(openSearchDescNs, "Contact", null, this.contact);
        }
        if (this.attribution != null) {
            w.simpleElement(openSearchDescNs, "Attribution", null, this.attribution);
        }
        switch (this.syndicationRight) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                syndicationRightString = "limited";
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                syndicationRightString = "private";
                break;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                syndicationRightString = "closed";
                break;
            default:
                syndicationRightString = "open";
                break;
        }
        w.simpleElement(openSearchDescNs, "SyndicationRight", null, syndicationRightString);
        if (this.adultContent) {
            w.simpleElement(openSearchDescNs, "AdultContent", null, "true");
        }
        w.endElement(openSearchDescNs, "OpenSearchDescription");
    }

    public void validateConfiguration() throws ServiceConfigurationException {
        if (this.format == null) {
            throw new ServiceConfigurationException(CoreErrorDomain.ERR.missingFormat);
        } else if (this.shortName == null) {
            throw new ServiceConfigurationException(CoreErrorDomain.ERR.missingShortName);
        } else if (this.description == null) {
            throw new ServiceConfigurationException(CoreErrorDomain.ERR.missingDescription);
        } else if (this.tags == null) {
            throw new ServiceConfigurationException(CoreErrorDomain.ERR.missingTags);
        } else if (this.contact == null) {
            throw new ServiceConfigurationException(CoreErrorDomain.ERR.missingContact);
        }
    }

    public void parse(ExtensionProfile extProfile, Reader reader) throws IOException, ParseException {
        new XmlParser().parse(reader, new Handler(extProfile), Namespaces.getOpenSearchDescNs().getUri(), "OpenSearchDescription");
    }
}
