package com.practice.dao;

import com.practice.models.Account;
import com.practice.models.Match;

import java.util.List;

public interface BaseDAO {

    /**
     * Add matches for an account
     * @param matches
     */
    void addMatchHistory(List<Match> matches);

    /**
     * Add singular Match
     * @param match
     */
    void addMatch(Match match);

    /**
     * get all recent matches for an account
     * @param id
     */
    List<Match> getMatchesById(int id);

    /**
     * Add singular account
     * @param account
     */
    void addAccount(Account account);

    /**
     * Retrieve account by name
     * @param accountName
     * @return Account
     */
    Account getAccountByName(String accountName);

    /**
     * Retrieve account by account Id
     * @param accountId
     * @return Account
     */
    Account getAccountById(int accountId);
}
