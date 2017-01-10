package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

@GwtCompatible
final class BstMutationRule<K, N extends BstNode<K, N>> {
    private final BstBalancePolicy<N> balancePolicy;
    private final BstModifier<K, N> modifier;
    private final BstNodeFactory<N> nodeFactory;

    public static <K, N extends BstNode<K, N>> BstMutationRule<K, N> createRule(BstModifier<K, N> modifier, BstBalancePolicy<N> balancePolicy, BstNodeFactory<N> nodeFactory) {
        return new BstMutationRule(modifier, balancePolicy, nodeFactory);
    }

    private BstMutationRule(BstModifier<K, N> modifier, BstBalancePolicy<N> balancePolicy, BstNodeFactory<N> nodeFactory) {
        this.balancePolicy = (BstBalancePolicy) Preconditions.checkNotNull(balancePolicy);
        this.nodeFactory = (BstNodeFactory) Preconditions.checkNotNull(nodeFactory);
        this.modifier = (BstModifier) Preconditions.checkNotNull(modifier);
    }

    public BstModifier<K, N> getModifier() {
        return this.modifier;
    }

    public BstBalancePolicy<N> getBalancePolicy() {
        return this.balancePolicy;
    }

    public BstNodeFactory<N> getNodeFactory() {
        return this.nodeFactory;
    }
}
