package com.busservice.BusService.constant;

public final class SQLQueryConstants {
    SQLQueryConstants(){    }
    public static final String LANGUAGE_MASTER_DETAILS_BY_PAGING = "select lang_id, lang_name, remark, status_cd from language_master where lang_id = coalesce(:langId, lang_id) and lang_name = coalesce(:langName, lang_name) and status_cd = coalesce(:statusCd, status_cd) order by :sortName asc limit :pageSize offset :pageOffset";
    public static final String LANGUAGE_MASTER_DETAILS_BY_PAGING_COUNT = "select count(*) from language_master where lang_id = coalesce(:langId, lang_id) and lang_name = coalesce(:langName, lang_name) and status_cd = coalesce(:statusCd, status_cd)";

    public static final String ROUTES_MASTER_DETAILS_BY_PAGING = "select routes_id, routes_name,routes_start_location,routes_end_location, remark, status_cd from routes_master where routes_id = coalesce(:routesId, routes_id) and routes_name = coalesce(:routesName, routes_name) and status_cd = coalesce(:statusCd, status_cd) order by :sortName asc limit :pageSize offset :pageOffset";
    public static final String ROUTES_MASTER_DETAILS_BY_PAGING_COUNT = "select count(*) from routes_master where routes_id = coalesce(:routesId, routes_id) and routes_name = coalesce(:routesName, routes_name) and status_cd = coalesce(:statusCd, status_cd)";

    public static final String BUS_STOP_MASTER_DETAILS_BY_PAGING = "select bsm.bus_stop_id, bsm.bus_stop_name, bsm.bus_stop_no, rm.routes_id, rm.routes_name, rm.routes_start_location, rm.routes_end_location, bsm.remark, bsm.status_cd from bus_stop_master bsm, routes_master rm where bsm.routes_id=rm.routes_id and bsm.bus_stop_id = coalesce(:busStopId, bsm.bus_stop_id) and bsm.bus_stop_name = coalesce(:busStopName, bsm.bus_stop_name) and bsm.status_cd = coalesce(:statusCd, bsm.status_cd) order by :sortName asc limit :pageSize offset :pageOffset";
    public static final String BUS_STOP_MASTER_DETAILS_BY_PAGING_COUNT = "select count(*) from bus_stop_master bsm, routes_master rm where bsm.routes_id=rm.routes_id and bsm.bus_stop_id = coalesce(:busStopId, bsm.bus_stop_id) and bsm.bus_stop_name = coalesce(:busStopName, bsm.bus_stop_name) and bsm.status_cd = coalesce(:statusCd, bsm.status_cd)";

    public static final String DOCUMENT_MASTER_DETAILS_BY_PAGING = "select doc_id, doc_name, remark, status_cd from document_master where doc_id = coalesce(:docId, doc_id) and doc_name = coalesce(:docName, doc_name) and status_cd = coalesce(:statusCd, status_cd) order by :sortName asc limit :pageSize offset :pageOffset";
    public static final String DOCUMENT_MASTER_DETAILS_BY_PAGING_COUNT = "select count(*) from document_master where doc_id = coalesce(:docId, doc_id) and doc_name = coalesce(:docName, doc_name) and status_cd = coalesce(:statusCd, status_cd)";

    public static final String PASS_TYPE_MASTER_DETAILS_BY_PAGING = "select pass_type_id, pass_type_name,pass_type_description,pass_type_end_date,pass_type_collection_location,pass_type_amount, remark, status_cd from pass_type_master where pass_type_id = coalesce(:passTypeId, pass_type_id) and pass_type_name = coalesce(:passTypeName, pass_type_name) and status_cd = coalesce(:statusCd, status_cd) order by :sortName asc limit :pageSize offset :pageOffset";
    public static final String PASS_TYPE_MASTER_DETAILS_BY_PAGING_COUNT = "select count(*) from pass_type_master where pass_type_id = coalesce(:passTypeId, pass_type_id) and pass_type_name = coalesce(:passTypeName, pass_type_name) and status_cd = coalesce(:statusCd, status_cd)";

    public static final String PASS_TYPE_DOCUMENT_MASTER_DETAILS_BY_PAGING = "select ptm.pass_type_id, ptm.pass_type_name, ptm.pass_type_description, ptm.pass_type_end_date, ptm.pass_type_collection_location, ptm.pass_type_amount, dm.doc_id, dm.doc_name from pass_type_document_master ptdm, pass_type_master ptm , document_master dm where ptdm.pass_type_id =ptm.pass_type_id and ptdm.doc_id =dm.doc_id and ptdm.pass_type_doc_id=coalesce(:passTypeDocId,ptdm.pass_type_doc_id) and ptm.pass_type_id=coalesce(:passTypeId,ptm.pass_type_id) and ptdm.status_cd = coalesce(:statusCd, ptdm.status_cd) order by :sortName asc limit :pageSize offset :pageOffset";
    public static final String PASS_TYPE_DOCUMENT_MASTER_DETAILS_BY_PAGING_COUNT = "select count(*) from pass_type_document_master ptdm, pass_type_master ptm , document_master dm where ptdm.pass_type_id =ptm.pass_type_id and ptdm.doc_id =dm.doc_id and ptdm.pass_type_doc_id=coalesce(:passTypeDocId,ptdm.pass_type_doc_id) and ptm.pass_type_id=coalesce(:passTypeId,ptm.pass_type_id) and ptdm.status_cd = coalesce(:statusCd, ptdm.status_cd)";

}

