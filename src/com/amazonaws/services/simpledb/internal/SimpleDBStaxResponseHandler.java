package com.amazonaws.services.simpledb.internal;

import com.amazonaws.http.StaxResponseHandler;
import com.amazonaws.services.simpledb.SimpleDBResponseMetadata;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SimpleDBStaxResponseHandler<T> extends StaxResponseHandler<T> {
    public SimpleDBStaxResponseHandler(Unmarshaller<T, StaxUnmarshallerContext> unmarshaller) {
        super(unmarshaller);
    }

    protected void registerAdditionalMetadataExpressions(StaxUnmarshallerContext staxUnmarshallerContext) {
        staxUnmarshallerContext.registerMetadataExpression("ResponseMetadata/BoxUsage", 2, SimpleDBResponseMetadata.BOX_USAGE);
    }
}
