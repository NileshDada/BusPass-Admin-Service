package com.busservice.BusService.constant;

public final class SQLQueryConstants {
    SQLQueryConstants(){    }
    public static final String LANGUAGE_MASTER_DETAILS_BY_PAGING = "select lang_id, lang_name, remark, status_cd from language_master where lang_id = coalesce(:langId, lang_id) and lang_name = coalesce(:langName, lang_name) and status_cd = coalesce(:statusCd, status_cd) order by :sortName asc limit :pageSize offset :pageOffset";
    public static final String LANGUAGE_MASTER_DETAILS_BY_PAGING_COUNT = "select count(*) from language_master where lang_id = coalesce(:langId, lang_id) and lang_name = coalesce(:langName, lang_name) and status_cd = coalesce(:statusCd, status_cd)";
}
