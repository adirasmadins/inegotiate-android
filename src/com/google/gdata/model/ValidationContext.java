package com.google.gdata.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.util.ErrorContent;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.common.base.Join;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ValidationContext {
    private Map<Element, List<ErrorContent>> errors;

    public ValidationContext() {
        this.errors = Maps.newLinkedHashMap();
    }

    public Map<Element, List<ErrorContent>> getErrors() {
        return Collections.unmodifiableMap(this.errors);
    }

    public void addError(Element element, String error) {
        addError(element, CoreErrorDomain.ERR.invalidExtension.withInternalReason(error));
    }

    public void addError(Element element, ErrorContent error) {
        List<ErrorContent> list = (List) this.errors.get(element);
        if (list == null) {
            list = Lists.newArrayList();
            this.errors.put(element, list);
        }
        list.add(error);
    }

    public boolean isValid() {
        return this.errors.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry<Element, List<ErrorContent>> error : this.errors.entrySet()) {
            sb.append(((Element) error.getKey()).getElementId());
            sb.append(" { ");
            Iterable errors = Lists.newArrayList();
            for (ErrorContent element : (List) error.getValue()) {
                errors.add(new ParseException(element).toXmlErrorMessage());
            }
            sb.append(Join.join(", ", errors));
            sb.append(" }");
        }
        return sb.toString();
    }
}
