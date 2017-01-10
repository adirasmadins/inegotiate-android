package com.amazonaws.services.ec2.model;

public class DescribeImageAttributeResult {
    private ImageAttribute imageAttribute;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeImageAttributeResult)) {
            return false;
        }
        DescribeImageAttributeResult describeImageAttributeResult = (DescribeImageAttributeResult) obj;
        return ((describeImageAttributeResult.getImageAttribute() == null ? 1 : 0) ^ (getImageAttribute() == null ? 1 : 0)) == 0 ? describeImageAttributeResult.getImageAttribute() == null || describeImageAttributeResult.getImageAttribute().equals(getImageAttribute()) : false;
    }

    public ImageAttribute getImageAttribute() {
        return this.imageAttribute;
    }

    public int hashCode() {
        return (getImageAttribute() == null ? 0 : getImageAttribute().hashCode()) + 31;
    }

    public void setImageAttribute(ImageAttribute imageAttribute) {
        this.imageAttribute = imageAttribute;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.imageAttribute != null) {
            stringBuilder.append("ImageAttribute: " + this.imageAttribute + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeImageAttributeResult withImageAttribute(ImageAttribute imageAttribute) {
        this.imageAttribute = imageAttribute;
        return this;
    }
}
