package com.amazonaws.services.sns;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.sns.model.AddPermissionRequest;
import com.amazonaws.services.sns.model.ConfirmSubscriptionRequest;
import com.amazonaws.services.sns.model.ConfirmSubscriptionResult;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.DeleteTopicRequest;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesRequest;
import com.amazonaws.services.sns.model.GetSubscriptionAttributesResult;
import com.amazonaws.services.sns.model.GetTopicAttributesRequest;
import com.amazonaws.services.sns.model.GetTopicAttributesResult;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.ListSubscriptionsRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsResult;
import com.amazonaws.services.sns.model.ListTopicsRequest;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.RemovePermissionRequest;
import com.amazonaws.services.sns.model.SetSubscriptionAttributesRequest;
import com.amazonaws.services.sns.model.SetTopicAttributesRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.amazonaws.services.sns.model.UnsubscribeRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AmazonSNSAsyncClient extends AmazonSNSClient implements AmazonSNSAsync {
    private ExecutorService executorService;

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.10 */
    class AnonymousClass10 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteTopicRequest val$deleteTopicRequest;

        AnonymousClass10(DeleteTopicRequest deleteTopicRequest, AsyncHandler asyncHandler) {
            this.val$deleteTopicRequest = deleteTopicRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSNSAsyncClient.this.deleteTopic(this.val$deleteTopicRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteTopicRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.11 */
    class AnonymousClass11 implements Callable<Void> {
        final /* synthetic */ RemovePermissionRequest val$removePermissionRequest;

        AnonymousClass11(RemovePermissionRequest removePermissionRequest) {
            this.val$removePermissionRequest = removePermissionRequest;
        }

        public Void call() throws Exception {
            AmazonSNSAsyncClient.this.removePermission(this.val$removePermissionRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.12 */
    class AnonymousClass12 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ RemovePermissionRequest val$removePermissionRequest;

        AnonymousClass12(RemovePermissionRequest removePermissionRequest, AsyncHandler asyncHandler) {
            this.val$removePermissionRequest = removePermissionRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSNSAsyncClient.this.removePermission(this.val$removePermissionRequest);
                this.val$asyncHandler.onSuccess(this.val$removePermissionRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.13 */
    class AnonymousClass13 implements Callable<ListSubscriptionsResult> {
        final /* synthetic */ ListSubscriptionsRequest val$listSubscriptionsRequest;

        AnonymousClass13(ListSubscriptionsRequest listSubscriptionsRequest) {
            this.val$listSubscriptionsRequest = listSubscriptionsRequest;
        }

        public ListSubscriptionsResult call() throws Exception {
            return AmazonSNSAsyncClient.this.listSubscriptions(this.val$listSubscriptionsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.14 */
    class AnonymousClass14 implements Callable<ListSubscriptionsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ListSubscriptionsRequest val$listSubscriptionsRequest;

        AnonymousClass14(ListSubscriptionsRequest listSubscriptionsRequest, AsyncHandler asyncHandler) {
            this.val$listSubscriptionsRequest = listSubscriptionsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ListSubscriptionsResult call() throws Exception {
            try {
                ListSubscriptionsResult listSubscriptions = AmazonSNSAsyncClient.this.listSubscriptions(this.val$listSubscriptionsRequest);
                this.val$asyncHandler.onSuccess(this.val$listSubscriptionsRequest, listSubscriptions);
                return listSubscriptions;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.15 */
    class AnonymousClass15 implements Callable<Void> {
        final /* synthetic */ SetSubscriptionAttributesRequest val$setSubscriptionAttributesRequest;

        AnonymousClass15(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest) {
            this.val$setSubscriptionAttributesRequest = setSubscriptionAttributesRequest;
        }

        public Void call() throws Exception {
            AmazonSNSAsyncClient.this.setSubscriptionAttributes(this.val$setSubscriptionAttributesRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.16 */
    class AnonymousClass16 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SetSubscriptionAttributesRequest val$setSubscriptionAttributesRequest;

        AnonymousClass16(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest, AsyncHandler asyncHandler) {
            this.val$setSubscriptionAttributesRequest = setSubscriptionAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSNSAsyncClient.this.setSubscriptionAttributes(this.val$setSubscriptionAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$setSubscriptionAttributesRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.17 */
    class AnonymousClass17 implements Callable<Void> {
        final /* synthetic */ AddPermissionRequest val$addPermissionRequest;

        AnonymousClass17(AddPermissionRequest addPermissionRequest) {
            this.val$addPermissionRequest = addPermissionRequest;
        }

        public Void call() throws Exception {
            AmazonSNSAsyncClient.this.addPermission(this.val$addPermissionRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.18 */
    class AnonymousClass18 implements Callable<Void> {
        final /* synthetic */ AddPermissionRequest val$addPermissionRequest;
        final /* synthetic */ AsyncHandler val$asyncHandler;

        AnonymousClass18(AddPermissionRequest addPermissionRequest, AsyncHandler asyncHandler) {
            this.val$addPermissionRequest = addPermissionRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSNSAsyncClient.this.addPermission(this.val$addPermissionRequest);
                this.val$asyncHandler.onSuccess(this.val$addPermissionRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.19 */
    class AnonymousClass19 implements Callable<CreateTopicResult> {
        final /* synthetic */ CreateTopicRequest val$createTopicRequest;

        AnonymousClass19(CreateTopicRequest createTopicRequest) {
            this.val$createTopicRequest = createTopicRequest;
        }

        public CreateTopicResult call() throws Exception {
            return AmazonSNSAsyncClient.this.createTopic(this.val$createTopicRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.1 */
    class C00931 implements Callable<ConfirmSubscriptionResult> {
        final /* synthetic */ ConfirmSubscriptionRequest val$confirmSubscriptionRequest;

        C00931(ConfirmSubscriptionRequest confirmSubscriptionRequest) {
            this.val$confirmSubscriptionRequest = confirmSubscriptionRequest;
        }

        public ConfirmSubscriptionResult call() throws Exception {
            return AmazonSNSAsyncClient.this.confirmSubscription(this.val$confirmSubscriptionRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.20 */
    class AnonymousClass20 implements Callable<CreateTopicResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ CreateTopicRequest val$createTopicRequest;

        AnonymousClass20(CreateTopicRequest createTopicRequest, AsyncHandler asyncHandler) {
            this.val$createTopicRequest = createTopicRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public CreateTopicResult call() throws Exception {
            try {
                CreateTopicResult createTopic = AmazonSNSAsyncClient.this.createTopic(this.val$createTopicRequest);
                this.val$asyncHandler.onSuccess(this.val$createTopicRequest, createTopic);
                return createTopic;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.21 */
    class AnonymousClass21 implements Callable<GetSubscriptionAttributesResult> {
        final /* synthetic */ GetSubscriptionAttributesRequest val$getSubscriptionAttributesRequest;

        AnonymousClass21(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest) {
            this.val$getSubscriptionAttributesRequest = getSubscriptionAttributesRequest;
        }

        public GetSubscriptionAttributesResult call() throws Exception {
            return AmazonSNSAsyncClient.this.getSubscriptionAttributes(this.val$getSubscriptionAttributesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.22 */
    class AnonymousClass22 implements Callable<GetSubscriptionAttributesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetSubscriptionAttributesRequest val$getSubscriptionAttributesRequest;

        AnonymousClass22(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest, AsyncHandler asyncHandler) {
            this.val$getSubscriptionAttributesRequest = getSubscriptionAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetSubscriptionAttributesResult call() throws Exception {
            try {
                GetSubscriptionAttributesResult subscriptionAttributes = AmazonSNSAsyncClient.this.getSubscriptionAttributes(this.val$getSubscriptionAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$getSubscriptionAttributesRequest, subscriptionAttributes);
                return subscriptionAttributes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.23 */
    class AnonymousClass23 implements Callable<ListTopicsResult> {
        final /* synthetic */ ListTopicsRequest val$listTopicsRequest;

        AnonymousClass23(ListTopicsRequest listTopicsRequest) {
            this.val$listTopicsRequest = listTopicsRequest;
        }

        public ListTopicsResult call() throws Exception {
            return AmazonSNSAsyncClient.this.listTopics(this.val$listTopicsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.24 */
    class AnonymousClass24 implements Callable<ListTopicsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ListTopicsRequest val$listTopicsRequest;

        AnonymousClass24(ListTopicsRequest listTopicsRequest, AsyncHandler asyncHandler) {
            this.val$listTopicsRequest = listTopicsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ListTopicsResult call() throws Exception {
            try {
                ListTopicsResult listTopics = AmazonSNSAsyncClient.this.listTopics(this.val$listTopicsRequest);
                this.val$asyncHandler.onSuccess(this.val$listTopicsRequest, listTopics);
                return listTopics;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.25 */
    class AnonymousClass25 implements Callable<Void> {
        final /* synthetic */ UnsubscribeRequest val$unsubscribeRequest;

        AnonymousClass25(UnsubscribeRequest unsubscribeRequest) {
            this.val$unsubscribeRequest = unsubscribeRequest;
        }

        public Void call() throws Exception {
            AmazonSNSAsyncClient.this.unsubscribe(this.val$unsubscribeRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.26 */
    class AnonymousClass26 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ UnsubscribeRequest val$unsubscribeRequest;

        AnonymousClass26(UnsubscribeRequest unsubscribeRequest, AsyncHandler asyncHandler) {
            this.val$unsubscribeRequest = unsubscribeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSNSAsyncClient.this.unsubscribe(this.val$unsubscribeRequest);
                this.val$asyncHandler.onSuccess(this.val$unsubscribeRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.27 */
    class AnonymousClass27 implements Callable<ListSubscriptionsByTopicResult> {
        final /* synthetic */ ListSubscriptionsByTopicRequest val$listSubscriptionsByTopicRequest;

        AnonymousClass27(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest) {
            this.val$listSubscriptionsByTopicRequest = listSubscriptionsByTopicRequest;
        }

        public ListSubscriptionsByTopicResult call() throws Exception {
            return AmazonSNSAsyncClient.this.listSubscriptionsByTopic(this.val$listSubscriptionsByTopicRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.28 */
    class AnonymousClass28 implements Callable<ListSubscriptionsByTopicResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ListSubscriptionsByTopicRequest val$listSubscriptionsByTopicRequest;

        AnonymousClass28(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest, AsyncHandler asyncHandler) {
            this.val$listSubscriptionsByTopicRequest = listSubscriptionsByTopicRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ListSubscriptionsByTopicResult call() throws Exception {
            try {
                ListSubscriptionsByTopicResult listSubscriptionsByTopic = AmazonSNSAsyncClient.this.listSubscriptionsByTopic(this.val$listSubscriptionsByTopicRequest);
                this.val$asyncHandler.onSuccess(this.val$listSubscriptionsByTopicRequest, listSubscriptionsByTopic);
                return listSubscriptionsByTopic;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.29 */
    class AnonymousClass29 implements Callable<PublishResult> {
        final /* synthetic */ PublishRequest val$publishRequest;

        AnonymousClass29(PublishRequest publishRequest) {
            this.val$publishRequest = publishRequest;
        }

        public PublishResult call() throws Exception {
            return AmazonSNSAsyncClient.this.publish(this.val$publishRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.2 */
    class C00942 implements Callable<ConfirmSubscriptionResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ConfirmSubscriptionRequest val$confirmSubscriptionRequest;

        C00942(ConfirmSubscriptionRequest confirmSubscriptionRequest, AsyncHandler asyncHandler) {
            this.val$confirmSubscriptionRequest = confirmSubscriptionRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ConfirmSubscriptionResult call() throws Exception {
            try {
                ConfirmSubscriptionResult confirmSubscription = AmazonSNSAsyncClient.this.confirmSubscription(this.val$confirmSubscriptionRequest);
                this.val$asyncHandler.onSuccess(this.val$confirmSubscriptionRequest, confirmSubscription);
                return confirmSubscription;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.30 */
    class AnonymousClass30 implements Callable<PublishResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ PublishRequest val$publishRequest;

        AnonymousClass30(PublishRequest publishRequest, AsyncHandler asyncHandler) {
            this.val$publishRequest = publishRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public PublishResult call() throws Exception {
            try {
                PublishResult publish = AmazonSNSAsyncClient.this.publish(this.val$publishRequest);
                this.val$asyncHandler.onSuccess(this.val$publishRequest, publish);
                return publish;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.3 */
    class C00953 implements Callable<GetTopicAttributesResult> {
        final /* synthetic */ GetTopicAttributesRequest val$getTopicAttributesRequest;

        C00953(GetTopicAttributesRequest getTopicAttributesRequest) {
            this.val$getTopicAttributesRequest = getTopicAttributesRequest;
        }

        public GetTopicAttributesResult call() throws Exception {
            return AmazonSNSAsyncClient.this.getTopicAttributes(this.val$getTopicAttributesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.4 */
    class C00964 implements Callable<GetTopicAttributesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetTopicAttributesRequest val$getTopicAttributesRequest;

        C00964(GetTopicAttributesRequest getTopicAttributesRequest, AsyncHandler asyncHandler) {
            this.val$getTopicAttributesRequest = getTopicAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetTopicAttributesResult call() throws Exception {
            try {
                GetTopicAttributesResult topicAttributes = AmazonSNSAsyncClient.this.getTopicAttributes(this.val$getTopicAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$getTopicAttributesRequest, topicAttributes);
                return topicAttributes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.5 */
    class C00975 implements Callable<SubscribeResult> {
        final /* synthetic */ SubscribeRequest val$subscribeRequest;

        C00975(SubscribeRequest subscribeRequest) {
            this.val$subscribeRequest = subscribeRequest;
        }

        public SubscribeResult call() throws Exception {
            return AmazonSNSAsyncClient.this.subscribe(this.val$subscribeRequest);
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.6 */
    class C00986 implements Callable<SubscribeResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SubscribeRequest val$subscribeRequest;

        C00986(SubscribeRequest subscribeRequest, AsyncHandler asyncHandler) {
            this.val$subscribeRequest = subscribeRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public SubscribeResult call() throws Exception {
            try {
                SubscribeResult subscribe = AmazonSNSAsyncClient.this.subscribe(this.val$subscribeRequest);
                this.val$asyncHandler.onSuccess(this.val$subscribeRequest, subscribe);
                return subscribe;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.7 */
    class C00997 implements Callable<Void> {
        final /* synthetic */ SetTopicAttributesRequest val$setTopicAttributesRequest;

        C00997(SetTopicAttributesRequest setTopicAttributesRequest) {
            this.val$setTopicAttributesRequest = setTopicAttributesRequest;
        }

        public Void call() throws Exception {
            AmazonSNSAsyncClient.this.setTopicAttributes(this.val$setTopicAttributesRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.8 */
    class C01008 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SetTopicAttributesRequest val$setTopicAttributesRequest;

        C01008(SetTopicAttributesRequest setTopicAttributesRequest, AsyncHandler asyncHandler) {
            this.val$setTopicAttributesRequest = setTopicAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSNSAsyncClient.this.setTopicAttributes(this.val$setTopicAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$setTopicAttributesRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.sns.AmazonSNSAsyncClient.9 */
    class C01019 implements Callable<Void> {
        final /* synthetic */ DeleteTopicRequest val$deleteTopicRequest;

        C01019(DeleteTopicRequest deleteTopicRequest) {
            this.val$deleteTopicRequest = deleteTopicRequest;
        }

        public Void call() throws Exception {
            AmazonSNSAsyncClient.this.deleteTopic(this.val$deleteTopicRequest);
            return null;
        }
    }

    public AmazonSNSAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public AmazonSNSAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newCachedThreadPool());
    }

    public AmazonSNSAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newCachedThreadPool());
    }

    public AmazonSNSAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonSNSAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.executorService = executorService;
    }

    public AmazonSNSAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newCachedThreadPool());
    }

    public AmazonSNSAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonSNSAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public Future<Void> addPermissionAsync(AddPermissionRequest addPermissionRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass17(addPermissionRequest));
    }

    public Future<Void> addPermissionAsync(AddPermissionRequest addPermissionRequest, AsyncHandler<AddPermissionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass18(addPermissionRequest, asyncHandler));
    }

    public Future<ConfirmSubscriptionResult> confirmSubscriptionAsync(ConfirmSubscriptionRequest confirmSubscriptionRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00931(confirmSubscriptionRequest));
    }

    public Future<ConfirmSubscriptionResult> confirmSubscriptionAsync(ConfirmSubscriptionRequest confirmSubscriptionRequest, AsyncHandler<ConfirmSubscriptionRequest, ConfirmSubscriptionResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00942(confirmSubscriptionRequest, asyncHandler));
    }

    public Future<CreateTopicResult> createTopicAsync(CreateTopicRequest createTopicRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass19(createTopicRequest));
    }

    public Future<CreateTopicResult> createTopicAsync(CreateTopicRequest createTopicRequest, AsyncHandler<CreateTopicRequest, CreateTopicResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass20(createTopicRequest, asyncHandler));
    }

    public Future<Void> deleteTopicAsync(DeleteTopicRequest deleteTopicRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C01019(deleteTopicRequest));
    }

    public Future<Void> deleteTopicAsync(DeleteTopicRequest deleteTopicRequest, AsyncHandler<DeleteTopicRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass10(deleteTopicRequest, asyncHandler));
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Future<GetSubscriptionAttributesResult> getSubscriptionAttributesAsync(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass21(getSubscriptionAttributesRequest));
    }

    public Future<GetSubscriptionAttributesResult> getSubscriptionAttributesAsync(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest, AsyncHandler<GetSubscriptionAttributesRequest, GetSubscriptionAttributesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass22(getSubscriptionAttributesRequest, asyncHandler));
    }

    public Future<GetTopicAttributesResult> getTopicAttributesAsync(GetTopicAttributesRequest getTopicAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00953(getTopicAttributesRequest));
    }

    public Future<GetTopicAttributesResult> getTopicAttributesAsync(GetTopicAttributesRequest getTopicAttributesRequest, AsyncHandler<GetTopicAttributesRequest, GetTopicAttributesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00964(getTopicAttributesRequest, asyncHandler));
    }

    public Future<ListSubscriptionsResult> listSubscriptionsAsync(ListSubscriptionsRequest listSubscriptionsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass13(listSubscriptionsRequest));
    }

    public Future<ListSubscriptionsResult> listSubscriptionsAsync(ListSubscriptionsRequest listSubscriptionsRequest, AsyncHandler<ListSubscriptionsRequest, ListSubscriptionsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass14(listSubscriptionsRequest, asyncHandler));
    }

    public Future<ListSubscriptionsByTopicResult> listSubscriptionsByTopicAsync(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass27(listSubscriptionsByTopicRequest));
    }

    public Future<ListSubscriptionsByTopicResult> listSubscriptionsByTopicAsync(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest, AsyncHandler<ListSubscriptionsByTopicRequest, ListSubscriptionsByTopicResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass28(listSubscriptionsByTopicRequest, asyncHandler));
    }

    public Future<ListTopicsResult> listTopicsAsync(ListTopicsRequest listTopicsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass23(listTopicsRequest));
    }

    public Future<ListTopicsResult> listTopicsAsync(ListTopicsRequest listTopicsRequest, AsyncHandler<ListTopicsRequest, ListTopicsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass24(listTopicsRequest, asyncHandler));
    }

    public Future<PublishResult> publishAsync(PublishRequest publishRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass29(publishRequest));
    }

    public Future<PublishResult> publishAsync(PublishRequest publishRequest, AsyncHandler<PublishRequest, PublishResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass30(publishRequest, asyncHandler));
    }

    public Future<Void> removePermissionAsync(RemovePermissionRequest removePermissionRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass11(removePermissionRequest));
    }

    public Future<Void> removePermissionAsync(RemovePermissionRequest removePermissionRequest, AsyncHandler<RemovePermissionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass12(removePermissionRequest, asyncHandler));
    }

    public Future<Void> setSubscriptionAttributesAsync(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass15(setSubscriptionAttributesRequest));
    }

    public Future<Void> setSubscriptionAttributesAsync(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest, AsyncHandler<SetSubscriptionAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass16(setSubscriptionAttributesRequest, asyncHandler));
    }

    public Future<Void> setTopicAttributesAsync(SetTopicAttributesRequest setTopicAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00997(setTopicAttributesRequest));
    }

    public Future<Void> setTopicAttributesAsync(SetTopicAttributesRequest setTopicAttributesRequest, AsyncHandler<SetTopicAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C01008(setTopicAttributesRequest, asyncHandler));
    }

    public void shutdown() {
        super.shutdown();
        this.executorService.shutdownNow();
    }

    public Future<SubscribeResult> subscribeAsync(SubscribeRequest subscribeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00975(subscribeRequest));
    }

    public Future<SubscribeResult> subscribeAsync(SubscribeRequest subscribeRequest, AsyncHandler<SubscribeRequest, SubscribeResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00986(subscribeRequest, asyncHandler));
    }

    public Future<Void> unsubscribeAsync(UnsubscribeRequest unsubscribeRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass25(unsubscribeRequest));
    }

    public Future<Void> unsubscribeAsync(UnsubscribeRequest unsubscribeRequest, AsyncHandler<UnsubscribeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass26(unsubscribeRequest, asyncHandler));
    }
}
