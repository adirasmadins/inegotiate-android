package com.google.gdata.model;

import com.google.gdata.util.ParseException;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.wireformats.ContentCreationException;
import java.util.Collection;

public interface ElementMetadata<D, E extends Element> extends Metadata<D> {

    public enum Cardinality {
        SINGLE,
        MULTIPLE,
        SET
    }

    public interface MultipleVirtualElement {
        Collection<? extends Element> generateMultiple(Element element, ElementMetadata<?, ?> elementMetadata, ElementMetadata<?, ?> elementMetadata2);

        void parse(Element element, ElementMetadata<?, ?> elementMetadata, Collection<Element> collection, ElementMetadata<?, ?> elementMetadata2) throws ParseException;
    }

    public interface SingleVirtualElement {
        Element generateSingle(Element element, ElementMetadata<?, ?> elementMetadata, ElementMetadata<?, ?> elementMetadata2);

        void parse(Element element, ElementMetadata<?, ?> elementMetadata, Element element2, ElementMetadata<?, ?> elementMetadata2) throws ParseException;
    }

    ElementKey<?, ?> adapt(String str);

    ElementMetadata<D, E> bind(MetadataContext metadataContext);

    <K> AttributeMetadata<K> bindAttribute(AttributeKey<K> attributeKey);

    <K, L extends Element> ElementMetadata<K, L> bindElement(ElementKey<K, L> elementKey);

    E createElement() throws ContentCreationException;

    AttributeKey<?> findAttribute(QName qName);

    ElementKey<?, ?> findElement(QName qName);

    Collection<AttributeKey<?>> getAttributes();

    Cardinality getCardinality();

    XmlNamespace getDefaultNamespace();

    Collection<ElementKey<?, ?>> getElements();

    ElementKey<D, E> getKey();

    MultipleVirtualElement getMultipleVirtualElement();

    Object getProperties();

    Collection<XmlNamespace> getReferencedNamespaces();

    SingleVirtualElement getSingleVirtualElement();

    ElementValidator getValidator();

    boolean isContentRequired();

    boolean isDeclared(AttributeKey<?> attributeKey);

    boolean isDeclared(ElementKey<?, ?> elementKey);

    boolean isFlattened();

    boolean isReferenced();

    boolean isSelected(Element element);

    void validate(ValidationContext validationContext, Element element);
}
