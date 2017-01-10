package com.google.gdata.data.docs;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.data.extensions.QuotaBytesUsed;
import com.google.gdata.util.Namespaces;
import java.util.List;

@Term("http://schemas.google.com/docs/2007#archive")
public class ArchiveEntry extends BaseEntry<ArchiveEntry> {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/docs/2007#archive";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND, "archive");
    }

    public ArchiveEntry() {
        getCategories().add(CATEGORY);
    }

    public ArchiveEntry(BaseEntry<?> sourceEntry) {
        super(sourceEntry);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        if (!extProfile.isDeclared(ArchiveEntry.class)) {
            super.declareExtensions(extProfile);
            extProfile.declare(ArchiveEntry.class, ArchiveComplete.class);
            extProfile.declare(ArchiveEntry.class, ArchiveConversion.getDefaultDescription(true, true));
            extProfile.declare(ArchiveEntry.class, ArchiveFailure.getDefaultDescription(false, true));
            extProfile.declare(ArchiveEntry.class, ArchiveNotify.class);
            extProfile.declare(ArchiveEntry.class, ArchiveNotifyStatus.class);
            extProfile.declare(ArchiveEntry.class, ArchiveResourceId.getDefaultDescription(false, true));
            extProfile.declare(ArchiveEntry.class, ArchiveStatus.class);
            extProfile.declare(ArchiveEntry.class, ArchiveTotal.class);
            extProfile.declare(ArchiveEntry.class, ArchiveTotalComplete.class);
            extProfile.declare(ArchiveEntry.class, ArchiveTotalFailure.class);
            extProfile.declare(ArchiveEntry.class, QuotaBytesUsed.class);
        }
    }

    public ArchiveComplete getArchiveComplete() {
        return (ArchiveComplete) getExtension(ArchiveComplete.class);
    }

    public void setArchiveComplete(ArchiveComplete archiveComplete) {
        if (archiveComplete == null) {
            removeExtension(ArchiveComplete.class);
        } else {
            setExtension(archiveComplete);
        }
    }

    public boolean hasArchiveComplete() {
        return hasExtension(ArchiveComplete.class);
    }

    public List<ArchiveConversion> getArchiveConversions() {
        return getRepeatingExtension(ArchiveConversion.class);
    }

    public void addArchiveConversion(ArchiveConversion archiveConversion) {
        getArchiveConversions().add(archiveConversion);
    }

    public boolean hasArchiveConversions() {
        return hasRepeatingExtension(ArchiveConversion.class);
    }

    public List<ArchiveFailure> getArchiveFailures() {
        return getRepeatingExtension(ArchiveFailure.class);
    }

    public void addArchiveFailure(ArchiveFailure archiveFailure) {
        getArchiveFailures().add(archiveFailure);
    }

    public boolean hasArchiveFailures() {
        return hasRepeatingExtension(ArchiveFailure.class);
    }

    public ArchiveNotify getArchiveNotify() {
        return (ArchiveNotify) getExtension(ArchiveNotify.class);
    }

    public void setArchiveNotify(ArchiveNotify archiveNotify) {
        if (archiveNotify == null) {
            removeExtension(ArchiveNotify.class);
        } else {
            setExtension(archiveNotify);
        }
    }

    public boolean hasArchiveNotify() {
        return hasExtension(ArchiveNotify.class);
    }

    public ArchiveNotifyStatus getArchiveNotifyStatus() {
        return (ArchiveNotifyStatus) getExtension(ArchiveNotifyStatus.class);
    }

    public void setArchiveNotifyStatus(ArchiveNotifyStatus archiveNotifyStatus) {
        if (archiveNotifyStatus == null) {
            removeExtension(ArchiveNotifyStatus.class);
        } else {
            setExtension(archiveNotifyStatus);
        }
    }

    public boolean hasArchiveNotifyStatus() {
        return hasExtension(ArchiveNotifyStatus.class);
    }

    public List<ArchiveResourceId> getArchiveResourceIds() {
        return getRepeatingExtension(ArchiveResourceId.class);
    }

    public void addArchiveResourceId(ArchiveResourceId archiveResourceId) {
        getArchiveResourceIds().add(archiveResourceId);
    }

    public boolean hasArchiveResourceIds() {
        return hasRepeatingExtension(ArchiveResourceId.class);
    }

    public ArchiveStatus getArchiveStatus() {
        return (ArchiveStatus) getExtension(ArchiveStatus.class);
    }

    public void setArchiveStatus(ArchiveStatus archiveStatus) {
        if (archiveStatus == null) {
            removeExtension(ArchiveStatus.class);
        } else {
            setExtension(archiveStatus);
        }
    }

    public boolean hasArchiveStatus() {
        return hasExtension(ArchiveStatus.class);
    }

    public ArchiveTotal getArchiveTotal() {
        return (ArchiveTotal) getExtension(ArchiveTotal.class);
    }

    public void setArchiveTotal(ArchiveTotal archiveTotal) {
        if (archiveTotal == null) {
            removeExtension(ArchiveTotal.class);
        } else {
            setExtension(archiveTotal);
        }
    }

    public boolean hasArchiveTotal() {
        return hasExtension(ArchiveTotal.class);
    }

    public ArchiveTotalComplete getArchiveTotalComplete() {
        return (ArchiveTotalComplete) getExtension(ArchiveTotalComplete.class);
    }

    public void setArchiveTotalComplete(ArchiveTotalComplete archiveTotalComplete) {
        if (archiveTotalComplete == null) {
            removeExtension(ArchiveTotalComplete.class);
        } else {
            setExtension(archiveTotalComplete);
        }
    }

    public boolean hasArchiveTotalComplete() {
        return hasExtension(ArchiveTotalComplete.class);
    }

    public ArchiveTotalFailure getArchiveTotalFailure() {
        return (ArchiveTotalFailure) getExtension(ArchiveTotalFailure.class);
    }

    public void setArchiveTotalFailure(ArchiveTotalFailure archiveTotalFailure) {
        if (archiveTotalFailure == null) {
            removeExtension(ArchiveTotalFailure.class);
        } else {
            setExtension(archiveTotalFailure);
        }
    }

    public boolean hasArchiveTotalFailure() {
        return hasExtension(ArchiveTotalFailure.class);
    }

    public QuotaBytesUsed getQuotaBytesUsed() {
        return (QuotaBytesUsed) getExtension(QuotaBytesUsed.class);
    }

    public void setQuotaBytesUsed(QuotaBytesUsed quotaBytesUsed) {
        if (quotaBytesUsed == null) {
            removeExtension(QuotaBytesUsed.class);
        } else {
            setExtension(quotaBytesUsed);
        }
    }

    public boolean hasQuotaBytesUsed() {
        return hasExtension(QuotaBytesUsed.class);
    }

    protected void validate() {
    }

    public String toString() {
        return "{ArchiveEntry " + super.toString() + "}";
    }
}
