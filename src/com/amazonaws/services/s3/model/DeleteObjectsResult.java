package com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.List;

public class DeleteObjectsResult {
    private final List<DeletedObject> deletedObjects;

    public static class DeletedObject {
        private boolean deleteMarker;
        private String deleteMarkerVersionId;
        private String key;
        private String versionId;

        public String getDeleteMarkerVersionId() {
            return this.deleteMarkerVersionId;
        }

        public String getKey() {
            return this.key;
        }

        public String getVersionId() {
            return this.versionId;
        }

        public boolean isDeleteMarker() {
            return this.deleteMarker;
        }

        public void setDeleteMarker(boolean z) {
            this.deleteMarker = z;
        }

        public void setDeleteMarkerVersionId(String str) {
            this.deleteMarkerVersionId = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setVersionId(String str) {
            this.versionId = str;
        }
    }

    public DeleteObjectsResult(List<DeletedObject> list) {
        this.deletedObjects = new ArrayList();
        this.deletedObjects.addAll(list);
    }

    public List<DeletedObject> getDeletedObjects() {
        return this.deletedObjects;
    }
}
