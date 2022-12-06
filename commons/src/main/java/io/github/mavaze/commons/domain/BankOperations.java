package io.github.mavaze.commons.domain;

public interface BankOperations {

    String getBankCode();

    default String getQueueName() {
        return "queue-int-" + getBankCode();
    }

}
