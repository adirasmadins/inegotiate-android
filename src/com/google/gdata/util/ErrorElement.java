package com.google.gdata.util;

import com.google.gdata.util.ErrorContent.LocationType;
import com.google.gdata.util.common.base.Preconditions;

public class ErrorElement implements ErrorContent {
    private static final String GOOGLE_URI_PATTERN = "http://.*google\\.com/.*";
    private String errorCodeName;
    private String errorDebugInfo;
    private String errorDomainName;
    private String errorExtendedHelp;
    private String errorInternalReason;
    private String errorLocation;
    private LocationType errorLocationType;
    private String errorSendReport;

    ErrorElement() {
    }

    ErrorElement(ErrorContent source) {
        this.errorDomainName = source.getDomainName();
        this.errorCodeName = source.getCodeName();
        this.errorLocation = source.getLocation();
        this.errorLocationType = source.getLocationType();
        this.errorInternalReason = source.getInternalReason();
        this.errorExtendedHelp = source.getExtendedHelp();
        this.errorSendReport = source.getSendReport();
        this.errorDebugInfo = source.getDebugInfo();
    }

    public String getDomainName() {
        return this.errorDomainName;
    }

    public ErrorElement setDomain(String domainName) {
        Preconditions.checkNotNull(domainName, "Error domain must not be null.");
        this.errorDomainName = domainName;
        return this;
    }

    public String getCodeName() {
        return this.errorCodeName;
    }

    public ErrorElement setCode(String codeName) {
        Preconditions.checkNotNull(codeName, "Error code must not be null.");
        this.errorCodeName = codeName;
        return this;
    }

    public String getLocation() {
        return this.errorLocation;
    }

    public LocationType getLocationType() {
        return this.errorLocationType;
    }

    public ErrorElement setXpathLocation(String location) {
        return setLocation(location, LocationType.XPATH);
    }

    public ErrorElement setHeaderLocation(String location) {
        return setLocation(location, LocationType.HEADER);
    }

    public ErrorElement setLocation(String location) {
        return setLocation(location, LocationType.OTHER);
    }

    public ErrorElement setLocation(String location, LocationType locationType) {
        Preconditions.checkNotNull(location, "Location must not be null.");
        Preconditions.checkNotNull(locationType, "Location type must not be null.");
        this.errorLocation = location;
        this.errorLocationType = locationType;
        return this;
    }

    public String getInternalReason() {
        return this.errorInternalReason;
    }

    public ErrorElement setInternalReason(String internalReason) {
        Preconditions.checkNotNull(internalReason, "Internal Reason must not be null.");
        this.errorInternalReason = internalReason;
        return this;
    }

    public String getExtendedHelp() {
        return this.errorExtendedHelp;
    }

    public ErrorElement setExtendedHelp(String extendedHelp) {
        Preconditions.checkNotNull(extendedHelp, "Extended help uri must not be null.");
        Preconditions.checkArgument(extendedHelp.matches(GOOGLE_URI_PATTERN), "Invalid extended help URI: %s", extendedHelp);
        this.errorExtendedHelp = extendedHelp;
        return this;
    }

    public String getSendReport() {
        return this.errorSendReport;
    }

    public ErrorElement setSendReport(String sendReport) {
        Preconditions.checkNotNull(sendReport, "Send report uri must not be null.");
        Preconditions.checkArgument(sendReport.matches(GOOGLE_URI_PATTERN), "Invalid send report URI: %s", sendReport);
        this.errorSendReport = sendReport;
        return this;
    }

    public String getDebugInfo() {
        return this.errorDebugInfo;
    }

    public ErrorElement setDebugInfo(String debugInfo) {
        Preconditions.checkNotNull(debugInfo, "Debug info must not be null.");
        this.errorDebugInfo = debugInfo;
        return this;
    }
}
