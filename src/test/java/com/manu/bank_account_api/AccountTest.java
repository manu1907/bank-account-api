package com.manu.bank_account_api;

import com.manu.bank_account_api.domain.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on 01/20/2022
 *
 * @author manu
 */
class AccountTest {

    @DisplayName("Should Have Distinct ID's")
    @Test
    void givenCreatingAccount_whenGeneratingAccountNumber_thenDistinctElevenNumberOutput() {
        HashSet<Long> idSet = new HashSet<>();
        final long NUMBER_OF_ACCOUNTS = 1_000_000L;
        for (int i = 0; i < NUMBER_OF_ACCOUNTS; i++)
            idSet.add(Account.create().getId());

        assertEquals(
                NUMBER_OF_ACCOUNTS,
                idSet.stream().parallel().count(),
                "Number of accounts should be equal to number of ID's"
        );
    }
}
