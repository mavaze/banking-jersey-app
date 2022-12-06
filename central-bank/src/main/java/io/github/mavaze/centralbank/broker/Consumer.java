package io.github.mavaze.centralbank.broker;

import io.github.mavaze.centralbank.broker.message.Message;
import io.github.mavaze.commons.domain.Routable;
import lombok.NonNull;

public interface Consumer {
    <T extends Routable> void consume(@NonNull Message<T> message) throws Exception;
}
