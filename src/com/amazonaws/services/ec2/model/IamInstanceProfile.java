package com.amazonaws.services.ec2.model;

public class IamInstanceProfile {
    private String arn;
    private String id;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IamInstanceProfile)) {
            return false;
        }
        IamInstanceProfile iamInstanceProfile = (IamInstanceProfile) obj;
        if (((iamInstanceProfile.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (iamInstanceProfile.getArn() != null && !iamInstanceProfile.getArn().equals(getArn())) {
            return false;
        }
        return ((iamInstanceProfile.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) == 0 ? iamInstanceProfile.getId() == null || iamInstanceProfile.getId().equals(getId()) : false;
    }

    public String getArn() {
        return this.arn;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getArn() == null ? 0 : getArn().hashCode()) + 31) * 31;
        if (getId() != null) {
            i = getId().hashCode();
        }
        return hashCode + i;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.arn != null) {
            stringBuilder.append("Arn: " + this.arn + ", ");
        }
        if (this.id != null) {
            stringBuilder.append("Id: " + this.id + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public IamInstanceProfile withArn(String str) {
        this.arn = str;
        return this;
    }

    public IamInstanceProfile withId(String str) {
        this.id = str;
        return this;
    }
}
