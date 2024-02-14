package com.sqs.errorlibary.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorSourceType {
    BODY("BODY"),
    HEADER("HEADER"),
    QUERY("QUERY"),
    PATH("PATH"),
    METHOD("METHOD"),
    DOWNSTREAM("DOWNSTREAM"),
    VALIDATION("VALIDATION");

    private String value;
    ErrorSourceType(String value){
        this.value=value;
    }
   @JsonCreator
    public static ErrorSourceType fromValue(String text){
        for(ErrorSourceType  b:ErrorSourceType.values()){
            if(String.valueOf(b.value).equals(text)){
                return b;
            }
        }
        return null;
    }

    @Override
    @JsonValue
    public String toString(){
        return String.valueOf(value);
    }

}
