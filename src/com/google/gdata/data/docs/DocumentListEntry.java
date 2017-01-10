package com.google.gdata.data.docs;

import com.amazonaws.services.s3.internal.Mimetypes;
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.ILink;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.data.Link;
import com.google.gdata.data.MediaContent;
import com.google.gdata.data.Person;
import com.google.gdata.data.acl.AclFeed;
import com.google.gdata.data.acl.AclNamespace;
import com.google.gdata.data.docs.DocumentListLink.Type;
import com.google.gdata.data.extensions.Deleted;
import com.google.gdata.data.extensions.Labels;
import com.google.gdata.data.extensions.LastModifiedBy;
import com.google.gdata.data.extensions.LastViewed;
import com.google.gdata.data.extensions.QuotaBytesUsed;
import com.google.gdata.data.extensions.ResourceId;
import com.google.gdata.data.media.MediaEntry;
import com.google.gdata.data.media.MediaFileSource;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.common.base.StringUtil;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@Term("http://schemas.google.com/docs/2007#item")
public class DocumentListEntry extends MediaEntry<DocumentListEntry> {
    public static final Category CATEGORY;
    public static final String FOLDERS_NAMESPACE = "http://schemas.google.com/docs/2007/folders";
    private static final Pattern FOLDER_PATTERN;
    public static final String KIND = "http://schemas.google.com/docs/2007#item";
    public static final String LABEL = "item";
    public static final String PARENT_NAMESPACE = "http://schemas.google.com/docs/2007#parent";
    public static final String REVISIONS_NAMESPACE = "http://schemas.google.com/docs/2007/revisions";
    public static final String THUMBNAIL_NAMESPACE = "http://schemas.google.com/docs/2007/thumbnail";
    @Deprecated
    public static final Category UNKNOWN_CATEGORY;
    @Deprecated
    public static final String UNKNOWN_KIND = "http://schemas.google.com/docs/2007#unknown";
    @Deprecated
    public static final String UNKNOWN_LABEL = "unknown";

    public enum MediaType {
        JPG("image/jpeg"),
        JPEG("image/jpeg"),
        PNG("image/png"),
        BMP("image/bmp"),
        GIF("image/gif"),
        TXT("text/plain"),
        HTML(Mimetypes.MIMETYPE_HTML),
        HTM(Mimetypes.MIMETYPE_HTML),
        ODT("application/vnd.oasis.opendocument.text"),
        SXW("application/vnd.sun.xml.writer"),
        DOC("application/msword"),
        DOCX("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
        RTF("application/rtf"),
        PDF("application/pdf"),
        PPS("application/vnd.ms-powerpoint"),
        PPT("application/vnd.ms-powerpoint"),
        XLS("application/vnd.ms-excel"),
        XLSX("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
        ODS("application/x-vnd.oasis.opendocument.spreadsheet"),
        CSV("text/csv"),
        TAB("text/tab-separated-value"),
        TSV("text/tab-separated-value"),
        SWF("application/x-shockwave-flash"),
        ZIP(Type.APPLICATION_ZIP),
        WMF("application/x-msmetafile");
        
        private String mimeType;

        private MediaType(String mimeType) {
            this.mimeType = mimeType;
        }

        public String getMimeType() {
            return this.mimeType;
        }

        public static MediaType fromFileName(String fileName) {
            int index = fileName.lastIndexOf(46);
            if (index > 0) {
                return valueOf(fileName.substring(index + 1).toUpperCase());
            }
            return valueOf(fileName);
        }
    }

    protected static String getMimeTypeFromFileName(String fileName) {
        return MediaType.fromFileName(fileName).getMimeType();
    }

    static {
        UNKNOWN_CATEGORY = new Category(Namespaces.gKind, UNKNOWN_KIND, UNKNOWN_LABEL);
        CATEGORY = new Category(Namespaces.gKind, KIND, LABEL);
        FOLDER_PATTERN = Pattern.compile("^" + Pattern.quote(FOLDERS_NAMESPACE) + "(:?/[^/]+)?$");
    }

    public DocumentListEntry(BaseEntry<?> sourceEntry) {
        super(sourceEntry);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        super.declareExtensions(extProfile);
        extProfile.declare(DocumentListEntry.class, Description.class);
        extProfile.declare(DocumentListEntry.class, DocumentListAclFeedLink.class);
        extProfile.declare(DocumentListEntry.class, Filename.class);
        extProfile.declare(DocumentListEntry.class, LastCommented.class);
        extProfile.declare(DocumentListEntry.class, LastModifiedBy.class);
        extProfile.declare(DocumentListEntry.class, LastViewed.class);
        extProfile.declare(DocumentListEntry.class, Md5Checksum.class);
        extProfile.declare(DocumentListEntry.class, QuotaBytesUsed.class);
        extProfile.declare(DocumentListEntry.class, ResourceId.class);
        extProfile.declare(DocumentListEntry.class, SuggestedFilename.class);
        extProfile.declare(DocumentListEntry.class, WritersCanInvite.class);
    }

    public Link getDocumentLink() {
        return super.getHtmlLink();
    }

    @Deprecated
    public String getKey() {
        String result = this.state.id;
        if (result == null) {
            return result;
        }
        int position = result.lastIndexOf("/");
        if (position > 0) {
            return result.substring(position + 1);
        }
        return result;
    }

    public String getDocId() {
        String result = getResourceId();
        if (result == null) {
            return result;
        }
        int position = result.lastIndexOf(":");
        if (position > 0) {
            return result.substring(position + 1);
        }
        return result;
    }

    public String getType() {
        String result = getResourceId();
        if (result == null) {
            return result;
        }
        int position = result.lastIndexOf(":");
        if (position > 0) {
            return result.substring(0, position);
        }
        return result;
    }

    @Deprecated
    public void setFile(File file) {
        setFile(file, getMimeTypeFromFileName(file.getName()));
    }

    public void setFile(File file, String mimeType) {
        MediaFileSource fileSource = new MediaFileSource(file, mimeType);
        MediaContent content = new MediaContent();
        content.setMediaSource(fileSource);
        content.setMimeType(new ContentType(mimeType));
        setContent(content);
    }

    public void setHidden(boolean hidden) {
        if (hidden) {
            getCategories().add(Labels.HIDDEN);
        } else {
            getCategories().remove(Labels.HIDDEN);
        }
    }

    public boolean isHidden() {
        return getCategories().contains(Labels.HIDDEN);
    }

    public void setStarred(boolean starred) {
        if (starred) {
            getCategories().add(Labels.STARRED);
        } else {
            getCategories().remove(Labels.STARRED);
        }
    }

    public boolean isStarred() {
        return getCategories().contains(Labels.STARRED);
    }

    public void setViewed(boolean viewed) {
        if (viewed) {
            getCategories().add(Labels.VIEWED);
        } else {
            getCategories().remove(Labels.VIEWED);
        }
    }

    public boolean isViewed() {
        return getCategories().contains(Labels.VIEWED);
    }

    public void setTrashed(boolean trashed) {
        if (trashed) {
            getCategories().add(Labels.TRASHED);
            setExtension(new Deleted());
            return;
        }
        getCategories().remove(Labels.TRASHED);
        removeExtension(Deleted.class);
    }

    public boolean isTrashed() {
        return getCategories().contains(Labels.TRASHED) || hasExtension(Deleted.class);
    }

    public void setRestrictedDownload(boolean restrictedDownload) {
        if (restrictedDownload) {
            getCategories().add(Labels.RESTRICTED_DOWNLOAD);
        } else {
            getCategories().remove(Labels.RESTRICTED_DOWNLOAD);
        }
    }

    public boolean isRestrictedDownload() {
        return getCategories().contains(Labels.RESTRICTED_DOWNLOAD);
    }

    @Deprecated
    public void addFolder(Person owner, String folderName) {
        getCategories().add(new Category("http://schemas.google.com/docs/2007/folders/" + owner.getEmail(), folderName, folderName));
    }

    @Deprecated
    public Set<String> getFolders() {
        Set<String> folders = new HashSet();
        for (Category category : getCategories()) {
            if (FOLDER_PATTERN.matcher(category.getScheme()).matches()) {
                String folderName = category.getLabel();
                if (folderName == null || folderName.length() == 0) {
                    folderName = category.getTerm();
                }
                folders.add(folderName);
            }
        }
        return folders;
    }

    public DocumentListAclFeedLink getAclFeedLink() {
        for (DocumentListAclFeedLink feedLink : getRepeatingExtension(DocumentListAclFeedLink.class)) {
            if (AclNamespace.LINK_REL_ACCESS_CONTROL_LIST.equals(feedLink.getRel())) {
                return feedLink;
            }
        }
        return null;
    }

    public AclFeed getAclFeed() {
        DocumentListAclFeedLink feedLink = getAclFeedLink();
        return feedLink != null ? (AclFeed) feedLink.getFeed() : null;
    }

    public List<Link> getParentLinks() {
        return getLinks(PARENT_NAMESPACE, ILink.Type.ATOM);
    }

    public String getDescription() {
        Description description = (Description) getExtension(Description.class);
        if (description == null) {
            return null;
        }
        return description.getValue() == null ? StringUtil.EMPTY_STRING : description.getValue();
    }

    public void setDescription(String description) {
        if (description == null) {
            removeExtension(Description.class);
        } else {
            setExtension(new Description(description));
        }
    }

    public String getFilename() {
        Filename filename = (Filename) getExtension(Filename.class);
        return filename == null ? null : filename.getValue();
    }

    public void setFilename(String filename) {
        if (filename == null) {
            removeExtension(Filename.class);
        } else {
            setExtension(new Filename(filename));
        }
    }

    public String getSuggestedFilename() {
        SuggestedFilename filename = (SuggestedFilename) getExtension(SuggestedFilename.class);
        return filename == null ? null : filename.getValue();
    }

    public void setSuggestedFilename(String filename) {
        if (filename == null) {
            removeExtension(SuggestedFilename.class);
        } else {
            setExtension(new SuggestedFilename(filename));
        }
    }

    public DateTime getLastCommented() {
        LastCommented lastCommented = (LastCommented) getExtension(LastCommented.class);
        return lastCommented == null ? null : lastCommented.getValue();
    }

    public void setLastCommented(DateTime lastCommented) {
        if (lastCommented == null) {
            removeExtension(LastCommented.class);
        } else {
            setExtension(new LastCommented(lastCommented));
        }
    }

    public DateTime getLastViewed() {
        LastViewed lastViewed = (LastViewed) getExtension(LastViewed.class);
        return lastViewed == null ? null : lastViewed.getValue();
    }

    public void setLastViewed(DateTime lastViewed) {
        if (lastViewed == null) {
            removeExtension(LastViewed.class);
        } else {
            setExtension(new LastViewed(lastViewed));
        }
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

    public Long getQuotaBytesUsed() {
        QuotaBytesUsed quotaBytes = (QuotaBytesUsed) getExtension(QuotaBytesUsed.class);
        return quotaBytes == null ? null : quotaBytes.getValue();
    }

    public void setQuotaBytesUsed(Long quotaBytesUsed) {
        if (quotaBytesUsed == null) {
            removeExtension(QuotaBytesUsed.class);
        } else {
            setExtension(new QuotaBytesUsed(quotaBytesUsed));
        }
    }

    public Boolean isWritersCanInvite() {
        WritersCanInvite writersCanInvite = (WritersCanInvite) getExtension(WritersCanInvite.class);
        return writersCanInvite == null ? null : writersCanInvite.getValue();
    }

    public void setWritersCanInvite(Boolean writersCanInvite) {
        if (writersCanInvite == null) {
            removeExtension(WritersCanInvite.class);
        } else {
            setExtension(new WritersCanInvite(writersCanInvite));
        }
    }

    public LastModifiedBy getLastModifiedBy() {
        LastModifiedBy lastModifiedBy = (LastModifiedBy) getExtension(LastModifiedBy.class);
        return lastModifiedBy == null ? null : lastModifiedBy;
    }

    public void setLastModifiedBy(LastModifiedBy lastModifiedBy) {
        if (lastModifiedBy == null) {
            removeExtension(LastModifiedBy.class);
        } else {
            setExtension(lastModifiedBy);
        }
    }

    public String getResourceId() {
        ResourceId resourceId = (ResourceId) getExtension(ResourceId.class);
        return resourceId == null ? null : resourceId.getValue();
    }

    public void setResourceId(String resourceId) {
        if (resourceId == null) {
            removeExtension(ResourceId.class);
        } else {
            setExtension(new ResourceId(resourceId));
        }
    }
}
