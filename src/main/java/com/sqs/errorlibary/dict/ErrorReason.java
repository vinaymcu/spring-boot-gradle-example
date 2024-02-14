package com.sqs.errorlibary.dict;

import com.sqs.errorlibary.model.ErrorCode;
import org.springframework.http.HttpStatus;

public enum ErrorReason {

    AUTH_ERROR(HttpStatus.BAD_REQUEST, ErrorCode.BAD_REQUEST,BAD_REQUEST_ENUM.AUTH_ERROR,
    BAD_REQUEST_ENUM.AUTH_ERROR.getMessage(),BAD_REQUEST_ENUM.AUTH_ERROR.getDebugMesssage()),

    INVALID_INPUT(HttpStatus.BAD_REQUEST, ErrorCode.INVALID_INPUT,BAD_REQUEST_ENUM.INVALID_INPUT,
               BAD_REQUEST_ENUM.INVALID_INPUT.getMessage(),BAD_REQUEST_ENUM.INVALID_INPUT.getDebugMesssage());

    private HttpStatus httpStatus;

    public int getHttpStatus() {
        return (( HttpStatus) httpStatus).value();
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getStatus() {
        return (( ErrorCode) status).getValue();
    }


    public Enum<?> getReason() {
        return reason;
    }

    public void setReason(Enum<?> reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    @Override
    public String toString() {
        return "ErrorReason{" +
                "httpStatus=" + httpStatus +
                ", status=" + status +
                ", reason=" + reason +
                ", message='" + message + '\'' +
                ", debugMessage='" + debugMessage + '\'' +
                '}';
    }

    private Enum<?> status;
    private Enum<?> reason;
    private String message;
    private String debugMessage;

     ErrorReason(HttpStatus httpStatus,Enum<?> status,Enum<?> reason,String message, String debugMessage){
        this.httpStatus=httpStatus;
        this.status=status;
        this.reason=reason;
        this.message=message;
        this.debugMessage=debugMessage;
    }

    public static ErrorReason fromValue(String text){
        for(ErrorReason b: ErrorReason.values()){
            if(String.valueOf(b.toString()).equals(text)){
                return b;
            }
        }
        return null;
    }

    public static ErrorReason fromKey(Enum<?> enumName){
        ErrorReason  errorReason=Enum.valueOf(ErrorReason.class,enumName.name());
        return errorReason;
    }
}
