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



create table bus_stop_master(
            bus_stop_id serial  PRIMARY key,
            routes_id Integer,
            bus_stop_name VARCHAR(140),
             bus_stop_no VARCHAR(140),
            remark VARCHAR(200),
            status_cd VARCHAR(10),
            crte_user_id VARCHAR(20) ,
            crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
            lst_updt_ts TIMESTAMP null,
            lst_updt_user_id VARCHAR(20) null
        );

           create table document_master(
                    doc_id serial  PRIMARY key,
                    doc_name VARCHAR(40),
                    remark VARCHAR(200),
                    status_cd VARCHAR(10),
                    crte_user_id VARCHAR(20) ,
                    crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
                    lst_updt_ts TIMESTAMP null,
                    lst_updt_user_id VARCHAR(20) null
                );

                  create table pass_type_master(
                                    pass_type_id serial  PRIMARY key,
                                    pass_type_name VARCHAR(140),
                                    pass_type_description VARCHAR(340),
                                    pass_type_end_date timestamp,
                                    pass_type_collection_location VARCHAR(440),
                                    pass_type_amount VARCHAR(140),
                                    remark VARCHAR(200),
                                    status_cd VARCHAR(10),
                                    crte_user_id VARCHAR(20) ,
                                    crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
                                    lst_updt_ts TIMESTAMP null,
                                    lst_updt_user_id VARCHAR(20) null
                                );


