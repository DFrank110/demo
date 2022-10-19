package com.example.demo.exception;

public class CustomException  extends Exception  {
    //异常信息
    private String message;

    //构造函数
    public CustomException(String message){
        super(message);
        this.message = message;
    }
}
