package com.google.gdata.model;

import com.google.gdata.model.ElementMetadata.MultipleVirtualElement;
import com.google.gdata.model.ElementMetadata.SingleVirtualElement;

class VirtualElementHolder {
    private final MultipleVirtualElement multiple;
    private final SingleVirtualElement single;

    static VirtualElementHolder of(SingleVirtualElement single) {
        if (single == null) {
            return null;
        }
        return new VirtualElementHolder(single, null);
    }

    static VirtualElementHolder of(MultipleVirtualElement multiple) {
        if (multiple == null) {
            return null;
        }
        return new VirtualElementHolder(null, multiple);
    }

    static VirtualElementHolder of(Path path) {
        if (path == null) {
            return null;
        }
        ElementAdapter adapter = PathAdapter.elementAdapter(path);
        return new VirtualElementHolder(adapter, adapter);
    }

    private VirtualElementHolder(SingleVirtualElement single, MultipleVirtualElement multiple) {
        this.single = single;
        this.multiple = multiple;
    }

    SingleVirtualElement getSingleVirtualElement() {
        return this.single;
    }

    MultipleVirtualElement getMultipleVirtualElement() {
        return this.multiple;
    }
}
