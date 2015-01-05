create table users (
    username  varchar2(100) not null primary key,
    password  varchar2(100) not null,
    enabled   number(1,0)  default 0 not null
);

create table authorities (
    username  varchar2(100) not null,
    authority varchar2(100) not null,
    foreign key (username) references users (username),
    primary key (username, authority)
);

create table groups (
    id         number not null primary key,
    group_name varchar2(100) not null
);

CREATE SEQUENCE  "GROUPSSEQ"
    MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;


create table group_authorities (
    group_id  number not null,
    authority varchar2(100) not null,
    foreign key (group_id) references groups (id),
    primary key (group_id, authority)
);

create table group_members (
    username varchar2(100) not null,
    group_id number not null,
    foreign key (group_id) references groups (id),
    primary key (username, group_id)
);