package com.sqs.errorlibary.exception;

import com.sqs.errorlibary.dict.ErrorReasonData;
import com.sqs.errorlibary.model.ErrorDetail;
import com.sqs.errorlibary.model.ErrorResponse;
import com.sqs.errorlibary.model.ErrorSourceType;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter @Getter
public abstract class GlobalException extends RuntimeException {

    //@Setter @Getter
    ErrorReasonData errorReason;

    //@Setter @Getter
    String message;

    //@Setter @Getter
    ErrorSourceType errorSourceType;
    //@Setter @Getter
    Exception baseException;
    //@Setter @Getter
    ErrorDetail errorDetail;
    //@Setter @Getter
    ErrorResponse errorResponse;
    //@Setter @Getter
    Map<DEBUG_CONSTANTS,String> debugValues;

    public GlobalException(ErrorReasonData errorReason){

        this.errorReason=errorReason;
    }

    public GlobalException(ErrorReasonData errorReason,Map<DEBUG_CONSTANTS,String> debugValues){
        System.out.println(" debugValues :"+debugValues);
        this.errorReason=errorReason;
        this.debugValues=debugValues;
    }

    public GlobalException(ErrorReasonData errorReason,ErrorDetail errorDetail,Map<DEBUG_CONSTANTS,String> debugValues){
        System.out.println(" debugValues111 :"+debugValues);
        this.errorReason=errorReason;
        this.errorDetail=errorDetail;
        this.debugValues=debugValues;
    }

    public GlobalException(ErrorResponse errorResponse){

        this.errorResponse=errorResponse;
    }

    public ErrorReasonData getErrorReason() {
        return errorReason;
    }

    public void setErrorReason(ErrorReasonData errorReason) {
        this.errorReason = errorReason;
    }

    @Override
    public String getMessage() {
        System.out.println("message : "+message);
        return message;
    }

    public void setMessage(String message) {
        System.out.println(" set meggase :"+message);
        this.message = message;
    }

//    public ErrorSourceType getErrorSourceType() {
//        return errorSourceType;
//    }
//
//    public void setErrorSourceType(ErrorSourceType errorSourceType) {
//        this.errorSourceType = errorSourceType;
//    }
//
//    public Exception getBaseException() {
//        return baseException;
//    }
//
//    public void setBaseException(Exception baseException) {
//        this.baseException = baseException;
//    }
//
//    public ErrorDetail getErrorDetail() {
//        return errorDetail;
//    }
//
//    public void setErrorDetail(ErrorDetail errorDetail) {
//        this.errorDetail = errorDetail;
//    }
//
//    public ErrorResponse getErrorResponse() {
//        return errorResponse;
//    }
//
//    public void setErrorResponse(ErrorResponse errorResponse) {
//        this.errorResponse = errorResponse;
//    }
//
//    public Map<DEBUG_CONSTANTS, String> getDebugValues() {
//        return debugValues;
//    }
//
//    public void setDebugValues(Map<DEBUG_CONSTANTS, String> debugValues) {
//        this.debugValues = debugValues;
//    }
//



}
