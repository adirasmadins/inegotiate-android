package com.amazonaws.services.elasticloadbalancing.model;

public class HealthCheck {
    private Integer healthyThreshold;
    private Integer interval;
    private String target;
    private Integer timeout;
    private Integer unhealthyThreshold;

    public HealthCheck(String str, Integer num, Integer num2, Integer num3, Integer num4) {
        this.target = str;
        this.interval = num;
        this.timeout = num2;
        this.unhealthyThreshold = num3;
        this.healthyThreshold = num4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof HealthCheck)) {
            return false;
        }
        HealthCheck healthCheck = (HealthCheck) obj;
        if (((healthCheck.getTarget() == null ? 1 : 0) ^ (getTarget() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (healthCheck.getTarget() != null && !healthCheck.getTarget().equals(getTarget())) {
            return false;
        }
        if (((healthCheck.getInterval() == null ? 1 : 0) ^ (getInterval() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (healthCheck.getInterval() != null && !healthCheck.getInterval().equals(getInterval())) {
            return false;
        }
        if (((healthCheck.getTimeout() == null ? 1 : 0) ^ (getTimeout() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (healthCheck.getTimeout() != null && !healthCheck.getTimeout().equals(getTimeout())) {
            return false;
        }
        if (((healthCheck.getUnhealthyThreshold() == null ? 1 : 0) ^ (getUnhealthyThreshold() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (healthCheck.getUnhealthyThreshold() != null && !healthCheck.getUnhealthyThreshold().equals(getUnhealthyThreshold())) {
            return false;
        }
        return ((healthCheck.getHealthyThreshold() == null ? 1 : 0) ^ (getHealthyThreshold() == null ? 1 : 0)) == 0 ? healthCheck.getHealthyThreshold() == null || healthCheck.getHealthyThreshold().equals(getHealthyThreshold()) : false;
    }

    public Integer getHealthyThreshold() {
        return this.healthyThreshold;
    }

    public Integer getInterval() {
        return this.interval;
    }

    public String getTarget() {
        return this.target;
    }

    public Integer getTimeout() {
        return this.timeout;
    }

    public Integer getUnhealthyThreshold() {
        return this.unhealthyThreshold;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getUnhealthyThreshold() == null ? 0 : getUnhealthyThreshold().hashCode()) + (((getTimeout() == null ? 0 : getTimeout().hashCode()) + (((getInterval() == null ? 0 : getInterval().hashCode()) + (((getTarget() == null ? 0 : getTarget().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getHealthyThreshold() != null) {
            i = getHealthyThreshold().hashCode();
        }
        return hashCode + i;
    }

    public void setHealthyThreshold(Integer num) {
        this.healthyThreshold = num;
    }

    public void setInterval(Integer num) {
        this.interval = num;
    }

    public void setTarget(String str) {
        this.target = str;
    }

    public void setTimeout(Integer num) {
        this.timeout = num;
    }

    public void setUnhealthyThreshold(Integer num) {
        this.unhealthyThreshold = num;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.target != null) {
            stringBuilder.append("Target: " + this.target + ", ");
        }
        if (this.interval != null) {
            stringBuilder.append("Interval: " + this.interval + ", ");
        }
        if (this.timeout != null) {
            stringBuilder.append("Timeout: " + this.timeout + ", ");
        }
        if (this.unhealthyThreshold != null) {
            stringBuilder.append("UnhealthyThreshold: " + this.unhealthyThreshold + ", ");
        }
        if (this.healthyThreshold != null) {
            stringBuilder.append("HealthyThreshold: " + this.healthyThreshold + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public HealthCheck withHealthyThreshold(Integer num) {
        this.healthyThreshold = num;
        return this;
    }

    public HealthCheck withInterval(Integer num) {
        this.interval = num;
        return this;
    }

    public HealthCheck withTarget(String str) {
        this.target = str;
        return this;
    }

    public HealthCheck withTimeout(Integer num) {
        this.timeout = num;
        return this;
    }

    public HealthCheck withUnhealthyThreshold(Integer num) {
        this.unhealthyThreshold = num;
        return this;
    }
}
