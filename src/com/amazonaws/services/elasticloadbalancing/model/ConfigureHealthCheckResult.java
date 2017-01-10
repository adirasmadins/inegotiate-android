package com.amazonaws.services.elasticloadbalancing.model;

public class ConfigureHealthCheckResult {
    private HealthCheck healthCheck;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfigureHealthCheckResult)) {
            return false;
        }
        ConfigureHealthCheckResult configureHealthCheckResult = (ConfigureHealthCheckResult) obj;
        return ((configureHealthCheckResult.getHealthCheck() == null ? 1 : 0) ^ (getHealthCheck() == null ? 1 : 0)) == 0 ? configureHealthCheckResult.getHealthCheck() == null || configureHealthCheckResult.getHealthCheck().equals(getHealthCheck()) : false;
    }

    public HealthCheck getHealthCheck() {
        return this.healthCheck;
    }

    public int hashCode() {
        return (getHealthCheck() == null ? 0 : getHealthCheck().hashCode()) + 31;
    }

    public void setHealthCheck(HealthCheck healthCheck) {
        this.healthCheck = healthCheck;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.healthCheck != null) {
            stringBuilder.append("HealthCheck: " + this.healthCheck + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ConfigureHealthCheckResult withHealthCheck(HealthCheck healthCheck) {
        this.healthCheck = healthCheck;
        return this;
    }
}
