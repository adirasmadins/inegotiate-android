package com.google.gdata.data.docs;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.Category;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.Kind.Term;
import com.google.gdata.data.extensions.QuotaBytesTotal;
import com.google.gdata.data.extensions.QuotaBytesUsed;
import com.google.gdata.util.Namespaces;
import java.util.List;

@Term("http://schemas.google.com/docs/2007#metadata")
public class MetadataEntry extends BaseEntry<MetadataEntry> {
    public static final Category CATEGORY;
    public static final String KIND = "http://schemas.google.com/docs/2007#metadata";

    static {
        CATEGORY = new Category(Namespaces.gKind, KIND, "metadata");
    }

    public MetadataEntry() {
        getCategories().add(CATEGORY);
    }

    public MetadataEntry(BaseEntry<?> sourceEntry) {
        super(sourceEntry);
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        if (!extProfile.isDeclared(MetadataEntry.class)) {
            super.declareExtensions(extProfile);
            extProfile.declare(MetadataEntry.class, AdditionalRoleInfo.getDefaultDescription(false, true));
            new AdditionalRoleInfo().declareExtensions(extProfile);
            extProfile.declare(MetadataEntry.class, ExportFormat.getDefaultDescription(false, true));
            extProfile.declare(MetadataEntry.class, Feature.getDefaultDescription(false, true));
            new Feature().declareExtensions(extProfile);
            extProfile.declare(MetadataEntry.class, ImportFormat.getDefaultDescription(false, true));
            extProfile.declare(MetadataEntry.class, LargestChangestamp.getDefaultDescription(true, false));
            extProfile.declare(MetadataEntry.class, MaxUploadSize.getDefaultDescription(false, true));
            extProfile.declare(MetadataEntry.class, QuotaBytesTotal.class);
            extProfile.declare(MetadataEntry.class, QuotaBytesUsed.class);
            extProfile.declare(MetadataEntry.class, QuotaBytesUsedInTrash.class);
            extProfile.declare(MetadataEntry.class, RemainingChangestamps.class);
        }
    }

    public List<AdditionalRoleInfo> getAdditionalRoleInfos() {
        return getRepeatingExtension(AdditionalRoleInfo.class);
    }

    public void addAdditionalRoleInfo(AdditionalRoleInfo additionalRoleInfo) {
        getAdditionalRoleInfos().add(additionalRoleInfo);
    }

    public boolean hasAdditionalRoleInfos() {
        return hasRepeatingExtension(AdditionalRoleInfo.class);
    }

    public List<ExportFormat> getExportFormats() {
        return getRepeatingExtension(ExportFormat.class);
    }

    public void addExportFormat(ExportFormat exportFormat) {
        getExportFormats().add(exportFormat);
    }

    public boolean hasExportFormats() {
        return hasRepeatingExtension(ExportFormat.class);
    }

    public List<Feature> getFeatures() {
        return getRepeatingExtension(Feature.class);
    }

    public void addFeature(Feature feature) {
        getFeatures().add(feature);
    }

    public boolean hasFeatures() {
        return hasRepeatingExtension(Feature.class);
    }

    public List<ImportFormat> getImportFormats() {
        return getRepeatingExtension(ImportFormat.class);
    }

    public void addImportFormat(ImportFormat importFormat) {
        getImportFormats().add(importFormat);
    }

    public boolean hasImportFormats() {
        return hasRepeatingExtension(ImportFormat.class);
    }

    public LargestChangestamp getLargestChangestamp() {
        return (LargestChangestamp) getExtension(LargestChangestamp.class);
    }

    public void setLargestChangestamp(LargestChangestamp largestChangestamp) {
        if (largestChangestamp == null) {
            removeExtension(LargestChangestamp.class);
        } else {
            setExtension(largestChangestamp);
        }
    }

    public boolean hasLargestChangestamp() {
        return hasExtension(LargestChangestamp.class);
    }

    public List<MaxUploadSize> getMaxUploadSizes() {
        return getRepeatingExtension(MaxUploadSize.class);
    }

    public void addMaxUploadSize(MaxUploadSize maxUploadSize) {
        getMaxUploadSizes().add(maxUploadSize);
    }

    public boolean hasMaxUploadSizes() {
        return hasRepeatingExtension(MaxUploadSize.class);
    }

    public QuotaBytesTotal getQuotaBytesTotal() {
        return (QuotaBytesTotal) getExtension(QuotaBytesTotal.class);
    }

    public void setQuotaBytesTotal(QuotaBytesTotal quotaBytesTotal) {
        if (quotaBytesTotal == null) {
            removeExtension(QuotaBytesTotal.class);
        } else {
            setExtension(quotaBytesTotal);
        }
    }

    public boolean hasQuotaBytesTotal() {
        return hasExtension(QuotaBytesTotal.class);
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

    public QuotaBytesUsedInTrash getQuotaBytesUsedInTrash() {
        return (QuotaBytesUsedInTrash) getExtension(QuotaBytesUsedInTrash.class);
    }

    public void setQuotaBytesUsedInTrash(QuotaBytesUsedInTrash quotaBytesUsedInTrash) {
        if (quotaBytesUsedInTrash == null) {
            removeExtension(QuotaBytesUsedInTrash.class);
        } else {
            setExtension(quotaBytesUsedInTrash);
        }
    }

    public boolean hasQuotaBytesUsedInTrash() {
        return hasExtension(QuotaBytesUsedInTrash.class);
    }

    public RemainingChangestamps getRemainingChangestamps() {
        return (RemainingChangestamps) getExtension(RemainingChangestamps.class);
    }

    public void setRemainingChangestamps(RemainingChangestamps remainingChangestamps) {
        if (remainingChangestamps == null) {
            removeExtension(RemainingChangestamps.class);
        } else {
            setExtension(remainingChangestamps);
        }
    }

    public boolean hasRemainingChangestamps() {
        return hasExtension(RemainingChangestamps.class);
    }

    protected void validate() {
    }

    public String toString() {
        return "{MetadataEntry " + super.toString() + "}";
    }
}
