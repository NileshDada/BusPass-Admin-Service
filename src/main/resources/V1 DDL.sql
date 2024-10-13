create table language_master(
            lang_id serial  PRIMARY key,
            lang_name VARCHAR(40),
            remark VARCHAR(200),
            status_cd VARCHAR(10),
            crte_user_id VARCHAR(20) ,
            crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
            lst_updt_ts TIMESTAMP null,
            lst_updt_user_id VARCHAR(20) null
        );