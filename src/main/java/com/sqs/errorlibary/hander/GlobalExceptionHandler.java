package com.sqs.errorlibary.hander;

import com.sqs.errorlibary.exception.DEBUG_CONSTANTS;
import com.sqs.errorlibary.ErrorConstants;
import com.sqs.errorlibary.dict.ErrorReason;
import com.sqs.errorlibary.exception.GlobalException;
import com.sqs.errorlibary.model.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    protected ResponseEntity<Object> handleGlobalException(GlobalException ex){
        System.out.println(" #  handleGlobalException 11111");
        setErrorDetailRequired(false);
        ErrorReason reason=ErrorReason.fromKey((Enum<?>) ex.getErrorReason());
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setStatusCode(Integer.toString(HttpStatus.valueOf(reason.getHttpStatus()).value()));
        //rorResponse.setStatusCode("OK");
        errorResponse.setError(setFDXErrorObject(reason));
        return createErrorResponse(ex,errorResponse);

    }

    private ResponseEntity<Object> createErrorResponse(GlobalException ex, ErrorResponse errorResponse) {
        System.out.println(" #  handleGlobalException 22222");
        ErrorReason reason=ErrorReason.fromKey((Enum<?>) ex.getErrorReason());
        System.out.println(" Message >>>> "+reason.getMessage());
        System.out.println(" ex.getDebugValues() :::"+ex.getDebugValues());

        Map<DEBUG_CONSTANTS,String> replacingValues=ex.getDebugValues();

        if(null!=replacingValues){
            replacePlaceHolderValues(errorResponse,replacingValues);
        }

        return getResponseEntity(ex,errorResponse,reason);
    }

    private void replacePlaceHolderValues(ErrorResponse errorResponse, Map<DEBUG_CONSTANTS, String> replacingValues) {
        replacingValues.put(DEBUG_CONSTANTS.TIMESTAMP, OffsetDateTime.now().toString());
        System.out.println(" replacePlaceHolderValues >>>>>");
        for(DEBUG_CONSTANTS key: replacingValues.keySet()){
            System.out.println("00000000000");
            if(null !=errorResponse.getError().getMessage()
                    && errorResponse.getError().getMessage().contains(" {"+key.getValue()+"}")
                    && (!replacingValues.get(key).isEmpty())){
                System.out.println("1111111111111111111111111");
                errorResponse.getError().
                        setMessage(errorResponse.getError().getMessage().replace(" {"+key.getValue()+"}",replacingValues.get(key)));
            }
            if(null !=errorResponse.getError().getDebugMessage()
              && errorResponse.getError().getMessage().contains(" {"+key.getValue()+"}")
                    && (!replacingValues.get(key).isEmpty())
            ){
                System.out.println("2222222222222222222222222222222");
                errorResponse.getError().
                        setDebugMessage(errorResponse.getError().getDebugMessage().replace(" {"+key.getValue()+"}",replacingValues.get(key)));
            }
        }
    }

    public ResponseEntity getResponseEntity(GlobalException ex, ErrorResponse errorResponse,ErrorReason errorReason){
        System.out.println(" #  getResponseEntity 3333");
        if(ex.getErrorDetail()!=null){
            String interaction_id=ex.getDebugValues().get(DEBUG_CONSTANTS.INTERACTION_ID);

        }
        if(ErrorConstants.isErrorDetailRequired && ex.getErrorDetail()!=null){
            errorResponse.setErrorDetail(ex.getErrorDetail());
            System.out.println(" 44444444444");
            return new ResponseEntity(errorResponse,HttpStatus.valueOf(errorReason.getHttpStatus()));
        }else{
            System.out.println(" 5555555555555");
            return new ResponseEntity(errorResponse.getError(),HttpStatus.valueOf(errorReason.getHttpStatus()));
        }


    }

    public void setErrorDetailRequired(boolean isReq){
        ErrorConstants.isErrorDetailRequired=isReq;
    }

    public  com.sqs.errorlibary.model.Error setFDXErrorObject(ErrorReason reason){
        System.out.println(" RRRRRRRRRRRR:"+reason.toString());
        com.sqs.errorlibary.model.Error error=new com.sqs.errorlibary.model.Error();
        error.setCode(reason.getStatus());
        error.setMessage(reason.getMessage());
        error.setDebugMessage(reason.getDebugMessage());
      //  if(isDebugMsgRequired){

       // }
        return error;

    }
}
