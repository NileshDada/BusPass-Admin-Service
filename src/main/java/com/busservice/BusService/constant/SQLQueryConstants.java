package com.busservice.BusService.constant;

public final class SQLQueryConstants {
    SQLQueryConstants(){    }
    public static final String LANGUAGE_MASTER_DETAILS_BY_PAGING = "select lang_id, lang_name, remark, status_cd from language_master where lang_id = coalesce(:langId, lang_id) and lang_name = coalesce(:langName, lang_name) and status_cd = coalesce(:statusCd, status_cd) order by :sortName asc limit :pageSize offset :pageOffset";
    public static final String LANGUAGE_MASTER_DETAILS_BY_PAGING_COUNT = "select count(*) from language_master where lang_id = coalesce(:langId, lang_id) and lang_name = coalesce(:langName, lang_name) and status_cd = coalesce(:statusCd, status_cd)";

    public static final String ROUTES_MASTER_DETAILS_BY_PAGING = "select routes_id, routes_name,routes_start_location,routes_end_location, remark, status_cd from routes_master where routes_id = coalesce(:routesId, routes_id) and routes_name = coalesce(:routesName, routes_name) and status_cd = coalesce(:statusCd, status_cd) order by :sortName asc limit :pageSize offset :pageOffset";
    public static final String ROUTES_MASTER_DETAILS_BY_PAGING_COUNT = "select count(*) from routes_master where routes_id = coalesce(:routesId, routes_id) and routes_name = coalesce(:routesName, routes_name) and status_cd = coalesce(:statusCd, status_cd)";
}
