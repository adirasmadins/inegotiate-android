package com.amazonaws.services.sns;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
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
import java.util.concurrent.Future;

public interface AmazonSNSAsync extends AmazonSNS {
    Future<Void> addPermissionAsync(AddPermissionRequest addPermissionRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> addPermissionAsync(AddPermissionRequest addPermissionRequest, AsyncHandler<AddPermissionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ConfirmSubscriptionResult> confirmSubscriptionAsync(ConfirmSubscriptionRequest confirmSubscriptionRequest) throws AmazonServiceException, AmazonClientException;

    Future<ConfirmSubscriptionResult> confirmSubscriptionAsync(ConfirmSubscriptionRequest confirmSubscriptionRequest, AsyncHandler<ConfirmSubscriptionRequest, ConfirmSubscriptionResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CreateTopicResult> createTopicAsync(CreateTopicRequest createTopicRequest) throws AmazonServiceException, AmazonClientException;

    Future<CreateTopicResult> createTopicAsync(CreateTopicRequest createTopicRequest, AsyncHandler<CreateTopicRequest, CreateTopicResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteTopicAsync(DeleteTopicRequest deleteTopicRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteTopicAsync(DeleteTopicRequest deleteTopicRequest, AsyncHandler<DeleteTopicRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<GetSubscriptionAttributesResult> getSubscriptionAttributesAsync(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest) throws AmazonServiceException, AmazonClientException;

    Future<GetSubscriptionAttributesResult> getSubscriptionAttributesAsync(GetSubscriptionAttributesRequest getSubscriptionAttributesRequest, AsyncHandler<GetSubscriptionAttributesRequest, GetSubscriptionAttributesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<GetTopicAttributesResult> getTopicAttributesAsync(GetTopicAttributesRequest getTopicAttributesRequest) throws AmazonServiceException, AmazonClientException;

    Future<GetTopicAttributesResult> getTopicAttributesAsync(GetTopicAttributesRequest getTopicAttributesRequest, AsyncHandler<GetTopicAttributesRequest, GetTopicAttributesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ListSubscriptionsResult> listSubscriptionsAsync(ListSubscriptionsRequest listSubscriptionsRequest) throws AmazonServiceException, AmazonClientException;

    Future<ListSubscriptionsResult> listSubscriptionsAsync(ListSubscriptionsRequest listSubscriptionsRequest, AsyncHandler<ListSubscriptionsRequest, ListSubscriptionsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ListSubscriptionsByTopicResult> listSubscriptionsByTopicAsync(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest) throws AmazonServiceException, AmazonClientException;

    Future<ListSubscriptionsByTopicResult> listSubscriptionsByTopicAsync(ListSubscriptionsByTopicRequest listSubscriptionsByTopicRequest, AsyncHandler<ListSubscriptionsByTopicRequest, ListSubscriptionsByTopicResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ListTopicsResult> listTopicsAsync(ListTopicsRequest listTopicsRequest) throws AmazonServiceException, AmazonClientException;

    Future<ListTopicsResult> listTopicsAsync(ListTopicsRequest listTopicsRequest, AsyncHandler<ListTopicsRequest, ListTopicsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<PublishResult> publishAsync(PublishRequest publishRequest) throws AmazonServiceException, AmazonClientException;

    Future<PublishResult> publishAsync(PublishRequest publishRequest, AsyncHandler<PublishRequest, PublishResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> removePermissionAsync(RemovePermissionRequest removePermissionRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> removePermissionAsync(RemovePermissionRequest removePermissionRequest, AsyncHandler<RemovePermissionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> setSubscriptionAttributesAsync(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> setSubscriptionAttributesAsync(SetSubscriptionAttributesRequest setSubscriptionAttributesRequest, AsyncHandler<SetSubscriptionAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> setTopicAttributesAsync(SetTopicAttributesRequest setTopicAttributesRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> setTopicAttributesAsync(SetTopicAttributesRequest setTopicAttributesRequest, AsyncHandler<SetTopicAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<SubscribeResult> subscribeAsync(SubscribeRequest subscribeRequest) throws AmazonServiceException, AmazonClientException;

    Future<SubscribeResult> subscribeAsync(SubscribeRequest subscribeRequest, AsyncHandler<SubscribeRequest, SubscribeResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> unsubscribeAsync(UnsubscribeRequest unsubscribeRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> unsubscribeAsync(UnsubscribeRequest unsubscribeRequest, AsyncHandler<UnsubscribeRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;
}
