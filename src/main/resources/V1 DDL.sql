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



create table school_information_master(
school_id serial  PRIMARY key,
school_identification_number VARCHAR(20),
school_name VARCHAR(300),
school_address VARCHAR(300),
school_automomus VARCHAR(300),
school_everyday_start_timing TIMESTAMP,
school_everyday_end_timing TIMESTAMP,
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
pass_type_age_limit VARCHAR(40),
remark VARCHAR(200),
status_cd VARCHAR(10),
crte_user_id VARCHAR(20) ,
crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
lst_updt_ts TIMESTAMP null,
lst_updt_user_id VARCHAR(20) null
);


create table pass_type_document_master(
pass_type_doc_id serial  PRIMARY key,
pass_type_id Integer,
doc_id Integer,
remark VARCHAR(200),
status_cd VARCHAR(10),
crte_user_id VARCHAR(20) ,
crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
lst_updt_ts TIMESTAMP null,
lst_updt_user_id VARCHAR(20) null
);

create table role_master(
ROLE_ID serial  PRIMARY key,
ROLE_NAME VARCHAR(30),
REMARK VARCHAR(100),
STATUS_CD VARCHAR(10),
crte_user_id VARCHAR(20) ,
crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
lst_updt_ts TIMESTAMP null,
lst_updt_user_id VARCHAR(20) null
);


create table customer_master(
cust_id serial  PRIMARY key,
cust_first_name VARCHAR(200),
cust_middle_name VARCHAR(200),
cust_last_name VARCHAR(200),
cust_address VARCHAR(500),
cust_photo bytea,
cust_mobile_no VARCHAR(20),
cust_email_id VARCHAR(120),
cust_gender VARCHAR(20),
cust_dob timestamp,
cust_login_user_name VARCHAR(20),
cust_login_password VARCHAR(20),
roleId Integer,
cust_status VARCHAR(20),
remark VARCHAR(200),
status_cd VARCHAR(10),
crte_user_id VARCHAR(20) ,
crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
lst_updt_ts TIMESTAMP null,
lst_updt_user_id VARCHAR(20) null
);



create table student_pass_master(
stud_pass_id serial  PRIMARY key,
stud_pass_form_no VARCHAR(100),
cust_id Integer,
pass_type_id Integer,
stud_pass_created_date timestamp,
stud_pass_expire_date timestamp,
routes_id Integer,
from_bus_stop_id Integer,
to_bus_stop_id Integer,
stud_pass_amount VARCHAR(50),
stud_pass_amount_paid_status VARCHAR(100),
school_name VARCHAR(400),
school_address VARCHAR(400),
school_automomus VARCHAR(10),
school_udise_number VARCHAR(100),
school_everyday_start_timing timestamp,
school_everyday_end_timing timestamp,
stud_class_name VARCHAR(100),
stud_course_name VARCHAR(100),
stud_roll_no VARCHAR(100),
stud_pass_status VARCHAR(20),
remark VARCHAR(200),
status_cd VARCHAR(10),
crte_user_id VARCHAR(20) ,
crte_ts TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
lst_updt_ts TIMESTAMP null,
lst_updt_user_id VARCHAR(20) null
);