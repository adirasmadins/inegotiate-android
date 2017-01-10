package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import org.codehaus.jackson.impl.JsonWriteContext;

@GwtCompatible
final class BstRangeOps {

    /* renamed from: com.google.common.collect.BstRangeOps.1 */
    static /* synthetic */ class C04331 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BstSide;

        static {
            $SwitchMap$com$google$common$collect$BstSide = new int[BstSide.values().length];
            try {
                $SwitchMap$com$google$common$collect$BstSide[BstSide.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$common$collect$BstSide[BstSide.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static <K, N extends BstNode<K, N>> long totalInRange(BstAggregate<? super N> aggregate, GeneralRange<K> range, @Nullable N root) {
        Preconditions.checkNotNull(aggregate);
        Preconditions.checkNotNull(range);
        if (root == null || range.isEmpty()) {
            return 0;
        }
        long total = aggregate.treeValue(root);
        if (range.hasLowerBound()) {
            total -= totalBeyondRangeToSide(aggregate, range, BstSide.LEFT, root);
        }
        if (range.hasUpperBound()) {
            return total - totalBeyondRangeToSide(aggregate, range, BstSide.RIGHT, root);
        }
        return total;
    }

    private static <K, N extends BstNode<K, N>> long totalBeyondRangeToSide(BstAggregate<? super N> aggregate, GeneralRange<K> range, BstSide side, @Nullable N root) {
        long accum = 0;
        while (root != null) {
            if (beyond(range, root.getKey(), side)) {
                accum = (accum + ((long) aggregate.entryValue(root))) + aggregate.treeValue(root.childOrNull(side));
                root = root.childOrNull(side.other());
            } else {
                root = root.childOrNull(side);
            }
        }
        return accum;
    }

    @Nullable
    public static <K, N extends BstNode<K, N>> N minusRange(GeneralRange<K> range, BstBalancePolicy<N> balancePolicy, BstNodeFactory<N> nodeFactory, @Nullable N root) {
        N higher;
        N lower;
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(balancePolicy);
        Preconditions.checkNotNull(nodeFactory);
        if (range.hasUpperBound()) {
            higher = subTreeBeyondRangeToSide(range, balancePolicy, nodeFactory, BstSide.RIGHT, root);
        } else {
            higher = null;
        }
        if (range.hasLowerBound()) {
            lower = subTreeBeyondRangeToSide(range, balancePolicy, nodeFactory, BstSide.LEFT, root);
        } else {
            lower = null;
        }
        return balancePolicy.combine(nodeFactory, lower, higher);
    }

    @Nullable
    private static <K, N extends BstNode<K, N>> N subTreeBeyondRangeToSide(GeneralRange<K> range, BstBalancePolicy<N> balancePolicy, BstNodeFactory<N> nodeFactory, BstSide side, @Nullable N root) {
        if (root == null) {
            return null;
        }
        if (!beyond(range, root.getKey(), side)) {
            return subTreeBeyondRangeToSide(range, balancePolicy, nodeFactory, side, root.childOrNull(side));
        }
        N left = root.childOrNull(BstSide.LEFT);
        N right = root.childOrNull(BstSide.RIGHT);
        switch (C04331.$SwitchMap$com$google$common$collect$BstSide[side.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                right = subTreeBeyondRangeToSide(range, balancePolicy, nodeFactory, BstSide.LEFT, right);
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                left = subTreeBeyondRangeToSide(range, balancePolicy, nodeFactory, BstSide.RIGHT, left);
                break;
            default:
                throw new AssertionError();
        }
        return balancePolicy.balance(nodeFactory, root, left, right);
    }

    @Nullable
    public static <K, N extends BstNode<K, N>, P extends BstPath<N, P>> P furthestPath(GeneralRange<K> range, BstSide side, BstPathFactory<N, P> pathFactory, @Nullable N root) {
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(pathFactory);
        Preconditions.checkNotNull(side);
        if (root == null) {
            return null;
        }
        return furthestPath((GeneralRange) range, side, (BstPathFactory) pathFactory, pathFactory.initialPath(root));
    }

    private static <K, N extends BstNode<K, N>, P extends BstPath<N, P>> P furthestPath(GeneralRange<K> range, BstSide side, BstPathFactory<N, P> pathFactory, P currentPath) {
        N tip = currentPath.getTip();
        K tipKey = tip.getKey();
        if (!beyond(range, tipKey, side)) {
            if (tip.hasChild(side)) {
                P alphaPath = furthestPath((GeneralRange) range, side, (BstPathFactory) pathFactory, pathFactory.extension(currentPath, side));
                if (alphaPath != null) {
                    return alphaPath;
                }
            }
            if (beyond(range, tipKey, side.other())) {
                return null;
            }
            return currentPath;
        } else if (tip.hasChild(side.other())) {
            return furthestPath((GeneralRange) range, side, (BstPathFactory) pathFactory, pathFactory.extension(currentPath, side.other()));
        } else {
            return null;
        }
    }

    public static <K> boolean beyond(GeneralRange<K> range, @Nullable K key, BstSide side) {
        Preconditions.checkNotNull(range);
        switch (C04331.$SwitchMap$com$google$common$collect$BstSide[side.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return range.tooLow(key);
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return range.tooHigh(key);
            default:
                throw new AssertionError();
        }
    }

    private BstRangeOps() {
    }
}
