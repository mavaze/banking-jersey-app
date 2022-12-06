package io.github.mavaze.corebank.eventing;

public interface EventSubscriber {

    boolean subscribedFor(BankingEvent event);

    void submit(BankingEvent event);
}
