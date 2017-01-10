package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.model.gd.Reminder.Method;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.xml.sax.Attributes;

public class Person extends ExtensionPoint implements IPerson {
    protected String email;
    protected String name;
    protected String nameLang;
    protected String uri;

    public class AtomHandler extends ExtensionHandler {

        class EmailHandler extends ElementHandler {
            EmailHandler() {
            }

            public void processEndElement() throws ParseException {
                if (Person.this.email != null) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateEmail);
                } else if (this.value == null) {
                    throw new ParseException(CoreErrorDomain.ERR.emailValueRequired);
                } else {
                    Person.this.email = this.value;
                }
            }
        }

        class NameHandler extends ElementHandler {
            NameHandler() {
            }

            public void processEndElement() throws ParseException {
                if (Person.this.name != null) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateName);
                } else if (this.value == null) {
                    throw new ParseException(CoreErrorDomain.ERR.nameValueRequired);
                } else {
                    Person.this.name = this.value;
                    Person.this.nameLang = this.xmlLang;
                }
            }
        }

        class UriHandler extends ElementHandler {
            UriHandler() {
            }

            public void processEndElement() throws ParseException {
                if (Person.this.uri != null) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateUri);
                } else if (this.value == null) {
                    throw new ParseException(CoreErrorDomain.ERR.uriValueRequired);
                } else {
                    Person.this.uri = this.value;
                }
            }
        }

        public AtomHandler(ExtensionProfile extProfile) {
            super(Person.this, extProfile, Person.this.getClass());
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (!namespace.equals(Namespaces.atom)) {
                return super.getChildHandler(namespace, localName, attrs);
            }
            if (localName.equals("name")) {
                return new NameHandler();
            }
            if (localName.equals("uri")) {
                return new UriHandler();
            }
            if (localName.equals(Method.EMAIL)) {
                return new EmailHandler();
            }
            return null;
        }
    }

    public Person(String name) {
        if (name == null) {
            throw new NullPointerException("Name must have a value");
        }
        this.name = name;
    }

    public Person(String name, String uri, String email) {
        this(name);
        this.uri = uri;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String v) {
        this.name = v;
    }

    public String getNameLang() {
        return this.nameLang;
    }

    public void setNameLang(String v) {
        this.nameLang = v;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String v) {
        this.uri = v;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String v) {
        this.email = v;
    }

    public void generate(ExtensionProfile extProfile, XmlWriter w, XmlNamespace elementNamespace, String elementName, Collection<Attribute> attributes) throws IOException {
        generateStartElement(w, elementNamespace, elementName, attributes, null);
        if (this.name != null && this.name.trim().length() > 0) {
            ArrayList<Attribute> attrs;
            if (this.nameLang != null) {
                attrs = new ArrayList(1);
                attrs.add(new Attribute("xml:lang", this.nameLang));
            } else {
                attrs = null;
            }
            w.simpleElement(Namespaces.atomNs, "name", attrs, this.name);
        }
        if (this.uri != null && this.uri.trim().length() > 0) {
            w.simpleElement(Namespaces.atomNs, "uri", null, this.uri);
        }
        if (this.email != null && this.email.trim().length() > 0) {
            w.simpleElement(Namespaces.atomNs, Method.EMAIL, null, this.email);
        }
        generateExtensions(w, extProfile);
        w.endElement(elementNamespace, elementName);
    }

    protected void generate(XmlWriter w, ExtensionProfile p, XmlNamespace namespace, String localName, List<Attribute> attrs, AttributeGenerator generator) throws IOException {
        generate(p, w, namespace, localName, attrs);
    }

    public void generateAtom(ExtensionProfile extProfile, XmlWriter w, String elementName) throws IOException {
        generate(extProfile, w, Namespaces.atomNs, elementName, null);
    }

    public void generateRss(XmlWriter w, String elementName) throws IOException {
        String text = new String();
        if (this.email != null) {
            text = text + this.email;
        }
        if (this.name != null) {
            if (this.email != null) {
                text = text + " (";
            }
            text = text + this.name;
            if (this.email != null) {
                text = text + ")";
            }
        }
        w.simpleElement(Namespaces.rssNs, elementName, null, text);
    }

    public ElementHandler getHandler(ExtensionProfile extProfile, String namespace, String localName, Attributes attrs) {
        return new AtomHandler(extProfile);
    }
}
