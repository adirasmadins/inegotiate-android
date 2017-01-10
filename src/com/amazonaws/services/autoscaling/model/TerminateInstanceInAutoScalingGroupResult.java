package com.amazonaws.services.autoscaling.model;

public class TerminateInstanceInAutoScalingGroupResult {
    private Activity activity;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TerminateInstanceInAutoScalingGroupResult)) {
            return false;
        }
        TerminateInstanceInAutoScalingGroupResult terminateInstanceInAutoScalingGroupResult = (TerminateInstanceInAutoScalingGroupResult) obj;
        return ((terminateInstanceInAutoScalingGroupResult.getActivity() == null ? 1 : 0) ^ (getActivity() == null ? 1 : 0)) == 0 ? terminateInstanceInAutoScalingGroupResult.getActivity() == null || terminateInstanceInAutoScalingGroupResult.getActivity().equals(getActivity()) : false;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public int hashCode() {
        return (getActivity() == null ? 0 : getActivity().hashCode()) + 31;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.activity != null) {
            stringBuilder.append("Activity: " + this.activity + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public TerminateInstanceInAutoScalingGroupResult withActivity(Activity activity) {
        this.activity = activity;
        return this;
    }
}
