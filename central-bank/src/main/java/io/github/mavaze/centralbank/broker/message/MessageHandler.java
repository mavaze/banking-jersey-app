package io.github.mavaze.centralbank.broker.message;

import io.github.mavaze.centralbank.broker.Acknowledge;
import io.github.mavaze.commons.domain.Identifiable;
import io.github.mavaze.commons.domain.Routable;

import java.util.Optional;

public interface MessageHandler<T extends Routable & Identifiable> {

    Optional<Acknowledge> onMessage(Message<T> message);

    void onAcknowledge(Acknowledge<T> acknowledge) throws Exception;
}
