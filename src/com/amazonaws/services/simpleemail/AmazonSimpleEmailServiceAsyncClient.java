package com.amazonaws.services.simpleemail;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.simpleemail.model.DeleteIdentityRequest;
import com.amazonaws.services.simpleemail.model.DeleteIdentityResult;
import com.amazonaws.services.simpleemail.model.DeleteVerifiedEmailAddressRequest;
import com.amazonaws.services.simpleemail.model.GetIdentityDkimAttributesRequest;
import com.amazonaws.services.simpleemail.model.GetIdentityDkimAttributesResult;
import com.amazonaws.services.simpleemail.model.GetIdentityNotificationAttributesRequest;
import com.amazonaws.services.simpleemail.model.GetIdentityNotificationAttributesResult;
import com.amazonaws.services.simpleemail.model.GetIdentityVerificationAttributesRequest;
import com.amazonaws.services.simpleemail.model.GetIdentityVerificationAttributesResult;
import com.amazonaws.services.simpleemail.model.GetSendQuotaRequest;
import com.amazonaws.services.simpleemail.model.GetSendQuotaResult;
import com.amazonaws.services.simpleemail.model.GetSendStatisticsRequest;
import com.amazonaws.services.simpleemail.model.GetSendStatisticsResult;
import com.amazonaws.services.simpleemail.model.ListIdentitiesRequest;
import com.amazonaws.services.simpleemail.model.ListIdentitiesResult;
import com.amazonaws.services.simpleemail.model.ListVerifiedEmailAddressesRequest;
import com.amazonaws.services.simpleemail.model.ListVerifiedEmailAddressesResult;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.amazonaws.services.simpleemail.model.SendEmailResult;
import com.amazonaws.services.simpleemail.model.SendRawEmailRequest;
import com.amazonaws.services.simpleemail.model.SendRawEmailResult;
import com.amazonaws.services.simpleemail.model.SetIdentityDkimEnabledRequest;
import com.amazonaws.services.simpleemail.model.SetIdentityDkimEnabledResult;
import com.amazonaws.services.simpleemail.model.SetIdentityFeedbackForwardingEnabledRequest;
import com.amazonaws.services.simpleemail.model.SetIdentityFeedbackForwardingEnabledResult;
import com.amazonaws.services.simpleemail.model.SetIdentityNotificationTopicRequest;
import com.amazonaws.services.simpleemail.model.SetIdentityNotificationTopicResult;
import com.amazonaws.services.simpleemail.model.VerifyDomainDkimRequest;
import com.amazonaws.services.simpleemail.model.VerifyDomainDkimResult;
import com.amazonaws.services.simpleemail.model.VerifyDomainIdentityRequest;
import com.amazonaws.services.simpleemail.model.VerifyDomainIdentityResult;
import com.amazonaws.services.simpleemail.model.VerifyEmailAddressRequest;
import com.amazonaws.services.simpleemail.model.VerifyEmailIdentityRequest;
import com.amazonaws.services.simpleemail.model.VerifyEmailIdentityResult;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AmazonSimpleEmailServiceAsyncClient extends AmazonSimpleEmailServiceClient implements AmazonSimpleEmailServiceAsync {
    private ExecutorService executorService;

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.10 */
    class AnonymousClass10 implements Callable<GetIdentityNotificationAttributesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetIdentityNotificationAttributesRequest val$getIdentityNotificationAttributesRequest;

        AnonymousClass10(GetIdentityNotificationAttributesRequest getIdentityNotificationAttributesRequest, AsyncHandler asyncHandler) {
            this.val$getIdentityNotificationAttributesRequest = getIdentityNotificationAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetIdentityNotificationAttributesResult call() throws Exception {
            try {
                GetIdentityNotificationAttributesResult identityNotificationAttributes = AmazonSimpleEmailServiceAsyncClient.this.getIdentityNotificationAttributes(this.val$getIdentityNotificationAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$getIdentityNotificationAttributesRequest, identityNotificationAttributes);
                return identityNotificationAttributes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.11 */
    class AnonymousClass11 implements Callable<VerifyDomainDkimResult> {
        final /* synthetic */ VerifyDomainDkimRequest val$verifyDomainDkimRequest;

        AnonymousClass11(VerifyDomainDkimRequest verifyDomainDkimRequest) {
            this.val$verifyDomainDkimRequest = verifyDomainDkimRequest;
        }

        public VerifyDomainDkimResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.verifyDomainDkim(this.val$verifyDomainDkimRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.12 */
    class AnonymousClass12 implements Callable<VerifyDomainDkimResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ VerifyDomainDkimRequest val$verifyDomainDkimRequest;

        AnonymousClass12(VerifyDomainDkimRequest verifyDomainDkimRequest, AsyncHandler asyncHandler) {
            this.val$verifyDomainDkimRequest = verifyDomainDkimRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public VerifyDomainDkimResult call() throws Exception {
            try {
                VerifyDomainDkimResult verifyDomainDkim = AmazonSimpleEmailServiceAsyncClient.this.verifyDomainDkim(this.val$verifyDomainDkimRequest);
                this.val$asyncHandler.onSuccess(this.val$verifyDomainDkimRequest, verifyDomainDkim);
                return verifyDomainDkim;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.13 */
    class AnonymousClass13 implements Callable<GetIdentityDkimAttributesResult> {
        final /* synthetic */ GetIdentityDkimAttributesRequest val$getIdentityDkimAttributesRequest;

        AnonymousClass13(GetIdentityDkimAttributesRequest getIdentityDkimAttributesRequest) {
            this.val$getIdentityDkimAttributesRequest = getIdentityDkimAttributesRequest;
        }

        public GetIdentityDkimAttributesResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.getIdentityDkimAttributes(this.val$getIdentityDkimAttributesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.14 */
    class AnonymousClass14 implements Callable<GetIdentityDkimAttributesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetIdentityDkimAttributesRequest val$getIdentityDkimAttributesRequest;

        AnonymousClass14(GetIdentityDkimAttributesRequest getIdentityDkimAttributesRequest, AsyncHandler asyncHandler) {
            this.val$getIdentityDkimAttributesRequest = getIdentityDkimAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetIdentityDkimAttributesResult call() throws Exception {
            try {
                GetIdentityDkimAttributesResult identityDkimAttributes = AmazonSimpleEmailServiceAsyncClient.this.getIdentityDkimAttributes(this.val$getIdentityDkimAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$getIdentityDkimAttributesRequest, identityDkimAttributes);
                return identityDkimAttributes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.15 */
    class AnonymousClass15 implements Callable<Void> {
        final /* synthetic */ VerifyEmailAddressRequest val$verifyEmailAddressRequest;

        AnonymousClass15(VerifyEmailAddressRequest verifyEmailAddressRequest) {
            this.val$verifyEmailAddressRequest = verifyEmailAddressRequest;
        }

        public Void call() throws Exception {
            AmazonSimpleEmailServiceAsyncClient.this.verifyEmailAddress(this.val$verifyEmailAddressRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.16 */
    class AnonymousClass16 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ VerifyEmailAddressRequest val$verifyEmailAddressRequest;

        AnonymousClass16(VerifyEmailAddressRequest verifyEmailAddressRequest, AsyncHandler asyncHandler) {
            this.val$verifyEmailAddressRequest = verifyEmailAddressRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSimpleEmailServiceAsyncClient.this.verifyEmailAddress(this.val$verifyEmailAddressRequest);
                this.val$asyncHandler.onSuccess(this.val$verifyEmailAddressRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.17 */
    class AnonymousClass17 implements Callable<SendRawEmailResult> {
        final /* synthetic */ SendRawEmailRequest val$sendRawEmailRequest;

        AnonymousClass17(SendRawEmailRequest sendRawEmailRequest) {
            this.val$sendRawEmailRequest = sendRawEmailRequest;
        }

        public SendRawEmailResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.sendRawEmail(this.val$sendRawEmailRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.18 */
    class AnonymousClass18 implements Callable<SendRawEmailResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SendRawEmailRequest val$sendRawEmailRequest;

        AnonymousClass18(SendRawEmailRequest sendRawEmailRequest, AsyncHandler asyncHandler) {
            this.val$sendRawEmailRequest = sendRawEmailRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public SendRawEmailResult call() throws Exception {
            try {
                SendRawEmailResult sendRawEmail = AmazonSimpleEmailServiceAsyncClient.this.sendRawEmail(this.val$sendRawEmailRequest);
                this.val$asyncHandler.onSuccess(this.val$sendRawEmailRequest, sendRawEmail);
                return sendRawEmail;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.19 */
    class AnonymousClass19 implements Callable<ListIdentitiesResult> {
        final /* synthetic */ ListIdentitiesRequest val$listIdentitiesRequest;

        AnonymousClass19(ListIdentitiesRequest listIdentitiesRequest) {
            this.val$listIdentitiesRequest = listIdentitiesRequest;
        }

        public ListIdentitiesResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.listIdentities(this.val$listIdentitiesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.1 */
    class C00841 implements Callable<DeleteIdentityResult> {
        final /* synthetic */ DeleteIdentityRequest val$deleteIdentityRequest;

        C00841(DeleteIdentityRequest deleteIdentityRequest) {
            this.val$deleteIdentityRequest = deleteIdentityRequest;
        }

        public DeleteIdentityResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.deleteIdentity(this.val$deleteIdentityRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.20 */
    class AnonymousClass20 implements Callable<ListIdentitiesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ListIdentitiesRequest val$listIdentitiesRequest;

        AnonymousClass20(ListIdentitiesRequest listIdentitiesRequest, AsyncHandler asyncHandler) {
            this.val$listIdentitiesRequest = listIdentitiesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ListIdentitiesResult call() throws Exception {
            try {
                ListIdentitiesResult listIdentities = AmazonSimpleEmailServiceAsyncClient.this.listIdentities(this.val$listIdentitiesRequest);
                this.val$asyncHandler.onSuccess(this.val$listIdentitiesRequest, listIdentities);
                return listIdentities;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.21 */
    class AnonymousClass21 implements Callable<GetIdentityVerificationAttributesResult> {
        final /* synthetic */ GetIdentityVerificationAttributesRequest val$getIdentityVerificationAttributesRequest;

        AnonymousClass21(GetIdentityVerificationAttributesRequest getIdentityVerificationAttributesRequest) {
            this.val$getIdentityVerificationAttributesRequest = getIdentityVerificationAttributesRequest;
        }

        public GetIdentityVerificationAttributesResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.getIdentityVerificationAttributes(this.val$getIdentityVerificationAttributesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.22 */
    class AnonymousClass22 implements Callable<GetIdentityVerificationAttributesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetIdentityVerificationAttributesRequest val$getIdentityVerificationAttributesRequest;

        AnonymousClass22(GetIdentityVerificationAttributesRequest getIdentityVerificationAttributesRequest, AsyncHandler asyncHandler) {
            this.val$getIdentityVerificationAttributesRequest = getIdentityVerificationAttributesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetIdentityVerificationAttributesResult call() throws Exception {
            try {
                GetIdentityVerificationAttributesResult identityVerificationAttributes = AmazonSimpleEmailServiceAsyncClient.this.getIdentityVerificationAttributes(this.val$getIdentityVerificationAttributesRequest);
                this.val$asyncHandler.onSuccess(this.val$getIdentityVerificationAttributesRequest, identityVerificationAttributes);
                return identityVerificationAttributes;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.23 */
    class AnonymousClass23 implements Callable<SetIdentityDkimEnabledResult> {
        final /* synthetic */ SetIdentityDkimEnabledRequest val$setIdentityDkimEnabledRequest;

        AnonymousClass23(SetIdentityDkimEnabledRequest setIdentityDkimEnabledRequest) {
            this.val$setIdentityDkimEnabledRequest = setIdentityDkimEnabledRequest;
        }

        public SetIdentityDkimEnabledResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.setIdentityDkimEnabled(this.val$setIdentityDkimEnabledRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.24 */
    class AnonymousClass24 implements Callable<SetIdentityDkimEnabledResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SetIdentityDkimEnabledRequest val$setIdentityDkimEnabledRequest;

        AnonymousClass24(SetIdentityDkimEnabledRequest setIdentityDkimEnabledRequest, AsyncHandler asyncHandler) {
            this.val$setIdentityDkimEnabledRequest = setIdentityDkimEnabledRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public SetIdentityDkimEnabledResult call() throws Exception {
            try {
                SetIdentityDkimEnabledResult identityDkimEnabled = AmazonSimpleEmailServiceAsyncClient.this.setIdentityDkimEnabled(this.val$setIdentityDkimEnabledRequest);
                this.val$asyncHandler.onSuccess(this.val$setIdentityDkimEnabledRequest, identityDkimEnabled);
                return identityDkimEnabled;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.25 */
    class AnonymousClass25 implements Callable<GetSendQuotaResult> {
        final /* synthetic */ GetSendQuotaRequest val$getSendQuotaRequest;

        AnonymousClass25(GetSendQuotaRequest getSendQuotaRequest) {
            this.val$getSendQuotaRequest = getSendQuotaRequest;
        }

        public GetSendQuotaResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.getSendQuota(this.val$getSendQuotaRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.26 */
    class AnonymousClass26 implements Callable<GetSendQuotaResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetSendQuotaRequest val$getSendQuotaRequest;

        AnonymousClass26(GetSendQuotaRequest getSendQuotaRequest, AsyncHandler asyncHandler) {
            this.val$getSendQuotaRequest = getSendQuotaRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetSendQuotaResult call() throws Exception {
            try {
                GetSendQuotaResult sendQuota = AmazonSimpleEmailServiceAsyncClient.this.getSendQuota(this.val$getSendQuotaRequest);
                this.val$asyncHandler.onSuccess(this.val$getSendQuotaRequest, sendQuota);
                return sendQuota;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.27 */
    class AnonymousClass27 implements Callable<SetIdentityFeedbackForwardingEnabledResult> {
        final /* synthetic */ SetIdentityFeedbackForwardingEnabledRequest val$setIdentityFeedbackForwardingEnabledRequest;

        AnonymousClass27(SetIdentityFeedbackForwardingEnabledRequest setIdentityFeedbackForwardingEnabledRequest) {
            this.val$setIdentityFeedbackForwardingEnabledRequest = setIdentityFeedbackForwardingEnabledRequest;
        }

        public SetIdentityFeedbackForwardingEnabledResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.setIdentityFeedbackForwardingEnabled(this.val$setIdentityFeedbackForwardingEnabledRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.28 */
    class AnonymousClass28 implements Callable<SetIdentityFeedbackForwardingEnabledResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SetIdentityFeedbackForwardingEnabledRequest val$setIdentityFeedbackForwardingEnabledRequest;

        AnonymousClass28(SetIdentityFeedbackForwardingEnabledRequest setIdentityFeedbackForwardingEnabledRequest, AsyncHandler asyncHandler) {
            this.val$setIdentityFeedbackForwardingEnabledRequest = setIdentityFeedbackForwardingEnabledRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public SetIdentityFeedbackForwardingEnabledResult call() throws Exception {
            try {
                SetIdentityFeedbackForwardingEnabledResult identityFeedbackForwardingEnabled = AmazonSimpleEmailServiceAsyncClient.this.setIdentityFeedbackForwardingEnabled(this.val$setIdentityFeedbackForwardingEnabledRequest);
                this.val$asyncHandler.onSuccess(this.val$setIdentityFeedbackForwardingEnabledRequest, identityFeedbackForwardingEnabled);
                return identityFeedbackForwardingEnabled;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.29 */
    class AnonymousClass29 implements Callable<VerifyDomainIdentityResult> {
        final /* synthetic */ VerifyDomainIdentityRequest val$verifyDomainIdentityRequest;

        AnonymousClass29(VerifyDomainIdentityRequest verifyDomainIdentityRequest) {
            this.val$verifyDomainIdentityRequest = verifyDomainIdentityRequest;
        }

        public VerifyDomainIdentityResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.verifyDomainIdentity(this.val$verifyDomainIdentityRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.2 */
    class C00852 implements Callable<DeleteIdentityResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteIdentityRequest val$deleteIdentityRequest;

        C00852(DeleteIdentityRequest deleteIdentityRequest, AsyncHandler asyncHandler) {
            this.val$deleteIdentityRequest = deleteIdentityRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public DeleteIdentityResult call() throws Exception {
            try {
                DeleteIdentityResult deleteIdentity = AmazonSimpleEmailServiceAsyncClient.this.deleteIdentity(this.val$deleteIdentityRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteIdentityRequest, deleteIdentity);
                return deleteIdentity;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.30 */
    class AnonymousClass30 implements Callable<VerifyDomainIdentityResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ VerifyDomainIdentityRequest val$verifyDomainIdentityRequest;

        AnonymousClass30(VerifyDomainIdentityRequest verifyDomainIdentityRequest, AsyncHandler asyncHandler) {
            this.val$verifyDomainIdentityRequest = verifyDomainIdentityRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public VerifyDomainIdentityResult call() throws Exception {
            try {
                VerifyDomainIdentityResult verifyDomainIdentity = AmazonSimpleEmailServiceAsyncClient.this.verifyDomainIdentity(this.val$verifyDomainIdentityRequest);
                this.val$asyncHandler.onSuccess(this.val$verifyDomainIdentityRequest, verifyDomainIdentity);
                return verifyDomainIdentity;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.31 */
    class AnonymousClass31 implements Callable<SendEmailResult> {
        final /* synthetic */ SendEmailRequest val$sendEmailRequest;

        AnonymousClass31(SendEmailRequest sendEmailRequest) {
            this.val$sendEmailRequest = sendEmailRequest;
        }

        public SendEmailResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.sendEmail(this.val$sendEmailRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.32 */
    class AnonymousClass32 implements Callable<SendEmailResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SendEmailRequest val$sendEmailRequest;

        AnonymousClass32(SendEmailRequest sendEmailRequest, AsyncHandler asyncHandler) {
            this.val$sendEmailRequest = sendEmailRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public SendEmailResult call() throws Exception {
            try {
                SendEmailResult sendEmail = AmazonSimpleEmailServiceAsyncClient.this.sendEmail(this.val$sendEmailRequest);
                this.val$asyncHandler.onSuccess(this.val$sendEmailRequest, sendEmail);
                return sendEmail;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.33 */
    class AnonymousClass33 implements Callable<Void> {
        final /* synthetic */ DeleteVerifiedEmailAddressRequest val$deleteVerifiedEmailAddressRequest;

        AnonymousClass33(DeleteVerifiedEmailAddressRequest deleteVerifiedEmailAddressRequest) {
            this.val$deleteVerifiedEmailAddressRequest = deleteVerifiedEmailAddressRequest;
        }

        public Void call() throws Exception {
            AmazonSimpleEmailServiceAsyncClient.this.deleteVerifiedEmailAddress(this.val$deleteVerifiedEmailAddressRequest);
            return null;
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.34 */
    class AnonymousClass34 implements Callable<Void> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ DeleteVerifiedEmailAddressRequest val$deleteVerifiedEmailAddressRequest;

        AnonymousClass34(DeleteVerifiedEmailAddressRequest deleteVerifiedEmailAddressRequest, AsyncHandler asyncHandler) {
            this.val$deleteVerifiedEmailAddressRequest = deleteVerifiedEmailAddressRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public Void call() throws Exception {
            try {
                AmazonSimpleEmailServiceAsyncClient.this.deleteVerifiedEmailAddress(this.val$deleteVerifiedEmailAddressRequest);
                this.val$asyncHandler.onSuccess(this.val$deleteVerifiedEmailAddressRequest, null);
                return null;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.35 */
    class AnonymousClass35 implements Callable<SetIdentityNotificationTopicResult> {
        final /* synthetic */ SetIdentityNotificationTopicRequest val$setIdentityNotificationTopicRequest;

        AnonymousClass35(SetIdentityNotificationTopicRequest setIdentityNotificationTopicRequest) {
            this.val$setIdentityNotificationTopicRequest = setIdentityNotificationTopicRequest;
        }

        public SetIdentityNotificationTopicResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.setIdentityNotificationTopic(this.val$setIdentityNotificationTopicRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.36 */
    class AnonymousClass36 implements Callable<SetIdentityNotificationTopicResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ SetIdentityNotificationTopicRequest val$setIdentityNotificationTopicRequest;

        AnonymousClass36(SetIdentityNotificationTopicRequest setIdentityNotificationTopicRequest, AsyncHandler asyncHandler) {
            this.val$setIdentityNotificationTopicRequest = setIdentityNotificationTopicRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public SetIdentityNotificationTopicResult call() throws Exception {
            try {
                SetIdentityNotificationTopicResult identityNotificationTopic = AmazonSimpleEmailServiceAsyncClient.this.setIdentityNotificationTopic(this.val$setIdentityNotificationTopicRequest);
                this.val$asyncHandler.onSuccess(this.val$setIdentityNotificationTopicRequest, identityNotificationTopic);
                return identityNotificationTopic;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.3 */
    class C00863 implements Callable<ListVerifiedEmailAddressesResult> {
        final /* synthetic */ ListVerifiedEmailAddressesRequest val$listVerifiedEmailAddressesRequest;

        C00863(ListVerifiedEmailAddressesRequest listVerifiedEmailAddressesRequest) {
            this.val$listVerifiedEmailAddressesRequest = listVerifiedEmailAddressesRequest;
        }

        public ListVerifiedEmailAddressesResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.listVerifiedEmailAddresses(this.val$listVerifiedEmailAddressesRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.4 */
    class C00874 implements Callable<ListVerifiedEmailAddressesResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ ListVerifiedEmailAddressesRequest val$listVerifiedEmailAddressesRequest;

        C00874(ListVerifiedEmailAddressesRequest listVerifiedEmailAddressesRequest, AsyncHandler asyncHandler) {
            this.val$listVerifiedEmailAddressesRequest = listVerifiedEmailAddressesRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public ListVerifiedEmailAddressesResult call() throws Exception {
            try {
                ListVerifiedEmailAddressesResult listVerifiedEmailAddresses = AmazonSimpleEmailServiceAsyncClient.this.listVerifiedEmailAddresses(this.val$listVerifiedEmailAddressesRequest);
                this.val$asyncHandler.onSuccess(this.val$listVerifiedEmailAddressesRequest, listVerifiedEmailAddresses);
                return listVerifiedEmailAddresses;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.5 */
    class C00885 implements Callable<GetSendStatisticsResult> {
        final /* synthetic */ GetSendStatisticsRequest val$getSendStatisticsRequest;

        C00885(GetSendStatisticsRequest getSendStatisticsRequest) {
            this.val$getSendStatisticsRequest = getSendStatisticsRequest;
        }

        public GetSendStatisticsResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.getSendStatistics(this.val$getSendStatisticsRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.6 */
    class C00896 implements Callable<GetSendStatisticsResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ GetSendStatisticsRequest val$getSendStatisticsRequest;

        C00896(GetSendStatisticsRequest getSendStatisticsRequest, AsyncHandler asyncHandler) {
            this.val$getSendStatisticsRequest = getSendStatisticsRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public GetSendStatisticsResult call() throws Exception {
            try {
                GetSendStatisticsResult sendStatistics = AmazonSimpleEmailServiceAsyncClient.this.getSendStatistics(this.val$getSendStatisticsRequest);
                this.val$asyncHandler.onSuccess(this.val$getSendStatisticsRequest, sendStatistics);
                return sendStatistics;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.7 */
    class C00907 implements Callable<VerifyEmailIdentityResult> {
        final /* synthetic */ VerifyEmailIdentityRequest val$verifyEmailIdentityRequest;

        C00907(VerifyEmailIdentityRequest verifyEmailIdentityRequest) {
            this.val$verifyEmailIdentityRequest = verifyEmailIdentityRequest;
        }

        public VerifyEmailIdentityResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.verifyEmailIdentity(this.val$verifyEmailIdentityRequest);
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.8 */
    class C00918 implements Callable<VerifyEmailIdentityResult> {
        final /* synthetic */ AsyncHandler val$asyncHandler;
        final /* synthetic */ VerifyEmailIdentityRequest val$verifyEmailIdentityRequest;

        C00918(VerifyEmailIdentityRequest verifyEmailIdentityRequest, AsyncHandler asyncHandler) {
            this.val$verifyEmailIdentityRequest = verifyEmailIdentityRequest;
            this.val$asyncHandler = asyncHandler;
        }

        public VerifyEmailIdentityResult call() throws Exception {
            try {
                VerifyEmailIdentityResult verifyEmailIdentity = AmazonSimpleEmailServiceAsyncClient.this.verifyEmailIdentity(this.val$verifyEmailIdentityRequest);
                this.val$asyncHandler.onSuccess(this.val$verifyEmailIdentityRequest, verifyEmailIdentity);
                return verifyEmailIdentity;
            } catch (Exception e) {
                this.val$asyncHandler.onError(e);
                throw e;
            }
        }
    }

    /* renamed from: com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient.9 */
    class C00929 implements Callable<GetIdentityNotificationAttributesResult> {
        final /* synthetic */ GetIdentityNotificationAttributesRequest val$getIdentityNotificationAttributesRequest;

        C00929(GetIdentityNotificationAttributesRequest getIdentityNotificationAttributesRequest) {
            this.val$getIdentityNotificationAttributesRequest = getIdentityNotificationAttributesRequest;
        }

        public GetIdentityNotificationAttributesResult call() throws Exception {
            return AmazonSimpleEmailServiceAsyncClient.this.getIdentityNotificationAttributes(this.val$getIdentityNotificationAttributesRequest);
        }
    }

    public AmazonSimpleEmailServiceAsyncClient() {
        this(new DefaultAWSCredentialsProviderChain());
    }

    public AmazonSimpleEmailServiceAsyncClient(ClientConfiguration clientConfiguration) {
        this(new DefaultAWSCredentialsProviderChain(), clientConfiguration, Executors.newCachedThreadPool());
    }

    public AmazonSimpleEmailServiceAsyncClient(AWSCredentials aWSCredentials) {
        this(aWSCredentials, Executors.newCachedThreadPool());
    }

    public AmazonSimpleEmailServiceAsyncClient(AWSCredentials aWSCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentials, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonSimpleEmailServiceAsyncClient(AWSCredentials aWSCredentials, ExecutorService executorService) {
        super(aWSCredentials);
        this.executorService = executorService;
    }

    public AmazonSimpleEmailServiceAsyncClient(AWSCredentialsProvider aWSCredentialsProvider) {
        this(aWSCredentialsProvider, Executors.newCachedThreadPool());
    }

    public AmazonSimpleEmailServiceAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService) {
        super(aWSCredentialsProvider, clientConfiguration);
        this.executorService = executorService;
    }

    public AmazonSimpleEmailServiceAsyncClient(AWSCredentialsProvider aWSCredentialsProvider, ExecutorService executorService) {
        this(aWSCredentialsProvider, new ClientConfiguration(), executorService);
    }

    public Future<DeleteIdentityResult> deleteIdentityAsync(DeleteIdentityRequest deleteIdentityRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00841(deleteIdentityRequest));
    }

    public Future<DeleteIdentityResult> deleteIdentityAsync(DeleteIdentityRequest deleteIdentityRequest, AsyncHandler<DeleteIdentityRequest, DeleteIdentityResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00852(deleteIdentityRequest, asyncHandler));
    }

    public Future<Void> deleteVerifiedEmailAddressAsync(DeleteVerifiedEmailAddressRequest deleteVerifiedEmailAddressRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass33(deleteVerifiedEmailAddressRequest));
    }

    public Future<Void> deleteVerifiedEmailAddressAsync(DeleteVerifiedEmailAddressRequest deleteVerifiedEmailAddressRequest, AsyncHandler<DeleteVerifiedEmailAddressRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass34(deleteVerifiedEmailAddressRequest, asyncHandler));
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Future<GetIdentityDkimAttributesResult> getIdentityDkimAttributesAsync(GetIdentityDkimAttributesRequest getIdentityDkimAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass13(getIdentityDkimAttributesRequest));
    }

    public Future<GetIdentityDkimAttributesResult> getIdentityDkimAttributesAsync(GetIdentityDkimAttributesRequest getIdentityDkimAttributesRequest, AsyncHandler<GetIdentityDkimAttributesRequest, GetIdentityDkimAttributesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass14(getIdentityDkimAttributesRequest, asyncHandler));
    }

    public Future<GetIdentityNotificationAttributesResult> getIdentityNotificationAttributesAsync(GetIdentityNotificationAttributesRequest getIdentityNotificationAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00929(getIdentityNotificationAttributesRequest));
    }

    public Future<GetIdentityNotificationAttributesResult> getIdentityNotificationAttributesAsync(GetIdentityNotificationAttributesRequest getIdentityNotificationAttributesRequest, AsyncHandler<GetIdentityNotificationAttributesRequest, GetIdentityNotificationAttributesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass10(getIdentityNotificationAttributesRequest, asyncHandler));
    }

    public Future<GetIdentityVerificationAttributesResult> getIdentityVerificationAttributesAsync(GetIdentityVerificationAttributesRequest getIdentityVerificationAttributesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass21(getIdentityVerificationAttributesRequest));
    }

    public Future<GetIdentityVerificationAttributesResult> getIdentityVerificationAttributesAsync(GetIdentityVerificationAttributesRequest getIdentityVerificationAttributesRequest, AsyncHandler<GetIdentityVerificationAttributesRequest, GetIdentityVerificationAttributesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass22(getIdentityVerificationAttributesRequest, asyncHandler));
    }

    public Future<GetSendQuotaResult> getSendQuotaAsync(GetSendQuotaRequest getSendQuotaRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass25(getSendQuotaRequest));
    }

    public Future<GetSendQuotaResult> getSendQuotaAsync(GetSendQuotaRequest getSendQuotaRequest, AsyncHandler<GetSendQuotaRequest, GetSendQuotaResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass26(getSendQuotaRequest, asyncHandler));
    }

    public Future<GetSendStatisticsResult> getSendStatisticsAsync(GetSendStatisticsRequest getSendStatisticsRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00885(getSendStatisticsRequest));
    }

    public Future<GetSendStatisticsResult> getSendStatisticsAsync(GetSendStatisticsRequest getSendStatisticsRequest, AsyncHandler<GetSendStatisticsRequest, GetSendStatisticsResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00896(getSendStatisticsRequest, asyncHandler));
    }

    public Future<ListIdentitiesResult> listIdentitiesAsync(ListIdentitiesRequest listIdentitiesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass19(listIdentitiesRequest));
    }

    public Future<ListIdentitiesResult> listIdentitiesAsync(ListIdentitiesRequest listIdentitiesRequest, AsyncHandler<ListIdentitiesRequest, ListIdentitiesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass20(listIdentitiesRequest, asyncHandler));
    }

    public Future<ListVerifiedEmailAddressesResult> listVerifiedEmailAddressesAsync(ListVerifiedEmailAddressesRequest listVerifiedEmailAddressesRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00863(listVerifiedEmailAddressesRequest));
    }

    public Future<ListVerifiedEmailAddressesResult> listVerifiedEmailAddressesAsync(ListVerifiedEmailAddressesRequest listVerifiedEmailAddressesRequest, AsyncHandler<ListVerifiedEmailAddressesRequest, ListVerifiedEmailAddressesResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00874(listVerifiedEmailAddressesRequest, asyncHandler));
    }

    public Future<SendEmailResult> sendEmailAsync(SendEmailRequest sendEmailRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass31(sendEmailRequest));
    }

    public Future<SendEmailResult> sendEmailAsync(SendEmailRequest sendEmailRequest, AsyncHandler<SendEmailRequest, SendEmailResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass32(sendEmailRequest, asyncHandler));
    }

    public Future<SendRawEmailResult> sendRawEmailAsync(SendRawEmailRequest sendRawEmailRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass17(sendRawEmailRequest));
    }

    public Future<SendRawEmailResult> sendRawEmailAsync(SendRawEmailRequest sendRawEmailRequest, AsyncHandler<SendRawEmailRequest, SendRawEmailResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass18(sendRawEmailRequest, asyncHandler));
    }

    public Future<SetIdentityDkimEnabledResult> setIdentityDkimEnabledAsync(SetIdentityDkimEnabledRequest setIdentityDkimEnabledRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass23(setIdentityDkimEnabledRequest));
    }

    public Future<SetIdentityDkimEnabledResult> setIdentityDkimEnabledAsync(SetIdentityDkimEnabledRequest setIdentityDkimEnabledRequest, AsyncHandler<SetIdentityDkimEnabledRequest, SetIdentityDkimEnabledResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass24(setIdentityDkimEnabledRequest, asyncHandler));
    }

    public Future<SetIdentityFeedbackForwardingEnabledResult> setIdentityFeedbackForwardingEnabledAsync(SetIdentityFeedbackForwardingEnabledRequest setIdentityFeedbackForwardingEnabledRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass27(setIdentityFeedbackForwardingEnabledRequest));
    }

    public Future<SetIdentityFeedbackForwardingEnabledResult> setIdentityFeedbackForwardingEnabledAsync(SetIdentityFeedbackForwardingEnabledRequest setIdentityFeedbackForwardingEnabledRequest, AsyncHandler<SetIdentityFeedbackForwardingEnabledRequest, SetIdentityFeedbackForwardingEnabledResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass28(setIdentityFeedbackForwardingEnabledRequest, asyncHandler));
    }

    public Future<SetIdentityNotificationTopicResult> setIdentityNotificationTopicAsync(SetIdentityNotificationTopicRequest setIdentityNotificationTopicRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass35(setIdentityNotificationTopicRequest));
    }

    public Future<SetIdentityNotificationTopicResult> setIdentityNotificationTopicAsync(SetIdentityNotificationTopicRequest setIdentityNotificationTopicRequest, AsyncHandler<SetIdentityNotificationTopicRequest, SetIdentityNotificationTopicResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass36(setIdentityNotificationTopicRequest, asyncHandler));
    }

    public void shutdown() {
        super.shutdown();
        this.executorService.shutdownNow();
    }

    public Future<VerifyDomainDkimResult> verifyDomainDkimAsync(VerifyDomainDkimRequest verifyDomainDkimRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass11(verifyDomainDkimRequest));
    }

    public Future<VerifyDomainDkimResult> verifyDomainDkimAsync(VerifyDomainDkimRequest verifyDomainDkimRequest, AsyncHandler<VerifyDomainDkimRequest, VerifyDomainDkimResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass12(verifyDomainDkimRequest, asyncHandler));
    }

    public Future<VerifyDomainIdentityResult> verifyDomainIdentityAsync(VerifyDomainIdentityRequest verifyDomainIdentityRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass29(verifyDomainIdentityRequest));
    }

    public Future<VerifyDomainIdentityResult> verifyDomainIdentityAsync(VerifyDomainIdentityRequest verifyDomainIdentityRequest, AsyncHandler<VerifyDomainIdentityRequest, VerifyDomainIdentityResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass30(verifyDomainIdentityRequest, asyncHandler));
    }

    public Future<Void> verifyEmailAddressAsync(VerifyEmailAddressRequest verifyEmailAddressRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass15(verifyEmailAddressRequest));
    }

    public Future<Void> verifyEmailAddressAsync(VerifyEmailAddressRequest verifyEmailAddressRequest, AsyncHandler<VerifyEmailAddressRequest, Void> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new AnonymousClass16(verifyEmailAddressRequest, asyncHandler));
    }

    public Future<VerifyEmailIdentityResult> verifyEmailIdentityAsync(VerifyEmailIdentityRequest verifyEmailIdentityRequest) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00907(verifyEmailIdentityRequest));
    }

    public Future<VerifyEmailIdentityResult> verifyEmailIdentityAsync(VerifyEmailIdentityRequest verifyEmailIdentityRequest, AsyncHandler<VerifyEmailIdentityRequest, VerifyEmailIdentityResult> asyncHandler) throws AmazonServiceException, AmazonClientException {
        return this.executorService.submit(new C00918(verifyEmailIdentityRequest, asyncHandler));
    }
}
