package org.taiyi.config.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.taiyi.result.Result;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 全局异常处理执行的方法
    @ExceptionHandler(Exception.class)
    public Result error(Exception e){
        return Result.fail().code(500).message(e.getMessage());
    }
}
