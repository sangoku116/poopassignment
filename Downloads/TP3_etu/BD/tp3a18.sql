DROP DATABASE if exists tp3a18;
CREATE DATABASE tp3a18;
USE tp3a18;
CREATE TABLE UTILISATEUR (
  ID int(11) PRIMARY KEY AUTO_INCREMENT,
  NOM varchar(20) UNIQUE KEY,
  MOTPASSE varchar(255) DEFAULT NULL
) ENGINE=InnoDB;