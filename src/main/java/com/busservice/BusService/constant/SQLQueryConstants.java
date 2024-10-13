package com.busservice.BusService.constant;

public final class SQLQueryConstants {
    SQLQueryConstants(){    }
    public static final String LANGUAGE_MASTER_DETAILS_BY_PAGING = "select lang_id, lang_name, remark, status_cd from language_master where lang_id = coalesce(:langId, lang_id) and lang_name = coalesce(:langName, lang_name) and status_cd = coalesce(:statusCd, status_cd) order by :sortName asc limit :pageSize offset :pageOffset";
    public static final String LANGUAGE_MASTER_DETAILS_BY_PAGING_COUNT = "select count(*) from language_master where lang_id = coalesce(:langId, lang_id) and lang_name = coalesce(:langName, lang_name) and status_cd = coalesce(:statusCd, status_cd)";

    public static final String ROUTES_MASTER_DETAILS_BY_PAGING = "select routes_id, routes_name,routes_start_location,routes_end_location, remark, status_cd from routes_master where routes_id = coalesce(:routesId, routes_id) and routes_name = coalesce(:routesName, routes_name) and status_cd = coalesce(:statusCd, status_cd) order by :sortName asc limit :pageSize offset :pageOffset";
    public static final String ROUTES_MASTER_DETAILS_BY_PAGING_COUNT = "select count(*) from routes_master where routes_id = coalesce(:routesId, routes_id) and routes_name = coalesce(:routesName, routes_name) and status_cd = coalesce(:statusCd, status_cd)";

    public static final String BUS_STOP_MASTER_DETAILS_BY_PAGING = "select bsm.bus_stop_id, bsm.bus_stop_name, bsm.bus_stop_no, rm.routes_id, rm.routes_name, rm.routes_start_location, rm.routes_end_location, bsm.remark, bsm.status_cd from bus_stop_master bsm, routes_master rm where bsm.routes_id=rm.routes_id and bsm.bus_stop_id = coalesce(:busStopId, bsm.bus_stop_id) and bsm.bus_stop_name = coalesce(:busStopName, bsm.bus_stop_name) and bsm.status_cd = coalesce(:statusCd, bsm.status_cd) order by :sortName asc limit :pageSize offset :pageOffset";
    public static final String BUS_STOP_MASTER_DETAILS_BY_PAGING_COUNT = "select count(*) from bus_stop_master bsm, routes_master rm where bsm.routes_id=rm.routes_id and bsm.bus_stop_id = coalesce(:busStopId, bsm.bus_stop_id) and bsm.bus_stop_name = coalesce(:busStopName, bsm.bus_stop_name) and bsm.status_cd = coalesce(:statusCd, bsm.status_cd)";
}
