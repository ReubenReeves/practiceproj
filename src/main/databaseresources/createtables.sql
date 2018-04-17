CREATE TABLE accountinfo (
	id int not null,
    accountid int not null,
    name varchar(20) not null,
    profileiconid int,
    revisiondate int,
    summonerlevel int,
    PRIMARY KEY(id),
    unique(accountid)
);

CREATE TABLE matches (
	PlatformID int NOT NULL,
    AccountID int NOT NULL,
    GameID int NOT NULL,
    Champion int,
    Queue int,
    Season int,
    TimePlayed int,
    Role VARCHAR(15),
    Lane VARCHAR(15),
    PRIMARY KEY(PlatformID),
    FOREIGN KEY(AccountID)
		references accountinfo(AccountID)
        ON DELETE CASCADE
);