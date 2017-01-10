package com.google.protobuf;

public final class RpcUtil {

    /* renamed from: com.google.protobuf.RpcUtil.1 */
    static class C08521 implements RpcCallback<Message> {
        final /* synthetic */ Message val$defaultInstance;
        final /* synthetic */ RpcCallback val$originalCallback;
        final /* synthetic */ Class val$originalClass;

        C08521(Class cls, Message message, RpcCallback rpcCallback) {
            this.val$originalClass = cls;
            this.val$defaultInstance = message;
            this.val$originalCallback = rpcCallback;
        }

        public void run(Message parameter) {
            Type typedParameter;
            try {
                typedParameter = (Message) this.val$originalClass.cast(parameter);
            } catch (ClassCastException e) {
                typedParameter = RpcUtil.copyAsType(this.val$defaultInstance, parameter);
            }
            this.val$originalCallback.run(typedParameter);
        }
    }

    /* renamed from: com.google.protobuf.RpcUtil.2 */
    static class C08532 implements RpcCallback<ParameterType> {
        private boolean alreadyCalled;
        final /* synthetic */ RpcCallback val$originalCallback;

        C08532(RpcCallback rpcCallback) {
            this.val$originalCallback = rpcCallback;
            this.alreadyCalled = false;
        }

        public void run(ParameterType parameter) {
            synchronized (this) {
                if (this.alreadyCalled) {
                    throw new AlreadyCalledException();
                }
                this.alreadyCalled = true;
            }
            this.val$originalCallback.run(parameter);
        }
    }

    public static final class AlreadyCalledException extends RuntimeException {
        private static final long serialVersionUID = 5469741279507848266L;

        public AlreadyCalledException() {
            super("This RpcCallback was already called and cannot be called multiple times.");
        }
    }

    private RpcUtil() {
    }

    public static <Type extends Message> RpcCallback<Type> specializeCallback(RpcCallback<Message> originalCallback) {
        return originalCallback;
    }

    public static <Type extends Message> RpcCallback<Message> generalizeCallback(RpcCallback<Type> originalCallback, Class<Type> originalClass, Type defaultInstance) {
        return new C08521(originalClass, defaultInstance, originalCallback);
    }

    private static <Type extends Message> Type copyAsType(Type typeDefaultInstance, Message source) {
        return typeDefaultInstance.newBuilderForType().mergeFrom(source).build();
    }

    public static <ParameterType> RpcCallback<ParameterType> newOneTimeCallback(RpcCallback<ParameterType> originalCallback) {
        return new C08532(originalCallback);
    }
}
