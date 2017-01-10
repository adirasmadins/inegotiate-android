package com.amazonaws.auth.policy.internal;

import com.amazonaws.auth.policy.Action;
import com.amazonaws.auth.policy.Condition;
import com.amazonaws.auth.policy.Policy;
import com.amazonaws.auth.policy.Principal;
import com.amazonaws.auth.policy.Resource;
import com.amazonaws.auth.policy.Statement;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonPolicyWriter {
    private Map<String, List<String>> sortConditionsByKey(List<Condition> list) {
        Map<String, List<String>> hashMap = new HashMap();
        for (Condition condition : list) {
            String conditionKey = condition.getConditionKey();
            Collection values = condition.getValues();
            if (!hashMap.containsKey(conditionKey)) {
                hashMap.put(conditionKey, new ArrayList());
            }
            ((List) hashMap.get(conditionKey)).addAll(values);
        }
        return hashMap;
    }

    private Map<String, List<Condition>> sortConditionsByType(List<Condition> list) {
        Map<String, List<Condition>> hashMap = new HashMap();
        for (Condition condition : list) {
            String type = condition.getType();
            if (hashMap.get(type) == null) {
                hashMap.put(type, new ArrayList());
            }
            ((List) hashMap.get(type)).add(condition);
        }
        return hashMap;
    }

    private void writeActions(Statement statement, JSONWriter jSONWriter) throws IOException, JSONException {
        List<Action> actions = statement.getActions();
        if (actions != null && !actions.isEmpty()) {
            jSONWriter.key("Action").array();
            for (Action actionName : actions) {
                jSONWriter.value(actionName.getActionName());
            }
            jSONWriter.endArray();
        }
    }

    private void writeConditions(Statement statement, JSONWriter jSONWriter) throws IOException, JSONException {
        List conditions = statement.getConditions();
        if (conditions != null && !conditions.isEmpty()) {
            Map sortConditionsByType = sortConditionsByType(conditions);
            jSONWriter.key("Condition").object();
            for (String str : sortConditionsByType.keySet()) {
                jSONWriter.key(str).object();
                Map sortConditionsByKey = sortConditionsByKey((List) sortConditionsByType.get(str));
                for (String str2 : sortConditionsByKey.keySet()) {
                    jSONWriter.key(str2).array();
                    for (Object value : (List) sortConditionsByKey.get(str2)) {
                        jSONWriter.value(value);
                    }
                    jSONWriter.endArray();
                }
                jSONWriter.endObject();
            }
            jSONWriter.endObject();
        }
    }

    private void writePolicy(Policy policy, JSONWriter jSONWriter) throws JSONException, IOException {
        jSONWriter.object();
        jSONWriter.key("Version").value(policy.getVersion());
        if (policy.getId() != null) {
            jSONWriter.key("Id").value(policy.getId());
        }
        jSONWriter.key("Statement").array();
        for (Statement statement : policy.getStatements()) {
            jSONWriter.object();
            if (statement.getId() != null) {
                jSONWriter.key("Sid").value(statement.getId());
            }
            jSONWriter.key("Effect").value(statement.getEffect().toString());
            writePrincipals(statement, jSONWriter);
            writeActions(statement, jSONWriter);
            writeResources(statement, jSONWriter);
            writeConditions(statement, jSONWriter);
            jSONWriter.endObject();
        }
        jSONWriter.endArray();
        jSONWriter.endObject();
    }

    private void writePrincipals(Statement statement, JSONWriter jSONWriter) throws IOException, JSONException {
        List<Principal> principals = statement.getPrincipals();
        if (principals != null && !principals.isEmpty()) {
            jSONWriter.key("Principal").object();
            Map hashMap = new HashMap();
            for (Principal principal : principals) {
                List list = (List) hashMap.get(principal.getProvider());
                if (list == null) {
                    list = new ArrayList();
                    hashMap.put(principal.getProvider(), list);
                }
                list.add(principal.getId());
            }
            for (String str : hashMap.keySet()) {
                jSONWriter.key(str).array();
                for (Object value : (List) hashMap.get(str)) {
                    jSONWriter.value(value);
                }
                jSONWriter.endArray();
            }
            jSONWriter.endObject();
        }
    }

    private void writeResources(Statement statement, JSONWriter jSONWriter) throws IOException, JSONException {
        List<Resource> resources = statement.getResources();
        if (resources != null && !resources.isEmpty()) {
            jSONWriter.key("Resource").array();
            for (Resource id : resources) {
                jSONWriter.value(id.getId());
            }
            jSONWriter.endArray();
        }
    }

    public String writePolicyToString(Policy policy) {
        if (policy == null) {
            throw new IllegalArgumentException("Policy cannot be null");
        }
        Writer stringWriter = new StringWriter();
        try {
            writePolicy(policy, new JSONWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            try {
                stringWriter.close();
            } catch (Exception e) {
            }
            return stringWriter2;
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Unable to serialize policy to JSON string: " + e2.getMessage(), e2);
        } catch (Throwable th) {
            try {
                stringWriter.close();
            } catch (Exception e3) {
            }
        }
    }
}
