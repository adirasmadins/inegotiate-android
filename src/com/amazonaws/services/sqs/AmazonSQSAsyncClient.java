package com.amazonaws.services.sqs;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sqs.model.AddPermissionRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResult;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResult;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.RemovePermissionRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AmazonSQSAsyncClient extends AmazonSQSClient implements AmazonSQSAsync {
    private ExecutorService executorService;

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.10 */
    class AnonymousClass10 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ RemovePermissionRequest val$removePermissionRequest;

        AnonymousClass10(RemovePermissionRequest removePermissionRequest, AsyncHandler asyncHandler) {
            this.val$removePermissionRequest = removePermissionRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSQSAsyncClient.this.removePermission(this.val$removePermissionRequest);
                this.val$asyncHandler.onSuccess(this.val$removePermissionRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.11 */
    class AnonymousClass11 implements Callable<GetQueueAttributesResult> {
        final /* synthetic */ GetQueueAttributesRequest val$getQueueAttributesRequest;

        AnonymousClass11(GetQueueAttributesRequest getQueueAttributesRequest) {
            this.val$getQueueAttributesRequest = getQueueAttributesRequest;
        }

        public GetQueueAttributesResult call() throws Exception {
            return AmazonSQSAsyncClient.this.getQueueAttributes(this.val$getQueueAttributesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.12 */
    class AnonymousClass12 implements Callable<GetQueueAttributesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetQueueAttributesRequest val$getQueueAttributesRequest;

        AnonymousClass12(GetQueueAttributesRequest getQueueAttributesRequest, AsyncHandler asyncHandler) {
            this.val$getQueueAttributesRequest = getQueueAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetQueueAttributesResult call() throws Exception {
            try {
                GetQueueAttributesResult queueAttributes = AmazonSQSAsyncClient.this.getQueueAttributes(this.val$getQueueAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$getQueueAttributesRequest, queueAttributes);
                return queueAttributes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.13 */
    class AnonymousClass13 implements Callable<SendMessageBatchResult> {
        final /* synthetic */ SendMessageBatchRequest val$sendMessageBatchRequest;

        AnonymousClass13(SendMessageBatchRequest sendMessageBatchRequest) {
            this.val$sendMessageBatchRequest = sendMessageBatchRequest;
        }

        public SendMessageBatchResult call() throws Exception {
            return AmazonSQSAsyncClient.this.sendMessageBatch(this.val$sendMessageBatchRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.14 */
    class AnonymousClass14 implements Callable<SendMessageBatchResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SendMessageBatchRequest val$sendMessageBatchRequest;

        AnonymousClass14(SendMessageBatchRequest sendMessageBatchRequest, AsyncHandler asyncHandler) {
            this.val$sendMessageBatchRequest = sendMessageBatchRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public SendMessageBatchResult call() throws Exception {
            try {
                SendMessageBatchResult sendMessageBatch = AmazonSQSAsyncClient.this.sendMessageBatch(this.val$sendMessageBatchRequest);
                this.val$asyncHandler.onSuccess(this.val$sendMessageBatchRequest, sendMessageBatch);
                return sendMessageBatch;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.15 */
    class AnonymousClass15 implements Callable<Void> {
        final /* synthetic */ DeleteQueueRequest val$deleteQueueRequest;

        AnonymousClass15(DeleteQueueRequest deleteQueueRequest) {
            this.val$deleteQueueRequest = deleteQueueRequest;
        }

        public Void call() throws Exception {
            AmazonSQSAsyncClient.this.deleteQueue(this.val$deleteQueueRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.16 */
    class AnonymousClass16 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteQueueRequest val$deleteQueueRequest;

        AnonymousClass16(DeleteQueueRequest deleteQueueRequest, AsyncHandler asyncHandler) {
            this.val$deleteQueueRequest = deleteQueueRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSQSAsyncClient.this.deleteQueue(this.val$deleteQueueRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteQueueRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.17 */
    class AnonymousClass17 implements Callable<SendMessageResult> {
        final /* synthetic */ SendMessageRequest val$sendMessageRequest;

        AnonymousClass17(SendMessageRequest sendMessageRequest) {
            this.val$sendMessageRequest = sendMessageRequest;
        }

        public SendMessageResult call() throws Exception {
            return AmazonSQSAsyncClient.this.sendMessage(this.val$sendMessageRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.18 */
    class AnonymousClass18 implements Callable<SendMessageResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SendMessageRequest val$sendMessageRequest;

        AnonymousClass18(SendMessageRequest sendMessageRequest, AsyncHandler asyncHandler) {
            this.val$sendMessageRequest = sendMessageRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public SendMessageResult call() throws Exception {
            try {
                SendMessageResult sendMessage = AmazonSQSAsyncClient.this.sendMessage(this.val$sendMessageRequest);
                this.val$asyncHandler.onSuccess(this.val$sendMessageRequest, sendMessage);
                return sendMessage;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.19 */
    class AnonymousClass19 implements Callable<ReceiveMessageResult> {
        final /* synthetic */ ReceiveMessageRequest val$receiveMessageRequest;

        AnonymousClass19(ReceiveMessageRequest receiveMessageRequest) {
            this.val$receiveMessageRequest = receiveMessageRequest;
        }

        public ReceiveMessageResult call() throws Exception {
            return AmazonSQSAsyncClient.this.receiveMessage(this.val$receiveMessageRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.1 */
    class C01021 implements Callable<Void> {
        final /* synthetic */ SetQueueAttributesRequest val$setQueueAttributesRequest;

        C01021(SetQueueAttributesRequest setQueueAttributesRequest) {
            this.val$setQueueAttributesRequest = setQueueAttributesRequest;
        }

        public Void call() throws Exception {
            AmazonSQSAsyncClient.this.setQueueAttributes(this.val$setQueueAttributesRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.20 */
    class AnonymousClass20 implements Callable<ReceiveMessageResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ReceiveMessageRequest val$receiveMessageRequest;

        AnonymousClass20(ReceiveMessageRequest receiveMessageRequest, AsyncHandler asyncHandler) {
            this.val$receiveMessageRequest = receiveMessageRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ReceiveMessageResult call() throws Exception {
            try {
                ReceiveMessageResult receiveMessage = AmazonSQSAsyncClient.this.receiveMessage(this.val$receiveMessageRequest);
                this.val$asyncHandler.onSuccess(this.val$receiveMessageRequest, receiveMessage);
                return receiveMessage;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.21 */
    class AnonymousClass21 implements Callable<ListQueuesResult> {
        final /* synthetic */ ListQueuesRequest val$listQueuesRequest;

        AnonymousClass21(ListQueuesRequest listQueuesRequest) {
            this.val$listQueuesRequest = listQueuesRequest;
        }

        public ListQueuesResult call() throws Exception {
            return AmazonSQSAsyncClient.this.listQueues(this.val$listQueuesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.22 */
    class AnonymousClass22 implements Callable<ListQueuesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ListQueuesRequest val$listQueuesRequest;

        AnonymousClass22(ListQueuesRequest listQueuesRequest, AsyncHandler asyncHandler) {
            this.val$listQueuesRequest = listQueuesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ListQueuesResult call() throws Exception {
            try {
                ListQueuesResult listQueues = AmazonSQSAsyncClient.this.listQueues(this.val$listQueuesRequest);
                this.val$asyncHandler.onSuccess(this.val$listQueuesRequest, listQueues);
                return listQueues;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.23 */
    class AnonymousClass23 implements Callable<DeleteMessageBatchResult> {
        final /* synthetic */ DeleteMessageBatchRequest val$deleteMessageBatchRequest;

        AnonymousClass23(DeleteMessageBatchRequest deleteMessageBatchRequest) {
            this.val$deleteMessageBatchRequest = deleteMessageBatchRequest;
        }

        public DeleteMessageBatchResult call() throws Exception {
            return AmazonSQSAsyncClient.this.deleteMessageBatch(this.val$deleteMessageBatchRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.24 */
    class AnonymousClass24 implements Callable<DeleteMessageBatchResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteMessageBatchRequest val$deleteMessageBatchRequest;

        AnonymousClass24(DeleteMessageBatchRequest deleteMessageBatchRequest, AsyncHandler asyncHandler) {
            this.val$deleteMessageBatchRequest = deleteMessageBatchRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DeleteMessageBatchResult call() throws Exception {
            try {
                DeleteMessageBatchResult deleteMessageBatch = AmazonSQSAsyncClient.this.deleteMessageBatch(this.val$deleteMessageBatchRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteMessageBatchRequest, deleteMessageBatch);
                return deleteMessageBatch;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.25 */
    class AnonymousClass25 implements Callable<CreateQueueResult> {
        final /* synthetic */ CreateQueueRequest val$createQueueRequest;

        AnonymousClass25(CreateQueueRequest createQueueRequest) {
            this.val$createQueueRequest = createQueueRequest;
        }

        public CreateQueueResult call() throws Exception {
            return AmazonSQSAsyncClient.this.createQueue(this.val$createQueueRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.26 */
    class AnonymousClass26 implements Callable<CreateQueueResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateQueueRequest val$createQueueRequest;

        AnonymousClass26(CreateQueueRequest createQueueRequest, AsyncHandler asyncHandler) {
            this.val$createQueueRequest = createQueueRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateQueueResult call() throws Exception {
            try {
                CreateQueueResult createQueue = AmazonSQSAsyncClient.this.createQueue(this.val$createQueueRequest);
                this.val$asyncHandler.onSuccess(this.val$createQueueRequest, createQueue);
                return createQueue;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.27 */
    class AnonymousClass27 implements Callable<Void> {
        final /* synthetic */ AddPermissionRequest val$addPermissionRequest;

        AnonymousClass27(AddPermissionRequest addPermissionRequest) {
            this.val$addPermissionRequest = addPermissionRequest;
        }

        public Void call() throws Exception {
            AmazonSQSAsyncClient.this.addPermission(this.val$addPermissionRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.28 */
    class AnonymousClass28 implements Callable<Void> {
        final /* synthetic */ AddPermissionRequest val$addPermissionRequest;
        final /* synthetic */ AsyncHandler val$asyncHandler;

        AnonymousClass28(AddPermissionRequest addPermissionRequest, AsyncHandler asyncHandler) {
            this.val$addPermissionRequest = addPermissionRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSQSAsyncClient.this.addPermission(this.val$addPermissionRequest);
                this.val$asyncHandler.onSuccess(this.val$addPermissionRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.29 */
    class AnonymousClass29 implements Callable<Void> {
        final /* synthetic */ DeleteMessageRequest val$deleteMessageRequest;

        AnonymousClass29(DeleteMessageRequest deleteMessageRequest) {
            this.val$deleteMessageRequest = deleteMessageRequest;
        }

        public Void call() throws Exception {
            AmazonSQSAsyncClient.this.deleteMessage(this.val$deleteMessageRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.2 */
    class C01032 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SetQueueAttributesRequest val$setQueueAttributesRequest;

        C01032(SetQueueAttributesRequest setQueueAttributesRequest, AsyncHandler asyncHandler) {
            this.val$setQueueAttributesRequest = setQueueAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSQSAsyncClient.this.setQueueAttributes(this.val$setQueueAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$setQueueAttributesRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.30 */
    class AnonymousClass30 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteMessageRequest val$deleteMessageRequest;

        AnonymousClass30(DeleteMessageRequest deleteMessageRequest, AsyncHandler asyncHandler) {
            this.val$deleteMessageRequest = deleteMessageRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSQSAsyncClient.this.deleteMessage(this.val$deleteMessageRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteMessageRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.3 */
    class C01043 implements Callable<ChangeMessageVisibilityBatchResult> {
        final /* synthetic */ ChangeMessageVisibilityBatchRequest val$changeMessageVisibilityBatchRequest;

        C01043(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) {
            this.val$changeMessageVisibilityBatchRequest = changeMessageVisibilityBatchRequest;
        }

        public ChangeMessageVisibilityBatchResult call() throws Exception {
            return AmazonSQSAsyncClient.this.changeMessageVisibilityBatch(this.val$changeMessageVisibilityBatchRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.4 */
    class C01054 implements Callable<ChangeMessageVisibilityBatchResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ChangeMessageVisibilityBatchRequest val$changeMessageVisibilityBatchRequest;

        C01054(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest, AsyncHandler asyncHandler) {
            this.val$changeMessageVisibilityBatchRequest = changeMessageVisibilityBatchRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ChangeMessageVisibilityBatchResult call() throws Exception {
            try {
                ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch = AmazonSQSAsyncClient.this.changeMessageVisibilityBatch(this.val$changeMessageVisibilityBatchRequest);
                this.val$asyncHandler.onSuccess(this.val$changeMessageVisibilityBatchRequest, changeMessageVisibilityBatch);
                return changeMessageVisibilityBatch;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.5 */
    class C01065 implements Callable<Void> {
        final /* synthetic */ ChangeMessageVisibilityRequest val$changeMessageVisibilityRequest;

        C01065(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) {
            this.val$changeMessageVisibilityRequest = changeMessageVisibilityRequest;
        }

        public Void call() throws Exception {
            AmazonSQSAsyncClient.this.changeMessageVisibility(this.val$changeMessageVisibilityRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.6 */
    class C01076 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ChangeMessageVisibilityRequest val$changeMessageVisibilityRequest;

        C01076(ChangeMessageVisibilityRequest changeMessageVisibilityRequest, AsyncHandler asyncHandler) {
            this.val$changeMessageVisibilityRequest = changeMessageVisibilityRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSQSAsyncClient.this.changeMessageVisibility(this.val$changeMessageVisibilityRequest);
                this.val$asyncHandler.onSuccess(this.val$changeMessageVisibilityRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.7 */
    class C01087 implements Callable<GetQueueUrlResult> {
        final /* synthetic */ GetQueueUrlRequest val$getQueueUrlRequest;

        C01087(GetQueueUrlRequest getQueueUrlRequest) {
            this.val$getQueueUrlRequest = getQueueUrlRequest;
        }

        public GetQueueUrlResult call() throws Exception {
            return AmazonSQSAsyncClient.this.getQueueUrl(this.val$getQueueUrlRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.8 */
    class C01098 implements Callable<GetQueueUrlResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetQueueUrlRequest val$getQueueUrlRequest;

        C01098(GetQueueUrlRequest getQueueUrlRequest, AsyncHandler asyncHandler) {
            this.val$getQueueUrlRequest = getQueueUrlRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetQueueUrlResult call() throws Exception {
            try {
                GetQueueUrlResult queueUrl = AmazonSQSAsyncClient.this.getQueueUrl(this.val$getQueueUrlRequest);
                this.val$asyncHandler.onSuccess(this.val$getQueueUrlRequest, queueUrl);
                return queueUrl;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sqs.AmazonSQSAsyncClient.9 */
    class C01109 implements Callable<Void> {
        final /* synthetic */ RemovePermissionRequest val$removePermissionRequest;

        C01109(RemovePermissionRequest removePermissionRequest) {
            this.val$removePermissionRequest = removePermissionRequest;
        }

        public Void call() throws Exception {
            AmazonSQSAsyncClient.this.removePermission(this.val$removePermissionRequest);
            return null;
        }
    }

    public AmazonSQSAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public AmazonSQSAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newCachedThreadPool());
    }

    public AmazonSQSAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newCachedThreadPool());
    }

    public AmazonSQSAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonSQSAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.executorService = executorService;
    }

    public AmazonSQSAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newCachedThreadPool());
    }

    public AmazonSQSAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonSQSAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public Future<Void> addPermissionAsync(AddPermissionRequest addPermissionRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass27(addPermissionRequest));
    }

    public Future<Void> addPermissionAsync(AddPermissionRequest addPermissionRequest, AsyncHandler<AddPermissionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass28(addPermissionRequest, asyncHandler));
    }

    public Future<Void> changeMessageVisibilityAsync(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C01065(changeMessageVisibilityRequest));
    }

    public Future<Void> changeMessageVisibilityAsync(ChangeMessageVisibilityRequest changeMessageVisibilityRequest, AsyncHandler<ChangeMessageVisibilityRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C01076(changeMessageVisibilityRequest, asyncHandler));
    }

    public Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C01043(changeMessageVisibilityBatchRequest));
    }

    public Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest, AsyncHandler<ChangeMessageVisibilityBatchRequest, ChangeMessageVisibilityBatchResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C01054(changeMessageVisibilityBatchRequest, asyncHandler));
    }

    public Future<CreateQueueResult> createQueueAsync(CreateQueueRequest createQueueRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass25(createQueueRequest));
    }

    public Future<CreateQueueResult> createQueueAsync(CreateQueueRequest createQueueRequest, AsyncHandler<CreateQueueRequest, CreateQueueResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass26(createQueueRequest, asyncHandler));
    }

    public Future<Void> deleteMessageAsync(DeleteMessageRequest deleteMessageRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass29(deleteMessageRequest));
    }

    public Future<Void> deleteMessageAsync(DeleteMessageRequest deleteMessageRequest, AsyncHandler<DeleteMessageRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass30(deleteMessageRequest, asyncHandler));
    }

    public Future<DeleteMessageBatchResult> deleteMessageBatchAsync(DeleteMessageBatchRequest deleteMessageBatchRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass23(deleteMessageBatchRequest));
    }

    public Future<DeleteMessageBatchResult> deleteMessageBatchAsync(DeleteMessageBatchRequest deleteMessageBatchRequest, AsyncHandler<DeleteMessageBatchRequest, DeleteMessageBatchResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass24(deleteMessageBatchRequest, asyncHandler));
    }

    public Future<Void> deleteQueueAsync(DeleteQueueRequest deleteQueueRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass15(deleteQueueRequest));
    }

    public Future<Void> deleteQueueAsync(DeleteQueueRequest deleteQueueRequest, AsyncHandler<DeleteQueueRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass16(deleteQueueRequest, asyncHandler));
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Future<GetQueueAttributesResult> getQueueAttributesAsync(GetQueueAttributesRequest getQueueAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass11(getQueueAttributesRequest));
    }

    public Future<GetQueueAttributesResult> getQueueAttributesAsync(GetQueueAttributesRequest getQueueAttributesRequest, AsyncHandler<GetQueueAttributesRequest, GetQueueAttributesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass12(getQueueAttributesRequest, asyncHandler));
    }

    public Future<GetQueueUrlResult> getQueueUrlAsync(GetQueueUrlRequest getQueueUrlRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C01087(getQueueUrlRequest));
    }

    public Future<GetQueueUrlResult> getQueueUrlAsync(GetQueueUrlRequest getQueueUrlRequest, AsyncHandler<GetQueueUrlRequest, GetQueueUrlResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C01098(getQueueUrlRequest, asyncHandler));
    }

    public Future<ListQueuesResult> listQueuesAsync(ListQueuesRequest listQueuesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass21(listQueuesRequest));
    }

    public Future<ListQueuesResult> listQueuesAsync(ListQueuesRequest listQueuesRequest, AsyncHandler<ListQueuesRequest, ListQueuesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass22(listQueuesRequest, asyncHandler));
    }

    public Future<ReceiveMessageResult> receiveMessageAsync(ReceiveMessageRequest receiveMessageRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass19(receiveMessageRequest));
    }

    public Future<ReceiveMessageResult> receiveMessageAsync(ReceiveMessageRequest receiveMessageRequest, AsyncHandler<ReceiveMessageRequest, ReceiveMessageResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass20(receiveMessageRequest, asyncHandler));
    }

    public Future<Void> removePermissionAsync(RemovePermissionRequest removePermissionRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C01109(removePermissionRequest));
    }

    public Future<Void> removePermissionAsync(RemovePermissionRequest removePermissionRequest, AsyncHandler<RemovePermissionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass10(removePermissionRequest, asyncHandler));
    }

    public Future<SendMessageResult> sendMessageAsync(SendMessageRequest sendMessageRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass17(sendMessageRequest));
    }

    public Future<SendMessageResult> sendMessageAsync(SendMessageRequest sendMessageRequest, AsyncHandler<SendMessageRequest, SendMessageResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass18(sendMessageRequest, asyncHandler));
    }

    public Future<SendMessageBatchResult> sendMessageBatchAsync(SendMessageBatchRequest sendMessageBatchRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass13(sendMessageBatchRequest));
    }

    public Future<SendMessageBatchResult> sendMessageBatchAsync(SendMessageBatchRequest sendMessageBatchRequest, AsyncHandler<SendMessageBatchRequest, SendMessageBatchResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass14(sendMessageBatchRequest, asyncHandler));
    }

    public Future<Void> setQueueAttributesAsync(SetQueueAttributesRequest setQueueAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C01021(setQueueAttributesRequest));
    }

    public Future<Void> setQueueAttributesAsync(SetQueueAttributesRequest setQueueAttributesRequest, AsyncHandler<SetQueueAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C01032(setQueueAttributesRequest, asyncHandler));
    }

    public void shutdown() {
        super.shutdown();
        this.executorService.shutdownNow();
    }
}
