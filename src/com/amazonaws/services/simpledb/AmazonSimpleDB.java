package com.amazonaws.services.simpledb;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpledb.model.BatchDeleteAttributesRequest;
import com.amazonaws.services.simpledb.model.BatchPutAttributesRequest;
import com.amazonaws.services.simpledb.model.CreateDomainRequest;
import com.amazonaws.services.simpledb.model.DeleteAttributesRequest;
import com.amazonaws.services.simpledb.model.DeleteDomainRequest;
import com.amazonaws.services.simpledb.model.DomainMetadataRequest;
import com.amazonaws.services.simpledb.model.DomainMetadataResult;
import com.amazonaws.services.simpledb.model.GetAttributesRequest;
import com.amazonaws.services.simpledb.model.GetAttributesResult;
import com.amazonaws.services.simpledb.model.ListDomainsRequest;
import com.amazonaws.services.simpledb.model.ListDomainsResult;
import com.amazonaws.services.simpledb.model.PutAttributesRequest;
import com.amazonaws.services.simpledb.model.SelectRequest;
import com.amazonaws.services.simpledb.model.SelectResult;

public interface AmazonSimpleDB {
    void batchDeleteAttributes(BatchDeleteAttributesRequest batchDeleteAttributesRequest) throws AmazonServiceException, AmazonClientException;

    void batchPutAttributes(BatchPutAttributesRequest batchPutAttributesRequest) throws AmazonServiceException, AmazonClientException;

    void createDomain(CreateDomainRequest createDomainRequest) throws AmazonServiceException, AmazonClientException;

    void deleteAttributes(DeleteAttributesRequest deleteAttributesRequest) throws AmazonServiceException, AmazonClientException;

    void deleteDomain(DeleteDomainRequest deleteDomainRequest) throws AmazonServiceException, AmazonClientException;

    DomainMetadataResult domainMetadata(DomainMetadataRequest domainMetadataRequest) throws AmazonServiceException, AmazonClientException;

    GetAttributesResult getAttributes(GetAttributesRequest getAttributesRequest) throws AmazonServiceException, AmazonClientException;

    ListDomainsResult listDomains() throws AmazonServiceException, AmazonClientException;

    ListDomainsResult listDomains(ListDomainsRequest listDomainsRequest) throws AmazonServiceException, AmazonClientException;

    void putAttributes(PutAttributesRequest putAttributesRequest) throws AmazonServiceException, AmazonClientException;

    SelectResult select(SelectRequest selectRequest) throws AmazonServiceException, AmazonClientException;

    void setEndpoint(String str) throws IllegalArgumentException;
}
