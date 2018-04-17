package com.practice.utils;

import com.practice.jsonmodels.AccountJson;
import com.practice.jsonmodels.MatchJson;
import com.practice.jsonmodels.MatchesHistoryJson;
import com.practice.models.Account;
import com.practice.models.Match;

import java.util.ArrayList;
import java.util.List;

public class ObjectConverter {

    public Account getAccountFromJson(AccountJson accountJson) {
        return new Account(accountJson.getId(),
                    accountJson.getAccountId(),
                    accountJson.getName(),
                    accountJson.getProfileIconId(),
                    accountJson.getRevisionDate(),
                    accountJson.getSummonerLevel());
    }

    public Match getMatchFromJson(MatchJson matchJson) {
        return new Match(matchJson.getPlatformId(),
                matchJson.getGameId(),
                matchJson.getChampion(),
                matchJson.getQueue(),
                matchJson.getSeason(),
                matchJson.getTimestamp(),
                matchJson.getRole(),
                matchJson.getLane()
                        );
    }

    public List<Match> getMatchListFromJson(MatchesHistoryJson matchListJson) {
        List<Match> matchList = new ArrayList<>();
        if (matchListJson != null) {
            for (MatchJson match : matchListJson.getMatches()) {
                matchList.add(getMatchFromJson(match));
            }
        }
        return matchList;
    }
}
