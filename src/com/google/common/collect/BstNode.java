package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import javax.annotation.Nullable;
import org.codehaus.jackson.impl.JsonWriteContext;

@GwtCompatible
class BstNode<K, N extends BstNode<K, N>> {
    private final K key;
    @Nullable
    private final N left;
    @Nullable
    private final N right;

    /* renamed from: com.google.common.collect.BstNode.1 */
    static /* synthetic */ class C04311 {
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

    BstNode(@Nullable K key, @Nullable N left, @Nullable N right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    @Nullable
    public final K getKey() {
        return this.key;
    }

    @Nullable
    public final N childOrNull(BstSide side) {
        switch (C04311.$SwitchMap$com$google$common$collect$BstSide[side.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return this.left;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return this.right;
            default:
                throw new AssertionError();
        }
    }

    public final boolean hasChild(BstSide side) {
        return childOrNull(side) != null;
    }

    public final N getChild(BstSide side) {
        N child = childOrNull(side);
        Preconditions.checkState(child != null);
        return child;
    }

    protected final boolean orderingInvariantHolds(Comparator<? super K> comparator) {
        int i = 1;
        Preconditions.checkNotNull(comparator);
        boolean result = true;
        if (hasChild(BstSide.LEFT)) {
            result = true & (comparator.compare(getChild(BstSide.LEFT).getKey(), this.key) < 0 ? 1 : 0);
        }
        if (!hasChild(BstSide.RIGHT)) {
            return result;
        }
        if (comparator.compare(getChild(BstSide.RIGHT).getKey(), this.key) <= 0) {
            i = 0;
        }
        return result & i;
    }
}
