package com.practice.services;

import com.practice.dao.BaseDAO;
import com.practice.dao.BaseDAOImpl;
import com.practice.jsonmodels.MatchesHistoryJson;
import com.practice.models.Account;
import com.practice.models.Match;
import com.practice.utils.JsonParser;
import com.practice.utils.ObjectConverter;
import com.practice.utils.WebConnector;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseServiceImpl implements BaseService {
    static Logger log = Logger.getLogger(BaseDAOImpl.class.getName());

    @Autowired
    private JsonParser jsonParser;
    @Autowired
    private BaseDAO baseDAO;
    @Autowired
    private WebConnector webConnector;
    @Autowired
    private ObjectConverter objectConverter;


    public boolean addMatchesForAccount(int accountId) {

        if (log.isDebugEnabled()) {
            log.debug("getMatchesForAccount " + accountId);
        }
        String matchesJson = webConnector.getMatches(accountId);
        if (matchesJson != null && StringUtils.isNotEmpty(matchesJson)) {
            MatchesHistoryJson matches = jsonParser.parseMatchHistory(matchesJson);
            List<Match> matchesList =  objectConverter.getMatchListFromJson(matches);

            for (Match match : matchesList) {
                match.setAccountID(accountId);
            }
            baseDAO.addMatchHistory(matchesList);
            return true;
        }
        return false;
    }

    public List<Match> getMatchesById(int accountId) {
        return baseDAO.getMatchesById(accountId);
    }

    public boolean addAccount(String accountName) {

        if (log.isDebugEnabled()) {
            log.debug("addAccount " + accountName);
        }
        String accountJson = webConnector.getAccount(accountName);
        if (accountJson != null && StringUtils.isNotEmpty(accountJson)) {
            Account account = objectConverter.getAccountFromJson(jsonParser.parseAccount(accountJson));
            if (StringUtils.isNotEmpty(account.getName()) && account.getId() != 0) {
                baseDAO.addAccount(account);
                return true;
            }
        }
        return false;
    }


    public Account getAccountByName(String accountName) {
        return baseDAO.getAccountByName(accountName);
    }

    public Account getAccountById(int id) {
        return baseDAO.getAccountById(id);
    }

    public String getAccountJsonById(int id) {
        return jsonParser.toJson(baseDAO.getAccountById(id));
    }


}
