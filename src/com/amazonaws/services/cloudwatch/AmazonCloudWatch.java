package com.amazonaws.services.cloudwatch;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
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

public interface AmazonCloudWatch {
    void deleteAlarms(DeleteAlarmsRequest deleteAlarmsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeAlarmHistoryResult describeAlarmHistory() throws AmazonServiceException, AmazonClientException;

    DescribeAlarmHistoryResult describeAlarmHistory(DescribeAlarmHistoryRequest describeAlarmHistoryRequest) throws AmazonServiceException, AmazonClientException;

    DescribeAlarmsResult describeAlarms() throws AmazonServiceException, AmazonClientException;

    DescribeAlarmsResult describeAlarms(DescribeAlarmsRequest describeAlarmsRequest) throws AmazonServiceException, AmazonClientException;

    DescribeAlarmsForMetricResult describeAlarmsForMetric(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest) throws AmazonServiceException, AmazonClientException;

    void disableAlarmActions(DisableAlarmActionsRequest disableAlarmActionsRequest) throws AmazonServiceException, AmazonClientException;

    void enableAlarmActions(EnableAlarmActionsRequest enableAlarmActionsRequest) throws AmazonServiceException, AmazonClientException;

    ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest);

    GetMetricStatisticsResult getMetricStatistics(GetMetricStatisticsRequest getMetricStatisticsRequest) throws AmazonServiceException, AmazonClientException;

    ListMetricsResult listMetrics() throws AmazonServiceException, AmazonClientException;

    ListMetricsResult listMetrics(ListMetricsRequest listMetricsRequest) throws AmazonServiceException, AmazonClientException;

    void putMetricAlarm(PutMetricAlarmRequest putMetricAlarmRequest) throws AmazonServiceException, AmazonClientException;

    void putMetricData(PutMetricDataRequest putMetricDataRequest) throws AmazonServiceException, AmazonClientException;

    void setAlarmState(SetAlarmStateRequest setAlarmStateRequest) throws AmazonServiceException, AmazonClientException;

    void setEndpoint(String str) throws IllegalArgumentException;

    void shutdown();
}
