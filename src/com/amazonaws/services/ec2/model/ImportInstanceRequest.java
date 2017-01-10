package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImportInstanceRequest extends AmazonWebServiceRequest {
    private String description;
    private List<DiskImage> diskImages;
    private ImportInstanceLaunchSpecification launchSpecification;
    private String platform;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImportInstanceRequest)) {
            return false;
        }
        ImportInstanceRequest importInstanceRequest = (ImportInstanceRequest) obj;
        if (((importInstanceRequest.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceRequest.getDescription() != null && !importInstanceRequest.getDescription().equals(getDescription())) {
            return false;
        }
        if (((importInstanceRequest.getLaunchSpecification() == null ? 1 : 0) ^ (getLaunchSpecification() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceRequest.getLaunchSpecification() != null && !importInstanceRequest.getLaunchSpecification().equals(getLaunchSpecification())) {
            return false;
        }
        if (((importInstanceRequest.getDiskImages() == null ? 1 : 0) ^ (getDiskImages() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (importInstanceRequest.getDiskImages() != null && !importInstanceRequest.getDiskImages().equals(getDiskImages())) {
            return false;
        }
        return ((importInstanceRequest.getPlatform() == null ? 1 : 0) ^ (getPlatform() == null ? 1 : 0)) == 0 ? importInstanceRequest.getPlatform() == null || importInstanceRequest.getPlatform().equals(getPlatform()) : false;
    }

    public String getDescription() {
        return this.description;
    }

    public List<DiskImage> getDiskImages() {
        if (this.diskImages == null) {
            this.diskImages = new ArrayList();
        }
        return this.diskImages;
    }

    public ImportInstanceLaunchSpecification getLaunchSpecification() {
        return this.launchSpecification;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDiskImages() == null ? 0 : getDiskImages().hashCode()) + (((getLaunchSpecification() == null ? 0 : getLaunchSpecification().hashCode()) + (((getDescription() == null ? 0 : getDescription().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getPlatform() != null) {
            i = getPlatform().hashCode();
        }
        return hashCode + i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDiskImages(Collection<DiskImage> collection) {
        if (collection == null) {
            this.diskImages = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.diskImages = arrayList;
    }

    public void setLaunchSpecification(ImportInstanceLaunchSpecification importInstanceLaunchSpecification) {
        this.launchSpecification = importInstanceLaunchSpecification;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.description != null) {
            stringBuilder.append("Description: " + this.description + ", ");
        }
        if (this.launchSpecification != null) {
            stringBuilder.append("LaunchSpecification: " + this.launchSpecification + ", ");
        }
        if (this.diskImages != null) {
            stringBuilder.append("DiskImages: " + this.diskImages + ", ");
        }
        if (this.platform != null) {
            stringBuilder.append("Platform: " + this.platform + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ImportInstanceRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public ImportInstanceRequest withDiskImages(Collection<DiskImage> collection) {
        if (collection == null) {
            this.diskImages = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.diskImages = arrayList;
        }
        return this;
    }

    public ImportInstanceRequest withDiskImages(DiskImage... diskImageArr) {
        if (getDiskImages() == null) {
            setDiskImages(new ArrayList(diskImageArr.length));
        }
        for (Object add : diskImageArr) {
            getDiskImages().add(add);
        }
        return this;
    }

    public ImportInstanceRequest withLaunchSpecification(ImportInstanceLaunchSpecification importInstanceLaunchSpecification) {
        this.launchSpecification = importInstanceLaunchSpecification;
        return this;
    }

    public ImportInstanceRequest withPlatform(String str) {
        this.platform = str;
        return this;
    }
}
