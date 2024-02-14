package com.sqs.errorlibary.exception;

import com.sqs.errorlibary.dict.ErrorReasonData;
import com.sqs.errorlibary.model.ErrorDetail;
import com.sqs.errorlibary.model.ErrorResponse;

import java.util.Map;

public class CommonGlobalExeption extends GlobalException {
    public CommonGlobalExeption(ErrorReasonData errorReason) {
        super(errorReason);
    }

    public CommonGlobalExeption(ErrorReasonData errorReason, Map<DEBUG_CONSTANTS, String> debugValues) {
        super(errorReason, debugValues);
    }

    public CommonGlobalExeption(ErrorReasonData errorReason, ErrorDetail errorDetail, Map<DEBUG_CONSTANTS, String> debugValues) {
        super(errorReason, errorDetail, debugValues);
    }

    public CommonGlobalExeption(ErrorResponse errorResponse) {
        super(errorResponse);
    }
}
