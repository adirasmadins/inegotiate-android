package com.google.gdata.util;

import com.google.gdata.util.ErrorContent.LocationType;
import com.google.gdata.util.common.base.Preconditions;

public abstract class ErrorDomain {
    private final String domainName;

    public class ErrorCode implements ErrorContent {
        private final String codeName;
        private final String extendedHelp;
        private final String internalReason;
        private final String sendReport;

        public ErrorCode(ErrorDomain errorDomain, String codeName) {
            this(codeName, null, null, null);
        }

        private ErrorCode(String codeName, String extendedHelp, String internalReason, String sendReport) {
            Preconditions.checkNotNull(codeName, "codeName");
            this.codeName = codeName;
            this.extendedHelp = extendedHelp;
            this.internalReason = internalReason;
            this.sendReport = sendReport;
        }

        public String getDomainName() {
            return ErrorDomain.this.getDomainName();
        }

        public String getCodeName() {
            return this.codeName;
        }

        public String getInternalReason() {
            return this.internalReason;
        }

        @Deprecated
        public ErrorCode setInternalReason(String newInternalReason) {
            return withInternalReason(newInternalReason);
        }

        public ErrorCode withInternalReason(String newInternalReason) {
            return new ErrorCode(this.codeName, this.extendedHelp, newInternalReason, this.sendReport);
        }

        public String getExtendedHelp() {
            return this.extendedHelp;
        }

        public ErrorCode withExtendedHelp(String newExtendedHelp) {
            return new ErrorCode(this.codeName, newExtendedHelp, this.internalReason, this.sendReport);
        }

        public String getSendReport() {
            return this.sendReport;
        }

        public ErrorCode withSendReport(String newSendReport) {
            return new ErrorCode(this.codeName, this.extendedHelp, this.internalReason, newSendReport);
        }

        public String getLocation() {
            return null;
        }

        public LocationType getLocationType() {
            return null;
        }

        public String getDebugInfo() {
            return null;
        }
    }

    public String getDomainName() {
        return this.domainName;
    }

    protected ErrorDomain(String domainName) {
        this.domainName = domainName;
    }

    protected ErrorDomain() {
        this.domainName = getClass().getName();
    }
}
