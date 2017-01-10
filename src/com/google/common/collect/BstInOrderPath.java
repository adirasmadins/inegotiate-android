package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;
import org.codehaus.jackson.impl.JsonWriteContext;

@GwtCompatible
final class BstInOrderPath<N extends BstNode<?, N>> extends BstPath<N, BstInOrderPath<N>> {
    static final /* synthetic */ boolean $assertionsDisabled;
    private transient Optional<BstInOrderPath<N>> nextInOrder;
    private transient Optional<BstInOrderPath<N>> prevInOrder;
    private final BstSide sideExtension;

    /* renamed from: com.google.common.collect.BstInOrderPath.1 */
    static class C04281 implements BstPathFactory<N, BstInOrderPath<N>> {
        C04281() {
        }

        public BstInOrderPath<N> extension(BstInOrderPath<N> path, BstSide side) {
            return BstInOrderPath.extension(path, side);
        }

        public BstInOrderPath<N> initialPath(N root) {
            return new BstInOrderPath(null, null, null);
        }
    }

    /* renamed from: com.google.common.collect.BstInOrderPath.2 */
    static /* synthetic */ class C04292 {
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

    static {
        $assertionsDisabled = !BstInOrderPath.class.desiredAssertionStatus();
    }

    public static <N extends BstNode<?, N>> BstPathFactory<N, BstInOrderPath<N>> inOrderFactory() {
        return new C04281();
    }

    private static <N extends BstNode<?, N>> BstInOrderPath<N> extension(BstInOrderPath<N> path, BstSide side) {
        Preconditions.checkNotNull(path);
        return new BstInOrderPath(path.getTip().getChild(side), side, path);
    }

    private BstInOrderPath(N tip, @Nullable BstSide sideExtension, @Nullable BstInOrderPath<N> tail) {
        Object obj = 1;
        super(tip, tail);
        this.sideExtension = sideExtension;
        if (!$assertionsDisabled) {
            Object obj2 = sideExtension == null ? 1 : null;
            if (tail != null) {
                obj = null;
            }
            if (obj2 != obj) {
                throw new AssertionError();
            }
        }
    }

    private Optional<BstInOrderPath<N>> computeNextInOrder(BstSide side) {
        if (getTip().hasChild(side)) {
            BstInOrderPath<N> path = extension(this, side);
            BstSide otherSide = side.other();
            while (path.getTip().hasChild(otherSide)) {
                path = extension(path, otherSide);
            }
            return Optional.of(path);
        }
        BstInOrderPath<N> current = this;
        while (current.sideExtension == side) {
            current = (BstInOrderPath) current.getPrefix();
        }
        return Optional.fromNullable((BstInOrderPath) current.prefixOrNull());
    }

    private Optional<BstInOrderPath<N>> nextInOrder(BstSide side) {
        Optional<BstInOrderPath<N>> result;
        Optional<BstInOrderPath<N>> computeNextInOrder;
        switch (C04292.$SwitchMap$com$google$common$collect$BstSide[side.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                result = this.prevInOrder;
                if (result != null) {
                    return result;
                }
                computeNextInOrder = computeNextInOrder(side);
                this.prevInOrder = computeNextInOrder;
                return computeNextInOrder;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                result = this.nextInOrder;
                if (result != null) {
                    return result;
                }
                computeNextInOrder = computeNextInOrder(side);
                this.nextInOrder = computeNextInOrder;
                return computeNextInOrder;
            default:
                throw new AssertionError();
        }
    }

    public boolean hasNext(BstSide side) {
        return nextInOrder(side).isPresent();
    }

    public BstInOrderPath<N> next(BstSide side) {
        if (hasNext(side)) {
            return (BstInOrderPath) nextInOrder(side).get();
        }
        throw new NoSuchElementException();
    }

    public BstSide getSideOfExtension() {
        return this.sideExtension;
    }
}
