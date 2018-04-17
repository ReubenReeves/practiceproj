CREATE TABLE accountinfo (
	id int not null,
    AccountID int not null,
    name varchar(20) not null,
    profileiconid int,
    revisiondate long,
    summonerlevel int,
    PRIMARY KEY(id),
    unique(accountid)
);

CREATE TABLE matches (
	PlatformID varchar(10) NOT NULL,
    AccountID int NOT NULL,
    GameID int NOT NULL,
    Champion int,
    Queue int,
    Season int,
    TimePlayed long,
    Role VARCHAR(15),
    Lane VARCHAR(15),
    PRIMARY KEY(GameID, AccountID)
);