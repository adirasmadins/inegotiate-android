package com.amazonaws.services.ec2.model;

import com.google.gdata.util.common.base.StringUtil;

public enum ResourceType {
    CustomerGateway("customer-gateway"),
    DhcpOptions("dhcp-options"),
    Image("image"),
    Instance("instance"),
    Snapshot("snapshot"),
    SpotInstancesRequest("spot-instances-request"),
    Subnet("subnet"),
    Volume("volume"),
    Vpc("vpc"),
    VpnConnection("vpn-connection"),
    VpnGateway("vpn-gateway");
    
    private String value;

    private ResourceType(String str) {
        this.value = str;
    }

    public static ResourceType fromValue(String str) {
        if (str == null || StringUtil.EMPTY_STRING.equals(str)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        } else if ("customer-gateway".equals(str)) {
            return CustomerGateway;
        } else {
            if ("dhcp-options".equals(str)) {
                return DhcpOptions;
            }
            if ("image".equals(str)) {
                return Image;
            }
            if ("instance".equals(str)) {
                return Instance;
            }
            if ("snapshot".equals(str)) {
                return Snapshot;
            }
            if ("spot-instances-request".equals(str)) {
                return SpotInstancesRequest;
            }
            if ("subnet".equals(str)) {
                return Subnet;
            }
            if ("volume".equals(str)) {
                return Volume;
            }
            if ("vpc".equals(str)) {
                return Vpc;
            }
            if ("vpn-connection".equals(str)) {
                return VpnConnection;
            }
            if ("vpn-gateway".equals(str)) {
                return VpnGateway;
            }
            throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
        }
    }

    public String toString() {
        return this.value;
    }
}
