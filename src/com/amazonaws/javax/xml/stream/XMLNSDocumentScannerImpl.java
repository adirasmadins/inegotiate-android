package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.util.NamespaceSupport;
import com.amazonaws.javax.xml.stream.xerces.util.XMLAttributesImpl;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.util.XMLSymbols;
import com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext;
import com.amazonaws.javax.xml.stream.xerces.xni.QName;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLComponentManager;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class XMLNSDocumentScannerImpl extends XMLDocumentScannerImpl {
    private boolean fEmptyElement;
    protected boolean fPerformValidation;
    private boolean fXmlnsDeclared;
    private XMLBufferListenerImpl listener;

    protected final class NSContentDriver extends ContentDriver {
        protected NSContentDriver() {
            super();
        }

        protected boolean scanRootElementHook() throws IOException, XNIException {
            if (!XMLNSDocumentScannerImpl.this.scanStartElement()) {
                return false;
            }
            XMLNSDocumentScannerImpl.this.setScannerState(44);
            XMLNSDocumentScannerImpl.this.setDriver(XMLNSDocumentScannerImpl.this.fTrailingMiscDriver);
            return true;
        }
    }

    public XMLNSDocumentScannerImpl() {
        this.fEmptyElement = false;
        this.listener = new XMLBufferListenerImpl();
        this.fXmlnsDeclared = false;
    }

    public void reset(PropertyManager propertyManager) {
        setPropertyManager(propertyManager);
        super.reset(propertyManager);
        try {
            if (!this.fAttributeCacheInitDone) {
                for (int i = 0; i < this.initialCacheCount; i++) {
                    this.attributeValueCache.add(new XMLString());
                    this.stringBufferCache.add(new XMLStringBuffer());
                }
                this.fAttributeCacheInitDone = true;
            }
            this.fStringBufferIndex = 0;
            this.fAttributeCacheUsedCount = 0;
            this.fEntityScanner.registerListener(this.listener);
            this.dtdGrammarUtil = null;
        } catch (RuntimeException e) {
        }
    }

    public QName getElementQName() {
        if (this.fScannerLastState == 2) {
            this.fElementQName.setValues(this.fElementStack.getLastPoppedElement());
        }
        return this.fElementQName;
    }

    protected boolean scanStartElement() throws IOException, XNIException {
        QName name;
        if (this.fSkip && !this.fAdd) {
            name = this.fElementStack.getNext();
            this.fSkip = this.fEntityScanner.skipString(name.characters);
            if (this.fSkip) {
                this.fElementStack.push();
                this.fElementQName = name;
            } else {
                this.fElementStack.reposition();
            }
        }
        if (!this.fSkip || this.fAdd) {
            this.fElementQName = this.fElementStack.nextElement();
            if (this.fBindNamespaces) {
                this.fEntityScanner.scanQName(this.fElementQName);
            } else {
                String name2 = this.fEntityScanner.scanName();
                this.fElementQName.setValues(null, name2, name2, null);
                this.fElementQName.characters = this.fEntityScanner.scannedName;
            }
        }
        if (this.fAdd) {
            this.fElementStack.matchElement(this.fElementQName);
        }
        this.fCurrentElement = this.fElementQName;
        String rawname = this.fElementQName.rawname;
        if (this.fBindNamespaces) {
            this.fNamespaceContext.pushContext();
            if (this.fScannerState == 26 && this.fPerformValidation) {
                this.fErrorReporter.reportError(XMLMessageFormatter.XML_DOMAIN, "MSG_GRAMMAR_NOT_FOUND", new Object[]{rawname}, (short) 1);
                if (this.fDoctypeName == null || !this.fDoctypeName.equals(rawname)) {
                    this.fErrorReporter.reportError(XMLMessageFormatter.XML_DOMAIN, "RootElementTypeMustMatchDoctypedecl", new Object[]{this.fDoctypeName, rawname}, (short) 1);
                }
            }
        }
        this.fEmptyElement = false;
        this.fAttributes.removeAllAttributes();
        if (!seekCloseOfStartTag()) {
            this.fReadingAttributes = true;
            this.fAttributeCacheUsedCount = 0;
            this.fStringBufferIndex = 0;
            this.fAddDefaultAttr = true;
            this.fXmlnsDeclared = false;
            do {
                scanAttribute(this.fAttributes);
            } while (!seekCloseOfStartTag());
            this.fReadingAttributes = false;
        }
        if (this.fBindNamespaces) {
            if (this.fElementQName.prefix == XMLSymbols.PREFIX_XMLNS) {
                this.fErrorReporter.reportError(XMLMessageFormatter.XMLNS_DOMAIN, "ElementXMLNSPrefix", new Object[]{this.fElementQName.rawname}, (short) 2);
            }
            this.fElementQName.uri = this.fNamespaceContext.getURI(this.fElementQName.prefix != null ? this.fElementQName.prefix : XMLSymbols.EMPTY_STRING);
            this.fCurrentElement.uri = this.fElementQName.uri;
            if (this.fElementQName.prefix == null && this.fElementQName.uri != null) {
                this.fElementQName.prefix = XMLSymbols.EMPTY_STRING;
            }
            if (this.fElementQName.prefix != null && this.fElementQName.uri == null) {
                this.fErrorReporter.reportError(XMLMessageFormatter.XMLNS_DOMAIN, "ElementPrefixUnbound", new Object[]{this.fElementQName.prefix, this.fElementQName.rawname}, (short) 2);
            }
            int length = this.fAttributes.getLength();
            for (int i = 0; i < length; i++) {
                this.fAttributes.getName(i, this.fAttributeQName);
                String aprefix = this.fAttributeQName.prefix != null ? this.fAttributeQName.prefix : XMLSymbols.EMPTY_STRING;
                String uri = this.fNamespaceContext.getURI(aprefix);
                if ((this.fAttributeQName.uri == null || this.fAttributeQName.uri != uri) && aprefix != XMLSymbols.EMPTY_STRING) {
                    this.fAttributeQName.uri = uri;
                    if (uri == null) {
                        this.fErrorReporter.reportError(XMLMessageFormatter.XMLNS_DOMAIN, "AttributePrefixUnbound", new Object[]{this.fElementQName.rawname, this.fAttributeQName.rawname, aprefix}, (short) 2);
                    }
                    this.fAttributes.setURI(i, uri);
                }
            }
            if (length > 1) {
                name = this.fAttributes.checkDuplicatesNS();
                if (name != null) {
                    if (name.uri != null) {
                        this.fErrorReporter.reportError(XMLMessageFormatter.XMLNS_DOMAIN, "AttributeNSNotUnique", new Object[]{this.fElementQName.rawname, name.localpart, name.uri}, (short) 2);
                    } else {
                        this.fErrorReporter.reportError(XMLMessageFormatter.XMLNS_DOMAIN, "AttributeNotUnique", new Object[]{this.fElementQName.rawname, name.rawname}, (short) 2);
                    }
                }
            }
        }
        if (this.fEmptyElement) {
            this.fMarkupDepth--;
            if (this.fMarkupDepth < this.fEntityStack[this.fEntityDepth - 1]) {
                reportFatalError("ElementEntityMismatch", new Object[]{this.fCurrentElement.rawname});
            }
            if (this.fDocumentHandler != null) {
                this.fDocumentHandler.emptyElement(this.fElementQName, this.fAttributes, null);
            }
            this.fScanEndElement = true;
            this.fElementStack.popElement();
        } else {
            if (this.dtdGrammarUtil != null) {
                this.dtdGrammarUtil.startElement(this.fElementQName, this.fAttributes);
            }
            if (this.fDocumentHandler != null) {
            }
        }
        return this.fEmptyElement;
    }

    private boolean seekCloseOfStartTag() throws IOException, XNIException {
        boolean sawSpace = this.fEntityScanner.skipSpaces();
        int c = this.fEntityScanner.peekChar();
        if (c == 62) {
            this.fEntityScanner.scanChar();
            return true;
        } else if (c == 47) {
            this.fEntityScanner.scanChar();
            if (!this.fEntityScanner.skipChar(62)) {
                reportFatalError("ElementUnterminated", new Object[]{this.fElementQName.rawname});
            }
            this.fEmptyElement = true;
            return true;
        } else {
            if (!(XMLScanner.isValidNameStartChar(c) && sawSpace)) {
                reportFatalError("ElementUnterminated", new Object[]{this.fElementQName.rawname});
            }
            return false;
        }
    }

    protected void scanAttribute(XMLAttributesImpl attributes) throws IOException, XNIException {
        int attrIndex;
        this.fEntityScanner.scanQName(this.fAttributeQName);
        this.fEntityScanner.skipSpaces();
        if (!this.fEntityScanner.skipChar(61)) {
            reportFatalError("EqRequiredInAttribute", new Object[]{this.fCurrentElement.rawname, this.fAttributeQName.rawname});
        }
        this.fEntityScanner.skipSpaces();
        boolean isVC = this.fHasExternalDTD && !this.fStandalone;
        XMLString tmpStr = getString();
        scanAttributeValue(tmpStr, this.fTempString2, this.fAttributeQName.rawname, attributes, 0, isVC);
        if (this.fBindNamespaces) {
            String localpart = this.fAttributeQName.localpart;
            String prefix = this.fAttributeQName.prefix != null ? this.fAttributeQName.prefix : XMLSymbols.EMPTY_STRING;
            if (prefix == XMLSymbols.PREFIX_XMLNS || (prefix == XMLSymbols.EMPTY_STRING && localpart == XMLSymbols.PREFIX_XMLNS)) {
                String uri = this.fSymbolTable.addSymbol(tmpStr.ch, tmpStr.offset, tmpStr.length);
                String value = uri;
                if (prefix == XMLSymbols.PREFIX_XMLNS && localpart == XMLSymbols.PREFIX_XMLNS) {
                    this.fErrorReporter.reportError(XMLMessageFormatter.XMLNS_DOMAIN, "CantBindXMLNS", new Object[]{this.fAttributeQName}, (short) 2);
                }
                if (uri == NamespaceContext.XMLNS_URI) {
                    this.fErrorReporter.reportError(XMLMessageFormatter.XMLNS_DOMAIN, "CantBindXMLNS", new Object[]{this.fAttributeQName}, (short) 2);
                }
                if (localpart == XMLSymbols.PREFIX_XML) {
                    if (uri != NamespaceContext.XML_URI) {
                        this.fErrorReporter.reportError(XMLMessageFormatter.XMLNS_DOMAIN, "CantBindXML", new Object[]{this.fAttributeQName}, (short) 2);
                    }
                } else if (uri == NamespaceContext.XML_URI) {
                    this.fErrorReporter.reportError(XMLMessageFormatter.XMLNS_DOMAIN, "CantBindXML", new Object[]{this.fAttributeQName}, (short) 2);
                }
                prefix = localpart != XMLSymbols.PREFIX_XMLNS ? localpart : XMLSymbols.EMPTY_STRING;
                if (uri == XMLSymbols.EMPTY_STRING && localpart != XMLSymbols.PREFIX_XMLNS) {
                    this.fErrorReporter.reportError(XMLMessageFormatter.XMLNS_DOMAIN, "EmptyPrefixedAttName", new Object[]{this.fAttributeQName}, (short) 2);
                }
                if (((NamespaceSupport) this.fNamespaceContext).containsPrefixInCurrentContext(prefix)) {
                    reportFatalError("AttributeNotUnique", new Object[]{this.fCurrentElement.rawname, this.fAttributeQName.rawname});
                }
                NamespaceContext namespaceContext = this.fNamespaceContext;
                if (uri.length() == 0) {
                    uri = null;
                }
                if (!namespaceContext.declarePrefix(prefix, uri)) {
                    if (this.fXmlnsDeclared) {
                        reportFatalError("AttributeNotUnique", new Object[]{this.fCurrentElement.rawname, this.fAttributeQName.rawname});
                    }
                    this.fXmlnsDeclared = true;
                    return;
                }
                return;
            }
        }
        if (this.fBindNamespaces) {
            attrIndex = attributes.getLength();
            attributes.addAttributeNS(this.fAttributeQName, XMLSymbols.fCDATASymbol, null);
        } else {
            int oldLen = attributes.getLength();
            attrIndex = attributes.addAttribute(this.fAttributeQName, XMLSymbols.fCDATASymbol, null);
            if (oldLen == attributes.getLength()) {
                reportFatalError("AttributeNotUnique", new Object[]{this.fCurrentElement.rawname, this.fAttributeQName.rawname});
            }
        }
        attributes.setValue(attrIndex, null, tmpStr);
        attributes.setSpecified(attrIndex, true);
        if (this.fAttributeQName.prefix != null) {
            attributes.setURI(attrIndex, this.fNamespaceContext.getURI(this.fAttributeQName.prefix));
        }
    }

    protected int scanEndElement() throws IOException, XNIException {
        QName endElementName = this.fElementStack.popElement();
        String rawname = endElementName.rawname;
        if (!this.fEntityScanner.skipString(endElementName.characters)) {
            reportFatalError("ETagRequired", new Object[]{rawname});
        }
        this.fEntityScanner.skipSpaces();
        if (!this.fEntityScanner.skipChar(62)) {
            reportFatalError("ETagUnterminated", new Object[]{rawname});
        }
        this.fMarkupDepth--;
        this.fMarkupDepth--;
        if (this.fMarkupDepth < this.fEntityStack[this.fEntityDepth - 1]) {
            reportFatalError("ElementEntityMismatch", new Object[]{rawname});
        }
        if (this.fDocumentHandler != null) {
        }
        if (this.dtdGrammarUtil != null) {
            this.dtdGrammarUtil.endElement(endElementName);
        }
        this.fScanEndElement = true;
        return this.fMarkupDepth;
    }

    public NamespaceContext getNamespaceContext() {
        return this.fNamespaceContext;
    }

    public void reset(XMLComponentManager componentManager) throws XMLConfigurationException {
        super.reset(componentManager);
        this.fPerformValidation = false;
        this.fBindNamespaces = false;
    }

    protected Driver createContentDriver() {
        return new NSContentDriver();
    }

    XMLString getString() {
        if (this.fAttributeCacheUsedCount < this.initialCacheCount || this.fAttributeCacheUsedCount < this.attributeValueCache.size()) {
            ArrayList arrayList = this.attributeValueCache;
            int i = this.fAttributeCacheUsedCount;
            this.fAttributeCacheUsedCount = i + 1;
            return (XMLString) arrayList.get(i);
        }
        XMLString str = new XMLString();
        this.fAttributeCacheUsedCount++;
        this.attributeValueCache.add(str);
        return str;
    }

    public XMLStringBuffer getDTDDecl() {
        this.fDTDDecl.append(this.fEntityScanner.getCurrentEntity().ch, this.fStartPos, this.fEndPos - this.fStartPos);
        if (this.fSeenInternalSubset) {
            this.fDTDDecl.append("]>");
        }
        return this.fDTDDecl;
    }

    public String getCharacterEncodingScheme() {
        return this.fDeclaredEncoding;
    }
}
