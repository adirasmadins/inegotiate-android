package com.google.api.client.http;

import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;

public final class MultipartRelatedContent implements HttpContent {
    private static final byte[] CONTENT_TRANSFER_ENCODING;
    private static final byte[] CONTENT_TYPE;
    private static final byte[] CR_LF;
    private static final byte[] TWO_DASHES;
    public String boundary;
    public Collection<HttpContent> parts;

    public MultipartRelatedContent() {
        this.boundary = "END_OF_PART";
        this.parts = new ArrayList();
    }

    static {
        CR_LF = StringUtil.LINE_BREAKS.getBytes();
        CONTENT_TYPE = "Content-Type: ".getBytes();
        CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding: binary".getBytes();
        TWO_DASHES = "--".getBytes();
    }

    public static MultipartRelatedContent forRequest(HttpRequest request) {
        MultipartRelatedContent result = new MultipartRelatedContent();
        request.headers.mimeVersion = XMLStreamWriterImpl.DEFAULT_XML_VERSION;
        request.content = result;
        return result;
    }

    public void writeTo(OutputStream out) throws IOException {
        byte[] END_OF_PART = this.boundary.getBytes();
        out.write(TWO_DASHES);
        out.write(END_OF_PART);
        for (HttpContent part : this.parts) {
            String contentType = part.getType();
            byte[] typeBytes = contentType.getBytes();
            out.write(CR_LF);
            out.write(CONTENT_TYPE);
            out.write(typeBytes);
            out.write(CR_LF);
            if (!LogContent.isTextBasedContentType(contentType)) {
                out.write(CONTENT_TRANSFER_ENCODING);
                out.write(CR_LF);
            }
            out.write(CR_LF);
            part.writeTo(out);
            out.write(CR_LF);
            out.write(TWO_DASHES);
            out.write(END_OF_PART);
        }
        out.write(TWO_DASHES);
        out.flush();
    }

    public String getEncoding() {
        return null;
    }

    public long getLength() {
        return -1;
    }

    public String getType() {
        return "multipart/related; boundary=\"END_OF_PART\"";
    }
}
