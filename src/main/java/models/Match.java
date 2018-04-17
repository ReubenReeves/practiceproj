package com.practice.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MATCHES")
public class Match implements Serializable {

    public static final String ACCOUNT_ID_COLUMN = "AccountID";

    @Column(name = "PlatformID")
    private String platformID;

    @Id
    @Column(name = "AccountID")
    private int accountID;

    @Id
    @Column(name = "GameID")
    private int gameID;

    @Column(name = "Champion")
    private int champion;

    @Column(name = "Queue")
    private int queue;

    @Column(name = "Season")
    private int season;

    @Column(name = "TimePlayed")
    private long timePlayed;

    @Column(name = "Role")
    private String role;

    @Column(name = "Lane")
    private String lane;

    public Match(){}

    public Match(String platformID,int gameID, int champion, int queue, int season, long timePlayed, String role, String lane) {
        this.platformID = platformID;
        this.gameID = gameID;
        this.champion = champion;
        this.queue = queue;
        this.season = season;
        this.timePlayed = timePlayed;
        this.role = role;
        this.lane = lane;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getPlatformID() {
        return platformID;
    }

    public int getAccountID() {
        return accountID;
    }

    public int getGameID() {
        return gameID;
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

    public long getTimePlayed() {
        return timePlayed;
    }

    public String getRole() {
        return role;
    }

    public String getLane() {
        return lane;
    }
}
