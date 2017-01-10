package com.google.gdata.util;

import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.IEntry;
import com.google.gdata.util.ErrorDomain.ErrorCode;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import java.net.HttpURLConnection;

public class VersionConflictException extends ServiceException {
    private IEntry currentEntry;

    public VersionConflictException() {
        super("Version conflict");
        this.currentEntry = null;
        setHttpErrorCodeOverride(409);
    }

    public VersionConflictException(IEntry currentEntry) {
        super("Version conflict");
        this.currentEntry = currentEntry;
        setHttpErrorCodeOverride(409);
    }

    public VersionConflictException(IEntry currentEntry, Throwable cause) {
        super("Version conflict", cause);
        this.currentEntry = currentEntry;
        setHttpErrorCodeOverride(409);
    }

    public VersionConflictException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
    }

    public VersionConflictException(ErrorCode errorCode) {
        super((ErrorContent) errorCode);
        setHttpErrorCodeOverride(409);
    }

    public VersionConflictException(ErrorCode errorCode, Throwable cause) {
        super((ErrorContent) errorCode, cause);
        setHttpErrorCodeOverride(409);
    }

    public IEntry getCurrentEntry() {
        return this.currentEntry;
    }

    public void setCurrentEntry(IEntry entry) {
        this.currentEntry = entry;
    }

    public void generate(ExtensionProfile extProfile, XmlWriter xw) throws IOException {
        GenerateUtil.generateAtom(xw, this.currentEntry, extProfile);
    }
}
