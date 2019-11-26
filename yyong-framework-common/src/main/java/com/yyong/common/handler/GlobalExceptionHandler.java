package com.yyong.common.handler;


import com.yyong.common.constants.ResultCodeEnum;
import com.yyong.common.exception.MyException;
import com.yyong.common.util.ExceptionUtil;
import com.yyong.common.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.SizeLimitExceededException;

/**
 * 全局异常处理器
 * @author ygg
 * @since 2019/6/25
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     *异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        //log.error(e.getMessage());
        //输出异常处理信息
        //e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return R.error();
    }

    /**
     *sql语法错误
     * @param e
     * @return
     */
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e){
        //log.error(e.getMessage());
        //输出异常堆栈信息
        //e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }


    /**
     *json解析异常
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R error(JsonParseException e){
        //log.error(e.getMessage());
        //输出异常堆栈信息
        //e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }


    /**
     *上传文件过大
     * @param e
     * @return
     */
    @ExceptionHandler(SizeLimitExceededException.class)
    @ResponseBody
    public R error(SizeLimitExceededException e){
        //log.error(e.getMessage());
        //输出异常堆栈信息
        //e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        //R r = R.setResult(ResultCodeEnum.SIZE_LIMIT_ERROR);
        R r = R.setResult(ResultCodeEnum.FILE_UPLOAD_ERROR);
        return r;
    }


    @ExceptionHandler(MyException.class)
    @ResponseBody
    public R error(MyException e){
        //log.error(e.getMessage());
        //输出异常堆栈信息
        //e.printStackTrace();
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message(e.getMessage()).code(e.getCode());
    }

}
