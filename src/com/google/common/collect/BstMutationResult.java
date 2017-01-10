package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import org.codehaus.jackson.impl.JsonWriteContext;

@GwtCompatible
final class BstMutationResult<K, N extends BstNode<K, N>> {
    static final /* synthetic */ boolean $assertionsDisabled;
    @Nullable
    private N changedRoot;
    private final BstModificationResult<N> modificationResult;
    @Nullable
    private N originalRoot;
    private final K targetKey;

    /* renamed from: com.google.common.collect.BstMutationResult.1 */
    static /* synthetic */ class C04301 {
        static final /* synthetic */ int[] f434xabb36de9;
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BstSide;

        static {
            f434xabb36de9 = new int[ModificationType.values().length];
            try {
                f434xabb36de9[ModificationType.IDENTITY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f434xabb36de9[ModificationType.REBUILDING_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f434xabb36de9[ModificationType.REBALANCING_CHANGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SwitchMap$com$google$common$collect$BstSide = new int[BstSide.values().length];
            try {
                $SwitchMap$com$google$common$collect$BstSide[BstSide.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$common$collect$BstSide[BstSide.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static {
        $assertionsDisabled = !BstMutationResult.class.desiredAssertionStatus();
    }

    public static <K, N extends BstNode<K, N>> BstMutationResult<K, N> mutationResult(@Nullable K targetKey, @Nullable N originalRoot, @Nullable N changedRoot, BstModificationResult<N> modificationResult) {
        return new BstMutationResult(targetKey, originalRoot, changedRoot, modificationResult);
    }

    private BstMutationResult(@Nullable K targetKey, @Nullable N originalRoot, @Nullable N changedRoot, BstModificationResult<N> modificationResult) {
        this.targetKey = targetKey;
        this.originalRoot = originalRoot;
        this.changedRoot = changedRoot;
        this.modificationResult = (BstModificationResult) Preconditions.checkNotNull(modificationResult);
    }

    public K getTargetKey() {
        return this.targetKey;
    }

    @Nullable
    public N getOriginalRoot() {
        return this.originalRoot;
    }

    @Nullable
    public N getChangedRoot() {
        return this.changedRoot;
    }

    @Nullable
    public N getOriginalTarget() {
        return this.modificationResult.getOriginalTarget();
    }

    @Nullable
    public N getChangedTarget() {
        return this.modificationResult.getChangedTarget();
    }

    ModificationType modificationType() {
        return this.modificationResult.getType();
    }

    public BstMutationResult<K, N> lift(N liftOriginalRoot, BstSide side, BstNodeFactory<N> nodeFactory, BstBalancePolicy<N> balancePolicy) {
        int i = 1;
        if (!$assertionsDisabled) {
            int i2 = (nodeFactory != null ? 1 : 0) & ((liftOriginalRoot != null ? 1 : 0) & (side != null ? 1 : 0));
            if (balancePolicy == null) {
                i = 0;
            }
            if ((i & i2) == 0) {
                throw new AssertionError();
            }
        }
        switch (C04301.f434xabb36de9[modificationType().ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                this.changedRoot = liftOriginalRoot;
                this.originalRoot = liftOriginalRoot;
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                this.originalRoot = liftOriginalRoot;
                N resultLeft = liftOriginalRoot.childOrNull(BstSide.LEFT);
                N resultRight = liftOriginalRoot.childOrNull(BstSide.RIGHT);
                switch (C04301.$SwitchMap$com$google$common$collect$BstSide[side.ordinal()]) {
                    case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                        resultLeft = this.changedRoot;
                        break;
                    case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                        resultRight = this.changedRoot;
                        break;
                    default:
                        throw new AssertionError();
                }
                if (modificationType() != ModificationType.REBUILDING_CHANGE) {
                    this.changedRoot = balancePolicy.balance(nodeFactory, liftOriginalRoot, resultLeft, resultRight);
                    break;
                }
                this.changedRoot = nodeFactory.createNode(liftOriginalRoot, resultLeft, resultRight);
                break;
            default:
                throw new AssertionError();
        }
        return this;
    }
}
