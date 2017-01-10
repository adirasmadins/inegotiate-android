package com.amazonaws.services.sns.model;

public class Topic {
    private String topicArn;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Topic)) {
            return false;
        }
        Topic topic = (Topic) obj;
        return ((topic.getTopicArn() == null ? 1 : 0) ^ (getTopicArn() == null ? 1 : 0)) == 0 ? topic.getTopicArn() == null || topic.getTopicArn().equals(getTopicArn()) : false;
    }

    public String getTopicArn() {
        return this.topicArn;
    }

    public int hashCode() {
        return (getTopicArn() == null ? 0 : getTopicArn().hashCode()) + 31;
    }

    public void setTopicArn(String str) {
        this.topicArn = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.topicArn != null) {
            stringBuilder.append("TopicArn: " + this.topicArn + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Topic withTopicArn(String str) {
        this.topicArn = str;
        return this;
    }
}
