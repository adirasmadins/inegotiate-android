package com.amazonaws.services.simpledb;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AmazonSimpleDBAsyncClient extends AmazonSimpleDBClient implements AmazonSimpleDBAsync {
    private ExecutorService executorService;

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.10 */
    class AnonymousClass10 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateDomainRequest val$createDomainRequest;

        AnonymousClass10(CreateDomainRequest createDomainRequest, AsyncHandler asyncHandler) {
            this.val$createDomainRequest = createDomainRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSimpleDBAsyncClient.this.createDomain(this.val$createDomainRequest);
                this.val$asyncHandler.onSuccess(this.val$createDomainRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.11 */
    class AnonymousClass11 implements Callable<Void> {
        final /* synthetic */ DeleteAttributesRequest val$deleteAttributesRequest;

        AnonymousClass11(DeleteAttributesRequest deleteAttributesRequest) {
            this.val$deleteAttributesRequest = deleteAttributesRequest;
        }

        public Void call() throws Exception {
            AmazonSimpleDBAsyncClient.this.deleteAttributes(this.val$deleteAttributesRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.12 */
    class AnonymousClass12 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteAttributesRequest val$deleteAttributesRequest;

        AnonymousClass12(DeleteAttributesRequest deleteAttributesRequest, AsyncHandler asyncHandler) {
            this.val$deleteAttributesRequest = deleteAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSimpleDBAsyncClient.this.deleteAttributes(this.val$deleteAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteAttributesRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.13 */
    class AnonymousClass13 implements Callable<ListDomainsResult> {
        final /* synthetic */ ListDomainsRequest val$listDomainsRequest;

        AnonymousClass13(ListDomainsRequest listDomainsRequest) {
            this.val$listDomainsRequest = listDomainsRequest;
        }

        public ListDomainsResult call() throws Exception {
            return AmazonSimpleDBAsyncClient.this.listDomains(this.val$listDomainsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.14 */
    class AnonymousClass14 implements Callable<ListDomainsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ListDomainsRequest val$listDomainsRequest;

        AnonymousClass14(ListDomainsRequest listDomainsRequest, AsyncHandler asyncHandler) {
            this.val$listDomainsRequest = listDomainsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ListDomainsResult call() throws Exception {
            try {
                ListDomainsResult listDomains = AmazonSimpleDBAsyncClient.this.listDomains(this.val$listDomainsRequest);
                this.val$asyncHandler.onSuccess(this.val$listDomainsRequest, listDomains);
                return listDomains;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.15 */
    class AnonymousClass15 implements Callable<GetAttributesResult> {
        final /* synthetic */ GetAttributesRequest val$getAttributesRequest;

        AnonymousClass15(GetAttributesRequest getAttributesRequest) {
            this.val$getAttributesRequest = getAttributesRequest;
        }

        public GetAttributesResult call() throws Exception {
            return AmazonSimpleDBAsyncClient.this.getAttributes(this.val$getAttributesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.16 */
    class AnonymousClass16 implements Callable<GetAttributesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetAttributesRequest val$getAttributesRequest;

        AnonymousClass16(GetAttributesRequest getAttributesRequest, AsyncHandler asyncHandler) {
            this.val$getAttributesRequest = getAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetAttributesResult call() throws Exception {
            try {
                GetAttributesResult attributes = AmazonSimpleDBAsyncClient.this.getAttributes(this.val$getAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$getAttributesRequest, attributes);
                return attributes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.17 */
    class AnonymousClass17 implements Callable<Void> {
        final /* synthetic */ BatchPutAttributesRequest val$batchPutAttributesRequest;

        AnonymousClass17(BatchPutAttributesRequest batchPutAttributesRequest) {
            this.val$batchPutAttributesRequest = batchPutAttributesRequest;
        }

        public Void call() throws Exception {
            AmazonSimpleDBAsyncClient.this.batchPutAttributes(this.val$batchPutAttributesRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.18 */
    class AnonymousClass18 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ BatchPutAttributesRequest val$batchPutAttributesRequest;

        AnonymousClass18(BatchPutAttributesRequest batchPutAttributesRequest, AsyncHandler asyncHandler) {
            this.val$batchPutAttributesRequest = batchPutAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSimpleDBAsyncClient.this.batchPutAttributes(this.val$batchPutAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$batchPutAttributesRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.19 */
    class AnonymousClass19 implements Callable<DomainMetadataResult> {
        final /* synthetic */ DomainMetadataRequest val$domainMetadataRequest;

        AnonymousClass19(DomainMetadataRequest domainMetadataRequest) {
            this.val$domainMetadataRequest = domainMetadataRequest;
        }

        public DomainMetadataResult call() throws Exception {
            return AmazonSimpleDBAsyncClient.this.domainMetadata(this.val$domainMetadataRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.1 */
    class C00751 implements Callable<SelectResult> {
        final /* synthetic */ SelectRequest val$selectRequest;

        C00751(SelectRequest selectRequest) {
            this.val$selectRequest = selectRequest;
        }

        public SelectResult call() throws Exception {
            return AmazonSimpleDBAsyncClient.this.select(this.val$selectRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.20 */
    class AnonymousClass20 implements Callable<DomainMetadataResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DomainMetadataRequest val$domainMetadataRequest;

        AnonymousClass20(DomainMetadataRequest domainMetadataRequest, AsyncHandler asyncHandler) {
            this.val$domainMetadataRequest = domainMetadataRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DomainMetadataResult call() throws Exception {
            try {
                DomainMetadataResult domainMetadata = AmazonSimpleDBAsyncClient.this.domainMetadata(this.val$domainMetadataRequest);
                this.val$asyncHandler.onSuccess(this.val$domainMetadataRequest, domainMetadata);
                return domainMetadata;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.2 */
    class C00762 implements Callable<SelectResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SelectRequest val$selectRequest;

        C00762(SelectRequest selectRequest, AsyncHandler asyncHandler) {
            this.val$selectRequest = selectRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public SelectResult call() throws Exception {
            try {
                SelectResult select = AmazonSimpleDBAsyncClient.this.select(this.val$selectRequest);
                this.val$asyncHandler.onSuccess(this.val$selectRequest, select);
                return select;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.3 */
    class C00773 implements Callable<Void> {
        final /* synthetic */ PutAttributesRequest val$putAttributesRequest;

        C00773(PutAttributesRequest putAttributesRequest) {
            this.val$putAttributesRequest = putAttributesRequest;
        }

        public Void call() throws Exception {
            AmazonSimpleDBAsyncClient.this.putAttributes(this.val$putAttributesRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.4 */
    class C00784 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ PutAttributesRequest val$putAttributesRequest;

        C00784(PutAttributesRequest putAttributesRequest, AsyncHandler asyncHandler) {
            this.val$putAttributesRequest = putAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSimpleDBAsyncClient.this.putAttributes(this.val$putAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$putAttributesRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.5 */
    class C00795 implements Callable<Void> {
        final /* synthetic */ BatchDeleteAttributesRequest val$batchDeleteAttributesRequest;

        C00795(BatchDeleteAttributesRequest batchDeleteAttributesRequest) {
            this.val$batchDeleteAttributesRequest = batchDeleteAttributesRequest;
        }

        public Void call() throws Exception {
            AmazonSimpleDBAsyncClient.this.batchDeleteAttributes(this.val$batchDeleteAttributesRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.6 */
    class C00806 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ BatchDeleteAttributesRequest val$batchDeleteAttributesRequest;

        C00806(BatchDeleteAttributesRequest batchDeleteAttributesRequest, AsyncHandler asyncHandler) {
            this.val$batchDeleteAttributesRequest = batchDeleteAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSimpleDBAsyncClient.this.batchDeleteAttributes(this.val$batchDeleteAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$batchDeleteAttributesRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.7 */
    class C00817 implements Callable<Void> {
        final /* synthetic */ DeleteDomainRequest val$deleteDomainRequest;

        C00817(DeleteDomainRequest deleteDomainRequest) {
            this.val$deleteDomainRequest = deleteDomainRequest;
        }

        public Void call() throws Exception {
            AmazonSimpleDBAsyncClient.this.deleteDomain(this.val$deleteDomainRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.8 */
    class C00828 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteDomainRequest val$deleteDomainRequest;

        C00828(DeleteDomainRequest deleteDomainRequest, AsyncHandler asyncHandler) {
            this.val$deleteDomainRequest = deleteDomainRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSimpleDBAsyncClient.this.deleteDomain(this.val$deleteDomainRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteDomainRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpledb.AmazonSimpleDBAsyncClient.9 */
    class C00839 implements Callable<Void> {
        final /* synthetic */ CreateDomainRequest val$createDomainRequest;

        C00839(CreateDomainRequest createDomainRequest) {
            this.val$createDomainRequest = createDomainRequest;
        }

        public Void call() throws Exception {
            AmazonSimpleDBAsyncClient.this.createDomain(this.val$createDomainRequest);
            return null;
        }
    }

    public AmazonSimpleDBAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public AmazonSimpleDBAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newCachedThreadPool());
    }

    public AmazonSimpleDBAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newCachedThreadPool());
    }

    public AmazonSimpleDBAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonSimpleDBAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.executorService = executorService;
    }

    public AmazonSimpleDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newCachedThreadPool());
    }

    public AmazonSimpleDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonSimpleDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public Future<Void> batchDeleteAttributesAsync(BatchDeleteAttributesRequest batchDeleteAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00795(batchDeleteAttributesRequest));
    }

    public Future<Void> batchDeleteAttributesAsync(BatchDeleteAttributesRequest batchDeleteAttributesRequest, AsyncHandler<BatchDeleteAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00806(batchDeleteAttributesRequest, asyncHandler));
    }

    public Future<Void> batchPutAttributesAsync(BatchPutAttributesRequest batchPutAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass17(batchPutAttributesRequest));
    }

    public Future<Void> batchPutAttributesAsync(BatchPutAttributesRequest batchPutAttributesRequest, AsyncHandler<BatchPutAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass18(batchPutAttributesRequest, asyncHandler));
    }

    public Future<Void> createDomainAsync(CreateDomainRequest createDomainRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00839(createDomainRequest));
    }

    public Future<Void> createDomainAsync(CreateDomainRequest createDomainRequest, AsyncHandler<CreateDomainRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass10(createDomainRequest, asyncHandler));
    }

    public Future<Void> deleteAttributesAsync(DeleteAttributesRequest deleteAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass11(deleteAttributesRequest));
    }

    public Future<Void> deleteAttributesAsync(DeleteAttributesRequest deleteAttributesRequest, AsyncHandler<DeleteAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass12(deleteAttributesRequest, asyncHandler));
    }

    public Future<Void> deleteDomainAsync(DeleteDomainRequest deleteDomainRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00817(deleteDomainRequest));
    }

    public Future<Void> deleteDomainAsync(DeleteDomainRequest deleteDomainRequest, AsyncHandler<DeleteDomainRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00828(deleteDomainRequest, asyncHandler));
    }

    public Future<DomainMetadataResult> domainMetadataAsync(DomainMetadataRequest domainMetadataRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass19(domainMetadataRequest));
    }

    public Future<DomainMetadataResult> domainMetadataAsync(DomainMetadataRequest domainMetadataRequest, AsyncHandler<DomainMetadataRequest, DomainMetadataResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass20(domainMetadataRequest, asyncHandler));
    }

    public Future<GetAttributesResult> getAttributesAsync(GetAttributesRequest getAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass15(getAttributesRequest));
    }

    public Future<GetAttributesResult> getAttributesAsync(GetAttributesRequest getAttributesRequest, AsyncHandler<GetAttributesRequest, GetAttributesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass16(getAttributesRequest, asyncHandler));
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Future<ListDomainsResult> listDomainsAsync(ListDomainsRequest listDomainsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass13(listDomainsRequest));
    }

    public Future<ListDomainsResult> listDomainsAsync(ListDomainsRequest listDomainsRequest, AsyncHandler<ListDomainsRequest, ListDomainsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass14(listDomainsRequest, asyncHandler));
    }

    public Future<Void> putAttributesAsync(PutAttributesRequest putAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00773(putAttributesRequest));
    }

    public Future<Void> putAttributesAsync(PutAttributesRequest putAttributesRequest, AsyncHandler<PutAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00784(putAttributesRequest, asyncHandler));
    }

    public Future<SelectResult> selectAsync(SelectRequest selectRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00751(selectRequest));
    }

    public Future<SelectResult> selectAsync(SelectRequest selectRequest, AsyncHandler<SelectRequest, SelectResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00762(selectRequest, asyncHandler));
    }

    public void shutdown() {
        super.shutdown();
        this.executorService.shutdownNow();
    }
}
