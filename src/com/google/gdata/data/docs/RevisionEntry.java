package com.google.gdata.data.docs;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.Link;
import com.google.gdata.data.Person;
import com.google.gdata.util.Namespaces;

public class RevisionEntry extends BaseEntry<RevisionEntry> {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/docs/2007#revision";
    public static final String LABEL = "revision";
    public static final String PUBLISH_NAMESPACE = "http://schemas.google.com/docs/2007#publish";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND, LABEL);
    }

    public RevisionEntry() {
        getCategories().add(CATEGORY);
    }

    public RevisionEntry(BaseEntry<?> sourceEntry) {
        super(sourceEntry);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        super.declareExtensions(extProfile);
        extProfile.declare(RevisionEntry.class, Md5Checksum.class);
        extProfile.declare(RevisionEntry.class, Publish.class);
        extProfile.declare(RevisionEntry.class, PublishAuto.class);
        extProfile.declare(RevisionEntry.class, PublishOutsideDomain.class);
    }

    public String getMd5Checksum() {
        Md5Checksum md5Checksum = (Md5Checksum) getExtension(Md5Checksum.class);
        return md5Checksum == null ? null : md5Checksum.getValue();
    }

    public void setMd5Checksum(String md5Checksum) {
        if (md5Checksum == null) {
            removeExtension(Md5Checksum.class);
        } else {
            setExtension(new Md5Checksum(md5Checksum));
        }
    }

    public void setModifyingUser(Person modifyingUser) {
        getAuthors().clear();
        if (modifyingUser != null) {
            getAuthors().add(modifyingUser);
        }
    }

    public Person getModifyingUser() {
        if (getAuthors().size() > 0) {
            return (Person) getAuthors().get(0);
        }
        return null;
    }

    public Link getPublishLink() {
        return getLink(PUBLISH_NAMESPACE, Type.HTML);
    }

    public Boolean isPublish() {
        Publish publish = (Publish) getExtension(Publish.class);
        return publish == null ? null : publish.getValue();
    }

    public void setPublish(Boolean publish) {
        if (publish == null) {
            removeExtension(Publish.class);
        } else {
            setExtension(new Publish(publish));
        }
    }

    public Boolean isPublishAuto() {
        PublishAuto publishAuto = (PublishAuto) getExtension(PublishAuto.class);
        return publishAuto == null ? null : publishAuto.getValue();
    }

    public void setPublishAuto(Boolean publishAuto) {
        if (publishAuto == null) {
            removeExtension(PublishAuto.class);
        } else {
            setExtension(new PublishAuto(publishAuto));
        }
    }

    public Boolean isPublishOutsideDomain() {
        PublishOutsideDomain publishOutsideDomain = (PublishOutsideDomain) getExtension(PublishOutsideDomain.class);
        return publishOutsideDomain == null ? null : publishOutsideDomain.getValue();
    }

    public void setPublishOutsideDomain(Boolean publishOutsideDomain) {
        if (publishOutsideDomain == null) {
            removeExtension(PublishOutsideDomain.class);
        } else {
            setExtension(new PublishOutsideDomain(publishOutsideDomain));
        }
    }
}
