package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible
@Beta
public final class Equivalences {

    private static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE;
        private static final long serialVersionUID = 1;

        private Equals() {
        }

        static {
            INSTANCE = new Equals();
        }

        protected boolean doEquivalent(Object a, Object b) {
            return a.equals(b);
        }

        public int doHash(Object o) {
            return o.hashCode();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE;
        private static final long serialVersionUID = 1;

        private Identity() {
        }

        static {
            INSTANCE = new Identity();
        }

        protected boolean doEquivalent(Object a, Object b) {
            return false;
        }

        protected int doHash(Object o) {
            return System.identityHashCode(o);
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private Equivalences() {
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }
}
