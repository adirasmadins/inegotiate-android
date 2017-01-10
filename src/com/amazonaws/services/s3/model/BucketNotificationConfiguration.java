package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BucketNotificationConfiguration {
    private List<TopicConfiguration> topicConfigurations;

    public static class TopicConfiguration {
        private final String event;
        private final String topic;

        public TopicConfiguration(String str, String str2) {
            this.topic = str;
            this.event = str2;
        }

        public String getEvent() {
            return this.event;
        }

        public String getTopic() {
            return this.topic;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("{");
            stringBuffer.append("Topic: " + getTopic() + ", ");
            stringBuffer.append("Event: " + getEvent() + ", ");
            stringBuffer.append("}");
            return stringBuffer.toString();
        }
    }

    public BucketNotificationConfiguration() {
        this.topicConfigurations = null;
        this.topicConfigurations = new ArrayList(1);
    }

    public BucketNotificationConfiguration(Collection<TopicConfiguration> collection) {
        this.topicConfigurations = null;
        this.topicConfigurations = new ArrayList(1);
        this.topicConfigurations.addAll(collection);
    }

    public List<TopicConfiguration> getTopicConfigurations() {
        return this.topicConfigurations;
    }

    public void setTopicConfigurations(Collection<TopicConfiguration> collection) {
        this.topicConfigurations.clear();
        this.topicConfigurations.addAll(collection);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("TopicConfigurations: " + getTopicConfigurations());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public BucketNotificationConfiguration withTopicConfigurations(TopicConfiguration... topicConfigurationArr) {
        this.topicConfigurations.clear();
        for (Object add : topicConfigurationArr) {
            this.topicConfigurations.add(add);
        }
        return this;
    }
}
