create table users (
      username                varchar2(100)   not null primary key
    , password                varchar2(100)   not null
    , enabled                 number(1,0)     default 0 not null
    , created_date            TIMESTAMP
    , created_by              NUMBER
    , last_modified_date      TIMESTAMP
    , lasy_modified_by        NUMBER
);
create index idx_users_cr_date on users(created_date);
create index idx_users_lm_date on users(last_modified_date);

COMMENT ON COLUMN users.username           IS '사용자아이디(로그인아이디)';
COMMENT ON COLUMN users.password           IS '사용자패스워드';
COMMENT ON COLUMN users.enabled            IS '사용자활성화여부';
COMMENT ON COLUMN users.created_date       IS '데이터생성일';
COMMENT ON COLUMN users.created_by         IS '데이터생성자';
COMMENT ON COLUMN users.last_modified_date IS '데이터수정일';
COMMENT ON COLUMN users.lasy_modified_by   IS '데이터수정자';


create table authorities (
      username                varchar2(100)   not null
    , authority               varchar2(100)   not null
    , created_date            TIMESTAMP
    , created_by              NUMBER
    , last_modified_date      TIMESTAMP
    , lasy_modified_by        NUMBER
    , foreign key (username)  references users (username)
    , primary key (username, authority)
);
create index idx_authorities_cr_date on authorities(created_date);
create index idx_authorities_lm_date on authorities(last_modified_date);

COMMENT ON COLUMN authorities.username             IS '사용자아이디(로그인아이디)';
COMMENT ON COLUMN authorities.authority            IS '권한';
COMMENT ON COLUMN authorities.created_date         IS '데이터생성일';
COMMENT ON COLUMN authorities.created_by           IS '데이터생성자';
COMMENT ON COLUMN authorities.last_modified_date   IS '데이터수정일';
COMMENT ON COLUMN authorities.lasy_modified_by     IS '데이터수정자';



create table groups (
      id                      number          not null primary key
    , group_name              varchar2(100)   not null
    , created_date            TIMESTAMP
    , created_by              NUMBER
    , last_modified_date      TIMESTAMP
    , lasy_modified_by        NUMBER
);
create index idx_groups_cr_date on groups(created_date);
create index idx_groups_lm_date on groups(last_modified_date);

CREATE SEQUENCE  "GROUPSSEQ"
    MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

COMMENT ON COLUMN groups.id                             IS '그룹아이디';
COMMENT ON COLUMN groups.group_name                     IS '그룹이름';
COMMENT ON COLUMN groups.created_date                   IS '데이터생성일';
COMMENT ON COLUMN groups.created_by                     IS '데이터생성자';
COMMENT ON COLUMN groups.last_modified_date             IS '데이터수정일';
COMMENT ON COLUMN groups.lasy_modified_by               IS '데이터수정자';


create table group_authorities (
      group_id                number          not null
    , authority               varchar2(100)   not null
    , created_date            TIMESTAMP
    , created_by              NUMBER
    , last_modified_date      TIMESTAMP
    , lasy_modified_by        NUMBER
    , foreign key (group_id)  references groups (id)
    , primary key (group_id, authority)
);
create index idx_g_auth_cr_date on group_authorities(created_date);
create index idx_g_auth_lm_date on group_authorities(last_modified_date);

COMMENT ON COLUMN group_authorities.group_id            IS '그룹아이디';
COMMENT ON COLUMN group_authorities.authority           IS '권한';
COMMENT ON COLUMN group_authorities.created_date        IS '데이터생성일';
COMMENT ON COLUMN group_authorities.created_by          IS '데이터생성자';
COMMENT ON COLUMN group_authorities.last_modified_date  IS '데이터수정일';
COMMENT ON COLUMN group_authorities.lasy_modified_by    IS '데이터수정자';



create table group_members (
      username                varchar2(100)   not null
    , group_id                number          not null
    , created_date            TIMESTAMP
    , created_by              NUMBER
    , last_modified_date      TIMESTAMP
    , lasy_modified_by        NUMBER
    , foreign key (group_id)  references groups (id)
    , primary key (username, group_id)
);
create index idx_g_memb_cr_date on group_members(created_date);
create index idx_g_memb_lm_date on group_members(last_modified_date);

COMMENT ON COLUMN group_members.username                IS '사용자아이디(로그인아이디)';
COMMENT ON COLUMN group_members.group_id                IS '그룹아이디';
COMMENT ON COLUMN group_members.created_date            IS '데이터생성일';
COMMENT ON COLUMN group_members.created_by              IS '데이터생성자';
COMMENT ON COLUMN group_members.last_modified_date      IS '데이터수정일';
COMMENT ON COLUMN group_members.lasy_modified_by        IS '데이터수정자';