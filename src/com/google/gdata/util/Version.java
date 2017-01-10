package com.google.gdata.util;

import com.google.gdata.client.Service;
import com.google.gdata.util.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Version {
    public static final int ANY = -1;
    private static final Pattern VERSION_PROPERTY_PATTERN;
    private List<Version> impliedVersions;
    private int major;
    private int minor;
    private Class<? extends Service> serviceClass;

    public static Version findServiceVersion(Collection<? extends Version> versionList, Class<? extends Service> serviceClass) {
        for (Version v : versionList) {
            if (v.getServiceClass().equals(serviceClass)) {
                return v;
            }
        }
        return null;
    }

    public static Version anyMinorVersionOf(Version v) {
        return new Version(v.getServiceClass(), v.getMajor(), ANY, new Version[0]);
    }

    static {
        VERSION_PROPERTY_PATTERN = Pattern.compile("([^\\d]+-)?(\\d+)(\\.\\d+)?");
    }

    public Version(Class<? extends Service> serviceClass, int major, int minor, Version... impliedVersions) throws NullPointerException, IllegalArgumentException {
        this.impliedVersions = new ArrayList();
        if (serviceClass == null) {
            throw new NullPointerException("Null service class");
        } else if (major < 0 && major != ANY) {
            throw new IllegalArgumentException("Invalid major version:" + major);
        } else if (minor >= 0 || minor == ANY) {
            this.serviceClass = serviceClass;
            this.major = major;
            this.minor = minor;
            computeImpliedVersions(impliedVersions);
        } else {
            throw new IllegalArgumentException("Invalid minor version:" + minor);
        }
    }

    public Version(Class<? extends Service> serviceClass, String versionDescription, Version... impliedVersions) throws IllegalArgumentException {
        this.impliedVersions = new ArrayList();
        this.serviceClass = serviceClass;
        Matcher matcher = VERSION_PROPERTY_PATTERN.matcher(versionDescription);
        if (matcher.matches()) {
            String minorValue = matcher.group(3);
            this.major = Integer.parseInt(matcher.group(2));
            this.minor = minorValue != null ? Integer.parseInt(minorValue.substring(1)) : ANY;
            computeImpliedVersions(impliedVersions);
            return;
        }
        throw new IllegalArgumentException("Version description does not match expected format[{service}]{major}[.{minor}]:" + versionDescription);
    }

    public final Class<? extends Service> getServiceClass() {
        return this.serviceClass;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final String getVersionString() {
        StringBuilder sb = new StringBuilder();
        if (this.major != ANY) {
            sb.append(this.major);
        }
        if (this.minor != ANY) {
            sb.append('.');
            sb.append(this.minor);
        }
        return sb.toString();
    }

    public final boolean isSameService(Version v) {
        return v != null && this.serviceClass.equals(v.serviceClass);
    }

    public final boolean isCompatible(Version v) {
        if (isSameService(v) && (this.major == v.major || this.major == ANY || v.major == ANY)) {
            return true;
        }
        for (Version impliedVersion : this.impliedVersions) {
            if (impliedVersion != this && impliedVersion.isCompatible(v)) {
                return true;
            }
        }
        return false;
    }

    private int raiseAny(int versionNumber) {
        return versionNumber != ANY ? versionNumber : Integer.MAX_VALUE;
    }

    public final boolean matches(Version v) {
        if (isSameService(v) && ((this.major == v.major || this.major == ANY || v.major == ANY) && (this.minor == v.minor || this.minor == ANY || v.minor == ANY))) {
            return true;
        }
        for (Version impliedVersion : this.impliedVersions) {
            if (impliedVersion != this && impliedVersion.matches(v)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isAfter(Version v) {
        boolean z;
        Version serviceVersion = findServiceVersion(this.impliedVersions, v.getServiceClass());
        if (serviceVersion != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "No relationship between versions");
        int serviceMajor = raiseAny(serviceVersion.major);
        int vMajor = raiseAny(v.major);
        if (serviceMajor != vMajor) {
            if (serviceMajor > vMajor) {
                return true;
            }
            return false;
        } else if (raiseAny(serviceVersion.minor) <= raiseAny(v.minor)) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean isBefore(Version v) {
        Version serviceVersion = findServiceVersion(this.impliedVersions, v.getServiceClass());
        Preconditions.checkArgument(serviceVersion != null, "No relationship between versions");
        if (serviceVersion.major != v.major) {
            if (serviceVersion.major < v.major) {
                return true;
            }
            return false;
        } else if (serviceVersion.minor >= v.minor) {
            return false;
        } else {
            return true;
        }
    }

    public List<Version> getImpliedVersions() {
        return this.impliedVersions;
    }

    private void computeImpliedVersions(Version... versionList) {
        this.impliedVersions.add(this);
        for (Version v : versionList) {
            addImpliedVersion(v);
        }
    }

    private void addImpliedVersion(Version v) {
        if (!this.impliedVersions.contains(v)) {
            this.impliedVersions.add(v);
            for (Version impliedVersion : v.getImpliedVersions()) {
                addImpliedVersion(impliedVersion);
            }
        }
    }

    public boolean equals(Object o) {
        if (!(o instanceof Version)) {
            return false;
        }
        Version v = (Version) o;
        if (isSameService(v) && this.major == v.major && this.minor == v.minor) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.serviceClass.hashCode() * 37) + this.major) * 37) + this.minor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.serviceClass.getName());
        sb.append(':');
        sb.append(getVersionString());
        return sb.toString();
    }
}
