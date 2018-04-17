package com.practice.models;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNTINFO")
public class Account {

    public static final String NAME_COLUMN = "name";

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "ACCOUNTID")
    private int accountID;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PROFILEICONID")
    private int profileIconId;

    @Column(name = "REVISIONDATE")
    private long revisionDate;

    @Column(name = "SUMMONERLEVEL")
    private int summonerLevel;

    public Account() {
    }

    public Account(int id, int accountID, String name, int profileIconId, long revisionDate, int summonerLevel) {
        this.id = id;
        this.name = name;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.summonerLevel = summonerLevel;
        this.accountID = accountID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public long getRevisionDate() {
        return revisionDate;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public int getAccountID() {
        return accountID;
    }
}
