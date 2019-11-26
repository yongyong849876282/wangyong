package com.yyong.common.constants;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(true, 20000,"成功"),
    UNKNOWN_REASON(false, 20001, "未知错误"),
    BAD_SQL_GRAMMAR(false, 21001, "sql语法错误"),
    JSON_PARSE_ERROR(false, 21002, "json解析异常"),
    PARAM_ERROR(false, 21003, "参数不正确"),
    FILE_UPLOAD_ERROR(false, 21004, "文件上传错误"),
    EXCEL_DATA_IMPORT_ERROR(false, 21005, "Excel数据导入错误"),
    SIZE_LIMIT_ERROR( false, 21009, "文件过大错误"),
    VIDEO_UPLOAD_TOMCAT_ERROR( false, 220001, "视频上传错误"),
    VIDEO_UPLOAD_ALIYUN_ERROR( false, 210010, "文xxx"),
    VIDEO_DELETE_ALIYUN_ERROR( false, 210010, "文xxx");



    private Boolean success;

    private Integer code;

    private String message;

    private ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
