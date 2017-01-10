package com.google.gdata.data;

import com.google.gdata.util.ContentType;

public interface ILink extends Reference {

    public static final class Rel {
        public static final String ALTERNATE = "alternate";
        public static final String ENCLOSURE = "enclosure";
        public static final String ENTRY_EDIT = "edit";
        public static final String ENTRY_POST = "http://schemas.google.com/g/2005#post";
        public static final String FEED = "http://schemas.google.com/g/2005#feed";
        public static final String FEED_BATCH = "http://schemas.google.com/g/2005#batch";
        public static final String HUB = "hub";
        public static final String MEDIA_EDIT = "edit-media";
        @Deprecated
        public static final String MEDIA_EDIT_BACKCOMPAT = "media-edit";
        public static final String NEXT = "next";
        public static final String PREVIOUS = "previous";
        public static final String RELATED = "related";
        public static final String RESUMABLE_CREATE_MEDIA = "http://schemas.google.com/g/2005#resumable-create-media";
        public static final String RESUMABLE_EDIT_MEDIA = "http://schemas.google.com/g/2005#resumable-edit-media";
        public static final String SELF = "self";
        public static final String VIA = "via";

        private Rel() {
        }
    }

    public static final class Type {
        public static final String ATOM;
        public static final String HTML;

        static {
            ATOM = ContentType.ATOM.getMediaType();
            HTML = ContentType.TEXT_HTML.getMediaType();
        }

        private Type() {
        }
    }

    String getRel();

    String getType();

    void setRel(String str);

    void setType(String str);
}
