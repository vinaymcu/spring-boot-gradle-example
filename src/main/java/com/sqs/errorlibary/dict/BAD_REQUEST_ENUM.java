package com.sqs.errorlibary.dict;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sqs.errorlibary.exception.DEBUG_CONSTANTS;

public enum BAD_REQUEST_ENUM  implements ErrorReasonData{

    AUTH_ERROR("AUTH_ERROR","test error tvjcjcxcxjvcxj"),
    INVALID_INPUT("INVALID_INPUT","invalid input"),
    BAD_REQUEST_ENUM("BAD_REQUEST","test");
    private String value;
    private String message;
    private String debugMessage;

    BAD_REQUEST_ENUM(String value,String message){
        this.value=value;
        this.message=message;
        this.debugMessage= DEBUG_CONSTANTS.DEBUG_MSG.getValue();
    }



    @JsonCreator
    public static BAD_REQUEST_ENUM fromValue(String text){
        for(BAD_REQUEST_ENUM  b:BAD_REQUEST_ENUM.values()){
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

    @Override
    @JsonValue
    public String getMessage() {
        return String.valueOf(message);
    }

    @Override
    @JsonValue
    public String getDebugMesssage() {
        return String.valueOf(debugMessage);
    }

    @Override
    public boolean isDefault() {
        return false;
    }
}
