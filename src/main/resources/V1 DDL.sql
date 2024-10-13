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

create table routes_master(
            routes_id serial  PRIMARY key,
            routes_name VARCHAR(140),
             routes_start_location VARCHAR(140),
              routes_end_location VARCHAR(140),
            remark VARCHAR(200),
            status_cd VARCHAR(10),
            crte_user_id VARCHAR(20) ,
            crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
            lst_updt_ts TIMESTAMP null,
            lst_updt_user_id VARCHAR(20) null
        );


