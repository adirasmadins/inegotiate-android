package com.amazonaws.services.ec2.model;

public class DescribeSpotDatafeedSubscriptionResult {
    private SpotDatafeedSubscription spotDatafeedSubscription;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeSpotDatafeedSubscriptionResult)) {
            return false;
        }
        DescribeSpotDatafeedSubscriptionResult describeSpotDatafeedSubscriptionResult = (DescribeSpotDatafeedSubscriptionResult) obj;
        return ((describeSpotDatafeedSubscriptionResult.getSpotDatafeedSubscription() == null ? 1 : 0) ^ (getSpotDatafeedSubscription() == null ? 1 : 0)) == 0 ? describeSpotDatafeedSubscriptionResult.getSpotDatafeedSubscription() == null || describeSpotDatafeedSubscriptionResult.getSpotDatafeedSubscription().equals(getSpotDatafeedSubscription()) : false;
    }

    public SpotDatafeedSubscription getSpotDatafeedSubscription() {
        return this.spotDatafeedSubscription;
    }

    public int hashCode() {
        return (getSpotDatafeedSubscription() == null ? 0 : getSpotDatafeedSubscription().hashCode()) + 31;
    }

    public void setSpotDatafeedSubscription(SpotDatafeedSubscription spotDatafeedSubscription) {
        this.spotDatafeedSubscription = spotDatafeedSubscription;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.spotDatafeedSubscription != null) {
            stringBuilder.append("SpotDatafeedSubscription: " + this.spotDatafeedSubscription + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeSpotDatafeedSubscriptionResult withSpotDatafeedSubscription(SpotDatafeedSubscription spotDatafeedSubscription) {
        this.spotDatafeedSubscription = spotDatafeedSubscription;
        return this;
    }
}
