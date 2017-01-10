package com.google.gdata.data;

import com.google.gdata.data.TextConstruct.RssFormat;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;

public class TextContent extends Content implements ITextContent {
    protected TextConstruct content;

    public TextContent(TextConstruct content) {
        this.content = content;
    }

    public int getType() {
        return 1;
    }

    public String getLang() {
        if (this.content == null) {
            return null;
        }
        return this.content.getLang();
    }

    public TextConstruct getContent() {
        return this.content;
    }

    public void setContent(TextConstruct v) {
        this.content = v;
    }

    public void generateAtom(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        if (this.content != null) {
            this.content.generateAtom(w, "content");
        }
    }

    public void generateRss(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        if (this.content != null) {
            this.content.generateRss(w, "description", RssFormat.FULL_HTML);
        }
    }
}
