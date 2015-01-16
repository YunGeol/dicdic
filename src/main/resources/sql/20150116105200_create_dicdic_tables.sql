create table dictionary (
      word                    varchar2(200)  not null primary key
    , value                   varchar2(200)  not null
    , des                     varchar2(500)  not null
    , created_date            TIMESTAMP      not null
    , created_by              NUMBER
    , last_modified_date      TIMESTAMP      not null
    , lasy_modified_by        NUMBER
);

create index idx_dic_cr_date on dictionary(created_date);
create index idx_dic_lm_date on dictionary(last_modified_date);

COMMENT ON COLUMN dictionary.word                 IS '단어';
COMMENT ON COLUMN dictionary.value                IS '값';
COMMENT ON COLUMN dictionary.des                  IS '부연설명';
COMMENT ON COLUMN dictionary.created_date         IS '데이터생성자';
COMMENT ON COLUMN dictionary.created_by           IS '데이터수정일';
COMMENT ON COLUMN dictionary.last_modified_date   IS '데이터수정자';
COMMENT ON COLUMN dictionary.lasy_modified_by     IS '데이터수정자';

