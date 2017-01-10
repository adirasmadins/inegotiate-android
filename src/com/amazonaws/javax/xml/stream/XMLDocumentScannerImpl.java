package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.XMLConstants;
import com.amazonaws.javax.xml.stream.Entity.ScannedEntity;
import com.amazonaws.javax.xml.stream.dtd.DTDGrammarUtil;
import com.amazonaws.javax.xml.stream.xerces.util.NamespaceSupport;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XMLString;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLComponentManager;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLConfigurationException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLDTDScanner;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import com.paypal.android.MEP.PayPal;
import java.io.EOFException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class XMLDocumentScannerImpl extends XMLDocumentFragmentScannerImpl {
    public static final char[] COMMENTSTRING;
    protected static final String DISALLOW_DOCTYPE_DECL_FEATURE = "http://apache.org/xml/features/disallow-doctype-decl";
    public static final char[] DOCTYPE;
    protected static final String DTD_SCANNER = "http://apache.org/xml/properties/internal/dtd-scanner";
    private static final Boolean[] FEATURE_DEFAULTS;
    protected static final String LOAD_EXTERNAL_DTD = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
    private static final Object[] PROPERTY_DEFAULTS;
    private static final String[] RECOGNIZED_FEATURES;
    private static final String[] RECOGNIZED_PROPERTIES;
    protected static final int SCANNER_STATE_DTD_EXTERNAL = 46;
    protected static final int SCANNER_STATE_DTD_EXTERNAL_DECLS = 47;
    protected static final int SCANNER_STATE_DTD_INTERNAL_DECLS = 45;
    protected static final int SCANNER_STATE_NO_SUCH_ELEMENT_EXCEPTION = 48;
    protected static final int SCANNER_STATE_PROLOG = 43;
    protected static final int SCANNER_STATE_TRAILING_MISC = 44;
    protected static final int SCANNER_STATE_XML_DECL = 42;
    protected static final String VALIDATION_MANAGER = "http://apache.org/xml/properties/internal/validation-manager";
    protected boolean fBindNamespaces;
    protected XMLStringBuffer fDTDDecl;
    protected Driver fDTDDriver;
    protected XMLDTDScanner fDTDScanner;
    protected String fDoctypeName;
    protected String fDoctypePublicId;
    protected String fDoctypeSystemId;
    protected boolean fEndOfDocument;
    protected int fEndPos;
    protected boolean fLoadExternalDTD;
    protected NamespaceContext fNamespaceContext;
    protected Driver fPrologDriver;
    protected boolean fReadingAttributes;
    protected boolean fReadingDTD;
    protected boolean fScanEndElement;
    protected XMLBufferListenerImpl fScannerBufferlistener;
    protected int fScannerLastState;
    protected boolean fSeenDoctypeDecl;
    protected boolean fSeenInternalSubset;
    protected int fStartPos;
    private XMLString fString;
    private String[] fStrings;
    protected Driver fTrailingMiscDriver;
    protected Driver fXMLDeclDriver;

    protected class ContentDriver extends FragmentContentDriver {
        protected ContentDriver() {
            super();
        }

        protected boolean scanForDoctypeHook() throws IOException, XNIException {
            if (!XMLDocumentScannerImpl.this.fEntityScanner.skipString(XMLDocumentScannerImpl.DOCTYPE)) {
                return false;
            }
            XMLDocumentScannerImpl.this.setScannerState(24);
            return true;
        }

        protected boolean elementDepthIsZeroHook() throws IOException, XNIException {
            XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_TRAILING_MISC);
            XMLDocumentScannerImpl.this.setDriver(XMLDocumentScannerImpl.this.fTrailingMiscDriver);
            return true;
        }

        protected boolean scanRootElementHook() throws IOException, XNIException {
            if (!XMLDocumentScannerImpl.this.scanStartElement()) {
                return false;
            }
            XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_TRAILING_MISC);
            XMLDocumentScannerImpl.this.setDriver(XMLDocumentScannerImpl.this.fTrailingMiscDriver);
            return true;
        }

        protected void endOfFileHook(EOFException e) throws IOException, XNIException {
            XMLDocumentScannerImpl.this.reportFatalError("PrematureEOF", null);
        }
    }

    protected final class DTDDriver implements Driver {
        public boolean dispatch(boolean r14) throws java.io.IOException, com.amazonaws.javax.xml.stream.xerces.xni.XNIException {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:78:? in {6, 10, 21, 24, 29, 32, 35, 38, 46, 50, 58, 60, 61, 64, 65, 66, 67, 69, 71, 72, 73, 74, 75, 76, 77, 80, 81} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r13 = this;
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r8 = r8.fEntityManager;
            r9 = 0;
            r8.setEntityHandler(r9);
            r5 = new com.amazonaws.javax.xml.stream.xerces.util.XMLResourceIdentifierImpl;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r5.<init>();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fDTDScanner;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r8 != 0) goto L_0x002f;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x0013:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = new com.amazonaws.javax.xml.stream.XMLDTDScannerImpl;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9.<init>();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.fDTDScanner = r9;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fPropertyManager;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r8 == 0) goto L_0x002f;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x0022:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fDTDScanner;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = (com.amazonaws.javax.xml.stream.XMLDTDScannerImpl) r8;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r9.fPropertyManager;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.reset(r9);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x002f:
            r0 = 0;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fScannerState;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            switch(r8) {
                case 43: goto L_0x0196;
                case 44: goto L_0x0037;
                case 45: goto L_0x0085;
                case 46: goto L_0x0150;
                case 47: goto L_0x017a;
                default: goto L_0x0037;
            };	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x0037:
            r8 = new com.amazonaws.javax.xml.stream.xerces.xni.XNIException;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = new java.lang.StringBuffer;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9.<init>();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = "DTDDriver#dispatch: scanner state=";	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r9.append(r10);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = r10.fScannerState;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r9.append(r10);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = " (";	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r9.append(r10);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r11 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r11 = r11.fScannerState;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = r10.getScannerStateName(r11);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r9.append(r10);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = 41;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r9.append(r10);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r9.toString();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.<init>(r9);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            throw r8;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x006e:
            r2 = move-exception;
            r2.printStackTrace();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = "PrematureEOF";	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = 0;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.reportFatalError(r9, r10);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = 0;
            r9 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r9 = r9.fEntityManager;
            r10 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r9.setEntityHandler(r10);
        L_0x0084:
            return r8;
        L_0x0085:
            r1 = 1;
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r8.fDTDScanner;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = r8.fStandalone;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fHasExternalDTD;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r8 == 0) goto L_0x0124;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x0094:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fLoadExternalDTD;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r8 == 0) goto L_0x0124;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x009a:
            r8 = 1;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x009b:
            r4 = r9.scanDTDInternalSubset(r1, r10, r8);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fEntityScanner;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r3 = r8.getCurrentEntity();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r3 instanceof com.amazonaws.javax.xml.stream.Entity.ScannedEntity;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r8 == 0) goto L_0x00b3;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x00ab:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r3 = (com.amazonaws.javax.xml.stream.Entity.ScannedEntity) r3;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r3.position;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.fEndPos = r9;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x00b3:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = 0;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.fReadingDTD = r9;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r4 != 0) goto L_0x0140;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x00ba:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fEntityScanner;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = 93;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.skipChar(r9);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r8 != 0) goto L_0x00ce;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x00c6:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = "EXPECTED_SQUARE_BRACKET_TO_CLOSE_INTERNAL_SUBSET";	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = 0;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.reportFatalError(r9, r10);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x00ce:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fEntityScanner;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.skipSpaces();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fEntityScanner;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = 62;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.skipChar(r9);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r8 != 0) goto L_0x00f2;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x00e1:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = "DoctypedeclUnterminated";	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = 1;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = new java.lang.Object[r10];	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r11 = 0;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r12 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r12 = r12.fDoctypeName;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10[r11] = r12;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.reportFatalError(r9, r10);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x00f2:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r8.fMarkupDepth;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r9 + -1;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.fMarkupDepth = r9;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fDisallowDoctype;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r8 == 0) goto L_0x0127;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x0100:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r9.fEntityManager;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r9.getEntityStore();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.fEntityStore = r9;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fEntityStore;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.reset();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x0113:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.setEndDTDScanState();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = 1;
            r9 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r9 = r9.fEntityManager;
            r10 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r9.setEntityHandler(r10);
            goto L_0x0084;
        L_0x0124:
            r8 = 0;
            goto L_0x009b;
        L_0x0127:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fDoctypeSystemId;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r8 == 0) goto L_0x0113;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x012d:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fValidation;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r8 != 0) goto L_0x0139;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x0133:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fLoadExternalDTD;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r8 == 0) goto L_0x0113;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x0139:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = 46;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.setScannerState(r9);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x0140:
            if (r14 != 0) goto L_0x002f;
        L_0x0142:
            if (r0 != 0) goto L_0x002f;
        L_0x0144:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r8 = r8.fEntityManager;
            r9 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r8.setEntityHandler(r9);
            r8 = 1;
            goto L_0x0084;
        L_0x0150:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fDoctypePublicId;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = r9.fDoctypeSystemId;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r10 = 0;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r11 = 0;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r5.setValues(r8, r9, r10, r11);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r7 = 0;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fEntityManager;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r6 = r8.resolveEntityAsPerStax(r5);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r7 = r6.getXMLInputSource();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fDTDScanner;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.setInputSource(r7);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r9 = 47;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.setScannerState(r9);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r0 = 1;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            goto L_0x0140;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x017a:
            r1 = 1;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = r8.fDTDScanner;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r4 = r8.scanDTDExternalSubset(r1);	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            if (r4 != 0) goto L_0x0140;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
        L_0x0185:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.setEndDTDScanState();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = 1;
            r9 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r9 = r9.fEntityManager;
            r10 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r9.setEntityHandler(r10);
            goto L_0x0084;
        L_0x0196:
            r8 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8.setEndDTDScanState();	 Catch:{ EOFException -> 0x006e, all -> 0x01a7 }
            r8 = 1;
            r9 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r9 = r9.fEntityManager;
            r10 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r9.setEntityHandler(r10);
            goto L_0x0084;
        L_0x01a7:
            r8 = move-exception;
            r9 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r9 = r9.fEntityManager;
            r10 = com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.this;
            r9.setEntityHandler(r10);
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.javax.xml.stream.XMLDocumentScannerImpl.DTDDriver.dispatch(boolean):boolean");
        }

        protected DTDDriver() {
        }

        public int next() throws IOException, XNIException {
            dispatch(true);
            XMLDocumentScannerImpl.this.dtdGrammarUtil = new DTDGrammarUtil(((XMLDTDScannerImpl) XMLDocumentScannerImpl.this.fDTDScanner).getGrammar(), XMLDocumentScannerImpl.this.fSymbolTable, XMLDocumentScannerImpl.this.fNamespaceContext);
            return 11;
        }
    }

    protected final class PrologDriver implements Driver {
        protected PrologDriver() {
        }

        public int next() throws IOException, XNIException {
            while (true) {
                try {
                    Entity entity;
                    switch (XMLDocumentScannerImpl.this.fScannerState) {
                        case PayPal.PAYMENT_SUBTYPE_TRANSFER /*21*/:
                            XMLDocumentScannerImpl xMLDocumentScannerImpl = XMLDocumentScannerImpl.this;
                            xMLDocumentScannerImpl.fMarkupDepth++;
                            if (!XMLDocumentScannerImpl.this.fEntityScanner.skipChar(63)) {
                                if (!XMLDocumentScannerImpl.this.fEntityScanner.skipChar(33)) {
                                    if (!XMLChar.isNameStart(XMLDocumentScannerImpl.this.fEntityScanner.peekChar())) {
                                        XMLDocumentScannerImpl.this.reportFatalError("MarkupNotRecognizedInProlog", null);
                                        break;
                                    }
                                    XMLDocumentScannerImpl.this.setScannerState(26);
                                    break;
                                } else if (!XMLDocumentScannerImpl.this.fEntityScanner.skipChar(XMLDocumentScannerImpl.SCANNER_STATE_DTD_INTERNAL_DECLS)) {
                                    if (!XMLDocumentScannerImpl.this.fEntityScanner.skipString(XMLDocumentScannerImpl.DOCTYPE)) {
                                        XMLDocumentScannerImpl.this.reportFatalError("MarkupNotRecognizedInProlog", null);
                                        break;
                                    }
                                    XMLDocumentScannerImpl.this.setScannerState(24);
                                    entity = XMLDocumentScannerImpl.this.fEntityScanner.getCurrentEntity();
                                    if (entity instanceof ScannedEntity) {
                                        XMLDocumentScannerImpl.this.fStartPos = ((ScannedEntity) entity).position;
                                    }
                                    XMLDocumentScannerImpl.this.fReadingDTD = true;
                                    if (XMLDocumentScannerImpl.this.fDTDDecl == null) {
                                        XMLDocumentScannerImpl.this.fDTDDecl = new XMLStringBuffer();
                                    }
                                    XMLDocumentScannerImpl.this.fDTDDecl.append("<!DOCTYPE");
                                    break;
                                } else {
                                    if (!XMLDocumentScannerImpl.this.fEntityScanner.skipChar(XMLDocumentScannerImpl.SCANNER_STATE_DTD_INTERNAL_DECLS)) {
                                        XMLDocumentScannerImpl.this.reportFatalError("InvalidCommentStart", null);
                                    }
                                    XMLDocumentScannerImpl.this.setScannerState(27);
                                    break;
                                }
                            }
                            XMLDocumentScannerImpl.this.setScannerState(23);
                            break;
                        case XMLDocumentScannerImpl.SCANNER_STATE_PROLOG /*43*/:
                            XMLDocumentScannerImpl.this.fEntityScanner.skipSpaces();
                            if (!XMLDocumentScannerImpl.this.fEntityScanner.skipChar(60)) {
                                if (!XMLDocumentScannerImpl.this.fEntityScanner.skipChar(38)) {
                                    XMLDocumentScannerImpl.this.setScannerState(22);
                                    break;
                                }
                                XMLDocumentScannerImpl.this.setScannerState(28);
                                break;
                            }
                            XMLDocumentScannerImpl.this.setScannerState(21);
                            break;
                    }
                    if (XMLDocumentScannerImpl.this.fScannerState != XMLDocumentScannerImpl.SCANNER_STATE_PROLOG && XMLDocumentScannerImpl.this.fScannerState != 21) {
                        switch (XMLDocumentScannerImpl.this.fScannerState) {
                            case PayPal.PAYMENT_SUBTYPE_NONE /*22*/:
                                XMLDocumentScannerImpl.this.reportFatalError("ContentIllegalInProlog", null);
                                XMLDocumentScannerImpl.this.fEntityScanner.scanChar();
                                break;
                            case 23:
                                XMLDocumentScannerImpl.this.fContentBuffer.clear();
                                XMLDocumentScannerImpl.this.scanPI(XMLDocumentScannerImpl.this.fContentBuffer);
                                XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_PROLOG);
                                return 3;
                            case 24:
                                if (XMLDocumentScannerImpl.this.fSeenDoctypeDecl) {
                                    XMLDocumentScannerImpl.this.reportFatalError("AlreadySeenDoctype", null);
                                }
                                XMLDocumentScannerImpl.this.fSeenDoctypeDecl = true;
                                if (XMLDocumentScannerImpl.this.scanDoctypeDecl(XMLDocumentScannerImpl.this.fDisallowDoctype)) {
                                    XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_DTD_INTERNAL_DECLS);
                                    XMLDocumentScannerImpl.this.fSeenInternalSubset = true;
                                    if (XMLDocumentScannerImpl.this.fDTDDriver == null) {
                                        XMLDocumentScannerImpl.this.fDTDDriver = new DTDDriver();
                                    }
                                    XMLDocumentScannerImpl.this.setDriver(XMLDocumentScannerImpl.this.fContentDriver);
                                    return XMLDocumentScannerImpl.this.fDTDDriver.next();
                                }
                                if (XMLDocumentScannerImpl.this.fSeenDoctypeDecl) {
                                    entity = XMLDocumentScannerImpl.this.fEntityScanner.getCurrentEntity();
                                    if (entity instanceof ScannedEntity) {
                                        XMLDocumentScannerImpl.this.fEndPos = ((ScannedEntity) entity).position;
                                    }
                                    XMLDocumentScannerImpl.this.fReadingDTD = false;
                                }
                                if (XMLDocumentScannerImpl.this.fDoctypeSystemId == null || !(XMLDocumentScannerImpl.this.fValidation || XMLDocumentScannerImpl.this.fLoadExternalDTD)) {
                                    if (XMLDocumentScannerImpl.this.fDTDScanner != null) {
                                        XMLDocumentScannerImpl.this.fDTDScanner.setInputSource(null);
                                    }
                                    XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_PROLOG);
                                    return 11;
                                }
                                if (XMLDocumentScannerImpl.this.fDisallowDoctype) {
                                    XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_PROLOG);
                                } else {
                                    XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_DTD_EXTERNAL);
                                }
                                XMLDocumentScannerImpl.this.setDriver(XMLDocumentScannerImpl.this.fContentDriver);
                                if (XMLDocumentScannerImpl.this.fDTDDriver == null) {
                                    XMLDocumentScannerImpl.this.fDTDDriver = new DTDDriver();
                                }
                                return XMLDocumentScannerImpl.this.fDTDDriver.next();
                            case 26:
                                XMLDocumentScannerImpl.this.setScannerState(38);
                                XMLDocumentScannerImpl.this.setDriver(XMLDocumentScannerImpl.this.fContentDriver);
                                return XMLDocumentScannerImpl.this.fContentDriver.next();
                            case 27:
                                XMLDocumentScannerImpl.this.scanComment();
                                XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_PROLOG);
                                return 5;
                            case 28:
                                break;
                            default:
                                return -1;
                        }
                        XMLDocumentScannerImpl.this.reportFatalError("ReferenceIllegalInProlog", null);
                        return -1;
                    }
                } catch (EOFException e) {
                    XMLDocumentScannerImpl.this.reportFatalError("PrematureEOF", null);
                    return -1;
                }
            }
        }
    }

    protected final class TrailingMiscDriver implements Driver {
        protected TrailingMiscDriver() {
        }

        public int next() throws IOException, XNIException {
            try {
                if (XMLDocumentScannerImpl.this.fScannerState == 34) {
                    return 8;
                }
                while (true) {
                    switch (XMLDocumentScannerImpl.this.fScannerState) {
                        case PayPal.PAYMENT_SUBTYPE_TRANSFER /*21*/:
                            XMLDocumentScannerImpl xMLDocumentScannerImpl = XMLDocumentScannerImpl.this;
                            xMLDocumentScannerImpl.fMarkupDepth++;
                            if (!XMLDocumentScannerImpl.this.fEntityScanner.skipChar(63)) {
                                if (!XMLDocumentScannerImpl.this.fEntityScanner.skipChar(33)) {
                                    if (!XMLDocumentScannerImpl.this.fEntityScanner.skipChar(XMLDocumentScannerImpl.SCANNER_STATE_DTD_EXTERNAL_DECLS)) {
                                        if (!XMLChar.isNameStart(XMLDocumentScannerImpl.this.fEntityScanner.peekChar())) {
                                            XMLDocumentScannerImpl.this.reportFatalError("MarkupNotRecognizedInMisc", null);
                                            break;
                                        }
                                        XMLDocumentScannerImpl.this.reportFatalError("MarkupNotRecognizedInMisc", null);
                                        XMLDocumentScannerImpl.this.scanStartElement();
                                        XMLDocumentScannerImpl.this.setScannerState(22);
                                        break;
                                    }
                                    XMLDocumentScannerImpl.this.reportFatalError("MarkupNotRecognizedInMisc", null);
                                    break;
                                }
                                XMLDocumentScannerImpl.this.setScannerState(27);
                                break;
                            }
                            XMLDocumentScannerImpl.this.setScannerState(23);
                            break;
                        case XMLDocumentScannerImpl.SCANNER_STATE_TRAILING_MISC /*44*/:
                            XMLDocumentScannerImpl.this.fEntityScanner.skipSpaces();
                            if (XMLDocumentScannerImpl.this.fScannerState != 34) {
                                if (!XMLDocumentScannerImpl.this.fEntityScanner.skipChar(60)) {
                                    XMLDocumentScannerImpl.this.setScannerState(22);
                                    break;
                                }
                                XMLDocumentScannerImpl.this.setScannerState(21);
                                break;
                            }
                            return 8;
                    }
                    if (XMLDocumentScannerImpl.this.fScannerState != 21 && XMLDocumentScannerImpl.this.fScannerState != XMLDocumentScannerImpl.SCANNER_STATE_TRAILING_MISC) {
                        switch (XMLDocumentScannerImpl.this.fScannerState) {
                            case PayPal.PAYMENT_SUBTYPE_NONE /*22*/:
                                if (XMLDocumentScannerImpl.this.fEntityScanner.peekChar() == -1) {
                                    XMLDocumentScannerImpl.this.setScannerState(34);
                                    return 8;
                                }
                                XMLDocumentScannerImpl.this.reportFatalError("ContentIllegalInTrailingMisc", null);
                                XMLDocumentScannerImpl.this.fEntityScanner.scanChar();
                                XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_TRAILING_MISC);
                                return 4;
                            case 23:
                                XMLDocumentScannerImpl.this.fContentBuffer.clear();
                                XMLDocumentScannerImpl.this.scanPI(XMLDocumentScannerImpl.this.fContentBuffer);
                                XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_TRAILING_MISC);
                                return 3;
                            case 27:
                                if (!XMLDocumentScannerImpl.this.fEntityScanner.skipString(XMLDocumentScannerImpl.COMMENTSTRING)) {
                                    XMLDocumentScannerImpl.this.reportFatalError("InvalidCommentStart", null);
                                }
                                XMLDocumentScannerImpl.this.scanComment();
                                XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_TRAILING_MISC);
                                return 5;
                            case 28:
                                XMLDocumentScannerImpl.this.reportFatalError("ReferenceIllegalInTrailingMisc", null);
                                XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_TRAILING_MISC);
                                return 9;
                            case 34:
                                XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_NO_SUCH_ELEMENT_EXCEPTION);
                                return 8;
                            case XMLDocumentScannerImpl.SCANNER_STATE_NO_SUCH_ELEMENT_EXCEPTION /*48*/:
                                throw new NoSuchElementException("No more events to be parsed");
                            default:
                                throw new XNIException(new StringBuffer().append("Scanner State ").append(XMLDocumentScannerImpl.this.fScannerState).append(" not Recognized ").toString());
                        }
                    }
                }
            } catch (EOFException e) {
                if (XMLDocumentScannerImpl.this.fMarkupDepth != 0) {
                    XMLDocumentScannerImpl.this.reportFatalError("PrematureEOF", null);
                    return -1;
                }
                System.out.println("EOFException thrown");
                XMLDocumentScannerImpl.this.setScannerState(34);
                return 8;
            }
        }
    }

    protected class XMLBufferListenerImpl implements XMLBufferListener {
        protected XMLBufferListenerImpl() {
        }

        public void refresh() {
            refresh(0);
        }

        public void refresh(int refreshPosition) {
            if (XMLDocumentScannerImpl.this.fReadingAttributes) {
                XMLDocumentScannerImpl.this.fAttributes.refresh();
            }
            if (XMLDocumentScannerImpl.this.fReadingDTD) {
                Entity entity = XMLDocumentScannerImpl.this.fEntityScanner.getCurrentEntity();
                if (entity instanceof ScannedEntity) {
                    XMLDocumentScannerImpl.this.fEndPos = ((ScannedEntity) entity).position;
                }
                XMLDocumentScannerImpl.this.fDTDDecl.append(((ScannedEntity) entity).ch, XMLDocumentScannerImpl.this.fStartPos, XMLDocumentScannerImpl.this.fEndPos - XMLDocumentScannerImpl.this.fStartPos);
                XMLDocumentScannerImpl.this.fStartPos = refreshPosition;
            }
            if (XMLDocumentScannerImpl.this.fScannerState == 37) {
                XMLDocumentScannerImpl.this.fContentBuffer.append(XMLDocumentScannerImpl.this.fTempString);
                XMLDocumentScannerImpl.this.fTempString.length = 0;
                XMLDocumentScannerImpl.this.fUsebuffer = true;
            }
        }
    }

    protected final class XMLDeclDriver implements Driver {
        protected XMLDeclDriver() {
        }

        public int next() throws IOException, XNIException {
            XMLDocumentScannerImpl.this.setScannerState(XMLDocumentScannerImpl.SCANNER_STATE_PROLOG);
            XMLDocumentScannerImpl.this.setDriver(XMLDocumentScannerImpl.this.fPrologDriver);
            try {
                if (XMLDocumentScannerImpl.this.fEntityScanner.skipString(XMLDocumentFragmentScannerImpl.xmlDecl)) {
                    XMLDocumentScannerImpl xMLDocumentScannerImpl = XMLDocumentScannerImpl.this;
                    xMLDocumentScannerImpl.fMarkupDepth++;
                    if (XMLChar.isName(XMLDocumentScannerImpl.this.fEntityScanner.peekChar())) {
                        XMLDocumentScannerImpl.this.fStringBuffer.clear();
                        XMLDocumentScannerImpl.this.fStringBuffer.append(XMLConstants.XML_NS_PREFIX);
                        while (XMLChar.isName(XMLDocumentScannerImpl.this.fEntityScanner.peekChar())) {
                            XMLDocumentScannerImpl.this.fStringBuffer.append((char) XMLDocumentScannerImpl.this.fEntityScanner.scanChar());
                        }
                        String target = XMLDocumentScannerImpl.this.fSymbolTable.addSymbol(XMLDocumentScannerImpl.this.fStringBuffer.ch, XMLDocumentScannerImpl.this.fStringBuffer.offset, XMLDocumentScannerImpl.this.fStringBuffer.length);
                        XMLDocumentScannerImpl.this.fStringBuffer.clear();
                        XMLDocumentScannerImpl.this.scanPIData(target, XMLDocumentScannerImpl.this.fStringBuffer);
                        XMLDocumentScannerImpl.this.fEntityManager.fCurrentEntity.mayReadChunks = true;
                        return 3;
                    }
                    XMLDocumentScannerImpl.this.scanXMLDeclOrTextDecl(false);
                    XMLDocumentScannerImpl.this.fEntityManager.fCurrentEntity.mayReadChunks = true;
                    return 7;
                }
                XMLDocumentScannerImpl.this.fEntityManager.fCurrentEntity.mayReadChunks = true;
                return 7;
            } catch (EOFException e) {
                XMLDocumentScannerImpl.this.reportFatalError("PrematureEOF", null);
                return -1;
            }
        }
    }

    static {
        RECOGNIZED_FEATURES = new String[]{LOAD_EXTERNAL_DTD, DISALLOW_DOCTYPE_DECL_FEATURE};
        FEATURE_DEFAULTS = new Boolean[]{Boolean.TRUE, Boolean.FALSE};
        RECOGNIZED_PROPERTIES = new String[]{DTD_SCANNER, VALIDATION_MANAGER};
        PROPERTY_DEFAULTS = new Object[]{null, null};
        DOCTYPE = new char[]{'D', 'O', 'C', 'T', 'Y', 'P', 'E'};
        COMMENTSTRING = new char[]{'-', '-'};
    }

    public XMLDocumentScannerImpl() {
        this.fDTDScanner = null;
        this.fDTDDecl = null;
        this.fReadingDTD = false;
        this.fNamespaceContext = new NamespaceSupport();
        this.fLoadExternalDTD = true;
        this.fXMLDeclDriver = new XMLDeclDriver();
        this.fPrologDriver = new PrologDriver();
        this.fDTDDriver = null;
        this.fTrailingMiscDriver = new TrailingMiscDriver();
        this.fStartPos = 0;
        this.fEndPos = 0;
        this.fSeenInternalSubset = false;
        this.fStrings = new String[3];
        this.fString = new XMLString();
        this.fReadingAttributes = false;
        this.fScannerBufferlistener = new XMLBufferListenerImpl();
    }

    public void setInputSource(XMLInputSource inputSource) throws IOException {
        this.fEntityManager.setEntityHandler(this);
        this.fEntityManager.startDocumentEntity(inputSource);
        setScannerState(7);
    }

    public void reset(PropertyManager propertyManager) {
        boolean z = true;
        super.reset(propertyManager);
        this.fDoctypeName = null;
        this.fDoctypePublicId = null;
        this.fDoctypeSystemId = null;
        this.fSeenDoctypeDecl = false;
        this.fNamespaceContext.reset();
        this.fDisallowDoctype = !((Boolean) propertyManager.getProperty(XMLInputFactory.SUPPORT_DTD)).booleanValue();
        this.fBindNamespaces = ((Boolean) propertyManager.getProperty(XMLInputFactory.IS_NAMESPACE_AWARE)).booleanValue();
        if (((Boolean) propertyManager.getProperty("http://java.sun.com/xml/stream/properties/ignore-external-dtd")).booleanValue()) {
            z = false;
        }
        this.fLoadExternalDTD = z;
        this.fEndOfDocument = false;
        setScannerState(7);
        setDriver(this.fXMLDeclDriver);
        this.fSeenInternalSubset = false;
        if (this.fDTDScanner != null) {
            ((XMLDTDScannerImpl) this.fDTDScanner).reset(propertyManager);
        }
        this.fEndPos = 0;
        this.fStartPos = 0;
        if (this.fDTDDecl != null) {
            this.fDTDDecl.clear();
        }
    }

    public int getScannetState() {
        return this.fScannerState;
    }

    public int next() throws IOException, XNIException {
        if (this.fScannerLastState == 2 && this.fBindNamespaces) {
            this.fScannerLastState = -1;
            this.fNamespaceContext.popContext();
        }
        int next = this.fDriver.next();
        this.fScannerLastState = next;
        return next;
    }

    public void reset(XMLComponentManager componentManager) throws XMLConfigurationException {
        super.reset(componentManager);
        this.fDoctypeName = null;
        this.fDoctypePublicId = null;
        this.fDoctypeSystemId = null;
        this.fSeenDoctypeDecl = false;
        this.fNamespaceContext.reset();
        try {
            this.fLoadExternalDTD = componentManager.getFeature(LOAD_EXTERNAL_DTD);
        } catch (XMLConfigurationException e) {
            this.fLoadExternalDTD = true;
        }
        try {
            this.fDisallowDoctype = componentManager.getFeature(DISALLOW_DOCTYPE_DECL_FEATURE);
        } catch (XMLConfigurationException e2) {
            this.fDisallowDoctype = false;
        }
        this.fDTDScanner = (XMLDTDScanner) componentManager.getProperty(DTD_SCANNER);
        this.fEndPos = 0;
        this.fStartPos = 0;
        if (this.fDTDDecl != null) {
            this.fDTDDecl.clear();
        }
        setScannerState(SCANNER_STATE_XML_DECL);
        setDriver(this.fXMLDeclDriver);
    }

    public String[] getRecognizedFeatures() {
        int length;
        String[] featureIds = super.getRecognizedFeatures();
        if (featureIds != null) {
            length = featureIds.length;
        } else {
            length = 0;
        }
        String[] combinedFeatureIds = new String[(RECOGNIZED_FEATURES.length + length)];
        if (featureIds != null) {
            System.arraycopy(featureIds, 0, combinedFeatureIds, 0, featureIds.length);
        }
        System.arraycopy(RECOGNIZED_FEATURES, 0, combinedFeatureIds, length, RECOGNIZED_FEATURES.length);
        return combinedFeatureIds;
    }

    public void setFeature(String featureId, boolean state) throws XMLConfigurationException {
        super.setFeature(featureId, state);
        if (featureId.startsWith(Constants.XERCES_FEATURE_PREFIX) && featureId.substring(Constants.XERCES_FEATURE_PREFIX.length()).equals(Constants.LOAD_EXTERNAL_DTD_FEATURE)) {
            this.fLoadExternalDTD = state;
        }
    }

    public String[] getRecognizedProperties() {
        int length;
        String[] propertyIds = super.getRecognizedProperties();
        if (propertyIds != null) {
            length = propertyIds.length;
        } else {
            length = 0;
        }
        String[] combinedPropertyIds = new String[(RECOGNIZED_PROPERTIES.length + length)];
        if (propertyIds != null) {
            System.arraycopy(propertyIds, 0, combinedPropertyIds, 0, propertyIds.length);
        }
        System.arraycopy(RECOGNIZED_PROPERTIES, 0, combinedPropertyIds, length, RECOGNIZED_PROPERTIES.length);
        return combinedPropertyIds;
    }

    public void setProperty(String propertyId, Object value) throws XMLConfigurationException {
        super.setProperty(propertyId, value);
        if (propertyId.startsWith(Constants.XERCES_PROPERTY_PREFIX) && propertyId.substring(Constants.XERCES_PROPERTY_PREFIX.length()).equals(Constants.DTD_SCANNER_PROPERTY)) {
            this.fDTDScanner = (XMLDTDScanner) value;
        }
    }

    public Boolean getFeatureDefault(String featureId) {
        for (int i = 0; i < RECOGNIZED_FEATURES.length; i++) {
            if (RECOGNIZED_FEATURES[i].equals(featureId)) {
                return FEATURE_DEFAULTS[i];
            }
        }
        return super.getFeatureDefault(featureId);
    }

    public Object getPropertyDefault(String propertyId) {
        for (int i = 0; i < RECOGNIZED_PROPERTIES.length; i++) {
            if (RECOGNIZED_PROPERTIES[i].equals(propertyId)) {
                return PROPERTY_DEFAULTS[i];
            }
        }
        return super.getPropertyDefault(propertyId);
    }

    public void startEntity(String name, XMLResourceIdentifier identifier, String encoding) throws XNIException {
        super.startEntity(name, identifier, encoding);
        if (!name.equals("[xml]") && this.fEntityScanner.isExternal() && this.fReplaceEntityReferences) {
            setScannerState(36);
        }
        if (this.fDocumentHandler != null && name.equals("[xml]")) {
            this.fDocumentHandler.startDocument(this.fEntityScanner, encoding, this.fNamespaceContext, null);
        }
    }

    public void endEntity(String name) throws IOException, XNIException {
        super.endEntity(name);
        if (!name.equals("[xml]")) {
            return;
        }
        if (this.fMarkupDepth == 0 && this.fDriver == this.fTrailingMiscDriver) {
            setScannerState(34);
            if (this.fDocumentHandler != null) {
                this.fDocumentHandler.endDocument(null);
                return;
            }
            return;
        }
        throw new EOFException();
    }

    protected Driver createContentDriver() {
        return new ContentDriver();
    }

    protected boolean scanDoctypeDecl(boolean ignore) throws IOException, XNIException {
        boolean z;
        if (!this.fEntityScanner.skipSpaces()) {
            reportFatalError("MSG_SPACE_REQUIRED_BEFORE_ROOT_ELEMENT_TYPE_IN_DOCTYPEDECL", null);
        }
        this.fDoctypeName = this.fEntityScanner.scanName();
        if (this.fDoctypeName == null) {
            reportFatalError("MSG_ROOT_ELEMENT_TYPE_REQUIRED", null);
        }
        if (this.fEntityScanner.skipSpaces()) {
            scanExternalID(this.fStrings, false);
            this.fDoctypeSystemId = this.fStrings[0];
            this.fDoctypePublicId = this.fStrings[1];
            this.fEntityScanner.skipSpaces();
        }
        if (this.fDoctypeSystemId != null) {
            z = true;
        } else {
            z = false;
        }
        this.fHasExternalDTD = z;
        if (!(this.fDocumentHandler == null || ignore)) {
            this.fDocumentHandler.doctypeDecl(this.fDoctypeName, this.fDoctypePublicId, this.fDoctypeSystemId, null);
        }
        boolean internalSubset = true;
        if (!this.fEntityScanner.skipChar(91)) {
            internalSubset = false;
            this.fEntityScanner.skipSpaces();
            if (!this.fEntityScanner.skipChar(62)) {
                reportFatalError("DoctypedeclUnterminated", new Object[]{this.fDoctypeName});
            }
            this.fMarkupDepth--;
        }
        return internalSubset;
    }

    protected void setEndDTDScanState() {
        setScannerState(SCANNER_STATE_PROLOG);
        setDriver(this.fPrologDriver);
        this.fEntityManager.setEntityHandler(this);
    }

    protected String getScannerStateName(int state) {
        switch (state) {
            case SCANNER_STATE_XML_DECL /*42*/:
                return "SCANNER_STATE_XML_DECL";
            case SCANNER_STATE_PROLOG /*43*/:
                return "SCANNER_STATE_PROLOG";
            case SCANNER_STATE_TRAILING_MISC /*44*/:
                return "SCANNER_STATE_TRAILING_MISC";
            case SCANNER_STATE_DTD_INTERNAL_DECLS /*45*/:
                return "SCANNER_STATE_DTD_INTERNAL_DECLS";
            case SCANNER_STATE_DTD_EXTERNAL /*46*/:
                return "SCANNER_STATE_DTD_EXTERNAL";
            case SCANNER_STATE_DTD_EXTERNAL_DECLS /*47*/:
                return "SCANNER_STATE_DTD_EXTERNAL_DECLS";
            default:
                return super.getScannerStateName(state);
        }
    }
}
