package com.sqs.errorlibary.exception;

public enum DEBUG_CONSTANTS {

    KEY("KEY"),
    INTERACTION_ID("INTERACTION_ID"),
    PARTY_ID("PARTY_ID"),
    TIMESTAMP("TIMESTAMP"),
    ID1("ID1"),
    ID2("ID2"),
    DEBUG_MSG("DEBUG_MSG");

    private String value;
    DEBUG_CONSTANTS(String value){
        this.value=value;
    }
    public String getValue(){
        return String.valueOf(value);
    }
}
