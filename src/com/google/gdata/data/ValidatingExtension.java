package com.google.gdata.data;

import com.google.gdata.util.ParseException;

public interface ValidatingExtension extends Extension {
    void validate(ExtensionPoint extensionPoint) throws ParseException;
}
