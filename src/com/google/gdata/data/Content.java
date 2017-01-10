package com.google.gdata.data;

import com.amazonaws.services.s3.internal.Mimetypes;
import com.google.ads.AdActivity;
import com.google.gdata.data.OutOfLineContent.AtomHandler;
import com.google.gdata.model.atom.TextContent;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import org.xml.sax.Attributes;

public abstract class Content implements IContent {

    public static class ChildHandlerInfo {
        public Content content;
        public ElementHandler handler;
    }

    public abstract void generateAtom(XmlWriter xmlWriter, ExtensionProfile extensionProfile) throws IOException;

    public abstract void generateRss(XmlWriter xmlWriter, ExtensionProfile extensionProfile) throws IOException;

    public abstract String getLang();

    public abstract int getType();

    public static ChildHandlerInfo getChildHandler(ExtensionProfile extProfile, Attributes attrs) throws ParseException, IOException {
        String type = attrs.getValue(StringUtil.EMPTY_STRING, "type");
        ChildHandlerInfo childHandlerInfo = new ChildHandlerInfo();
        if (attrs.getValue(StringUtil.EMPTY_STRING, "src") != null) {
            OutOfLineContent oolc = new OutOfLineContent();
            oolc.getClass();
            childHandlerInfo.handler = new AtomHandler();
            childHandlerInfo.content = oolc;
        } else if (type == null || type.equals(TextContent.KIND) || type.equals("text/plain") || type.equals(AdActivity.HTML_PARAM) || type.equals(Mimetypes.MIMETYPE_HTML) || type.equals("xhtml")) {
            TextContent tc = new TextContent();
            com.google.gdata.data.TextConstruct.ChildHandlerInfo chi = TextConstruct.getChildHandler(attrs);
            tc.setContent(chi.textConstruct);
            childHandlerInfo.handler = chi.handler;
            childHandlerInfo.content = tc;
        } else {
            OtherContent oc = new OtherContent();
            oc.getClass();
            childHandlerInfo.handler = new OtherContent.AtomHandler(extProfile, attrs);
            childHandlerInfo.content = oc;
        }
        return childHandlerInfo;
    }
}
