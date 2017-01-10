package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.XMLConstants;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public final class Constants {
    public static final String ALLOW_DTD_EVENTS_AFTER_ENDDTD_FEATURE = "allow-dtd-events-after-endDTD";
    public static final String ALLOW_JAVA_ENCODINGS_FEATURE = "allow-java-encodings";
    public static final String ATTRIBUTE_PSVI = "ATTRIBUTE_PSVI";
    public static final String BUFFER_SIZE_PROPERTY = "input-buffer-size";
    public static final String CONTINUE_AFTER_FATAL_ERROR_FEATURE = "continue-after-fatal-error";
    public static final String CREATE_CDATA_NODES_FEATURE = "create-cdata-nodes";
    public static final String CREATE_ENTITY_REF_NODES_FEATURE = "dom/create-entity-ref-nodes";
    public static final String CURRENT_ELEMENT_NODE_PROPERTY = "dom/current-element-node";
    public static final String DATATYPE_VALIDATOR_FACTORY_PROPERTY = "internal/datatype-validator-factory";
    public static final String DECLARATION_HANDLER_PROPERTY = "declaration-handler";
    public static final String DEFAULT_ATTRIBUTE_VALUES_FEATURE = "validation/default-attribute-values";
    public static final String DEFER_NODE_EXPANSION_FEATURE = "dom/defer-node-expansion";
    public static final String DISALLOW_DOCTYPE_DECL_FEATURE = "disallow-doctype-decl";
    public static final String DOCUMENT_CLASS_NAME_PROPERTY = "dom/document-class-name";
    public static final String DOCUMENT_SCANNER_PROPERTY = "internal/document-scanner";
    public static final String DOM_CANONICAL_FORM = "canonical-form";
    public static final String DOM_CDATA_SECTIONS = "cdata-sections";
    public static final String DOM_CERTIFIED = "certified";
    public static final String DOM_CHARSET_OVERRIDES_XML_ENCODING = "charset-overrides-xml-encoding";
    public static final String DOM_CHECK_CHAR_NORMALIZATION = "check-character-normalization";
    public static final String DOM_COMMENTS = "comments";
    public static final String DOM_DATATYPE_NORMALIZATION = "datatype-normalization";
    public static final String DOM_DISCARD_DEFAULT_CONTENT = "discard-default-content";
    public static final String DOM_ENTITIES = "entities";
    public static final String DOM_ENTITY_RESOLVER = "entity-resolver";
    public static final String DOM_ERROR_HANDLER = "error-handler";
    public static final String DOM_FORMAT_PRETTY_PRINT = "format-pretty-print";
    public static final String DOM_IGNORE_CHAR_DENORMALIZATION = "ignore-unknown-character-denomalizations";
    public static final String DOM_INFOSET = "infoset";
    public static final String DOM_NAMESPACES = "namespaces";
    public static final String DOM_NAMESPACE_DECLARATIONS = "namespace-declarations";
    public static final String DOM_NODE_PROPERTY = "dom-node";
    public static final String DOM_NORMALIZE_CHARACTERS = "normalize-characters";
    public static final String DOM_PSVI = "psvi";
    public static final String DOM_SCHEMA_LOCATION = "schema-location";
    public static final String DOM_SCHEMA_TYPE = "schema-type";
    public static final String DOM_SPLIT_CDATA = "split-cdata-sections";
    public static final String DOM_SUPPORTED_MEDIATYPES_ONLY = "supported-mediatypes-only";
    public static final String DOM_UNKNOWNCHARS = "unknown-characters";
    public static final String DOM_VALIDATE = "validate";
    public static final String DOM_VALIDATE_IF_SCHEMA = "validate-if-schema";
    public static final String DOM_WELLFORMED = "well-formed";
    public static final String DOM_WHITESPACE_IN_ELEMENT_CONTENT = "whitespace-in-element-content";
    public static final String DOM_XMLDECL = "xml-declaration";
    public static final String DTD_PROCESSOR_PROPERTY = "internal/dtd-processor";
    public static final String DTD_SCANNER_PROPERTY = "internal/dtd-scanner";
    public static final String DTD_VALIDATOR_PROPERTY = "internal/validator/dtd";
    public static final String DYNAMIC_VALIDATION_FEATURE = "validation/dynamic";
    public static final String ELEMENT_PSVI = "ELEMENT_PSVI";
    protected static final String ENTITY_MANAGER = "http://apache.org/xml/properties/internal/entity-manager";
    public static final String ENTITY_MANAGER_PROPERTY = "internal/entity-manager";
    public static final String ENTITY_RESOLVER_PROPERTY = "internal/entity-resolver";
    public static final String ERROR_HANDLER_PROPERTY = "internal/error-handler";
    protected static final String ERROR_REPORTER = "http://apache.org/xml/properties/internal/error-reporter";
    public static final String ERROR_REPORTER_PROPERTY = "internal/error-reporter";
    public static final String ESCAPE_CHARACTERS = "escapeCharacters";
    public static final String EXTERNAL_GENERAL_ENTITIES_FEATURE = "external-general-entities";
    public static final String EXTERNAL_PARAMETER_ENTITIES_FEATURE = "external-parameter-entities";
    public static final String IGNORE_EXTERNAL_DTD = "ignore-external-dtd";
    public static final String IMPLEMENTATION_NAME = "implementation-name";
    public static final String INCLUDE_COMMENTS_FEATURE = "include-comments";
    public static final String INCLUDE_IGNORABLE_WHITESPACE = "dom/include-ignorable-whitespace";
    public static final String JAXP_PROPERTY_PREFIX = "http://java.sun.com/xml/jaxp/properties/";
    public static final String LEXICAL_HANDLER_PROPERTY = "lexical-handler";
    public static final String LOAD_AS_INFOSET = "load-as-infoset";
    public static final String LOAD_DTD_GRAMMAR_FEATURE = "nonvalidating/load-dtd-grammar";
    public static final String LOAD_EXTERNAL_DTD_FEATURE = "nonvalidating/load-external-dtd";
    public static final String NAMESPACES_FEATURE = "namespaces";
    public static final String NAMESPACE_BINDER_PROPERTY = "internal/namespace-binder";
    public static final String NAMESPACE_CONTEXT_PROPERTY = "internal/namespace-context";
    public static final String NAMESPACE_PREFIXES_FEATURE = "namespace-prefixes";
    public static final String NOTIFY_BUILTIN_REFS_FEATURE = "scanner/notify-builtin-refs";
    public static final String NOTIFY_CHAR_REFS_FEATURE = "scanner/notify-char-refs";
    public static final String NS_DTD;
    public static final String NS_XMLSCHEMA;
    public static final String OUTPUTSTREAM = "outputstream";
    public static final String REUSE_INSTANCE = "reuse-instance";
    public static final String SAX_FEATURE_PREFIX = "http://xml.org/sax/features/";
    public static final String SAX_PROPERTY_PREFIX = "http://xml.org/sax/properties/";
    public static final String SCHEMA_AUGMENT_PSVI = "validation/schema/augment-psvi";
    public static final String SCHEMA_ELEMENT_DEFAULT = "validation/schema/element-default";
    public static final String SCHEMA_FULL_CHECKING = "validation/schema-full-checking";
    public static final String SCHEMA_LANGUAGE = "schemaLanguage";
    public static final String SCHEMA_LOCATION = "schema/external-schemaLocation";
    public static final String SCHEMA_NONS_LOCATION = "schema/external-noNamespaceSchemaLocation";
    public static final String SCHEMA_NORMALIZED_VALUE = "validation/schema/normalized-value";
    public static final String SCHEMA_SOURCE = "schemaSource";
    public static final String SCHEMA_VALIDATION_FEATURE = "validation/schema";
    public static final String SCHEMA_VALIDATOR_PROPERTY = "internal/validator/schema";
    public static final String SECURITY_MANAGER_PROPERTY = "security-manager";
    public static final String STANDARD_URI_CONFORMANT_FEATURE = "standard-uri-conformant";
    public static final String STAX_ENTITY_RESOLVER_PROPERTY = "internal/stax-entity-resolver";
    public static final String STAX_PROPERTIES = "stax-properties";
    public static final String STAX_REPORT_CDATA_EVENT = "report-cdata-event";
    public static final String STRING_INTERNING_FEATURE = "string-interning";
    protected static final String SYMBOL_TABLE = "http://apache.org/xml/properties/internal/symbol-table";
    public static final String SYMBOL_TABLE_PROPERTY = "internal/symbol-table";
    public static final String VALIDATE_CONTENT_MODELS_FEATURE = "validation/validate-content-models";
    public static final String VALIDATE_DATATYPES_FEATURE = "validation/validate-datatypes";
    public static final String VALIDATION_FEATURE = "validation";
    public static final String VALIDATION_MANAGER_PROPERTY = "internal/validation-manager";
    public static final String VALIDATOR_PROPERTY = "internal/validator";
    public static final String WARN_ON_DUPLICATE_ATTDEF_FEATURE = "validation/warn-on-duplicate-attdef";
    public static final String WARN_ON_DUPLICATE_ENTITYDEF_FEATURE = "warn-on-duplicate-entitydef";
    public static final String WARN_ON_UNDECLARED_ELEMDEF_FEATURE = "validation/warn-on-undeclared-elemdef";
    public static final String XERCES_FEATURE_PREFIX = "http://apache.org/xml/features/";
    public static final String XERCES_PROPERTY_PREFIX = "http://apache.org/xml/properties/";
    public static final String XINCLUDE_HANDLER_PROPERTY = "internal/xinclude-handler";
    public static final String XMLGRAMMAR_POOL_PROPERTY = "internal/grammar-pool";
    public static final String XML_STRING_PROPERTY = "xml-string";
    public static final short XML_VERSION_1_0 = (short) 1;
    public static final short XML_VERSION_1_1 = (short) 2;
    public static final String ZEPHYR_PROPERTY_PREFIX = "http://java.sun.com/xml/stream/properties/";
    private static final Enumeration fgEmptyEnumeration;
    private static final String[] fgSAXFeatures;
    private static final String[] fgSAXProperties;
    private static final String[] fgXercesFeatures;
    private static final String[] fgXercesProperties;
    private static final String[] zephyrFeatures;
    private static final String[] zephyrProperties;

    static class ArrayEnumeration implements Enumeration {
        private Object[] array;
        private int index;

        public ArrayEnumeration(Object[] array) {
            this.array = array;
        }

        public boolean hasMoreElements() {
            return this.index < this.array.length;
        }

        public Object nextElement() {
            if (this.index < this.array.length) {
                Object[] objArr = this.array;
                int i = this.index;
                this.index = i + 1;
                return objArr[i];
            }
            throw new NoSuchElementException();
        }
    }

    static {
        NS_XMLSCHEMA = XMLConstants.W3C_XML_SCHEMA_NS_URI.intern();
        NS_DTD = XMLConstants.XML_DTD_NS_URI.intern();
        fgSAXFeatures = new String[]{NAMESPACES_FEATURE, NAMESPACE_PREFIXES_FEATURE, STRING_INTERNING_FEATURE, VALIDATION_FEATURE, EXTERNAL_GENERAL_ENTITIES_FEATURE, EXTERNAL_PARAMETER_ENTITIES_FEATURE};
        fgSAXProperties = new String[]{DECLARATION_HANDLER_PROPERTY, LEXICAL_HANDLER_PROPERTY, DOM_NODE_PROPERTY, XML_STRING_PROPERTY};
        fgXercesFeatures = new String[]{SCHEMA_VALIDATION_FEATURE, SCHEMA_FULL_CHECKING, DYNAMIC_VALIDATION_FEATURE, WARN_ON_DUPLICATE_ATTDEF_FEATURE, WARN_ON_UNDECLARED_ELEMDEF_FEATURE, ALLOW_JAVA_ENCODINGS_FEATURE, CONTINUE_AFTER_FATAL_ERROR_FEATURE, LOAD_DTD_GRAMMAR_FEATURE, LOAD_EXTERNAL_DTD_FEATURE, CREATE_ENTITY_REF_NODES_FEATURE, INCLUDE_IGNORABLE_WHITESPACE, DEFAULT_ATTRIBUTE_VALUES_FEATURE, VALIDATE_CONTENT_MODELS_FEATURE, VALIDATE_DATATYPES_FEATURE, NOTIFY_CHAR_REFS_FEATURE};
        fgXercesProperties = new String[]{CURRENT_ELEMENT_NODE_PROPERTY, DOCUMENT_CLASS_NAME_PROPERTY, SYMBOL_TABLE_PROPERTY, ERROR_HANDLER_PROPERTY, ERROR_REPORTER_PROPERTY, ENTITY_MANAGER_PROPERTY, ENTITY_RESOLVER_PROPERTY, XMLGRAMMAR_POOL_PROPERTY, DATATYPE_VALIDATOR_FACTORY_PROPERTY, DOCUMENT_SCANNER_PROPERTY, DTD_SCANNER_PROPERTY, VALIDATOR_PROPERTY, SCHEMA_LOCATION, SCHEMA_NONS_LOCATION, VALIDATION_MANAGER_PROPERTY};
        zephyrFeatures = new String[]{"http://apache.org/xml/features/namespaces", "http://apache.org/xml/features/validation/warn-on-duplicate-attdef", "http://apache.org/xml/features/validation/warn-on-undeclared-elemdef", "http://apache.org/xml/features/allow-java-encodings"};
        zephyrProperties = new String[]{SYMBOL_TABLE, ERROR_REPORTER, "http://apache.org/xml/properties/internal/error-handler", "http://apache.org/xml/properties/internal/entity-resolver", "http://apache.org/xml/properties/internal/dtd-scanner"};
        fgEmptyEnumeration = new ArrayEnumeration(new Object[0]);
    }

    private Constants() {
    }

    public static Enumeration getZephyrFeatures() {
        return new ArrayEnumeration(zephyrFeatures);
    }

    public static Enumeration getZephyrProperties() {
        return new ArrayEnumeration(zephyrProperties);
    }

    public static Enumeration getSAXFeatures() {
        return fgSAXFeatures.length > 0 ? new ArrayEnumeration(fgSAXFeatures) : fgEmptyEnumeration;
    }

    public static Enumeration getSAXProperties() {
        return fgSAXProperties.length > 0 ? new ArrayEnumeration(fgSAXProperties) : fgEmptyEnumeration;
    }

    public static Enumeration getXercesFeatures() {
        return fgXercesFeatures.length > 0 ? new ArrayEnumeration(fgXercesFeatures) : fgEmptyEnumeration;
    }

    public static Enumeration getXercesProperties() {
        return fgXercesProperties.length > 0 ? new ArrayEnumeration(fgXercesProperties) : fgEmptyEnumeration;
    }

    public static void main(String[] argv) {
        print("SAX features:", SAX_FEATURE_PREFIX, fgSAXFeatures);
        print("SAX properties:", SAX_PROPERTY_PREFIX, fgSAXProperties);
        print("Xerces features:", XERCES_FEATURE_PREFIX, fgXercesFeatures);
        print("Xerces properties:", XERCES_PROPERTY_PREFIX, fgXercesProperties);
    }

    private static void print(String header, String prefix, Object[] array) {
        System.out.print(header);
        if (array.length > 0) {
            System.out.println();
            for (Object println : array) {
                System.out.print("  ");
                System.out.print(prefix);
                System.out.println(println);
            }
            return;
        }
        System.out.println(" none.");
    }
}
