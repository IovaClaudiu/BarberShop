DROP TABLE IF EXISTS users;
create table users(
	id integer AUTO_INCREMENT,
	username varchar2(50),
	password varchar2(50),
	role varchar2(20),
	PRIMARY KEY (id)
);

insert into users (username, password,role) values('Iova','qwerty','USER');
insert into users (username, password,role) values('Claudiu','qwerty','USER');
insert into users (username, password,role)values('Cristian','qwerty','USER');
insert into users (username, password,role)values('admin','admin','ADMIN');


DROP TABLE IF EXISTS appointment;
create table appointment(
	id integer AUTO_INCREMENT,
	client_name varchar2(50),
	action_type varchar2(50),
	PRIMARY KEY (id)
);