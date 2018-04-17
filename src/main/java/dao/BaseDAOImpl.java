package com.practice.dao;

import com.practice.models.Account;
import com.practice.models.Match;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseDAOImpl implements BaseDAO {

    static Logger log = Logger.getLogger(BaseDAOImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    public void addMatchHistory(List<Match> matches) {
        if (log.isDebugEnabled() && matches != null) {
            log.debug("addMatchHistory" + matches.toString());
        }
        Session session = sessionFactory.getCurrentSession();

        for (Match match : matches) {
            session.saveOrUpdate(match);
        }
    }

    public void addMatch(Match match) {
        if (log.isDebugEnabled() && match != null) {
            log.debug("addMatch" + match.toString());
        }
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(match);
    }

    public List<Match> getMatchesById(int accountId) {
        if (log.isDebugEnabled()) {
            log.debug("getMatchesById" + accountId);
        }
        Session session = sessionFactory.getCurrentSession();
        String queryString =
                    "SELECT a" + " " +
                    "FROM " + Match.class.getName() + " a " + " " +
                    "WHERE " + Match.ACCOUNT_ID_COLUMN + " = " + ":accountId";
        Query<Match> query = session.createQuery(queryString);
        query.setParameter("accountId", accountId);
        List<Match> matchResults = query.getResultList();
        return matchResults.isEmpty()? null : matchResults;
    }

    public void addAccount(Account account) {
        if (log.isDebugEnabled() && account != null) {
            log.debug("addAccount" + account.toString());
        }
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(account);
    }

    public Account getAccountByName(String accountName) {
        if (log.isDebugEnabled()) {
            log.debug("getAccount" + accountName);
        }
        if (StringUtils.isNotEmpty(accountName)) {
            Session session = sessionFactory.getCurrentSession();
            String queryString =
                    "SELECT a " +
                    "FROM " + Account.class.getName() + " a " +
                    "WHERE " + Account.NAME_COLUMN + " = " + ":accountName";

            Query<Account> query = session.createQuery(queryString);
            query.setParameter("accountName", accountName);
            List<Account> accountsResult = query.getResultList();
            return accountsResult.isEmpty()? null : accountsResult.get(0);
        }
        return null;
    }

    public Account getAccountById(int accountId) {
        if (log.isDebugEnabled()) {
            log.debug("getAccountById" + accountId);
        }
        Session session = sessionFactory.getCurrentSession();
        return session.find(Account.class, accountId);
    }
}
