create databse authdb;

use authdb;

create table User {
	id int primary key NOT NULL AUTO_INCREMENT,
	userName varchar(100),
	email varchar(100),
	password varchar(100),
	personId int,
	createDate varchar(100),
	modificationDate varchar(100)
	}

create table Role {
	id int primary key NOT NULL AUTO_INCREMENT,
	roleName varchar(100),
	description text,
	createDate varchar(100),
	modificationDate varchar(100),
	lastModificationUser varchar(100)
	}

create table UserRole {
	id int primary key NOT NULL AUTO_INCREMENT,
	userId int NOT NULL,
	roleId int NOT NULL,
	activeFlag varchar(1),
	createDate varchar(100),
	modificationDate varchar(100),
	lastModificationUser varchar(100)
	}

create table Permission {
	id int primary key NOT NULL AUTO_INCREMENT,
	permissionName varchar(100),
	permissionDescription text,
	createDate varchar(100),
	modificationDate varchar(100),
	lastModificationUser varchar(100)
	}

create table RolePermission {
	id int primary key NOT NULL AUTO_INCREMENT,
	roleId int NOT NULL,
	permissionId int NOT NULL,
	activeFlag varchar(1),
	createDate varchar(100),
	modificationDate varchar(100),
	lastModificationUser varchar(100)
	}








