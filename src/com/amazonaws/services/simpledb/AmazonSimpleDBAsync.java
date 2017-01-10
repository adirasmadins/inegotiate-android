package com.amazonaws.services.simpledb;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
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
import java.util.concurrent.Future;

public interface AmazonSimpleDBAsync extends AmazonSimpleDB {
    Future<Void> batchDeleteAttributesAsync(BatchDeleteAttributesRequest batchDeleteAttributesRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> batchDeleteAttributesAsync(BatchDeleteAttributesRequest batchDeleteAttributesRequest, AsyncHandler<BatchDeleteAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> batchPutAttributesAsync(BatchPutAttributesRequest batchPutAttributesRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> batchPutAttributesAsync(BatchPutAttributesRequest batchPutAttributesRequest, AsyncHandler<BatchPutAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> createDomainAsync(CreateDomainRequest createDomainRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> createDomainAsync(CreateDomainRequest createDomainRequest, AsyncHandler<CreateDomainRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteAttributesAsync(DeleteAttributesRequest deleteAttributesRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteAttributesAsync(DeleteAttributesRequest deleteAttributesRequest, AsyncHandler<DeleteAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteDomainAsync(DeleteDomainRequest deleteDomainRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteDomainAsync(DeleteDomainRequest deleteDomainRequest, AsyncHandler<DeleteDomainRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DomainMetadataResult> domainMetadataAsync(DomainMetadataRequest domainMetadataRequest) throws AmazonServiceException, AmazonClientException;

    Future<DomainMetadataResult> domainMetadataAsync(DomainMetadataRequest domainMetadataRequest, AsyncHandler<DomainMetadataRequest, DomainMetadataResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<GetAttributesResult> getAttributesAsync(GetAttributesRequest getAttributesRequest) throws AmazonServiceException, AmazonClientException;

    Future<GetAttributesResult> getAttributesAsync(GetAttributesRequest getAttributesRequest, AsyncHandler<GetAttributesRequest, GetAttributesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ListDomainsResult> listDomainsAsync(ListDomainsRequest listDomainsRequest) throws AmazonServiceException, AmazonClientException;

    Future<ListDomainsResult> listDomainsAsync(ListDomainsRequest listDomainsRequest, AsyncHandler<ListDomainsRequest, ListDomainsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> putAttributesAsync(PutAttributesRequest putAttributesRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> putAttributesAsync(PutAttributesRequest putAttributesRequest, AsyncHandler<PutAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<SelectResult> selectAsync(SelectRequest selectRequest) throws AmazonServiceException, AmazonClientException;

    Future<SelectResult> selectAsync(SelectRequest selectRequest, AsyncHandler<SelectRequest, SelectResult> asyncHandler) throws AmazonServiceException, AmazonClientException;
}
