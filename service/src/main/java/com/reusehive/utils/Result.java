package com.reusehive.utils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Result<T> {
    private String msg;
    private int code;
    private T data;

    public static <T> Result<T> ok(){
        return new Result<T>("success",1,null);
    }

    public static <T> Result<T> ok(T data){
        return new Result<T>("success",1,data);
    }

    public static <T> Result<T> ok(String msg, T data){
        return new Result<T>(msg,1,data);
    }

    public static <T> Result<T> error(String msg){
        return new Result<T>(msg,0,null);
    }


    public static <T> Result<T> error(String msg, T data){
        return new Result<T>(msg,0,data);
    }

    public static <T> Result<T> warm(String msg){
        return new Result<T>(msg,2,null);
    }

    public static <T> Result<T> warm(String msg, T data){
        return new Result<T>(msg,2,data);
    }

    public static <T> Result<T> warm(T data){
        return new Result<T>("success but warm",2,data);
    }
}
