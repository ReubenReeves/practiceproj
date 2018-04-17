package com.practice.services;

import com.practice.models.Account;
import com.practice.models.Match;

import java.util.List;

public interface BaseService {

    /**
     * Add all matches for a given account
     * @param accountId
     */
    boolean addMatchesForAccount(int accountId);

    /**
     * get all recent matches for an account
     * @param accountId
     */
    List<Match> getMatchesById(int accountId);

    /**
     * Add an account by account mame
     * @param accountName
     * @return true/false whether the method was successful
     */
    boolean addAccount(String accountName);

    /**
     * Retrieve account by account name
     * @param accountName
     * @return account object
     */
    Account getAccountByName(String accountName);

    /**
     * Retrieve account by account ID
     * @param id
     * @return account object
     */
    Account getAccountById(int id);

    /**
     * Retrieve account by account ID
     * @param id
     * @return account JSON
     */
    String getAccountJsonById(int id);
}
