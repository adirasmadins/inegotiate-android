package com.amazonaws.services.s3.model;

import java.util.Arrays;
import java.util.List;

public class BucketLifecycleConfiguration {
    public static final String DISABLED = "Disabled";
    public static final String ENABLED = "Enabled";
    private List<Rule> rules;

    public static class Rule {
        private int expirationInDays;
        private String id;
        private String prefix;
        private String status;

        public int getExpirationInDays() {
            return this.expirationInDays;
        }

        public String getId() {
            return this.id;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public String getStatus() {
            return this.status;
        }

        public void setExpirationInDays(int i) {
            this.expirationInDays = i;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setPrefix(String str) {
            this.prefix = str;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public Rule withExpirationInDays(int i) {
            this.expirationInDays = i;
            return this;
        }

        public Rule withId(String str) {
            this.id = str;
            return this;
        }

        public Rule withPrefix(String str) {
            this.prefix = str;
            return this;
        }

        public Rule withStatus(String str) {
            setStatus(str);
            return this;
        }
    }

    public BucketLifecycleConfiguration(List<Rule> list) {
        this.rules = list;
    }

    public List<Rule> getRules() {
        return this.rules;
    }

    public void setRules(List<Rule> list) {
        this.rules = list;
    }

    public BucketLifecycleConfiguration withRules(List<Rule> list) {
        setRules(list);
        return this;
    }

    public BucketLifecycleConfiguration withRules(Rule... ruleArr) {
        setRules(Arrays.asList(ruleArr));
        return this;
    }
}
