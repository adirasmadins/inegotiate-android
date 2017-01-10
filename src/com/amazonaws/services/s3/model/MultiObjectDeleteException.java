package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.model.DeleteObjectsResult.DeletedObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MultiObjectDeleteException extends AmazonS3Exception {
    private static final long serialVersionUID = -2004213552302446866L;
    private final List<DeletedObject> deletedObjects;
    private final List<DeleteError> errors;

    public static class DeleteError {
        private String code;
        private String key;
        private String message;
        private String versionId;

        public String getCode() {
            return this.code;
        }

        public String getKey() {
            return this.key;
        }

        public String getMessage() {
            return this.message;
        }

        public String getVersionId() {
            return this.versionId;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public void setVersionId(String str) {
            this.versionId = str;
        }
    }

    public MultiObjectDeleteException(Collection<DeleteError> collection, Collection<DeletedObject> collection2) {
        super("One or more objects could not be deleted");
        this.errors = new ArrayList();
        this.deletedObjects = new ArrayList();
        this.deletedObjects.addAll(collection2);
        this.errors.addAll(collection);
    }

    public List<DeletedObject> getDeletedObjects() {
        return this.deletedObjects;
    }

    public List<DeleteError> getErrors() {
        return this.errors;
    }
}
