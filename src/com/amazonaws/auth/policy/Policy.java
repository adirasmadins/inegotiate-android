package com.amazonaws.auth.policy;

import com.amazonaws.auth.policy.internal.JsonPolicyWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Policy {
    private static final String DEFAULT_POLICY_VERSION = "2008-10-17";
    private String id;
    private List<Statement> statements;
    private String version;

    public Policy() {
        this.version = DEFAULT_POLICY_VERSION;
        this.statements = new ArrayList();
    }

    public Policy(String str) {
        this.version = DEFAULT_POLICY_VERSION;
        this.statements = new ArrayList();
        this.id = str;
    }

    public Policy(String str, Collection<Statement> collection) {
        this(str);
        setStatements(collection);
    }

    private void assignUniqueStatementIds() {
        Set hashSet = new HashSet();
        for (Statement statement : this.statements) {
            if (statement.getId() != null) {
                hashSet.add(statement.getId());
            }
        }
        int i = 0;
        for (Statement statement2 : this.statements) {
            if (statement2.getId() == null) {
                do {
                    i++;
                } while (hashSet.contains(Integer.toString(i)));
                statement2.setId(Integer.toString(i));
            }
        }
    }

    public String getId() {
        return this.id;
    }

    public Collection<Statement> getStatements() {
        return this.statements;
    }

    public String getVersion() {
        return this.version;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setStatements(Collection<Statement> collection) {
        this.statements = new ArrayList(collection);
        assignUniqueStatementIds();
    }

    public String toJson() {
        return new JsonPolicyWriter().writePolicyToString(this);
    }

    public Policy withId(String str) {
        setId(str);
        return this;
    }

    public Policy withStatements(Statement... statementArr) {
        setStatements(Arrays.asList(statementArr));
        return this;
    }
}
