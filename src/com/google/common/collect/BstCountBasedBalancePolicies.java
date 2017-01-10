package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@GwtCompatible
final class BstCountBasedBalancePolicies {
    private static final int SECOND_ROTATE_RATIO = 2;
    private static final int SINGLE_ROTATE_RATIO = 4;

    /* renamed from: com.google.common.collect.BstCountBasedBalancePolicies.1 */
    static class C04251 implements BstBalancePolicy<N> {
        final /* synthetic */ BstAggregate val$countAggregate;

        C04251(BstAggregate bstAggregate) {
            this.val$countAggregate = bstAggregate;
        }

        public N balance(BstNodeFactory<N> nodeFactory, N source, @Nullable N left, @Nullable N right) {
            return ((BstNodeFactory) Preconditions.checkNotNull(nodeFactory)).createNode(source, left, right);
        }

        @Nullable
        public N combine(BstNodeFactory<N> nodeFactory, @Nullable N left, @Nullable N right) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            if (this.val$countAggregate.treeValue(left) > this.val$countAggregate.treeValue(right)) {
                return nodeFactory.createNode(left, left.childOrNull(BstSide.LEFT), combine(nodeFactory, left.childOrNull(BstSide.RIGHT), right));
            }
            return nodeFactory.createNode(right, combine(nodeFactory, left, right.childOrNull(BstSide.LEFT)), right.childOrNull(BstSide.RIGHT));
        }
    }

    /* renamed from: com.google.common.collect.BstCountBasedBalancePolicies.2 */
    static class C04262 implements BstBalancePolicy<N> {
        final /* synthetic */ BstAggregate val$countAggregate;

        C04262(BstAggregate bstAggregate) {
            this.val$countAggregate = bstAggregate;
        }

        public N balance(BstNodeFactory<N> nodeFactory, N source, @Nullable N left, @Nullable N right) {
            long countL = this.val$countAggregate.treeValue(left);
            long countR = this.val$countAggregate.treeValue(right);
            if (countL + countR > 1) {
                if (countR >= 4 * countL) {
                    return rotateL(nodeFactory, source, left, right);
                }
                if (countL >= 4 * countR) {
                    return rotateR(nodeFactory, source, left, right);
                }
            }
            return nodeFactory.createNode(source, left, right);
        }

        private N rotateL(BstNodeFactory<N> nodeFactory, N source, @Nullable N left, N right) {
            Preconditions.checkNotNull(right);
            N rl = right.childOrNull(BstSide.LEFT);
            N rr = right.childOrNull(BstSide.RIGHT);
            if (this.val$countAggregate.treeValue(rl) >= 2 * this.val$countAggregate.treeValue(rr)) {
                right = singleR(nodeFactory, right, rl, rr);
            }
            return singleL(nodeFactory, source, left, right);
        }

        private N rotateR(BstNodeFactory<N> nodeFactory, N source, N left, @Nullable N right) {
            Preconditions.checkNotNull(left);
            N lr = left.childOrNull(BstSide.RIGHT);
            N ll = left.childOrNull(BstSide.LEFT);
            if (this.val$countAggregate.treeValue(lr) >= 2 * this.val$countAggregate.treeValue(ll)) {
                left = singleL(nodeFactory, left, ll, lr);
            }
            return singleR(nodeFactory, source, left, right);
        }

        private N singleL(BstNodeFactory<N> nodeFactory, N source, @Nullable N left, N right) {
            Preconditions.checkNotNull(right);
            return nodeFactory.createNode(right, nodeFactory.createNode(source, left, right.childOrNull(BstSide.LEFT)), right.childOrNull(BstSide.RIGHT));
        }

        private N singleR(BstNodeFactory<N> nodeFactory, N source, N left, @Nullable N right) {
            Preconditions.checkNotNull(left);
            return nodeFactory.createNode(left, left.childOrNull(BstSide.LEFT), nodeFactory.createNode(source, left.childOrNull(BstSide.RIGHT), right));
        }

        @Nullable
        public N combine(BstNodeFactory<N> nodeFactory, @Nullable N left, @Nullable N right) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            N newRootSource;
            if (this.val$countAggregate.treeValue(left) > this.val$countAggregate.treeValue(right)) {
                BstMutationResult<K, N> extractLeftMax = BstOperations.extractMax(left, nodeFactory, this);
                newRootSource = extractLeftMax.getOriginalTarget();
                left = extractLeftMax.getChangedRoot();
            } else {
                BstMutationResult<K, N> extractRightMin = BstOperations.extractMin(right, nodeFactory, this);
                newRootSource = extractRightMin.getOriginalTarget();
                right = extractRightMin.getChangedRoot();
            }
            return nodeFactory.createNode(newRootSource, left, right);
        }
    }

    /* renamed from: com.google.common.collect.BstCountBasedBalancePolicies.3 */
    static class C04273 implements BstBalancePolicy<N> {
        final /* synthetic */ BstAggregate val$countAggregate;
        final /* synthetic */ BstBalancePolicy val$singleBalancePolicy;

        C04273(BstBalancePolicy bstBalancePolicy, BstAggregate bstAggregate) {
            this.val$singleBalancePolicy = bstBalancePolicy;
            this.val$countAggregate = bstAggregate;
        }

        public N balance(BstNodeFactory<N> nodeFactory, N source, @Nullable N left, @Nullable N right) {
            if (left == null) {
                return BstOperations.insertMin(right, source, nodeFactory, this.val$singleBalancePolicy);
            }
            if (right == null) {
                return BstOperations.insertMax(left, source, nodeFactory, this.val$singleBalancePolicy);
            }
            long countL = this.val$countAggregate.treeValue(left);
            long countR = this.val$countAggregate.treeValue(right);
            if (4 * countL <= countR) {
                return this.val$singleBalancePolicy.balance(nodeFactory, right, balance(nodeFactory, source, left, right.childOrNull(BstSide.LEFT)), right.childOrNull(BstSide.RIGHT));
            } else if (4 * countR > countL) {
                return nodeFactory.createNode(source, left, right);
            } else {
                return this.val$singleBalancePolicy.balance(nodeFactory, left, left.childOrNull(BstSide.LEFT), balance(nodeFactory, source, left.childOrNull(BstSide.RIGHT), right));
            }
        }

        @Nullable
        public N combine(BstNodeFactory<N> nodeFactory, @Nullable N left, @Nullable N right) {
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            long countL = this.val$countAggregate.treeValue(left);
            long countR = this.val$countAggregate.treeValue(right);
            if (4 * countL <= countR) {
                return this.val$singleBalancePolicy.balance(nodeFactory, right, combine(nodeFactory, left, right.childOrNull(BstSide.LEFT)), right.childOrNull(BstSide.RIGHT));
            } else if (4 * countR > countL) {
                return this.val$singleBalancePolicy.combine(nodeFactory, left, right);
            } else {
                return this.val$singleBalancePolicy.balance(nodeFactory, left, left.childOrNull(BstSide.LEFT), combine(nodeFactory, left.childOrNull(BstSide.RIGHT), right));
            }
        }
    }

    private BstCountBasedBalancePolicies() {
    }

    public static <N extends BstNode<?, N>> BstBalancePolicy<N> noRebalancePolicy(BstAggregate<N> countAggregate) {
        Preconditions.checkNotNull(countAggregate);
        return new C04251(countAggregate);
    }

    public static <K, N extends BstNode<K, N>> BstBalancePolicy<N> singleRebalancePolicy(BstAggregate<N> countAggregate) {
        Preconditions.checkNotNull(countAggregate);
        return new C04262(countAggregate);
    }

    public static <K, N extends BstNode<K, N>> BstBalancePolicy<N> fullRebalancePolicy(BstAggregate<N> countAggregate) {
        Preconditions.checkNotNull(countAggregate);
        return new C04273(singleRebalancePolicy(countAggregate), countAggregate);
    }
}
