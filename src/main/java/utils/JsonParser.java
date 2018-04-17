package com.practice.utils;

import com.google.gson.Gson;
import com.practice.jsonmodels.AccountJson;
import com.practice.jsonmodels.MatchesHistoryJson;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

public class JsonParser {

    @Autowired
    private Gson gson;


    /**
     * get Json from internal file.
     * @return
     * @throws IOException
     */
    @Deprecated
    public MatchesHistoryJson parseMatchHistory() throws IOException {
        InputStream pdInputStream = this.getClass().getResourceAsStream("/recentmatchesclick.json");
        String jsonString = IOUtils.toString(pdInputStream, "UTF-8");
        return gson.fromJson(jsonString, MatchesHistoryJson.class);
    }

    public MatchesHistoryJson parseMatchHistory(String matchHistory){
        return gson.fromJson(matchHistory, MatchesHistoryJson.class);
    }

    public AccountJson parseAccount(String account) {
        return gson.fromJson(account, AccountJson.class);
    }

    public String toJson(Object object) {
        return gson.toJson(object);
    }

}
