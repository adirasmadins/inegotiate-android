package com.amazonaws.services.cloudwatch;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AmazonCloudWatchAsyncClient extends AmazonCloudWatchClient implements AmazonCloudWatchAsync {
    private ExecutorService executorService;

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.10 */
    class AnonymousClass10 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DisableAlarmActionsRequest val$disableAlarmActionsRequest;

        AnonymousClass10(DisableAlarmActionsRequest disableAlarmActionsRequest, AsyncHandler asyncHandler) {
            this.val$disableAlarmActionsRequest = disableAlarmActionsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonCloudWatchAsyncClient.this.disableAlarmActions(this.val$disableAlarmActionsRequest);
                this.val$asyncHandler.onSuccess(this.val$disableAlarmActionsRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.11 */
    class AnonymousClass11 implements Callable<DescribeAlarmsResult> {
        final /* synthetic */ DescribeAlarmsRequest val$describeAlarmsRequest;

        AnonymousClass11(DescribeAlarmsRequest describeAlarmsRequest) {
            this.val$describeAlarmsRequest = describeAlarmsRequest;
        }

        public DescribeAlarmsResult call() throws Exception {
            return AmazonCloudWatchAsyncClient.this.describeAlarms(this.val$describeAlarmsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.12 */
    class AnonymousClass12 implements Callable<DescribeAlarmsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeAlarmsRequest val$describeAlarmsRequest;

        AnonymousClass12(DescribeAlarmsRequest describeAlarmsRequest, AsyncHandler asyncHandler) {
            this.val$describeAlarmsRequest = describeAlarmsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeAlarmsResult call() throws Exception {
            try {
                DescribeAlarmsResult describeAlarms = AmazonCloudWatchAsyncClient.this.describeAlarms(this.val$describeAlarmsRequest);
                this.val$asyncHandler.onSuccess(this.val$describeAlarmsRequest, describeAlarms);
                return describeAlarms;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.13 */
    class AnonymousClass13 implements Callable<DescribeAlarmsForMetricResult> {
        final /* synthetic */ DescribeAlarmsForMetricRequest val$describeAlarmsForMetricRequest;

        AnonymousClass13(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest) {
            this.val$describeAlarmsForMetricRequest = describeAlarmsForMetricRequest;
        }

        public DescribeAlarmsForMetricResult call() throws Exception {
            return AmazonCloudWatchAsyncClient.this.describeAlarmsForMetric(this.val$describeAlarmsForMetricRequest);
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.14 */
    class AnonymousClass14 implements Callable<DescribeAlarmsForMetricResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeAlarmsForMetricRequest val$describeAlarmsForMetricRequest;

        AnonymousClass14(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest, AsyncHandler asyncHandler) {
            this.val$describeAlarmsForMetricRequest = describeAlarmsForMetricRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeAlarmsForMetricResult call() throws Exception {
            try {
                DescribeAlarmsForMetricResult describeAlarmsForMetric = AmazonCloudWatchAsyncClient.this.describeAlarmsForMetric(this.val$describeAlarmsForMetricRequest);
                this.val$asyncHandler.onSuccess(this.val$describeAlarmsForMetricRequest, describeAlarmsForMetric);
                return describeAlarmsForMetric;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.15 */
    class AnonymousClass15 implements Callable<DescribeAlarmHistoryResult> {
        final /* synthetic */ DescribeAlarmHistoryRequest val$describeAlarmHistoryRequest;

        AnonymousClass15(DescribeAlarmHistoryRequest describeAlarmHistoryRequest) {
            this.val$describeAlarmHistoryRequest = describeAlarmHistoryRequest;
        }

        public DescribeAlarmHistoryResult call() throws Exception {
            return AmazonCloudWatchAsyncClient.this.describeAlarmHistory(this.val$describeAlarmHistoryRequest);
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.16 */
    class AnonymousClass16 implements Callable<DescribeAlarmHistoryResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DescribeAlarmHistoryRequest val$describeAlarmHistoryRequest;

        AnonymousClass16(DescribeAlarmHistoryRequest describeAlarmHistoryRequest, AsyncHandler asyncHandler) {
            this.val$describeAlarmHistoryRequest = describeAlarmHistoryRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DescribeAlarmHistoryResult call() throws Exception {
            try {
                DescribeAlarmHistoryResult describeAlarmHistory = AmazonCloudWatchAsyncClient.this.describeAlarmHistory(this.val$describeAlarmHistoryRequest);
                this.val$asyncHandler.onSuccess(this.val$describeAlarmHistoryRequest, describeAlarmHistory);
                return describeAlarmHistory;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.17 */
    class AnonymousClass17 implements Callable<Void> {
        final /* synthetic */ EnableAlarmActionsRequest val$enableAlarmActionsRequest;

        AnonymousClass17(EnableAlarmActionsRequest enableAlarmActionsRequest) {
            this.val$enableAlarmActionsRequest = enableAlarmActionsRequest;
        }

        public Void call() throws Exception {
            AmazonCloudWatchAsyncClient.this.enableAlarmActions(this.val$enableAlarmActionsRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.18 */
    class AnonymousClass18 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ EnableAlarmActionsRequest val$enableAlarmActionsRequest;

        AnonymousClass18(EnableAlarmActionsRequest enableAlarmActionsRequest, AsyncHandler asyncHandler) {
            this.val$enableAlarmActionsRequest = enableAlarmActionsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonCloudWatchAsyncClient.this.enableAlarmActions(this.val$enableAlarmActionsRequest);
                this.val$asyncHandler.onSuccess(this.val$enableAlarmActionsRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.19 */
    class AnonymousClass19 implements Callable<Void> {
        final /* synthetic */ DeleteAlarmsRequest val$deleteAlarmsRequest;

        AnonymousClass19(DeleteAlarmsRequest deleteAlarmsRequest) {
            this.val$deleteAlarmsRequest = deleteAlarmsRequest;
        }

        public Void call() throws Exception {
            AmazonCloudWatchAsyncClient.this.deleteAlarms(this.val$deleteAlarmsRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.1 */
    class C00261 implements Callable<Void> {
        final /* synthetic */ PutMetricAlarmRequest val$putMetricAlarmRequest;

        C00261(PutMetricAlarmRequest putMetricAlarmRequest) {
            this.val$putMetricAlarmRequest = putMetricAlarmRequest;
        }

        public Void call() throws Exception {
            AmazonCloudWatchAsyncClient.this.putMetricAlarm(this.val$putMetricAlarmRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.20 */
    class AnonymousClass20 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteAlarmsRequest val$deleteAlarmsRequest;

        AnonymousClass20(DeleteAlarmsRequest deleteAlarmsRequest, AsyncHandler asyncHandler) {
            this.val$deleteAlarmsRequest = deleteAlarmsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonCloudWatchAsyncClient.this.deleteAlarms(this.val$deleteAlarmsRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteAlarmsRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.21 */
    class AnonymousClass21 implements Callable<Void> {
        final /* synthetic */ SetAlarmStateRequest val$setAlarmStateRequest;

        AnonymousClass21(SetAlarmStateRequest setAlarmStateRequest) {
            this.val$setAlarmStateRequest = setAlarmStateRequest;
        }

        public Void call() throws Exception {
            AmazonCloudWatchAsyncClient.this.setAlarmState(this.val$setAlarmStateRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.22 */
    class AnonymousClass22 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SetAlarmStateRequest val$setAlarmStateRequest;

        AnonymousClass22(SetAlarmStateRequest setAlarmStateRequest, AsyncHandler asyncHandler) {
            this.val$setAlarmStateRequest = setAlarmStateRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonCloudWatchAsyncClient.this.setAlarmState(this.val$setAlarmStateRequest);
                this.val$asyncHandler.onSuccess(this.val$setAlarmStateRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.2 */
    class C00272 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ PutMetricAlarmRequest val$putMetricAlarmRequest;

        C00272(PutMetricAlarmRequest putMetricAlarmRequest, AsyncHandler asyncHandler) {
            this.val$putMetricAlarmRequest = putMetricAlarmRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonCloudWatchAsyncClient.this.putMetricAlarm(this.val$putMetricAlarmRequest);
                this.val$asyncHandler.onSuccess(this.val$putMetricAlarmRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.3 */
    class C00283 implements Callable<Void> {
        final /* synthetic */ PutMetricDataRequest val$putMetricDataRequest;

        C00283(PutMetricDataRequest putMetricDataRequest) {
            this.val$putMetricDataRequest = putMetricDataRequest;
        }

        public Void call() throws Exception {
            AmazonCloudWatchAsyncClient.this.putMetricData(this.val$putMetricDataRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.4 */
    class C00294 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ PutMetricDataRequest val$putMetricDataRequest;

        C00294(PutMetricDataRequest putMetricDataRequest, AsyncHandler asyncHandler) {
            this.val$putMetricDataRequest = putMetricDataRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonCloudWatchAsyncClient.this.putMetricData(this.val$putMetricDataRequest);
                this.val$asyncHandler.onSuccess(this.val$putMetricDataRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.5 */
    class C00305 implements Callable<ListMetricsResult> {
        final /* synthetic */ ListMetricsRequest val$listMetricsRequest;

        C00305(ListMetricsRequest listMetricsRequest) {
            this.val$listMetricsRequest = listMetricsRequest;
        }

        public ListMetricsResult call() throws Exception {
            return AmazonCloudWatchAsyncClient.this.listMetrics(this.val$listMetricsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.6 */
    class C00316 implements Callable<ListMetricsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ListMetricsRequest val$listMetricsRequest;

        C00316(ListMetricsRequest listMetricsRequest, AsyncHandler asyncHandler) {
            this.val$listMetricsRequest = listMetricsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ListMetricsResult call() throws Exception {
            try {
                ListMetricsResult listMetrics = AmazonCloudWatchAsyncClient.this.listMetrics(this.val$listMetricsRequest);
                this.val$asyncHandler.onSuccess(this.val$listMetricsRequest, listMetrics);
                return listMetrics;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.7 */
    class C00327 implements Callable<GetMetricStatisticsResult> {
        final /* synthetic */ GetMetricStatisticsRequest val$getMetricStatisticsRequest;

        C00327(GetMetricStatisticsRequest getMetricStatisticsRequest) {
            this.val$getMetricStatisticsRequest = getMetricStatisticsRequest;
        }

        public GetMetricStatisticsResult call() throws Exception {
            return AmazonCloudWatchAsyncClient.this.getMetricStatistics(this.val$getMetricStatisticsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.8 */
    class C00338 implements Callable<GetMetricStatisticsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetMetricStatisticsRequest val$getMetricStatisticsRequest;

        C00338(GetMetricStatisticsRequest getMetricStatisticsRequest, AsyncHandler asyncHandler) {
            this.val$getMetricStatisticsRequest = getMetricStatisticsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetMetricStatisticsResult call() throws Exception {
            try {
                GetMetricStatisticsResult metricStatistics = AmazonCloudWatchAsyncClient.this.getMetricStatistics(this.val$getMetricStatisticsRequest);
                this.val$asyncHandler.onSuccess(this.val$getMetricStatisticsRequest, metricStatistics);
                return metricStatistics;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient.9 */
    class C00349 implements Callable<Void> {
        final /* synthetic */ DisableAlarmActionsRequest val$disableAlarmActionsRequest;

        C00349(DisableAlarmActionsRequest disableAlarmActionsRequest) {
            this.val$disableAlarmActionsRequest = disableAlarmActionsRequest;
        }

        public Void call() throws Exception {
            AmazonCloudWatchAsyncClient.this.disableAlarmActions(this.val$disableAlarmActionsRequest);
            return null;
        }
    }

    public AmazonCloudWatchAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public AmazonCloudWatchAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newCachedThreadPool());
    }

    public AmazonCloudWatchAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newCachedThreadPool());
    }

    public AmazonCloudWatchAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonCloudWatchAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.executorService = executorService;
    }

    public AmazonCloudWatchAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newCachedThreadPool());
    }

    public AmazonCloudWatchAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonCloudWatchAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public Future<Void> deleteAlarmsAsync(DeleteAlarmsRequest deleteAlarmsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass19(deleteAlarmsRequest));
    }

    public Future<Void> deleteAlarmsAsync(DeleteAlarmsRequest deleteAlarmsRequest, AsyncHandler<DeleteAlarmsRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass20(deleteAlarmsRequest, asyncHandler));
    }

    public Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync(DescribeAlarmHistoryRequest describeAlarmHistoryRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass15(describeAlarmHistoryRequest));
    }

    public Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync(DescribeAlarmHistoryRequest describeAlarmHistoryRequest, AsyncHandler<DescribeAlarmHistoryRequest, DescribeAlarmHistoryResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass16(describeAlarmHistoryRequest, asyncHandler));
    }

    public Future<DescribeAlarmsResult> describeAlarmsAsync(DescribeAlarmsRequest describeAlarmsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass11(describeAlarmsRequest));
    }

    public Future<DescribeAlarmsResult> describeAlarmsAsync(DescribeAlarmsRequest describeAlarmsRequest, AsyncHandler<DescribeAlarmsRequest, DescribeAlarmsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass12(describeAlarmsRequest, asyncHandler));
    }

    public Future<DescribeAlarmsForMetricResult> describeAlarmsForMetricAsync(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass13(describeAlarmsForMetricRequest));
    }

    public Future<DescribeAlarmsForMetricResult> describeAlarmsForMetricAsync(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest, AsyncHandler<DescribeAlarmsForMetricRequest, DescribeAlarmsForMetricResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass14(describeAlarmsForMetricRequest, asyncHandler));
    }

    public Future<Void> disableAlarmActionsAsync(DisableAlarmActionsRequest disableAlarmActionsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00349(disableAlarmActionsRequest));
    }

    public Future<Void> disableAlarmActionsAsync(DisableAlarmActionsRequest disableAlarmActionsRequest, AsyncHandler<DisableAlarmActionsRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass10(disableAlarmActionsRequest, asyncHandler));
    }

    public Future<Void> enableAlarmActionsAsync(EnableAlarmActionsRequest enableAlarmActionsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass17(enableAlarmActionsRequest));
    }

    public Future<Void> enableAlarmActionsAsync(EnableAlarmActionsRequest enableAlarmActionsRequest, AsyncHandler<EnableAlarmActionsRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass18(enableAlarmActionsRequest, asyncHandler));
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Future<GetMetricStatisticsResult> getMetricStatisticsAsync(GetMetricStatisticsRequest getMetricStatisticsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00327(getMetricStatisticsRequest));
    }

    public Future<GetMetricStatisticsResult> getMetricStatisticsAsync(GetMetricStatisticsRequest getMetricStatisticsRequest, AsyncHandler<GetMetricStatisticsRequest, GetMetricStatisticsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00338(getMetricStatisticsRequest, asyncHandler));
    }

    public Future<ListMetricsResult> listMetricsAsync(ListMetricsRequest listMetricsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00305(listMetricsRequest));
    }

    public Future<ListMetricsResult> listMetricsAsync(ListMetricsRequest listMetricsRequest, AsyncHandler<ListMetricsRequest, ListMetricsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00316(listMetricsRequest, asyncHandler));
    }

    public Future<Void> putMetricAlarmAsync(PutMetricAlarmRequest putMetricAlarmRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00261(putMetricAlarmRequest));
    }

    public Future<Void> putMetricAlarmAsync(PutMetricAlarmRequest putMetricAlarmRequest, AsyncHandler<PutMetricAlarmRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00272(putMetricAlarmRequest, asyncHandler));
    }

    public Future<Void> putMetricDataAsync(PutMetricDataRequest putMetricDataRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00283(putMetricDataRequest));
    }

    public Future<Void> putMetricDataAsync(PutMetricDataRequest putMetricDataRequest, AsyncHandler<PutMetricDataRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00294(putMetricDataRequest, asyncHandler));
    }

    public Future<Void> setAlarmStateAsync(SetAlarmStateRequest setAlarmStateRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass21(setAlarmStateRequest));
    }

    public Future<Void> setAlarmStateAsync(SetAlarmStateRequest setAlarmStateRequest, AsyncHandler<SetAlarmStateRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass22(setAlarmStateRequest, asyncHandler));
    }

    public void shutdown() {
        super.shutdown();
        this.executorService.shutdownNow();
    }
}
