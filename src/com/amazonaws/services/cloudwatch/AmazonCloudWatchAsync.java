package com.amazonaws.services.cloudwatch;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.cloudwatch.model.DeleteAlarmsRequest;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryRequest;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryResult;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricRequest;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricResult;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsRequest;
import com.amazonaws.services.cloudwatch.model.DescribeAlarmsResult;
import com.amazonaws.services.cloudwatch.model.DisableAlarmActionsRequest;
import com.amazonaws.services.cloudwatch.model.EnableAlarmActionsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
import com.amazonaws.services.cloudwatch.model.ListMetricsRequest;
import com.amazonaws.services.cloudwatch.model.ListMetricsResult;
import com.amazonaws.services.cloudwatch.model.PutMetricAlarmRequest;
import com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;
import com.amazonaws.services.cloudwatch.model.SetAlarmStateRequest;
import java.util.concurrent.Future;

public interface AmazonCloudWatchAsync extends AmazonCloudWatch {
    Future<Void> deleteAlarmsAsync(DeleteAlarmsRequest deleteAlarmsRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> deleteAlarmsAsync(DeleteAlarmsRequest deleteAlarmsRequest, AsyncHandler<DeleteAlarmsRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync(DescribeAlarmHistoryRequest describeAlarmHistoryRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync(DescribeAlarmHistoryRequest describeAlarmHistoryRequest, AsyncHandler<DescribeAlarmHistoryRequest, DescribeAlarmHistoryResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeAlarmsResult> describeAlarmsAsync(DescribeAlarmsRequest describeAlarmsRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeAlarmsResult> describeAlarmsAsync(DescribeAlarmsRequest describeAlarmsRequest, AsyncHandler<DescribeAlarmsRequest, DescribeAlarmsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<DescribeAlarmsForMetricResult> describeAlarmsForMetricAsync(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest) throws AmazonServiceException, AmazonClientException;

    Future<DescribeAlarmsForMetricResult> describeAlarmsForMetricAsync(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest, AsyncHandler<DescribeAlarmsForMetricRequest, DescribeAlarmsForMetricResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> disableAlarmActionsAsync(DisableAlarmActionsRequest disableAlarmActionsRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> disableAlarmActionsAsync(DisableAlarmActionsRequest disableAlarmActionsRequest, AsyncHandler<DisableAlarmActionsRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> enableAlarmActionsAsync(EnableAlarmActionsRequest enableAlarmActionsRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> enableAlarmActionsAsync(EnableAlarmActionsRequest enableAlarmActionsRequest, AsyncHandler<EnableAlarmActionsRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<GetMetricStatisticsResult> getMetricStatisticsAsync(GetMetricStatisticsRequest getMetricStatisticsRequest) throws AmazonServiceException, AmazonClientException;

    Future<GetMetricStatisticsResult> getMetricStatisticsAsync(GetMetricStatisticsRequest getMetricStatisticsRequest, AsyncHandler<GetMetricStatisticsRequest, GetMetricStatisticsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<ListMetricsResult> listMetricsAsync(ListMetricsRequest listMetricsRequest) throws AmazonServiceException, AmazonClientException;

    Future<ListMetricsResult> listMetricsAsync(ListMetricsRequest listMetricsRequest, AsyncHandler<ListMetricsRequest, ListMetricsResult> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> putMetricAlarmAsync(PutMetricAlarmRequest putMetricAlarmRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> putMetricAlarmAsync(PutMetricAlarmRequest putMetricAlarmRequest, AsyncHandler<PutMetricAlarmRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> putMetricDataAsync(PutMetricDataRequest putMetricDataRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> putMetricDataAsync(PutMetricDataRequest putMetricDataRequest, AsyncHandler<PutMetricDataRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;

    Future<Void> setAlarmStateAsync(SetAlarmStateRequest setAlarmStateRequest) throws AmazonServiceException, AmazonClientException;

    Future<Void> setAlarmStateAsync(SetAlarmStateRequest setAlarmStateRequest, AsyncHandler<SetAlarmStateRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException;
}
