package com.google.gdata.model;

import com.google.gdata.util.Version;
import com.google.gdata.wireformats.AltFormat;

public final class MetadataContext implements Comparable<MetadataContext> {
    public static final MetadataContext ATOM;
    public static final MetadataContext RSS;
    private final AltFormat altFormat;
    private final String projection;
    private final Version version;

    static {
        ATOM = forAlt(AltFormat.ATOM);
        RSS = forAlt(AltFormat.RSS);
    }

    public static MetadataContext forAlt(AltFormat format) {
        return forContext(format, null, null);
    }

    public static MetadataContext forProjection(String projection) {
        return forContext(null, projection, null);
    }

    public static MetadataContext forVersion(Version version) {
        return forContext(null, null, version);
    }

    public static MetadataContext forContext(AltFormat format, String projection, Version version) {
        if (format == null && projection == null && version == null) {
            return null;
        }
        return new MetadataContext(format, projection, version);
    }

    private MetadataContext(AltFormat format, String projection, Version version) {
        this.altFormat = format;
        this.projection = projection;
        this.version = version;
    }

    public boolean matches(MetadataContext other) {
        return other != null && ((this.altFormat == null || this.altFormat.equals(other.altFormat)) && ((this.projection == null || this.projection.equals(other.projection)) && (this.version == null || (other.version != null && other.version.isCompatible(this.version)))));
    }

    public AltFormat getAltFormat() {
        return this.altFormat;
    }

    public String getProjection() {
        return this.projection;
    }

    public Version getVersion() {
        return this.version;
    }

    public int compareTo(MetadataContext other) {
        if (this == other) {
            return 0;
        }
        int compare = compareAltFormat(this.altFormat, other.altFormat);
        if (compare != 0) {
            return compare;
        }
        compare = compareString(this.projection, other.projection);
        return compare == 0 ? compareVersion(this.version, other.version) : compare;
    }

    static int compareAltFormat(AltFormat a, AltFormat b) {
        String str = null;
        String name = a == null ? null : a.getName();
        if (b != null) {
            str = b.getName();
        }
        return compareString(name, str);
    }

    static int compareString(String a, String b) {
        if (a == b) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }
        return a.compareTo(b);
    }

    static int compareVersion(Version a, Version b) {
        if (a == b) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }
        int compare = MetadataKey.compareClass(a.getServiceClass(), b.getServiceClass());
        if (compare != 0) {
            return compare;
        }
        int aMajor = a.getMajor();
        int bMajor = b.getMajor();
        if (aMajor == bMajor) {
            int aMinor = a.getMinor();
            int bMinor = b.getMinor();
            if (aMinor >= bMinor) {
                return aMinor == bMinor ? 0 : 1;
            } else {
                return -1;
            }
        } else if (aMajor >= bMajor) {
            return 1;
        } else {
            return -1;
        }
    }

    public int hashCode() {
        int hash = 0;
        if (this.altFormat != null) {
            hash = 0 + this.altFormat.hashCode();
        }
        if (this.projection != null) {
            hash = (hash * 37) + this.projection.hashCode();
        }
        if (this.version != null) {
            return (hash * 37) + this.version.hashCode();
        }
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MetadataContext)) {
            return false;
        }
        MetadataContext other = (MetadataContext) obj;
        if (this.altFormat == null) {
            if (other.altFormat != null) {
                return false;
            }
        } else if (!this.altFormat.equals(other.altFormat)) {
            return false;
        }
        if (this.projection == null) {
            if (other.projection != null) {
                return false;
            }
        } else if (!this.projection.equals(other.projection)) {
            return false;
        }
        if (this.version == null) {
            if (other.version != null) {
                return false;
            }
            return true;
        } else if (this.version.equals(other.version)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{MetadataContext(");
        sb.append(this.altFormat);
        sb.append(',');
        sb.append(this.projection);
        sb.append(',');
        sb.append(this.version);
        sb.append(")}");
        return sb.toString();
    }
}
