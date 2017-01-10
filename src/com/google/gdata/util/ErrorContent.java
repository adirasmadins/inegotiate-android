package com.google.gdata.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface ErrorContent {

    public enum LocationType {
        XPATH,
        HEADER,
        OTHER;
        
        private static final Map<String, LocationType> VALUE_MAP;

        static {
            Map<String, LocationType> map = new HashMap();
            for (LocationType locationType : values()) {
                map.put(locationType.toString(), locationType);
            }
            VALUE_MAP = Collections.unmodifiableMap(map);
        }

        public static LocationType fromString(String value) {
            return (LocationType) VALUE_MAP.get(value);
        }

        public String toString() {
            return name().toLowerCase();
        }
    }

    String getCodeName();

    String getDebugInfo();

    String getDomainName();

    String getExtendedHelp();

    String getInternalReason();

    String getLocation();

    LocationType getLocationType();

    String getSendReport();
}
