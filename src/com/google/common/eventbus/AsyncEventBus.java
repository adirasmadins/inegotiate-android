package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

@Beta
public class AsyncEventBus extends EventBus {
    private final ConcurrentLinkedQueue<EventWithHandler> eventsToDispatch;
    private final Executor executor;

    /* renamed from: com.google.common.eventbus.AsyncEventBus.1 */
    class C06531 implements Runnable {
        final /* synthetic */ Object val$event;
        final /* synthetic */ EventHandler val$handler;

        C06531(Object obj, EventHandler eventHandler) {
            this.val$event = obj;
            this.val$handler = eventHandler;
        }

        public void run() {
            super.dispatch(this.val$event, this.val$handler);
        }
    }

    public AsyncEventBus(String identifier, Executor executor) {
        super(identifier);
        this.eventsToDispatch = new ConcurrentLinkedQueue();
        this.executor = executor;
    }

    public AsyncEventBus(Executor executor) {
        this.eventsToDispatch = new ConcurrentLinkedQueue();
        this.executor = executor;
    }

    protected void enqueueEvent(Object event, EventHandler handler) {
        this.eventsToDispatch.offer(new EventWithHandler(event, handler));
    }

    protected void dispatchQueuedEvents() {
        while (true) {
            EventWithHandler eventWithHandler = (EventWithHandler) this.eventsToDispatch.poll();
            if (eventWithHandler != null) {
                dispatch(eventWithHandler.event, eventWithHandler.handler);
            } else {
                return;
            }
        }
    }

    protected void dispatch(Object event, EventHandler handler) {
        this.executor.execute(new C06531(event, handler));
    }
}
