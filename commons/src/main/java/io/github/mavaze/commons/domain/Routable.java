package io.github.mavaze.commons.domain;

public interface Routable<T> {

    T getSender();

    T getReceiver();
}
