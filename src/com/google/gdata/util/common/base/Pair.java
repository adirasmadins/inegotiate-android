package com.google.gdata.util.common.base;

import java.io.Serializable;

public class Pair<A, B> implements Serializable, Cloneable {
    private static final long serialVersionUID = 747826592375603043L;
    public final A first;
    public final B second;

    public static <A, B> Pair<A, B> of(A first, B second) {
        return new Pair(first, second);
    }

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return this.first;
    }

    public B getSecond() {
        return this.second;
    }

    public Pair<A, B> clone() {
        try {
            return (Pair) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object object) {
        if (!(object instanceof Pair)) {
            return false;
        }
        Pair<?, ?> other = (Pair) object;
        if (eq(this.first, other.first) && eq(this.second, other.second)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (hash(this.first, 0) - 559038737) ^ hash(this.second, 0);
    }

    public String toString() {
        return String.format("(%s, %s)", new Object[]{this.first, this.second});
    }

    private static boolean eq(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    private static int hash(Object object, int nullHash) {
        return object == null ? nullHash : object.hashCode();
    }
}
