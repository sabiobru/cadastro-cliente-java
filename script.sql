CREATE TABLE Client (
id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
name CHAR(255) ,
type BOOL ,
identityDocument CHAR(255) ,
registrationNumber CHAR(255) ,
registrationDate CHAR(255) ,
status BOOL,
PRIMARY KEY(id)
);

CREATE TABLE Contact (
id INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
areaCode CHAR(255) ,
phoneNumber CHAR(255) ,
clientId INTEGER,
PRIMARY KEY(id),
FOREIGN KEY(clientId) REFERENCES client(id)
);

