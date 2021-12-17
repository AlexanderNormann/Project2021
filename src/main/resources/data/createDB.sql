CREATE
DATABASE  IF NOT EXISTS `heroku_8c82ce867ddf156`;


/* user tabellen skal laves som den første tabel */
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `userid`    int(11) NOT NULL AUTO_INCREMENT,
    `firstname` varchar(500) NOT NULL,
    `lastname`  varchar(500) NOT NULL,
    `email`     varchar(200) DEFAULT NULL,
    `password`  varchar(500) NOT NULL,
    `role`      varchar(45)  DEFAULT NULL,
    PRIMARY KEY (`userid`),
    UNIQUE KEY `email_UNIQUE` (`email`)
);

/* project tabellen skal laves som nr 2 tabel */
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`
(
    `projectid`          int(11) NOT NULL AUTO_INCREMENT,
    `projectname`        varchar(200) NOT NULL,
    `projectdescription` varchar(500) DEFAULT NULL,
    `userID_FK`          int(11) NOT NULL,
    PRIMARY KEY (`projectid`),
    KEY                  `userid_idx` (`userID_FK`),
    CONSTRAINT `userid` FOREIGN KEY (`userID_FK`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE NO ACTION
);

/* task tabellen skal laves som nr 3 tabel */
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`
(
    `taskid`          int(11) NOT NULL AUTO_INCREMENT,
    `taskname`        varchar(45) NOT NULL,
    `taskdescription` varchar(500) DEFAULT NULL,
    `projectID_FK`    int(11) NOT NULL,
    PRIMARY KEY (`taskid`),
    KEY               `projectid_idx` (`projectID_FK`),
    CONSTRAINT `projectid` FOREIGN KEY (`projectID_FK`) REFERENCES `project` (`projectid`) ON DELETE CASCADE ON UPDATE NO ACTION
);

/* subtask tabellen skal laves som nr 4 tabel */
DROP TABLE IF EXISTS `subtask`;
CREATE TABLE `subtask`
(
    `subtaskid`           int(11) NOT NULL AUTO_INCREMENT,
    `subtaskname`         varchar(45) NOT NULL,
    `subtaskdescription`  varchar(500) DEFAULT NULL,
    `subtasktimeestimate` varchar(45) NOT NULL,
    `taskID_FK`           int(11) NOT NULL,
    PRIMARY KEY (`subtaskid`),
    KEY                   `taskid_idx` (`taskID_FK`),
    CONSTRAINT `taskid` FOREIGN KEY (`taskID_FK`) REFERENCES `task` (`taskid`) ON DELETE CASCADE ON UPDATE NO ACTION
);



