package com.amazonaws.services.ec2.model;

public class DescribeInstanceAttributeResult {
    private InstanceAttribute instanceAttribute;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeInstanceAttributeResult)) {
            return false;
        }
        DescribeInstanceAttributeResult describeInstanceAttributeResult = (DescribeInstanceAttributeResult) obj;
        return ((describeInstanceAttributeResult.getInstanceAttribute() == null ? 1 : 0) ^ (getInstanceAttribute() == null ? 1 : 0)) == 0 ? describeInstanceAttributeResult.getInstanceAttribute() == null || describeInstanceAttributeResult.getInstanceAttribute().equals(getInstanceAttribute()) : false;
    }

    public InstanceAttribute getInstanceAttribute() {
        return this.instanceAttribute;
    }

    public int hashCode() {
        return (getInstanceAttribute() == null ? 0 : getInstanceAttribute().hashCode()) + 31;
    }

    public void setInstanceAttribute(InstanceAttribute instanceAttribute) {
        this.instanceAttribute = instanceAttribute;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.instanceAttribute != null) {
            stringBuilder.append("InstanceAttribute: " + this.instanceAttribute + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeInstanceAttributeResult withInstanceAttribute(InstanceAttribute instanceAttribute) {
        this.instanceAttribute = instanceAttribute;
        return this;
    }
}
