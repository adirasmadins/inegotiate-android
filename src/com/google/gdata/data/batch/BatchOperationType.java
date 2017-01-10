package com.google.gdata.data.batch;

import com.google.gdata.util.Namespaces;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum BatchOperationType {
    QUERY("query", "GET"),
    INSERT("insert", "POST"),
    UPDATE("update", "PUT"),
    DELETE("delete", "DELETE");
    
    private static final Map<String, BatchOperationType> BY_NAME;
    private final String method;
    private final String name;

    static {
        BY_NAME = new HashMap();
        for (BatchOperationType op : values()) {
            BY_NAME.put(op.getName(), op);
        }
    }

    private BatchOperationType(String name, String method) {
        this.name = name;
        this.method = method;
    }

    public String getName() {
        return this.name;
    }

    public String getMethod() {
        return this.method;
    }

    public String toString() {
        return this.name;
    }

    public static BatchOperationType forName(String name) {
        return (BatchOperationType) BY_NAME.get(name);
    }

    public void generateAtom(XmlWriter w) throws IOException {
        w.simpleElement(Namespaces.batchNs, "operation", Collections.singletonList(new Attribute("type", getName())), null);
    }
}
