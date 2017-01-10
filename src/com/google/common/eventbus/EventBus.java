package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public class EventBus {
    private final ThreadLocal<ConcurrentLinkedQueue<EventWithHandler>> eventsToDispatch;
    private final HandlerFindingStrategy finder;
    private LoadingCache<Class<?>, Set<Class<?>>> flattenHierarchyCache;
    private final SetMultimap<Class<?>, EventHandler> handlersByType;
    private final ThreadLocal<Boolean> isDispatching;
    private final Logger logger;

    /* renamed from: com.google.common.eventbus.EventBus.1 */
    class C06541 implements Supplier<Set<EventHandler>> {
        C06541() {
        }

        public Set<EventHandler> get() {
            return new CopyOnWriteArraySet();
        }
    }

    /* renamed from: com.google.common.eventbus.EventBus.2 */
    class C06552 extends ThreadLocal<ConcurrentLinkedQueue<EventWithHandler>> {
        C06552() {
        }

        protected ConcurrentLinkedQueue<EventWithHandler> initialValue() {
            return new ConcurrentLinkedQueue();
        }
    }

    /* renamed from: com.google.common.eventbus.EventBus.3 */
    class C06563 extends ThreadLocal<Boolean> {
        C06563() {
        }

        protected Boolean initialValue() {
            return Boolean.valueOf(false);
        }
    }

    /* renamed from: com.google.common.eventbus.EventBus.4 */
    class C06574 extends CacheLoader<Class<?>, Set<Class<?>>> {
        C06574() {
        }

        public Set<Class<?>> load(Class<?> concreteClass) throws Exception {
            List<Class<?>> parents = Lists.newLinkedList();
            Set<Class<?>> classes = Sets.newHashSet();
            parents.add(concreteClass);
            while (!parents.isEmpty()) {
                Class<?> clazz = (Class) parents.remove(0);
                classes.add(clazz);
                Class<?> parent = clazz.getSuperclass();
                if (parent != null) {
                    parents.add(parent);
                }
                for (Class<?> iface : clazz.getInterfaces()) {
                    parents.add(iface);
                }
            }
            return classes;
        }
    }

    static class EventWithHandler {
        final Object event;
        final EventHandler handler;

        public EventWithHandler(Object event, EventHandler handler) {
            this.event = event;
            this.handler = handler;
        }
    }

    public EventBus() {
        this("default");
    }

    public EventBus(String identifier) {
        this.handlersByType = Multimaps.newSetMultimap(new ConcurrentHashMap(), new C06541());
        this.finder = new AnnotatedHandlerFinder();
        this.eventsToDispatch = new C06552();
        this.isDispatching = new C06563();
        this.flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new C06574());
        this.logger = Logger.getLogger(EventBus.class.getName() + "." + identifier);
    }

    public void register(Object object) {
        this.handlersByType.putAll(this.finder.findAllHandlers(object));
    }

    public void unregister(Object object) {
        for (Entry<Class<?>, Collection<EventHandler>> entry : this.finder.findAllHandlers(object).asMap().entrySet()) {
            Set<EventHandler> currentHandlers = getHandlersForEventType((Class) entry.getKey());
            Collection<EventHandler> eventMethodsInListener = (Collection) entry.getValue();
            if (currentHandlers == null || !currentHandlers.containsAll((Collection) entry.getValue())) {
                throw new IllegalArgumentException("missing event handler for an annotated method. Is " + object + " registered?");
            }
            currentHandlers.removeAll(eventMethodsInListener);
        }
    }

    public void post(Object event) {
        boolean dispatched = false;
        for (Class<?> eventType : flattenHierarchy(event.getClass())) {
            Set<EventHandler> wrappers = getHandlersForEventType(eventType);
            if (!(wrappers == null || wrappers.isEmpty())) {
                dispatched = true;
                for (EventHandler wrapper : wrappers) {
                    enqueueEvent(event, wrapper);
                }
            }
        }
        if (!(dispatched || (event instanceof DeadEvent))) {
            post(new DeadEvent(this, event));
        }
        dispatchQueuedEvents();
    }

    protected void enqueueEvent(Object event, EventHandler handler) {
        ((ConcurrentLinkedQueue) this.eventsToDispatch.get()).offer(new EventWithHandler(event, handler));
    }

    protected void dispatchQueuedEvents() {
        if (!((Boolean) this.isDispatching.get()).booleanValue()) {
            this.isDispatching.set(Boolean.valueOf(true));
            while (true) {
                EventWithHandler eventWithHandler = (EventWithHandler) ((ConcurrentLinkedQueue) this.eventsToDispatch.get()).poll();
                if (eventWithHandler == null) {
                    break;
                }
                try {
                    dispatch(eventWithHandler.event, eventWithHandler.handler);
                } finally {
                    this.isDispatching.set(Boolean.valueOf(false));
                }
            }
        }
    }

    protected void dispatch(Object event, EventHandler wrapper) {
        try {
            wrapper.handleEvent(event);
        } catch (InvocationTargetException e) {
            this.logger.log(Level.SEVERE, "Could not dispatch event: " + event + " to handler " + wrapper, e);
        }
    }

    Set<EventHandler> getHandlersForEventType(Class<?> type) {
        return this.handlersByType.get(type);
    }

    protected Set<EventHandler> newHandlerSet() {
        return new CopyOnWriteArraySet();
    }

    @VisibleForTesting
    Set<Class<?>> flattenHierarchy(Class<?> concreteClass) {
        try {
            return (Set) this.flattenHierarchyCache.get(concreteClass);
        } catch (ExecutionException e) {
            throw Throwables.propagate(e.getCause());
        }
    }
}
