package com.google.gdata.model.atom;

import com.google.gdata.model.Element;
import com.google.gdata.model.gd.GdAttributes;
import com.google.gdata.util.Namespaces;

class Kinds {
    static String getElementKind(Element source) {
        String term = (String) source.getAttributeValue(GdAttributes.KIND);
        if (term != null) {
            return term;
        }
        for (Category category : source.getElements(Category.KEY)) {
            if (Namespaces.gKind.equals(category.getScheme())) {
                return category.getTerm();
            }
        }
        return null;
    }

    private Kinds() {
    }
}
