package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.model.DeleteObjectsResult.DeletedObject;
import com.amazonaws.services.s3.model.MultiObjectDeleteException.DeleteError;
import java.util.ArrayList;
import java.util.List;

public class DeleteObjectsResponse {
    private List<DeletedObject> deletedObjects;
    private List<DeleteError> errors;

    public DeleteObjectsResponse(List<DeletedObject> list, List<DeleteError> list2) {
        this.deletedObjects = new ArrayList();
        this.errors = new ArrayList();
        this.deletedObjects = list;
        this.errors = list2;
    }

    public List<DeletedObject> getDeletedObjects() {
        return this.deletedObjects;
    }

    public List<DeleteError> getErrors() {
        return this.errors;
    }

    public void setDeletedObjects(List<DeletedObject> list) {
        this.deletedObjects = list;
    }

    public void setErrors(List<DeleteError> list) {
        this.errors = list;
    }
}
