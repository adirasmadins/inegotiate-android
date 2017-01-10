package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.services.cloudwatch.model.MetricDatum;
import com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;
import com.amazonaws.services.cloudwatch.model.StatisticSet;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class PutMetricDataRequestMarshaller implements Marshaller<Request<PutMetricDataRequest>, PutMetricDataRequest> {
    public Request<PutMetricDataRequest> marshall(PutMetricDataRequest putMetricDataRequest) {
        if (putMetricDataRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<PutMetricDataRequest> defaultRequest = new DefaultRequest(putMetricDataRequest, "AmazonCloudWatch");
        defaultRequest.addParameter("Action", "PutMetricData");
        defaultRequest.addParameter("Version", "2010-08-01");
        if (putMetricDataRequest.getNamespace() != null) {
            defaultRequest.addParameter("Namespace", StringUtils.fromString(putMetricDataRequest.getNamespace()));
        }
        int i = 1;
        for (MetricDatum metricDatum : putMetricDataRequest.getMetricData()) {
            if (metricDatum != null) {
                if (metricDatum.getMetricName() != null) {
                    defaultRequest.addParameter("MetricData.member." + i + ".MetricName", StringUtils.fromString(metricDatum.getMetricName()));
                }
                int i2 = 1;
                for (Dimension dimension : metricDatum.getDimensions()) {
                    if (dimension != null) {
                        if (dimension.getName() != null) {
                            defaultRequest.addParameter("MetricData.member." + i + ".Dimensions.member." + i2 + ".Name", StringUtils.fromString(dimension.getName()));
                        }
                        if (dimension.getValue() != null) {
                            defaultRequest.addParameter("MetricData.member." + i + ".Dimensions.member." + i2 + ".Value", StringUtils.fromString(dimension.getValue()));
                        }
                    }
                    i2++;
                }
                if (metricDatum.getTimestamp() != null) {
                    defaultRequest.addParameter("MetricData.member." + i + ".Timestamp", StringUtils.fromDate(metricDatum.getTimestamp()));
                }
                if (metricDatum.getValue() != null) {
                    defaultRequest.addParameter("MetricData.member." + i + ".Value", StringUtils.fromDouble(metricDatum.getValue()));
                }
                StatisticSet statisticValues = metricDatum.getStatisticValues();
                if (statisticValues != null) {
                    if (statisticValues.getSampleCount() != null) {
                        defaultRequest.addParameter("MetricData.member." + i + ".StatisticValues.SampleCount", StringUtils.fromDouble(statisticValues.getSampleCount()));
                    }
                    if (statisticValues.getSum() != null) {
                        defaultRequest.addParameter("MetricData.member." + i + ".StatisticValues.Sum", StringUtils.fromDouble(statisticValues.getSum()));
                    }
                    if (statisticValues.getMinimum() != null) {
                        defaultRequest.addParameter("MetricData.member." + i + ".StatisticValues.Minimum", StringUtils.fromDouble(statisticValues.getMinimum()));
                    }
                    if (statisticValues.getMaximum() != null) {
                        defaultRequest.addParameter("MetricData.member." + i + ".StatisticValues.Maximum", StringUtils.fromDouble(statisticValues.getMaximum()));
                    }
                }
                if (metricDatum.getUnit() != null) {
                    defaultRequest.addParameter("MetricData.member." + i + ".Unit", StringUtils.fromString(metricDatum.getUnit()));
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
