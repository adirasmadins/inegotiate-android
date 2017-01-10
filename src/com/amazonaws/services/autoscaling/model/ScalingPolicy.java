package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ScalingPolicy {
    private String adjustmentType;
    private List<Alarm> alarms;
    private String autoScalingGroupName;
    private Integer cooldown;
    private Integer minAdjustmentStep;
    private String policyARN;
    private String policyName;
    private Integer scalingAdjustment;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ScalingPolicy)) {
            return false;
        }
        ScalingPolicy scalingPolicy = (ScalingPolicy) obj;
        if (((scalingPolicy.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scalingPolicy.getAutoScalingGroupName() != null && !scalingPolicy.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((scalingPolicy.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scalingPolicy.getPolicyName() != null && !scalingPolicy.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        if (((scalingPolicy.getScalingAdjustment() == null ? 1 : 0) ^ (getScalingAdjustment() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scalingPolicy.getScalingAdjustment() != null && !scalingPolicy.getScalingAdjustment().equals(getScalingAdjustment())) {
            return false;
        }
        if (((scalingPolicy.getAdjustmentType() == null ? 1 : 0) ^ (getAdjustmentType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scalingPolicy.getAdjustmentType() != null && !scalingPolicy.getAdjustmentType().equals(getAdjustmentType())) {
            return false;
        }
        if (((scalingPolicy.getCooldown() == null ? 1 : 0) ^ (getCooldown() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scalingPolicy.getCooldown() != null && !scalingPolicy.getCooldown().equals(getCooldown())) {
            return false;
        }
        if (((scalingPolicy.getPolicyARN() == null ? 1 : 0) ^ (getPolicyARN() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scalingPolicy.getPolicyARN() != null && !scalingPolicy.getPolicyARN().equals(getPolicyARN())) {
            return false;
        }
        if (((scalingPolicy.getAlarms() == null ? 1 : 0) ^ (getAlarms() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (scalingPolicy.getAlarms() != null && !scalingPolicy.getAlarms().equals(getAlarms())) {
            return false;
        }
        return ((scalingPolicy.getMinAdjustmentStep() == null ? 1 : 0) ^ (getMinAdjustmentStep() == null ? 1 : 0)) == 0 ? scalingPolicy.getMinAdjustmentStep() == null || scalingPolicy.getMinAdjustmentStep().equals(getMinAdjustmentStep()) : false;
    }

    public String getAdjustmentType() {
        return this.adjustmentType;
    }

    public List<Alarm> getAlarms() {
        if (this.alarms == null) {
            this.alarms = new ArrayList();
        }
        return this.alarms;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public Integer getCooldown() {
        return this.cooldown;
    }

    public Integer getMinAdjustmentStep() {
        return this.minAdjustmentStep;
    }

    public String getPolicyARN() {
        return this.policyARN;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public Integer getScalingAdjustment() {
        return this.scalingAdjustment;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAlarms() == null ? 0 : getAlarms().hashCode()) + (((getPolicyARN() == null ? 0 : getPolicyARN().hashCode()) + (((getCooldown() == null ? 0 : getCooldown().hashCode()) + (((getAdjustmentType() == null ? 0 : getAdjustmentType().hashCode()) + (((getScalingAdjustment() == null ? 0 : getScalingAdjustment().hashCode()) + (((getPolicyName() == null ? 0 : getPolicyName().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getMinAdjustmentStep() != null) {
            i = getMinAdjustmentStep().hashCode();
        }
        return hashCode + i;
    }

    public void setAdjustmentType(String str) {
        this.adjustmentType = str;
    }

    public void setAlarms(Collection<Alarm> collection) {
        if (collection == null) {
            this.alarms = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.alarms = arrayList;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setCooldown(Integer num) {
        this.cooldown = num;
    }

    public void setMinAdjustmentStep(Integer num) {
        this.minAdjustmentStep = num;
    }

    public void setPolicyARN(String str) {
        this.policyARN = str;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public void setScalingAdjustment(Integer num) {
        this.scalingAdjustment = num;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
        }
        if (this.policyName != null) {
            stringBuilder.append("PolicyName: " + this.policyName + ", ");
        }
        if (this.scalingAdjustment != null) {
            stringBuilder.append("ScalingAdjustment: " + this.scalingAdjustment + ", ");
        }
        if (this.adjustmentType != null) {
            stringBuilder.append("AdjustmentType: " + this.adjustmentType + ", ");
        }
        if (this.cooldown != null) {
            stringBuilder.append("Cooldown: " + this.cooldown + ", ");
        }
        if (this.policyARN != null) {
            stringBuilder.append("PolicyARN: " + this.policyARN + ", ");
        }
        if (this.alarms != null) {
            stringBuilder.append("Alarms: " + this.alarms + ", ");
        }
        if (this.minAdjustmentStep != null) {
            stringBuilder.append("MinAdjustmentStep: " + this.minAdjustmentStep + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ScalingPolicy withAdjustmentType(String str) {
        this.adjustmentType = str;
        return this;
    }

    public ScalingPolicy withAlarms(Collection<Alarm> collection) {
        if (collection == null) {
            this.alarms = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.alarms = arrayList;
        }
        return this;
    }

    public ScalingPolicy withAlarms(Alarm... alarmArr) {
        if (getAlarms() == null) {
            setAlarms(new ArrayList(alarmArr.length));
        }
        for (Object add : alarmArr) {
            getAlarms().add(add);
        }
        return this;
    }

    public ScalingPolicy withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public ScalingPolicy withCooldown(Integer num) {
        this.cooldown = num;
        return this;
    }

    public ScalingPolicy withMinAdjustmentStep(Integer num) {
        this.minAdjustmentStep = num;
        return this;
    }

    public ScalingPolicy withPolicyARN(String str) {
        this.policyARN = str;
        return this;
    }

    public ScalingPolicy withPolicyName(String str) {
        this.policyName = str;
        return this;
    }

    public ScalingPolicy withScalingAdjustment(Integer num) {
        this.scalingAdjustment = num;
        return this;
    }
}
