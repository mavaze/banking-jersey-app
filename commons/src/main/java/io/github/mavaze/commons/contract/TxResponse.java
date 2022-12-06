package io.github.mavaze.commons.contract;

import io.github.mavaze.commons.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.NavigableSet;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TxResponse {

    private double balance;

    private NavigableSet<Transaction> transactions = Collections.emptyNavigableSet();
}
