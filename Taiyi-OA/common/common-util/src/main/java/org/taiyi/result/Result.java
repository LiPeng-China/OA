package org.taiyi.result;

import lombok.Data;

import java.util.Objects;

@Data
public class Result<T> {
    private Integer code;       // 状态码
    private String message;     // 返回信息
    private T data;             // 数据

    // 构造私有化
    private Result(){}

    // 封装返回的数据
    public static<T> Result<T> build(T data, ResultCodeEnum codeEnum){
        Result<T> result = new Result<>();

        // 数据
        if (!Objects.isNull(data)){
            result.setData(data);
        }
        // 状态码 和 返回信息
        result.setCode(codeEnum.getCode());
        result.setMessage(codeEnum.getMessage());

        return result;
    }


    // 1、成功
    // 1.1
    public static<T> Result<T> ok(){
        return build(null, ResultCodeEnum.SUCCESS);
    }
    // 1.2、有返回数据的成功
    public static<T> Result<T> ok(T data){
        return build(data, ResultCodeEnum.SUCCESS);
    }


    // 2、失败
    // 2.1、无返回数据的失败
    public static<T> Result<T> fail(){
        return build(null, ResultCodeEnum.FAIL);
    }
    // 2.2、又返回数据的失败
    public static<T> Result<T> fail(T data){
        return build(data, ResultCodeEnum.FAIL);
    }

    // 进一步扩展：可以自定义返回码和信息
    public Result<T> message(String message){
        this.setMessage(message);
        return this;
    }
    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

}
