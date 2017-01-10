package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.PartETag;
import com.google.gdata.client.GDataProtocol.Header;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RequestXmlFactory {

    /* renamed from: com.amazonaws.services.s3.model.transform.RequestXmlFactory.1 */
    static class C00651 implements Comparator<PartETag> {
        C00651() {
        }

        public int compare(PartETag partETag, PartETag partETag2) {
            return partETag.getPartNumber() < partETag2.getPartNumber() ? -1 : partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
        }
    }

    public static byte[] convertToXmlByteArray(List<PartETag> list) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("CompleteMultipartUpload");
        if (list != null) {
            Collections.sort(list, new C00651());
            for (PartETag partETag : list) {
                xmlWriter.start("Part");
                xmlWriter.start("PartNumber").value(Integer.toString(partETag.getPartNumber())).end();
                xmlWriter.start(Header.ETAG).value(partETag.getETag()).end();
                xmlWriter.end();
            }
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }
}
