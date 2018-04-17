package com.practice.jsonmodels;

public class MatchJson {

    private String platformId;
    private String accountID;
    private int gameId;
    private int champion;
    private int queue;
    private int season;
    private long timestamp;
    private String role;
    private String lane;

    public String getPlatformId() {
        return platformId;
    }

    public int getGameId() {
        return gameId;
    }

    public int getChampion() {
        return champion;
    }

    public int getQueue() {
        return queue;
    }

    public int getSeason() {
        return season;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getRole() {
        return role;
    }

    public String getLane() {
        return lane;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
