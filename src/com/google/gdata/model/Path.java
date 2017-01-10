package com.google.gdata.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.gdata.util.common.base.Objects;
import com.google.gdata.util.common.base.Preconditions;
import java.util.List;

public class Path {
    public static final Path ROOT;
    private final ElementMetadata<?, ?> root;
    private final AttributeMetadata<?> selectedAttribute;
    private final ElementMetadata<?, ?> selectedElement;
    private final boolean selectsAttribute;
    private final List<MetadataKey<?>> steps;

    public static class Builder {
        private ElementMetadata<?, ?> root;
        private AttributeMetadata<?> selectedAttribute;
        private ElementMetadata<?, ?> selectedElement;
        private boolean selectsAttribute;
        private List<MetadataKey<?>> steps;

        private Builder() {
            this.steps = Lists.newArrayList();
        }

        Builder fromRoot(ElementMetadata<?, ?> root) {
            ElementMetadata elementMetadata = (ElementMetadata) Preconditions.checkNotNull(root);
            this.root = elementMetadata;
            this.selectedElement = elementMetadata;
            if (this.steps != null) {
                List<MetadataKey<?>> prevSteps = Lists.newArrayList(this.steps);
                this.steps.clear();
                for (MetadataKey<?> step : prevSteps) {
                    addStep(step);
                }
            }
            return this;
        }

        public Builder addStep(MetadataKey<?> step) {
            if (this.selectedElement == null) {
                addToStepList(step);
            } else if (step instanceof ElementKey) {
                if (!addIfElement(step.getId())) {
                    throw new PathException("No child element matching key:" + step);
                }
            } else if (!addIfAttribute(step.getId())) {
                throw new PathException("No child attribute matching key:" + step);
            }
            return this;
        }

        public boolean addIfElement(QName id) {
            ElementKey<?, ?> elemKey;
            if (this.selectedElement != null) {
                elemKey = this.selectedElement.findElement(id);
                if (elemKey == null) {
                    return false;
                }
                this.selectedElement = this.selectedElement.bindElement(elemKey);
            } else {
                elemKey = ElementKey.of(id);
            }
            addToStepList(elemKey);
            return true;
        }

        public boolean addIfAttribute(QName id) {
            AttributeKey<?> attrKey;
            if (this.selectedElement != null) {
                attrKey = this.selectedElement.findAttribute(id);
                if (attrKey == null) {
                    return false;
                }
                this.selectedAttribute = this.selectedElement.bindAttribute(attrKey);
            } else {
                attrKey = AttributeKey.of(id);
            }
            addToStepList(attrKey);
            return true;
        }

        private void addToStepList(MetadataKey<?> step) {
            if (this.selectsAttribute) {
                throw new PathException("Cannot add to an attribute path: " + step.getId());
            }
            if (step instanceof AttributeKey) {
                this.selectsAttribute = true;
            }
            this.steps.add(step);
        }

        public Path build() {
            return new Path();
        }
    }

    static {
        ROOT = builder().build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Path of(MetadataKey<?>... steps) {
        Builder builder = new Builder();
        for (MetadataKey<?> step : steps) {
            builder.addStep(step);
        }
        return builder.build();
    }

    public static Path to(ElementMetadata<?, ?> root, MetadataKey<?>... keys) {
        Builder builder = new Builder().fromRoot(root);
        for (MetadataKey<?> key : keys) {
            builder.addStep(key);
        }
        return builder.build();
    }

    private Path(Builder builder) {
        this.root = builder.root;
        this.steps = ImmutableList.copyOf(builder.steps);
        this.selectsAttribute = builder.selectsAttribute;
        if (this.root == null) {
            this.selectedElement = null;
            this.selectedAttribute = null;
            return;
        }
        this.selectedElement = builder.selectedElement;
        this.selectedAttribute = builder.selectedAttribute;
    }

    public boolean selectsAttribute() {
        return this.selectsAttribute;
    }

    public boolean selectsElement() {
        return !this.selectsAttribute;
    }

    public ElementMetadata<?, ?> getSelectedElement() {
        return this.selectedElement;
    }

    public AttributeMetadata<?> getSelectedAttribute() {
        return this.selectedAttribute;
    }

    public List<MetadataKey<?>> getSteps() {
        return this.steps;
    }

    public boolean isRelative() {
        return this.root == null;
    }

    public AttributeKey<?> getSelectedAttributeKey() {
        Preconditions.checkState(this.selectsAttribute, "Must select an attribute key.");
        return (AttributeKey) this.steps.get(this.steps.size() - 1);
    }

    public ElementKey<?, ?> getSelectedElementKey() {
        boolean z;
        boolean z2 = true;
        if (this.steps.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z, "Must not be an empty path.");
        if (this.selectsAttribute) {
            z2 = false;
        }
        Preconditions.checkState(z2, "Must select an element key.");
        return (ElementKey) this.steps.get(this.steps.size() - 1);
    }

    public ElementKey<?, ?> getParentKey() {
        if (this.steps.size() > 1) {
            return (ElementKey) this.steps.get(this.steps.size() - 2);
        }
        return null;
    }

    public Path toAbsolute(ElementMetadata<?, ?> root) {
        Builder builder = new Builder().fromRoot(root);
        for (MetadataKey<?> step : this.steps) {
            builder.addStep(step);
        }
        return builder.build();
    }

    public String toString() {
        if (this.steps.isEmpty()) {
            return ".";
        }
        StringBuilder builder = new StringBuilder();
        for (MetadataKey<?> step : this.steps) {
            addPathSeparator(builder);
            if (step instanceof AttributeKey) {
                builder.append('@');
            }
            builder.append(step.getId());
        }
        return builder.toString();
    }

    private void addPathSeparator(StringBuilder builder) {
        if (builder.length() != 0) {
            builder.append('/');
        }
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != Path.class) {
            return false;
        }
        Path path = (Path) o;
        if (this.root == path.root && this.steps.equals(path.steps)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.root, this.steps);
    }
}
