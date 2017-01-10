package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeImagesResult {
    private List<Image> images;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeImagesResult)) {
            return false;
        }
        DescribeImagesResult describeImagesResult = (DescribeImagesResult) obj;
        return ((describeImagesResult.getImages() == null ? 1 : 0) ^ (getImages() == null ? 1 : 0)) == 0 ? describeImagesResult.getImages() == null || describeImagesResult.getImages().equals(getImages()) : false;
    }

    public List<Image> getImages() {
        if (this.images == null) {
            this.images = new ArrayList();
        }
        return this.images;
    }

    public int hashCode() {
        return (getImages() == null ? 0 : getImages().hashCode()) + 31;
    }

    public void setImages(Collection<Image> collection) {
        if (collection == null) {
            this.images = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.images = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.images != null) {
            stringBuilder.append("Images: " + this.images + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeImagesResult withImages(Collection<Image> collection) {
        if (collection == null) {
            this.images = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.images = arrayList;
        }
        return this;
    }

    public DescribeImagesResult withImages(Image... imageArr) {
        if (getImages() == null) {
            setImages(new ArrayList(imageArr.length));
        }
        for (Object add : imageArr) {
            getImages().add(add);
        }
        return this;
    }
}
