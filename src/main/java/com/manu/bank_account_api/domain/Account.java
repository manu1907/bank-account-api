package com.manu.bank_account_api.domain;

import java.util.HashSet;

import static com.manu.bank_account_api.utils.Constant.ELEVEN_DIGIT_MIN;
import static com.manu.bank_account_api.utils.Constant.ELEVEN_DIGIT_MAX;

/**
 * Created on 01/20/2022
 *
 * @author manu
 */
public class Account {
    //region Fields
    private static long nextId;
    private final long id;
    private static final HashSet<Long> DISTINCT_ID_STORE;
    //endregion

    //region Static Initialization Block
    static {
        // ELEVEN_DIGIT_MIN <= nextId <= ELEVEN_DIGIT_MAX
        nextId = ELEVEN_DIGIT_MIN + (long) (Math.random() * (ELEVEN_DIGIT_MAX + 1));
        DISTINCT_ID_STORE = new HashSet<>();
    }
    //endregion

    //region Constructor
    private Account() {
        id = assignDistinctId();
    }
    //endregion

    //region Methods
    public static Account create() { return new Account(); }
    private static long assignDistinctId() {
        if (DISTINCT_ID_STORE.add(nextId))
            return nextId;

        nextId++;
        return assignDistinctId();
    }
    public long getId() { return id; }
    //endregion
}
