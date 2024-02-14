package com.sqs.errorlibary.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ErrorCode {

    DEFAULT_ERROR_CODE("-1"),
    OK("200"),
    CREATED("201"),
    INVALID_INPUT("401"),
    BAD_REQUEST("400"),
    UNAUTHORIZED("602"),
    FORBIDDEN("403");

    private String value;
    ErrorCode(String value){
        this.value=value;
    }
    @JsonCreator
    public static ErrorCode fromValue(String text){
        for(ErrorCode  b:ErrorCode.values()){
            if(String.valueOf(b.value).equals(text)){
                return b;
            }
        }
        return null;
    }
    public String getValue(){
        return value;
    }
}
