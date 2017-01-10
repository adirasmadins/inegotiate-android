package com.amazonaws.services.ec2.model;

public class IamInstanceProfileSpecification {
    private String arn;
    private String name;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IamInstanceProfileSpecification)) {
            return false;
        }
        IamInstanceProfileSpecification iamInstanceProfileSpecification = (IamInstanceProfileSpecification) obj;
        if (((iamInstanceProfileSpecification.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (iamInstanceProfileSpecification.getArn() != null && !iamInstanceProfileSpecification.getArn().equals(getArn())) {
            return false;
        }
        return ((iamInstanceProfileSpecification.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) == 0 ? iamInstanceProfileSpecification.getName() == null || iamInstanceProfileSpecification.getName().equals(getName()) : false;
    }

    public String getArn() {
        return this.arn;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getArn() == null ? 0 : getArn().hashCode()) + 31) * 31;
        if (getName() != null) {
            i = getName().hashCode();
        }
        return hashCode + i;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.arn != null) {
            stringBuilder.append("Arn: " + this.arn + ", ");
        }
        if (this.name != null) {
            stringBuilder.append("Name: " + this.name + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public IamInstanceProfileSpecification withArn(String str) {
        this.arn = str;
        return this;
    }

    public IamInstanceProfileSpecification withName(String str) {
        this.name = str;
        return this;
    }
}
