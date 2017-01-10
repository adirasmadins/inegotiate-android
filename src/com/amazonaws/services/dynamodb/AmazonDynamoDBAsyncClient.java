package com.amazonaws.services.dynamodb;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.dynamodb.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodb.model.BatchGetItemResult;
import com.amazonaws.services.dynamodb.model.BatchWriteItemRequest;
import com.amazonaws.services.dynamodb.model.BatchWriteItemResult;
import com.amazonaws.services.dynamodb.model.CreateTableRequest;
import com.amazonaws.services.dynamodb.model.CreateTableResult;
import com.amazonaws.services.dynamodb.model.DeleteItemRequest;
import com.amazonaws.services.dynamodb.model.DeleteItemResult;
import com.amazonaws.services.dynamodb.model.DeleteTableRequest;
import com.amazonaws.services.dynamodb.model.DeleteTableResult;
import com.amazonaws.services.dynamodb.model.DescribeTableRequest;
import com.amazonaws.services.dynamodb.model.DescribeTableResult;
import com.amazonaws.services.dynamodb.model.GetItemRequest;
import com.amazonaws.services.dynamodb.model.GetItemResult;
import com.amazonaws.services.dynamodb.model.ListTablesRequest;
import com.amazonaws.services.dynamodb.model.ListTablesResult;
import com.amazonaws.services.dynamodb.model.PutItemRequest;
import com.amazonaws.services.dynamodb.model.PutItemResult;
import com.amazonaws.services.dynamodb.model.QueryRequest;
import com.amazonaws.services.dynamodb.model.QueryResult;
import com.amazonaws.services.dynamodb.model.ScanRequest;
import com.amazonaws.services.dynamodb.model.ScanResult;
import com.amazonaws.services.dynamodb.model.UpdateItemRequest;
import com.amazonaws.services.dynamodb.model.UpdateItemResult;
import com.amazonaws.services.dynamodb.model.UpdateTableRequest;
import com.amazonaws.services.dynamodb.model.UpdateTableResult;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AmazonDynamoDBAsyncClient extends AmazonDynamoDBClient implements AmazonDynamoDBAsync {
    private ExecutorService executorService;

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.10 */
    class AnonymousClass10 implements Callable<PutItemResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ PutItemRequest val$putItemRequest;

        AnonymousClass10(PutItemRequest putItemRequest, AsyncHandler asyncHandler) {
            this.val$putItemRequest = putItemRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public PutItemResult call() throws Exception {
            try {
                PutItemResult putItem = AmazonDynamoDBAsyncClient.this.putItem(this.val$putItemRequest);
                this.val$asyncHandler.onSuccess(this.val$putItemRequest, putItem);
                return putItem;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.11 */
    class AnonymousClass11 implements Callable<DescribeTableResult> {
        final /* synthetic */ DescribeTableRequest val$describeTableRequest;

        AnonymousClass11(DescribeTableRequest describeTableRequest) {
            this.val$describeTableRequest = describeTableRequest;
        }

        public DescribeTableResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.describeTable(this.val$describeTableRequest);
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.12 */
    class AnonymousClass12 implements Callable<DescribeTableResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeTableRequest val$describeTableRequest;

        AnonymousClass12(DescribeTableRequest describeTableRequest, AsyncHandler asyncHandler) {
            this.val$describeTableRequest = describeTableRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeTableResult call() throws Exception {
            try {
                DescribeTableResult describeTable = AmazonDynamoDBAsyncClient.this.describeTable(this.val$describeTableRequest);
                this.val$asyncHandler.onSuccess(this.val$describeTableRequest, describeTable);
                return describeTable;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.13 */
    class AnonymousClass13 implements Callable<ScanResult> {
        final /* synthetic */ ScanRequest val$scanRequest;

        AnonymousClass13(ScanRequest scanRequest) {
            this.val$scanRequest = scanRequest;
        }

        public ScanResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.scan(this.val$scanRequest);
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.14 */
    class AnonymousClass14 implements Callable<ScanResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ScanRequest val$scanRequest;

        AnonymousClass14(ScanRequest scanRequest, AsyncHandler asyncHandler) {
            this.val$scanRequest = scanRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ScanResult call() throws Exception {
            try {
                ScanResult scan = AmazonDynamoDBAsyncClient.this.scan(this.val$scanRequest);
                this.val$asyncHandler.onSuccess(this.val$scanRequest, scan);
                return scan;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.15 */
    class AnonymousClass15 implements Callable<CreateTableResult> {
        final /* synthetic */ CreateTableRequest val$createTableRequest;

        AnonymousClass15(CreateTableRequest createTableRequest) {
            this.val$createTableRequest = createTableRequest;
        }

        public CreateTableResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.createTable(this.val$createTableRequest);
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.16 */
    class AnonymousClass16 implements Callable<CreateTableResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateTableRequest val$createTableRequest;

        AnonymousClass16(CreateTableRequest createTableRequest, AsyncHandler asyncHandler) {
            this.val$createTableRequest = createTableRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateTableResult call() throws Exception {
            try {
                CreateTableResult createTable = AmazonDynamoDBAsyncClient.this.createTable(this.val$createTableRequest);
                this.val$asyncHandler.onSuccess(this.val$createTableRequest, createTable);
                return createTable;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.17 */
    class AnonymousClass17 implements Callable<UpdateTableResult> {
        final /* synthetic */ UpdateTableRequest val$updateTableRequest;

        AnonymousClass17(UpdateTableRequest updateTableRequest) {
            this.val$updateTableRequest = updateTableRequest;
        }

        public UpdateTableResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.updateTable(this.val$updateTableRequest);
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.18 */
    class AnonymousClass18 implements Callable<UpdateTableResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ UpdateTableRequest val$updateTableRequest;

        AnonymousClass18(UpdateTableRequest updateTableRequest, AsyncHandler asyncHandler) {
            this.val$updateTableRequest = updateTableRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public UpdateTableResult call() throws Exception {
            try {
                UpdateTableResult updateTable = AmazonDynamoDBAsyncClient.this.updateTable(this.val$updateTableRequest);
                this.val$asyncHandler.onSuccess(this.val$updateTableRequest, updateTable);
                return updateTable;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.19 */
    class AnonymousClass19 implements Callable<DeleteTableResult> {
        final /* synthetic */ DeleteTableRequest val$deleteTableRequest;

        AnonymousClass19(DeleteTableRequest deleteTableRequest) {
            this.val$deleteTableRequest = deleteTableRequest;
        }

        public DeleteTableResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.deleteTable(this.val$deleteTableRequest);
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.1 */
    class C00351 implements Callable<ListTablesResult> {
        final /* synthetic */ ListTablesRequest val$listTablesRequest;

        C00351(ListTablesRequest listTablesRequest) {
            this.val$listTablesRequest = listTablesRequest;
        }

        public ListTablesResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.listTables(this.val$listTablesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.20 */
    class AnonymousClass20 implements Callable<DeleteTableResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteTableRequest val$deleteTableRequest;

        AnonymousClass20(DeleteTableRequest deleteTableRequest, AsyncHandler asyncHandler) {
            this.val$deleteTableRequest = deleteTableRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DeleteTableResult call() throws Exception {
            try {
                DeleteTableResult deleteTable = AmazonDynamoDBAsyncClient.this.deleteTable(this.val$deleteTableRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteTableRequest, deleteTable);
                return deleteTable;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.21 */
    class AnonymousClass21 implements Callable<DeleteItemResult> {
        final /* synthetic */ DeleteItemRequest val$deleteItemRequest;

        AnonymousClass21(DeleteItemRequest deleteItemRequest) {
            this.val$deleteItemRequest = deleteItemRequest;
        }

        public DeleteItemResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.deleteItem(this.val$deleteItemRequest);
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.22 */
    class AnonymousClass22 implements Callable<DeleteItemResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteItemRequest val$deleteItemRequest;

        AnonymousClass22(DeleteItemRequest deleteItemRequest, AsyncHandler asyncHandler) {
            this.val$deleteItemRequest = deleteItemRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DeleteItemResult call() throws Exception {
            try {
                DeleteItemResult deleteItem = AmazonDynamoDBAsyncClient.this.deleteItem(this.val$deleteItemRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteItemRequest, deleteItem);
                return deleteItem;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.23 */
    class AnonymousClass23 implements Callable<GetItemResult> {
        final /* synthetic */ GetItemRequest val$getItemRequest;

        AnonymousClass23(GetItemRequest getItemRequest) {
            this.val$getItemRequest = getItemRequest;
        }

        public GetItemResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.getItem(this.val$getItemRequest);
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.24 */
    class AnonymousClass24 implements Callable<GetItemResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetItemRequest val$getItemRequest;

        AnonymousClass24(GetItemRequest getItemRequest, AsyncHandler asyncHandler) {
            this.val$getItemRequest = getItemRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetItemResult call() throws Exception {
            try {
                GetItemResult item = AmazonDynamoDBAsyncClient.this.getItem(this.val$getItemRequest);
                this.val$asyncHandler.onSuccess(this.val$getItemRequest, item);
                return item;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.25 */
    class AnonymousClass25 implements Callable<BatchGetItemResult> {
        final /* synthetic */ BatchGetItemRequest val$batchGetItemRequest;

        AnonymousClass25(BatchGetItemRequest batchGetItemRequest) {
            this.val$batchGetItemRequest = batchGetItemRequest;
        }

        public BatchGetItemResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.batchGetItem(this.val$batchGetItemRequest);
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.26 */
    class AnonymousClass26 implements Callable<BatchGetItemResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ BatchGetItemRequest val$batchGetItemRequest;

        AnonymousClass26(BatchGetItemRequest batchGetItemRequest, AsyncHandler asyncHandler) {
            this.val$batchGetItemRequest = batchGetItemRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public BatchGetItemResult call() throws Exception {
            try {
                BatchGetItemResult batchGetItem = AmazonDynamoDBAsyncClient.this.batchGetItem(this.val$batchGetItemRequest);
                this.val$asyncHandler.onSuccess(this.val$batchGetItemRequest, batchGetItem);
                return batchGetItem;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.2 */
    class C00362 implements Callable<ListTablesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ListTablesRequest val$listTablesRequest;

        C00362(ListTablesRequest listTablesRequest, AsyncHandler asyncHandler) {
            this.val$listTablesRequest = listTablesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ListTablesResult call() throws Exception {
            try {
                ListTablesResult listTables = AmazonDynamoDBAsyncClient.this.listTables(this.val$listTablesRequest);
                this.val$asyncHandler.onSuccess(this.val$listTablesRequest, listTables);
                return listTables;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.3 */
    class C00373 implements Callable<QueryResult> {
        final /* synthetic */ QueryRequest val$queryRequest;

        C00373(QueryRequest queryRequest) {
            this.val$queryRequest = queryRequest;
        }

        public QueryResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.query(this.val$queryRequest);
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.4 */
    class C00384 implements Callable<QueryResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ QueryRequest val$queryRequest;

        C00384(QueryRequest queryRequest, AsyncHandler asyncHandler) {
            this.val$queryRequest = queryRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public QueryResult call() throws Exception {
            try {
                QueryResult query = AmazonDynamoDBAsyncClient.this.query(this.val$queryRequest);
                this.val$asyncHandler.onSuccess(this.val$queryRequest, query);
                return query;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.5 */
    class C00395 implements Callable<BatchWriteItemResult> {
        final /* synthetic */ BatchWriteItemRequest val$batchWriteItemRequest;

        C00395(BatchWriteItemRequest batchWriteItemRequest) {
            this.val$batchWriteItemRequest = batchWriteItemRequest;
        }

        public BatchWriteItemResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.batchWriteItem(this.val$batchWriteItemRequest);
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.6 */
    class C00406 implements Callable<BatchWriteItemResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ BatchWriteItemRequest val$batchWriteItemRequest;

        C00406(BatchWriteItemRequest batchWriteItemRequest, AsyncHandler asyncHandler) {
            this.val$batchWriteItemRequest = batchWriteItemRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public BatchWriteItemResult call() throws Exception {
            try {
                BatchWriteItemResult batchWriteItem = AmazonDynamoDBAsyncClient.this.batchWriteItem(this.val$batchWriteItemRequest);
                this.val$asyncHandler.onSuccess(this.val$batchWriteItemRequest, batchWriteItem);
                return batchWriteItem;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.7 */
    class C00417 implements Callable<UpdateItemResult> {
        final /* synthetic */ UpdateItemRequest val$updateItemRequest;

        C00417(UpdateItemRequest updateItemRequest) {
            this.val$updateItemRequest = updateItemRequest;
        }

        public UpdateItemResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.updateItem(this.val$updateItemRequest);
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.8 */
    class C00428 implements Callable<UpdateItemResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ UpdateItemRequest val$updateItemRequest;

        C00428(UpdateItemRequest updateItemRequest, AsyncHandler asyncHandler) {
            this.val$updateItemRequest = updateItemRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public UpdateItemResult call() throws Exception {
            try {
                UpdateItemResult updateItem = AmazonDynamoDBAsyncClient.this.updateItem(this.val$updateItemRequest);
                this.val$asyncHandler.onSuccess(this.val$updateItemRequest, updateItem);
                return updateItem;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.dynamodb.AmazonDynamoDBAsyncClient.9 */
    class C00439 implements Callable<PutItemResult> {
        final /* synthetic */ PutItemRequest val$putItemRequest;

        C00439(PutItemRequest putItemRequest) {
            this.val$putItemRequest = putItemRequest;
        }

        public PutItemResult call() throws Exception {
            return AmazonDynamoDBAsyncClient.this.putItem(this.val$putItemRequest);
        }
    }

    public AmazonDynamoDBAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public AmazonDynamoDBAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newCachedThreadPool());
    }

    public AmazonDynamoDBAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newCachedThreadPool());
    }

    public AmazonDynamoDBAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonDynamoDBAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.executorService = executorService;
    }

    public AmazonDynamoDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newCachedThreadPool());
    }

    public AmazonDynamoDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonDynamoDBAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public Future<BatchGetItemResult> batchGetItemAsync(BatchGetItemRequest batchGetItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass25(batchGetItemRequest));
    }

    public Future<BatchGetItemResult> batchGetItemAsync(BatchGetItemRequest batchGetItemRequest, AsyncHandler<BatchGetItemRequest, BatchGetItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass26(batchGetItemRequest, asyncHandler));
    }

    public Future<BatchWriteItemResult> batchWriteItemAsync(BatchWriteItemRequest batchWriteItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00395(batchWriteItemRequest));
    }

    public Future<BatchWriteItemResult> batchWriteItemAsync(BatchWriteItemRequest batchWriteItemRequest, AsyncHandler<BatchWriteItemRequest, BatchWriteItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00406(batchWriteItemRequest, asyncHandler));
    }

    public Future<CreateTableResult> createTableAsync(CreateTableRequest createTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass15(createTableRequest));
    }

    public Future<CreateTableResult> createTableAsync(CreateTableRequest createTableRequest, AsyncHandler<CreateTableRequest, CreateTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass16(createTableRequest, asyncHandler));
    }

    public Future<DeleteItemResult> deleteItemAsync(DeleteItemRequest deleteItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass21(deleteItemRequest));
    }

    public Future<DeleteItemResult> deleteItemAsync(DeleteItemRequest deleteItemRequest, AsyncHandler<DeleteItemRequest, DeleteItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass22(deleteItemRequest, asyncHandler));
    }

    public Future<DeleteTableResult> deleteTableAsync(DeleteTableRequest deleteTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass19(deleteTableRequest));
    }

    public Future<DeleteTableResult> deleteTableAsync(DeleteTableRequest deleteTableRequest, AsyncHandler<DeleteTableRequest, DeleteTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass20(deleteTableRequest, asyncHandler));
    }

    public Future<DescribeTableResult> describeTableAsync(DescribeTableRequest describeTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass11(describeTableRequest));
    }

    public Future<DescribeTableResult> describeTableAsync(DescribeTableRequest describeTableRequest, AsyncHandler<DescribeTableRequest, DescribeTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass12(describeTableRequest, asyncHandler));
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Future<GetItemResult> getItemAsync(GetItemRequest getItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass23(getItemRequest));
    }

    public Future<GetItemResult> getItemAsync(GetItemRequest getItemRequest, AsyncHandler<GetItemRequest, GetItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass24(getItemRequest, asyncHandler));
    }

    public Future<ListTablesResult> listTablesAsync(ListTablesRequest listTablesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00351(listTablesRequest));
    }

    public Future<ListTablesResult> listTablesAsync(ListTablesRequest listTablesRequest, AsyncHandler<ListTablesRequest, ListTablesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00362(listTablesRequest, asyncHandler));
    }

    public Future<PutItemResult> putItemAsync(PutItemRequest putItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00439(putItemRequest));
    }

    public Future<PutItemResult> putItemAsync(PutItemRequest putItemRequest, AsyncHandler<PutItemRequest, PutItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass10(putItemRequest, asyncHandler));
    }

    public Future<QueryResult> queryAsync(QueryRequest queryRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00373(queryRequest));
    }

    public Future<QueryResult> queryAsync(QueryRequest queryRequest, AsyncHandler<QueryRequest, QueryResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00384(queryRequest, asyncHandler));
    }

    public Future<ScanResult> scanAsync(ScanRequest scanRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass13(scanRequest));
    }

    public Future<ScanResult> scanAsync(ScanRequest scanRequest, AsyncHandler<ScanRequest, ScanResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass14(scanRequest, asyncHandler));
    }

    public void shutdown() {
        super.shutdown();
        this.executorService.shutdownNow();
    }

    public Future<UpdateItemResult> updateItemAsync(UpdateItemRequest updateItemRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00417(updateItemRequest));
    }

    public Future<UpdateItemResult> updateItemAsync(UpdateItemRequest updateItemRequest, AsyncHandler<UpdateItemRequest, UpdateItemResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00428(updateItemRequest, asyncHandler));
    }

    public Future<UpdateTableResult> updateTableAsync(UpdateTableRequest updateTableRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass17(updateTableRequest));
    }

    public Future<UpdateTableResult> updateTableAsync(UpdateTableRequest updateTableRequest, AsyncHandler<UpdateTableRequest, UpdateTableResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass18(updateTableRequest, asyncHandler));
    }
}
