package com.amazonaws.services.sqs;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
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
import java.util.concurrent.Future;

public interface AmazonSQSAsync extends AmazonSQS {
    Future<Void> addPermissionAsync(AddPermissionRequest addPermissionRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> addPermissionAsync(AddPermissionRequest addPermissionRequest, AsyncHandler<AddPermissionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> changeMessageVisibilityAsync(ChangeMessageVisibilityRequest changeMessageVisibilityRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> changeMessageVisibilityAsync(ChangeMessageVisibilityRequest changeMessageVisibilityRequest, AsyncHandler<ChangeMessageVisibilityRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest) throws AmazonServiceException, AmazonClientException;

    Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(ChangeMessageVisibilityBatchRequest changeMessageVisibilityBatchRequest, AsyncHandler<ChangeMessageVisibilityBatchRequest, ChangeMessageVisibilityBatchResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<CreateQueueResult> createQueueAsync(CreateQueueRequest createQueueRequest) throws AmazonServiceException, AmazonClientException;

    Future<CreateQueueResult> createQueueAsync(CreateQueueRequest createQueueRequest, AsyncHandler<CreateQueueRequest, CreateQueueResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteMessageAsync(DeleteMessageRequest deleteMessageRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteMessageAsync(DeleteMessageRequest deleteMessageRequest, AsyncHandler<DeleteMessageRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DeleteMessageBatchResult> deleteMessageBatchAsync(DeleteMessageBatchRequest deleteMessageBatchRequest) throws AmazonServiceException, AmazonClientException;

    Future<DeleteMessageBatchResult> deleteMessageBatchAsync(DeleteMessageBatchRequest deleteMessageBatchRequest, AsyncHandler<DeleteMessageBatchRequest, DeleteMessageBatchResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteQueueAsync(DeleteQueueRequest deleteQueueRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteQueueAsync(DeleteQueueRequest deleteQueueRequest, AsyncHandler<DeleteQueueRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<GetQueueAttributesResult> getQueueAttributesAsync(GetQueueAttributesRequest getQueueAttributesRequest) throws AmazonServiceException, AmazonClientException;

    Future<GetQueueAttributesResult> getQueueAttributesAsync(GetQueueAttributesRequest getQueueAttributesRequest, AsyncHandler<GetQueueAttributesRequest, GetQueueAttributesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<GetQueueUrlResult> getQueueUrlAsync(GetQueueUrlRequest getQueueUrlRequest) throws AmazonServiceException, AmazonClientException;

    Future<GetQueueUrlResult> getQueueUrlAsync(GetQueueUrlRequest getQueueUrlRequest, AsyncHandler<GetQueueUrlRequest, GetQueueUrlResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ListQueuesResult> listQueuesAsync(ListQueuesRequest listQueuesRequest) throws AmazonServiceException, AmazonClientException;

    Future<ListQueuesResult> listQueuesAsync(ListQueuesRequest listQueuesRequest, AsyncHandler<ListQueuesRequest, ListQueuesResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ReceiveMessageResult> receiveMessageAsync(ReceiveMessageRequest receiveMessageRequest) throws AmazonServiceException, AmazonClientException;

    Future<ReceiveMessageResult> receiveMessageAsync(ReceiveMessageRequest receiveMessageRequest, AsyncHandler<ReceiveMessageRequest, ReceiveMessageResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> removePermissionAsync(RemovePermissionRequest removePermissionRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> removePermissionAsync(RemovePermissionRequest removePermissionRequest, AsyncHandler<RemovePermissionRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<SendMessageResult> sendMessageAsync(SendMessageRequest sendMessageRequest) throws AmazonServiceException, AmazonClientException;

    Future<SendMessageResult> sendMessageAsync(SendMessageRequest sendMessageRequest, AsyncHandler<SendMessageRequest, SendMessageResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<SendMessageBatchResult> sendMessageBatchAsync(SendMessageBatchRequest sendMessageBatchRequest) throws AmazonServiceException, AmazonClientException;

    Future<SendMessageBatchResult> sendMessageBatchAsync(SendMessageBatchRequest sendMessageBatchRequest, AsyncHandler<SendMessageBatchRequest, SendMessageBatchResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> setQueueAttributesAsync(SetQueueAttributesRequest setQueueAttributesRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> setQueueAttributesAsync(SetQueueAttributesRequest setQueueAttributesRequest, AsyncHandler<SetQueueAttributesRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;
}
