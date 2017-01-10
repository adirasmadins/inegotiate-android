package com.google.gdata.util;

import com.google.common.annotations.VisibleForTesting;
import com.google.gdata.client.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VersionRegistry {
    private static VersionRegistry versionRegistry;
    private List<Version> defaultVersions;
    private ThreadLocal<List<Version>> threadVersions;

    public VersionRegistry() {
        this.threadVersions = new ThreadLocal();
        this.defaultVersions = new ArrayList();
    }

    public static synchronized VersionRegistry ensureRegistry() {
        VersionRegistry versionRegistry;
        synchronized (VersionRegistry.class) {
            if (versionRegistry == null) {
                versionRegistry = new VersionRegistry();
            }
            versionRegistry = versionRegistry;
        }
        return versionRegistry;
    }

    @VisibleForTesting
    static void reset() {
        versionRegistry = null;
    }

    public static final VersionRegistry get() {
        if (versionRegistry != null) {
            return versionRegistry;
        }
        throw new IllegalStateException("Uninitialized version registry");
    }

    public static Version getVersionFromProperty(Class<? extends Service> serviceClass) {
        String propertyName = serviceClass.getName() + ".version";
        String versionProperty = System.getProperty(propertyName);
        if (versionProperty == null) {
            return null;
        }
        try {
            return new Version(serviceClass, versionProperty, new Version[0]);
        } catch (IllegalArgumentException iae) {
            throw new IllegalStateException("Invalid version property value: " + propertyName, iae);
        }
    }

    @VisibleForTesting
    static void mergeVersions(List<Version> target, List<Version> source) {
        for (Version checkVersion : source) {
            Version currentVersion = Version.findServiceVersion(target, checkVersion.getServiceClass());
            if (currentVersion != null) {
                target.remove(currentVersion);
            }
        }
        target.addAll(source);
    }

    @VisibleForTesting
    static void mergeVersions(List<Version> target, Version source) {
        mergeVersions((List) target, Arrays.asList(new Version[]{source}));
    }

    public List<Version> getDefaultVersions() {
        return this.defaultVersions;
    }

    public void addDefaultVersion(Version newDefault, boolean includeImplied) {
        List newDefaults = new ArrayList(this.defaultVersions);
        if (includeImplied) {
            mergeVersions(newDefaults, newDefault.getImpliedVersions());
        } else {
            mergeVersions(newDefaults, newDefault);
        }
        this.defaultVersions = Collections.unmodifiableList(newDefaults);
    }

    public void setThreadVersion(Version version) {
        this.threadVersions.set(Collections.unmodifiableList(version.getImpliedVersions()));
    }

    public List<Version> getThreadVersions() {
        return (List) this.threadVersions.get();
    }

    public void resetThreadVersion() {
        if (this.threadVersions != null) {
            this.threadVersions.remove();
        }
    }

    @VisibleForTesting
    List<Version> getVersions() {
        List<Version> defaultList = getDefaultVersions();
        List threadList = getThreadVersions();
        if (threadList == null) {
            return defaultList;
        }
        List<Version> combinedList = new ArrayList(defaultList.size() + threadList.size());
        combinedList.addAll(defaultList);
        mergeVersions((List) combinedList, threadList);
        return combinedList;
    }

    public Version getVersion(Class<? extends Service> serviceClass) {
        Version v = null;
        List<Version> threadList = getThreadVersions();
        if (threadList != null) {
            v = Version.findServiceVersion(threadList, serviceClass);
        }
        if (v == null) {
            v = Version.findServiceVersion(getDefaultVersions(), serviceClass);
            if (v == null) {
                throw new IllegalStateException("Attempt to access version information for unversioned service:" + serviceClass);
            }
        }
        return v;
    }

    @VisibleForTesting
    public synchronized void reset(List<Version> initialDefaults) {
        this.threadVersions = new ThreadLocal();
        if (initialDefaults != null) {
            this.defaultVersions = new ArrayList(initialDefaults);
        } else {
            this.defaultVersions = new ArrayList();
        }
    }
}
