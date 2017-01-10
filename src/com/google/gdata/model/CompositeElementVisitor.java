package com.google.gdata.model;

import com.google.gdata.model.ElementVisitor.StoppedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CompositeElementVisitor implements ElementVisitor {
    private final Map<ElementVisitor, Element> ignoringVisitors;
    private final Map<ElementVisitor, StoppedException> stoppedVisitors;
    private final List<ElementVisitor> visitors;

    public CompositeElementVisitor(ElementVisitor... visitors) {
        this.stoppedVisitors = new HashMap();
        this.ignoringVisitors = new HashMap();
        this.visitors = new ArrayList(visitors.length);
        for (ElementVisitor visitor : visitors) {
            this.visitors.add(visitor);
        }
    }

    public void addVisitor(ElementVisitor visitor) {
        this.visitors.add(visitor);
    }

    public List<ElementVisitor> getVisitors() {
        return this.visitors;
    }

    public StoppedException getStoppedException(ElementVisitor visitor) {
        return (StoppedException) this.stoppedVisitors.get(visitor);
    }

    public boolean visit(Element parent, Element target, ElementMetadata<?, ?> metadata) throws StoppedException {
        boolean newStopped = false;
        for (ElementVisitor visitor : this.visitors) {
            if (!this.ignoringVisitors.containsKey(visitor)) {
                try {
                    if (!visitor.visit(parent, target, metadata)) {
                        this.ignoringVisitors.put(visitor, target);
                    }
                } catch (StoppedException se) {
                    this.stoppedVisitors.put(visitor, se);
                    newStopped = true;
                }
            }
        }
        if (newStopped) {
            this.visitors.removeAll(this.stoppedVisitors.keySet());
            if (this.visitors.isEmpty()) {
                throw new StoppedException("All visitors stopped");
            }
        }
        return this.visitors.size() != this.ignoringVisitors.size();
    }

    public void visitComplete(Element parent, Element target, ElementMetadata<?, ?> metadata) throws StoppedException {
        List<ElementVisitor> resetList = null;
        for (Entry<ElementVisitor, Element> stateEntry : this.ignoringVisitors.entrySet()) {
            if (((Element) stateEntry.getValue()) == target) {
                if (resetList == null) {
                    resetList = new ArrayList();
                }
                resetList.add(stateEntry.getKey());
            }
        }
        if (resetList != null) {
            for (ElementVisitor enabledVisitor : resetList) {
                this.ignoringVisitors.remove(enabledVisitor);
            }
        }
        for (ElementVisitor visitor : this.visitors) {
            if (!this.ignoringVisitors.containsKey(visitor)) {
                visitor.visitComplete(parent, target, metadata);
            }
        }
    }
}
