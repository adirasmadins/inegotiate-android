package com.google.common.net;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Nullable;

@Beta
public final class InetAddresses {
    private static final Inet4Address ANY4;
    private static final int IPV4_PART_COUNT = 4;
    private static final int IPV6_PART_COUNT = 8;
    private static final Inet4Address LOOPBACK4;

    @Beta
    public static final class TeredoInfo {
        private final Inet4Address client;
        private final int flags;
        private final int port;
        private final Inet4Address server;

        public TeredoInfo(@Nullable Inet4Address server, @Nullable Inet4Address client, int port, int flags) {
            boolean z = port >= 0 && port <= 65535;
            Preconditions.checkArgument(z, "port '%s' is out of range (0 <= port <= 0xffff)", Integer.valueOf(port));
            if (flags < 0 || flags > 65535) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z, "flags '%s' is out of range (0 <= flags <= 0xffff)", Integer.valueOf(flags));
            if (server != null) {
                this.server = server;
            } else {
                this.server = InetAddresses.ANY4;
            }
            if (client != null) {
                this.client = client;
            } else {
                this.client = InetAddresses.ANY4;
            }
            this.port = port;
            this.flags = flags;
        }

        public Inet4Address getServer() {
            return this.server;
        }

        public Inet4Address getClient() {
            return this.client;
        }

        public int getPort() {
            return this.port;
        }

        public int getFlags() {
            return this.flags;
        }
    }

    static {
        LOOPBACK4 = (Inet4Address) forString("127.0.0.1");
        ANY4 = (Inet4Address) forString("0.0.0.0");
    }

    private InetAddresses() {
    }

    private static Inet4Address getInet4Address(byte[] bytes) {
        boolean z;
        if (bytes.length == IPV4_PART_COUNT) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Byte array has invalid length for an IPv4 address: %s != 4.", Integer.valueOf(bytes.length));
        try {
            InetAddress ipv4 = InetAddress.getByAddress(bytes);
            if (ipv4 instanceof Inet4Address) {
                return (Inet4Address) ipv4;
            }
            throw new UnknownHostException(String.format("'%s' is not an IPv4 address.", new Object[]{ipv4.getHostAddress()}));
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException(String.format("Host address '%s' is not a valid IPv4 address.", new Object[]{Arrays.toString(bytes)}), e);
        }
    }

    public static InetAddress forString(String ipString) {
        byte[] addr = ipStringToBytes(ipString);
        if (addr == null) {
            throw new IllegalArgumentException(String.format("'%s' is not an IP string literal.", new Object[]{ipString}));
        }
        try {
            return InetAddress.getByAddress(addr);
        } catch (UnknownHostException e) {
            throw new IllegalArgumentException(String.format("'%s' is extremely broken.", new Object[]{ipString}), e);
        }
    }

    public static boolean isInetAddress(String ipString) {
        return ipStringToBytes(ipString) != null;
    }

    private static byte[] ipStringToBytes(String ipString) {
        boolean hasColon = false;
        boolean hasDot = false;
        for (int i = 0; i < ipString.length(); i++) {
            char c = ipString.charAt(i);
            if (c == '.') {
                hasDot = true;
            } else if (c == ':') {
                if (hasDot) {
                    return null;
                }
                hasColon = true;
            } else if (Character.digit(c, 16) == -1) {
                return null;
            }
        }
        if (hasColon) {
            if (hasDot) {
                ipString = convertDottedQuadToHex(ipString);
                if (ipString == null) {
                    return null;
                }
            }
            return textToNumericFormatV6(ipString);
        } else if (hasDot) {
            return textToNumericFormatV4(ipString);
        } else {
            return null;
        }
    }

    private static byte[] textToNumericFormatV4(String ipString) {
        String[] address = ipString.split("\\.", 5);
        if (address.length != IPV4_PART_COUNT) {
            return null;
        }
        byte[] bytes = new byte[IPV4_PART_COUNT];
        int i = 0;
        while (i < bytes.length) {
            try {
                bytes[i] = parseOctet(address[i]);
                i++;
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return bytes;
    }

    private static byte[] textToNumericFormatV6(String ipString) {
        String[] parts = ipString.split(":", 10);
        if (parts.length < 3 || parts.length > 9) {
            return null;
        }
        int i;
        int partsHi;
        int partsLo;
        int skipIndex = -1;
        for (i = 1; i < parts.length - 1; i++) {
            if (parts[i].length() == 0) {
                if (skipIndex >= 0) {
                    return null;
                }
                skipIndex = i;
            }
        }
        if (skipIndex >= 0) {
            partsHi = skipIndex;
            partsLo = (parts.length - skipIndex) - 1;
            if (parts[0].length() == 0) {
                partsHi--;
                if (partsHi != 0) {
                    return null;
                }
            }
            if (parts[parts.length - 1].length() == 0) {
                partsLo--;
                if (partsLo != 0) {
                    return null;
                }
            }
        }
        partsHi = parts.length;
        partsLo = 0;
        int partsSkipped = 8 - (partsHi + partsLo);
        if (skipIndex >= 0) {
            if (partsSkipped < 1) {
                return null;
            }
        } else if (partsSkipped != 0) {
            return null;
        }
        ByteBuffer rawBytes = ByteBuffer.allocate(16);
        i = 0;
        while (i < partsHi) {
            try {
                rawBytes.putShort(parseHextet(parts[i]));
                i++;
            } catch (NumberFormatException e) {
                return null;
            }
        }
        for (i = 0; i < partsSkipped; i++) {
            rawBytes.putShort((short) 0);
        }
        for (i = partsLo; i > 0; i--) {
            rawBytes.putShort(parseHextet(parts[parts.length - i]));
        }
        return rawBytes.array();
    }

    private static String convertDottedQuadToHex(String ipString) {
        int lastColon = ipString.lastIndexOf(58);
        String initialPart = ipString.substring(0, lastColon + 1);
        byte[] quad = textToNumericFormatV4(ipString.substring(lastColon + 1));
        if (quad == null) {
            return null;
        }
        String penultimate = Integer.toHexString(((quad[0] & 255) << IPV6_PART_COUNT) | (quad[1] & 255));
        return initialPart + penultimate + ":" + Integer.toHexString(((quad[2] & 255) << IPV6_PART_COUNT) | (quad[3] & 255));
    }

    private static byte parseOctet(String ipPart) {
        int octet = Integer.parseInt(ipPart);
        if (octet <= 255 && (!ipPart.startsWith("0") || ipPart.length() <= 1)) {
            return (byte) octet;
        }
        throw new NumberFormatException();
    }

    private static short parseHextet(String ipPart) {
        int hextet = Integer.parseInt(ipPart, 16);
        if (hextet <= 65535) {
            return (short) hextet;
        }
        throw new NumberFormatException();
    }

    public static String toAddrString(InetAddress ip) {
        Preconditions.checkNotNull(ip);
        if (ip instanceof Inet4Address) {
            return ip.getHostAddress();
        }
        Preconditions.checkArgument(ip instanceof Inet6Address);
        byte[] bytes = ip.getAddress();
        int[] hextets = new int[IPV6_PART_COUNT];
        for (int i = 0; i < hextets.length; i++) {
            hextets[i] = Ints.fromBytes((byte) 0, (byte) 0, bytes[i * 2], bytes[(i * 2) + 1]);
        }
        compressLongestRunOfZeroes(hextets);
        return hextetsToIPv6String(hextets);
    }

    private static void compressLongestRunOfZeroes(int[] hextets) {
        int bestRunStart = -1;
        int bestRunLength = -1;
        int runStart = -1;
        int i = 0;
        while (i < hextets.length + 1) {
            if (i >= hextets.length || hextets[i] != 0) {
                if (runStart >= 0) {
                    int runLength = i - runStart;
                    if (runLength > bestRunLength) {
                        bestRunStart = runStart;
                        bestRunLength = runLength;
                    }
                    runStart = -1;
                }
            } else if (runStart < 0) {
                runStart = i;
            }
            i++;
        }
        if (bestRunLength >= 2) {
            Arrays.fill(hextets, bestRunStart, bestRunStart + bestRunLength, -1);
        }
    }

    private static String hextetsToIPv6String(int[] hextets) {
        StringBuilder buf = new StringBuilder(39);
        boolean lastWasNumber = false;
        for (int i = 0; i < hextets.length; i++) {
            boolean thisIsNumber = hextets[i] >= 0;
            if (thisIsNumber) {
                if (lastWasNumber) {
                    buf.append(':');
                }
                buf.append(Integer.toHexString(hextets[i]));
            } else if (i == 0 || lastWasNumber) {
                buf.append("::");
            }
            lastWasNumber = thisIsNumber;
        }
        return buf.toString();
    }

    public static String toUriString(InetAddress ip) {
        if (ip instanceof Inet6Address) {
            return "[" + toAddrString(ip) + "]";
        }
        return toAddrString(ip);
    }

    public static InetAddress forUriString(String hostAddr) {
        InetAddress retval;
        Preconditions.checkNotNull(hostAddr);
        Preconditions.checkArgument(hostAddr.length() > 0, "host string is empty");
        try {
            retval = forString(hostAddr);
            if (retval instanceof Inet4Address) {
                return retval;
            }
        } catch (IllegalArgumentException e) {
        }
        if (hostAddr.startsWith("[") && hostAddr.endsWith("]")) {
            retval = forString(hostAddr.substring(1, hostAddr.length() - 1));
            if (retval instanceof Inet6Address) {
                return retval;
            }
            throw new IllegalArgumentException("Not a valid address: \"" + hostAddr + '\"');
        }
        throw new IllegalArgumentException("Not a valid address: \"" + hostAddr + '\"');
    }

    public static boolean isUriInetAddress(String ipString) {
        try {
            forUriString(ipString);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean isCompatIPv4Address(Inet6Address ip) {
        if (!ip.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] bytes = ip.getAddress();
        if (bytes[12] == null && bytes[13] == null && bytes[14] == null && (bytes[15] == null || bytes[15] == (byte) 1)) {
            return false;
        }
        return true;
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address ip) {
        Preconditions.checkArgument(isCompatIPv4Address(ip), "Address '%s' is not IPv4-compatible.", toAddrString(ip));
        return getInet4Address(copyOfRange(ip.getAddress(), 12, 16));
    }

    public static boolean is6to4Address(Inet6Address ip) {
        byte[] bytes = ip.getAddress();
        if (bytes[0] == 32 && bytes[1] == 2) {
            return true;
        }
        return false;
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address ip) {
        Preconditions.checkArgument(is6to4Address(ip), "Address '%s' is not a 6to4 address.", toAddrString(ip));
        return getInet4Address(copyOfRange(ip.getAddress(), 2, 6));
    }

    public static boolean isTeredoAddress(Inet6Address ip) {
        byte[] bytes = ip.getAddress();
        if (bytes[0] == 32 && bytes[1] == (byte) 1 && bytes[2] == null && bytes[3] == null) {
            return true;
        }
        return false;
    }

    public static TeredoInfo getTeredoInfo(Inet6Address ip) {
        Preconditions.checkArgument(isTeredoAddress(ip), "Address '%s' is not a Teredo address.", toAddrString(ip));
        byte[] bytes = ip.getAddress();
        Inet4Address server = getInet4Address(copyOfRange(bytes, IPV4_PART_COUNT, IPV6_PART_COUNT));
        int flags = ByteStreams.newDataInput(bytes, IPV6_PART_COUNT).readShort() & 65535;
        int port = (ByteStreams.newDataInput(bytes, 10).readShort() ^ -1) & 65535;
        byte[] clientBytes = copyOfRange(bytes, 12, 16);
        for (int i = 0; i < clientBytes.length; i++) {
            clientBytes[i] = (byte) (clientBytes[i] ^ -1);
        }
        return new TeredoInfo(server, getInet4Address(clientBytes), port, flags);
    }

    public static boolean isIsatapAddress(Inet6Address ip) {
        if (isTeredoAddress(ip)) {
            return false;
        }
        byte[] bytes = ip.getAddress();
        if ((bytes[IPV6_PART_COUNT] | 3) == 3 && bytes[9] == null && bytes[10] == 94 && bytes[11] == -2) {
            return true;
        }
        return false;
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address ip) {
        Preconditions.checkArgument(isIsatapAddress(ip), "Address '%s' is not an ISATAP address.", toAddrString(ip));
        return getInet4Address(copyOfRange(ip.getAddress(), 12, 16));
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address ip) {
        return isCompatIPv4Address(ip) || is6to4Address(ip) || isTeredoAddress(ip);
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address ip) {
        if (isCompatIPv4Address(ip)) {
            return getCompatIPv4Address(ip);
        }
        if (is6to4Address(ip)) {
            return get6to4IPv4Address(ip);
        }
        if (isTeredoAddress(ip)) {
            return getTeredoInfo(ip).getClient();
        }
        throw new IllegalArgumentException(String.format("'%s' has no embedded IPv4 address.", new Object[]{toAddrString(ip)}));
    }

    public static boolean isMappedIPv4Address(String ipString) {
        byte[] bytes = ipStringToBytes(ipString);
        if (bytes == null || bytes.length != 16) {
            return false;
        }
        int i;
        for (i = 0; i < 10; i++) {
            if (bytes[i] != null) {
                return false;
            }
        }
        for (i = 10; i < 12; i++) {
            if (bytes[i] != -1) {
                return false;
            }
        }
        return true;
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress ip) {
        if (ip instanceof Inet4Address) {
            return (Inet4Address) ip;
        }
        byte[] bytes = ip.getAddress();
        boolean leadingBytesOfZero = true;
        for (int i = 0; i < 15; i++) {
            if (bytes[i] != null) {
                leadingBytesOfZero = false;
                break;
            }
        }
        if (leadingBytesOfZero && bytes[15] == 1) {
            return LOOPBACK4;
        }
        if (leadingBytesOfZero && bytes[15] == null) {
            return ANY4;
        }
        long addressAsLong;
        Inet6Address ip6 = (Inet6Address) ip;
        if (hasEmbeddedIPv4ClientAddress(ip6)) {
            addressAsLong = (long) getEmbeddedIPv4ClientAddress(ip6).hashCode();
        } else {
            addressAsLong = ByteBuffer.wrap(ip6.getAddress(), 0, IPV6_PART_COUNT).getLong();
        }
        int coercedHash = hash64To32(addressAsLong) | -536870912;
        if (coercedHash == -1) {
            coercedHash = -2;
        }
        return getInet4Address(Ints.toByteArray(coercedHash));
    }

    @VisibleForTesting
    static int hash64To32(long key) {
        key = (-1 ^ key) + (key << 18);
        key = (key ^ (key >>> 31)) * 21;
        key ^= key >>> 11;
        key += key << 6;
        return (int) (key ^ (key >>> 22));
    }

    public static int coerceToInteger(InetAddress ip) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(ip).getAddress()).readInt();
    }

    public static Inet4Address fromInteger(int address) {
        return getInet4Address(Ints.toByteArray(address));
    }

    public static InetAddress fromLittleEndianByteArray(byte[] addr) throws UnknownHostException {
        byte[] reversed = new byte[addr.length];
        for (int i = 0; i < addr.length; i++) {
            reversed[i] = addr[(addr.length - i) - 1];
        }
        return InetAddress.getByAddress(reversed);
    }

    public static InetAddress increment(InetAddress address) {
        boolean z;
        byte[] addr = address.getAddress();
        int i = addr.length - 1;
        while (i >= 0 && addr[i] == -1) {
            addr[i] = (byte) 0;
            i--;
        }
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Incrementing %s would wrap.", address);
        addr[i] = (byte) (addr[i] + 1);
        try {
            return InetAddress.getByAddress(addr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    public static boolean isMaximum(InetAddress address) {
        byte[] addr = address.getAddress();
        for (byte b : addr) {
            if (b != -1) {
                return false;
            }
        }
        return true;
    }

    private static byte[] copyOfRange(byte[] original, int from, int to) {
        Preconditions.checkNotNull(original);
        byte[] result = new byte[(to - from)];
        System.arraycopy(original, from, result, 0, Math.min(to, original.length) - from);
        return result;
    }
}
