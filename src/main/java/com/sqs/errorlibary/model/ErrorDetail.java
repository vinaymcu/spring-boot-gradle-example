package com.sqs.errorlibary.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetail {
    private String serviceName= "OBP_SERVICE_NAME";
    private String errorStatus=null;
    private String errorReason=null;

}
