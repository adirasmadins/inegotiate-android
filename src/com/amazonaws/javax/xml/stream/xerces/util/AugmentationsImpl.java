package com.amazonaws.javax.xml.stream.xerces.util;

import com.amazonaws.javax.xml.stream.xerces.xni.Augmentations;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

public class AugmentationsImpl implements Augmentations {
    private AugmentationsItemsContainer fAugmentationsContainer;

    abstract class AugmentationsItemsContainer {
        public abstract void clear();

        public abstract AugmentationsItemsContainer expand();

        public abstract Object getItem(Object obj);

        public abstract boolean isFull();

        public abstract Enumeration keys();

        public abstract Object putItem(Object obj, Object obj2);

        public abstract Object removeItem(Object obj);

        AugmentationsItemsContainer() {
        }
    }

    class LargeContainer extends AugmentationsItemsContainer {
        final Hashtable fAugmentations;

        LargeContainer() {
            super();
            this.fAugmentations = new Hashtable();
        }

        public Object getItem(Object key) {
            return this.fAugmentations.get(key);
        }

        public Object putItem(Object key, Object item) {
            return this.fAugmentations.put(key, item);
        }

        public Object removeItem(Object key) {
            return this.fAugmentations.remove(key);
        }

        public Enumeration keys() {
            return this.fAugmentations.keys();
        }

        public void clear() {
            this.fAugmentations.clear();
        }

        public boolean isFull() {
            return false;
        }

        public AugmentationsItemsContainer expand() {
            return this;
        }

        public String toString() {
            StringBuffer buff = new StringBuffer();
            buff.append("LargeContainer");
            Enumeration keys = this.fAugmentations.keys();
            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                buff.append("\nkey == ");
                buff.append(key);
                buff.append("; value == ");
                buff.append(this.fAugmentations.get(key));
            }
            return buff.toString();
        }
    }

    class SmallContainer extends AugmentationsItemsContainer {
        static final int SIZE_LIMIT = 10;
        final Object[] fAugmentations;
        int fNumEntries;

        class SmallContainerKeyEnumeration implements Enumeration {
            Object[] enumArray;
            int next;

            SmallContainerKeyEnumeration() {
                this.enumArray = new Object[SmallContainer.this.fNumEntries];
                this.next = 0;
                for (int i = 0; i < SmallContainer.this.fNumEntries; i++) {
                    this.enumArray[i] = SmallContainer.this.fAugmentations[i * 2];
                }
            }

            public boolean hasMoreElements() {
                return this.next < this.enumArray.length;
            }

            public Object nextElement() {
                if (this.next >= this.enumArray.length) {
                    throw new NoSuchElementException();
                }
                Object nextVal = this.enumArray[this.next];
                this.enumArray[this.next] = null;
                this.next++;
                return nextVal;
            }
        }

        SmallContainer() {
            super();
            this.fAugmentations = new Object[20];
            this.fNumEntries = 0;
        }

        public Enumeration keys() {
            return new SmallContainerKeyEnumeration();
        }

        public Object getItem(Object key) {
            for (int i = 0; i < this.fNumEntries * 2; i += 2) {
                if (this.fAugmentations[i].equals(key)) {
                    return this.fAugmentations[i + 1];
                }
            }
            return null;
        }

        public Object putItem(Object key, Object item) {
            for (int i = 0; i < this.fNumEntries * 2; i += 2) {
                if (this.fAugmentations[i].equals(key)) {
                    Object oldValue = this.fAugmentations[i + 1];
                    this.fAugmentations[i + 1] = item;
                    return oldValue;
                }
            }
            this.fAugmentations[this.fNumEntries * 2] = key;
            this.fAugmentations[(this.fNumEntries * 2) + 1] = item;
            this.fNumEntries++;
            return null;
        }

        public Object removeItem(Object key) {
            for (int i = 0; i < this.fNumEntries * 2; i += 2) {
                if (this.fAugmentations[i].equals(key)) {
                    Object oldValue = this.fAugmentations[i + 1];
                    for (int j = i; j < (this.fNumEntries * 2) - 2; j += 2) {
                        this.fAugmentations[j] = this.fAugmentations[j + 2];
                        this.fAugmentations[j + 1] = this.fAugmentations[j + 3];
                    }
                    this.fAugmentations[(this.fNumEntries * 2) - 2] = null;
                    this.fAugmentations[(this.fNumEntries * 2) - 1] = null;
                    this.fNumEntries--;
                    return oldValue;
                }
            }
            return null;
        }

        public void clear() {
            for (int i = 0; i < this.fNumEntries * 2; i += 2) {
                this.fAugmentations[i] = null;
                this.fAugmentations[i + 1] = null;
            }
            this.fNumEntries = 0;
        }

        public boolean isFull() {
            return this.fNumEntries == SIZE_LIMIT;
        }

        public AugmentationsItemsContainer expand() {
            LargeContainer expandedContainer = new LargeContainer();
            for (int i = 0; i < this.fNumEntries * 2; i += 2) {
                expandedContainer.putItem(this.fAugmentations[i], this.fAugmentations[i + 1]);
            }
            return expandedContainer;
        }

        public String toString() {
            StringBuffer buff = new StringBuffer();
            buff.append(new StringBuffer().append("SmallContainer - fNumEntries == ").append(this.fNumEntries).toString());
            for (int i = 0; i < 20; i += 2) {
                buff.append("\nfAugmentations[");
                buff.append(i);
                buff.append("] == ");
                buff.append(this.fAugmentations[i]);
                buff.append("; fAugmentations[");
                buff.append(i + 1);
                buff.append("] == ");
                buff.append(this.fAugmentations[i + 1]);
            }
            return buff.toString();
        }
    }

    public AugmentationsImpl() {
        this.fAugmentationsContainer = new SmallContainer();
    }

    public Object putItem(String key, Object item) {
        Object oldValue = this.fAugmentationsContainer.putItem(key, item);
        if (oldValue == null && this.fAugmentationsContainer.isFull()) {
            this.fAugmentationsContainer = this.fAugmentationsContainer.expand();
        }
        return oldValue;
    }

    public Object getItem(String key) {
        return this.fAugmentationsContainer.getItem(key);
    }

    public Object removeItem(String key) {
        return this.fAugmentationsContainer.removeItem(key);
    }

    public Enumeration keys() {
        return this.fAugmentationsContainer.keys();
    }

    public void removeAllItems() {
        this.fAugmentationsContainer.clear();
    }

    public String toString() {
        return this.fAugmentationsContainer.toString();
    }
}
