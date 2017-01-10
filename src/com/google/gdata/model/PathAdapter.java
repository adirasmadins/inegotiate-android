package com.google.gdata.model;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.ElementMetadata.MultipleVirtualElement;
import com.google.gdata.model.ElementMetadata.SingleVirtualElement;
import com.google.gdata.model.Metadata.VirtualValue;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.wireformats.ContentCreationException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class PathAdapter {

    static class ElementAdapter implements SingleVirtualElement, MultipleVirtualElement {
        private final Path path;

        ElementAdapter(Path path) {
            this.path = path;
        }

        public Element generateSingle(Element parent, ElementMetadata<?, ?> elementMetadata, ElementMetadata<?, ?> metadata) {
            Preconditions.checkState(this.path.selectsElement(), "An attribute path cannot be used to generate elements.");
            Element element = PathAdapter.getFinalElement(this.path, parent);
            if (element == null) {
                return null;
            }
            try {
                return Element.createElement(mergeKeys(element.getElementKey(), metadata.getKey()), element);
            } catch (ContentCreationException e) {
                throw new IllegalArgumentException("Invalid metadata", e);
            }
        }

        public void parse(Element parent, ElementMetadata<?, ?> elementMetadata, Element element, ElementMetadata<?, ?> elementMetadata2) throws ParseException {
            Preconditions.checkState(this.path.selectsElement(), "An attribute path cannot be used to parse elements.");
            try {
                PathAdapter.createParentElement(this.path, parent).addElement(Element.createElement(this.path.getSelectedElementKey(), element));
            } catch (Throwable e) {
                throw new ParseException(e);
            }
        }

        public Collection<? extends Element> generateMultiple(Element parent, ElementMetadata<?, ?> elementMetadata, ElementMetadata<?, ?> metadata) {
            Preconditions.checkState(this.path.selectsElement(), "An attribute path cannot be used to generate elements.");
            Collection<? extends Element> elements = PathAdapter.getFinalElements(this.path, parent);
            if (elements.isEmpty()) {
                return elements;
            }
            List<Element> result = Lists.newArrayListWithCapacity(elements.size());
            for (Element e : elements) {
                try {
                    result.add(Element.createElement(mergeKeys(e.getElementKey(), metadata.getKey()), e));
                } catch (ContentCreationException ex) {
                    throw new IllegalArgumentException("Invalid metadata", ex);
                }
            }
            return result;
        }

        public void parse(Element parent, ElementMetadata<?, ?> parentMetadata, Collection<Element> elements, ElementMetadata<?, ?> elementMetadata) throws ParseException {
            Preconditions.checkState(this.path.selectsElement(), "An attribute path cannot be used to parse elements.");
            Path bound = this.path.toAbsolute(parentMetadata);
            Collection<Element> parents = PathAdapter.createParentElements(bound, parent, parentMetadata, elements.size());
            ElementKey<?, ?> childKey = bound.getSelectedElementKey();
            ElementMetadata<?, ?> childMetadata = bound.getSelectedElement();
            Iterator<Element> pIter = parents.iterator();
            Iterator<Element> eIter = elements.iterator();
            if (parents.size() > 1) {
                PathAdapter.checkNotMultiple(childMetadata);
                while (pIter.hasNext() && eIter.hasNext()) {
                    ((Element) pIter.next()).addElement((Element) eIter.next());
                }
            } else if (elements.size() <= 1 || childMetadata == null || childMetadata.getCardinality() != Cardinality.SINGLE) {
                parent = (Element) pIter.next();
                while (eIter.hasNext()) {
                    parent.addElement((Element) eIter.next());
                }
            } else {
                throw new IllegalStateException("Metadata for key " + childKey + " represents a single-cardinality element." + " The path must contain at least one multiple-cardinality" + " element in order to parse multiple elements.");
            }
        }

        private static ElementKey<?, ?> mergeKeys(ElementKey<?, ?> sourceKey, ElementKey<?, ?> metadataKey) {
            if (metadataKey.getId().equals(sourceKey.getId())) {
                return sourceKey;
            }
            return ElementKey.of(metadataKey.getId(), sourceKey.getDatatype(), sourceKey.getElementType());
        }
    }

    static class ValueAdapter implements VirtualValue {
        private final Path path;

        ValueAdapter(Path path) {
            this.path = path;
        }

        public Object generate(Element element, ElementMetadata<?, ?> metadata) {
            Path bound = this.path.toAbsolute(metadata);
            element = PathAdapter.getFinalElement(bound, element);
            if (element == null) {
                return null;
            }
            if (bound.selectsAttribute()) {
                return PathAdapter.generateAttributeValue(element, bound.getSelectedElement(), bound.getSelectedAttributeKey(), bound.getSelectedAttribute());
            }
            return PathAdapter.generateTextValue(element, bound.getSelectedElement());
        }

        public void parse(Element element, ElementMetadata<?, ?> metadata, Object value) throws ParseException {
            Path bound = this.path.toAbsolute(metadata);
            element = PathAdapter.createFinalElement(this.path, element);
            if (bound.selectsAttribute()) {
                PathAdapter.parseAttributeValue(element, bound.getSelectedElement(), bound.getSelectedAttributeKey(), bound.getSelectedAttribute(), value);
            } else {
                PathAdapter.parseTextValue(element, bound.getSelectedElement(), value);
            }
        }
    }

    static ElementAdapter elementAdapter(Path path) {
        return new ElementAdapter(path);
    }

    static ValueAdapter valueAdapter(Path path) {
        return new ValueAdapter(path);
    }

    static Element getParentElement(Path path, Element rootElement) {
        Preconditions.checkNotNull(path, "path");
        Preconditions.checkNotNull(rootElement, "rootElement");
        List<MetadataKey<?>> steps = path.getSteps();
        if (steps.isEmpty()) {
            return null;
        }
        Element parent = rootElement;
        for (int i = 0; i < steps.size() - 1; i++) {
            parent = parent.getElement((ElementKey) steps.get(i));
            if (parent == null) {
                return null;
            }
        }
        return parent;
    }

    static Element getFinalElement(Path path, Element rootElement) {
        Element parent = getParentElement(path, rootElement);
        return (path.selectsAttribute() || parent == null) ? parent : parent.getElement(path.getSelectedElementKey());
    }

    static Collection<? extends Element> getFinalElements(Path path, Element rootElement) {
        List<? extends Element> parents = ImmutableList.of(rootElement);
        for (MetadataKey<?> part : path.getSteps()) {
            if (part instanceof AttributeKey) {
                break;
            }
            ElementKey childKey = (ElementKey) part;
            if (parents.size() > 1) {
                List<Element> next = Lists.newArrayListWithCapacity(parents.size());
                for (Element e : parents) {
                    next.add(e.getElement(childKey));
                }
                parents = next;
            } else {
                Element parent = (Element) parents.get(0);
                parents = ((Element) parents.get(0)).getElements(childKey);
            }
            if (parents.isEmpty()) {
                return parents;
            }
        }
        return parents;
    }

    static Element createParentElement(Path path, Element rootElement) throws ParseException {
        Preconditions.checkNotNull(path, "path");
        Preconditions.checkNotNull(rootElement, "rootElement");
        List<MetadataKey<?>> steps = path.getSteps();
        if (steps.isEmpty()) {
            return null;
        }
        Element parent = rootElement;
        for (int i = 0; i < steps.size() - 1; i++) {
            parent = getOrCreateChild(parent, (ElementKey) steps.get(i));
        }
        return parent;
    }

    static Collection<Element> createParentElements(Path path, Element rootElement, ElementMetadata<?, ?> rootMetadata, int elementCount) throws ParseException {
        Preconditions.checkNotNull(path, "path");
        Preconditions.checkNotNull(rootElement, "rootElement");
        List<MetadataKey<?>> steps = path.getSteps();
        if (steps.isEmpty()) {
            return ImmutableList.of();
        }
        Element parent = rootElement;
        Collection<Element> parents = null;
        ElementMetadata<?, ?> parentMetadata = rootMetadata;
        for (int i = 0; i < steps.size() - 1; i++) {
            ElementKey<?, ?> childKey = (ElementKey) steps.get(i);
            ElementMetadata<?, ?> childMetadata = parentMetadata == null ? null : parentMetadata.bindElement(childKey);
            List<Element> children;
            if (parents != null) {
                checkNotMultiple(childMetadata);
                children = Lists.newArrayListWithCapacity(parents.size());
                for (Element p : parents) {
                    children.add(getOrCreateChild(p, childKey));
                }
                parents = children;
                parentMetadata = childMetadata;
            } else if (childMetadata == null || childMetadata.getCardinality() == Cardinality.SINGLE) {
                parent = getOrCreateChild(parent, childKey);
                parentMetadata = childMetadata;
            } else {
                children = Lists.newArrayListWithCapacity(elementCount);
                int j = 0;
                while (j < elementCount) {
                    try {
                        Element child = Element.createElement(childKey);
                        parent.addElement(child);
                        children.add(child);
                        j++;
                    } catch (Throwable e) {
                        throw new ParseException(e);
                    }
                }
                Object parents2 = children;
                parentMetadata = childMetadata;
            }
        }
        return parents == null ? ImmutableList.of(parent) : parents;
    }

    static Element createFinalElement(Path path, Element rootElement) throws ParseException {
        Element parent = createParentElement(path, rootElement);
        if (path.selectsAttribute() || parent == null) {
            return parent;
        }
        ElementKey childKey = path.getSelectedElementKey();
        Element child = parent.getElement(childKey);
        if (child != null) {
            return child;
        }
        try {
            child = Element.createElement(childKey);
            parent.addElement(child);
            return child;
        } catch (Throwable e) {
            throw new ParseException(e);
        }
    }

    private static Element getOrCreateChild(Element parent, ElementKey<?, ?> childKey) throws ParseException {
        Element child = parent.getElement((ElementKey) childKey);
        if (child != null) {
            return child;
        }
        try {
            child = Element.createElement(childKey);
            parent.addElement(child);
            return child;
        } catch (Throwable e) {
            throw new ParseException(e);
        }
    }

    private static void checkNotMultiple(ElementMetadata<?, ?> meta) {
        if (meta != null && meta.getCardinality() != Cardinality.SINGLE) {
            throw new IllegalStateException("Metadata for key " + meta.getKey() + " represents a multiple-cardinality element." + " The path cannot contain more than one multiple-cardinality" + " element.");
        }
    }

    static Object generateAttributeValue(Element element, ElementMetadata<?, ?> metadata, AttributeKey<?> attKey, AttributeMetadata<?> attMeta) {
        if (metadata == null || attMeta == null) {
            return element.getAttributeValue((AttributeKey) attKey);
        }
        return attMeta.generateValue(element, metadata);
    }

    static void parseAttributeValue(Element element, ElementMetadata<?, ?> metadata, AttributeKey<?> attKey, AttributeMetadata<?> attMeta, Object value) throws ParseException {
        if (attMeta == null) {
            element.setAttributeValue((AttributeKey) attKey, value);
        } else {
            attMeta.parseValue(element, metadata, value);
        }
    }

    static Object generateTextValue(Element element, ElementMetadata<?, ?> metadata) {
        if (metadata != null) {
            return metadata.generateValue(element, metadata);
        }
        return element.getTextValue();
    }

    static void parseTextValue(Element element, ElementMetadata<?, ?> metadata, Object value) throws ParseException {
        if (metadata != null) {
            metadata.parseValue(element, metadata, value);
        } else {
            element.setTextValue(value);
        }
    }

    private PathAdapter() {
    }
}
