package io.github.mavaze.corebank.routing;

import io.github.mavaze.centralbank.broker.message.Message;
import io.github.mavaze.commons.domain.Routable;

public interface Router<T> {

    void route(Routable<T> request) throws Exception;
    void route(Message<? extends Routable<T>> message) throws Exception;
}
