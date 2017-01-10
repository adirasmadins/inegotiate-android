package com.amazonaws.services.sns.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListTopicsResult {
    private String nextToken;
    private List<Topic> topics;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListTopicsResult)) {
            return false;
        }
        ListTopicsResult listTopicsResult = (ListTopicsResult) obj;
        if (((listTopicsResult.getTopics() == null ? 1 : 0) ^ (getTopics() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (listTopicsResult.getTopics() != null && !listTopicsResult.getTopics().equals(getTopics())) {
            return false;
        }
        return ((listTopicsResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? listTopicsResult.getNextToken() == null || listTopicsResult.getNextToken().equals(getNextToken()) : false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<Topic> getTopics() {
        if (this.topics == null) {
            this.topics = new ArrayList();
        }
        return this.topics;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTopics() == null ? 0 : getTopics().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setTopics(Collection<Topic> collection) {
        if (collection == null) {
            this.topics = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.topics = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.topics != null) {
            stringBuilder.append("Topics: " + this.topics + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ListTopicsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListTopicsResult withTopics(Collection<Topic> collection) {
        if (collection == null) {
            this.topics = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.topics = arrayList;
        }
        return this;
    }

    public ListTopicsResult withTopics(Topic... topicArr) {
        if (getTopics() == null) {
            setTopics(new ArrayList(topicArr.length));
        }
        for (Object add : topicArr) {
            getTopics().add(add);
        }
        return this;
    }
}
