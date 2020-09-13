create database authdb;

use authdb;


CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'newuser';
GRANT ALL PRIVILEGES ON *.* TO 'newuser'@'localhost';

create table User (
	id int primary key NOT NULL AUTO_INCREMENT,
	userName varchar(100),
	email varchar(100),
	password varchar(100),
	personId int,
	createDate varchar(100),
	modificationDate varchar(100)
	);

ALTER TABLE User
ADD CONSTRAINT UC_User UNIQUE (email,userName,personId);

create table Role (
	id int primary key NOT NULL AUTO_INCREMENT,
	roleName varchar(100),
	description text,
	createDate varchar(100),
	modificationDate varchar(100),
	lastModificationUser varchar(100)
	);


create table UserRole (
	id int primary key NOT NULL AUTO_INCREMENT,
	userId int NOT NULL,
	roleId int NOT NULL,
	activeFlag varchar(1),
	createDate varchar(100),
	modificationDate varchar(100),
	lastModificationUser varchar(100)
	);

create table Permission (
	id int primary key NOT NULL AUTO_INCREMENT,
	permissionName varchar(100),
	permissionDescription text,
	createDate varchar(100),
	modificationDate varchar(100),
	lastModificationUser varchar(100)
	);

create table RolePermission (
	id int primary key NOT NULL AUTO_INCREMENT,
	roleId int NOT NULL,
	permissionId int NOT NULL,
	activeFlag varchar(1),
	createDate varchar(100),
	modificationDate varchar(100),
	lastModificationUser varchar(100)
	);


ALTER TABLE UserRole ADD  CONSTRAINT FK_user_userRole FOREIGN KEY(userId)
REFERENCES User (id)
;

ALTER TABLE UserRole ADD  CONSTRAINT FK_role_UserRole FOREIGN KEY(roleId)
REFERENCES Role (id)
;

ALTER TABLE RolePermission ADD  CONSTRAINT FK_role_PerRole FOREIGN KEY(roleId)
REFERENCES Role (id)
;

ALTER TABLE RolePermission ADD  CONSTRAINT FK_permission_PerRole FOREIGN KEY(permissionId)
REFERENCES Permission (id)
;



insert into User values (default, "admin", "admin@gmail.com", "admin", "1", "09-12-2020", "09-12-2020");

insert into Role values (default, "admin", "admin", "09-12-2020", "09-12-2020", "admin");
insert into Role values (default, "normal", "normal", "09-12-2020", "09-12-2020", "admin");		

insert into UserRole values (default, "1", "1", "y" ,"09-12-2020", "09-12-2020", "admin");

insert into Permission values (default, "All_Database", "admin", "09-12-2020", "09-12-2020", "admin");
insert into Permission values (default, "All_Database", "normal", "09-12-2020", "09-12-2020", "admin");
	
insert into RolePermission values (default, "1", "1", "y" ,"09-12-2020", "09-12-2020", "admin");




