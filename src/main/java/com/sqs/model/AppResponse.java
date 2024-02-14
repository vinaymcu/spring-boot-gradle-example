package com.sqs.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppResponse {
    String statusCode;
    long articleId;
    public String message;


}
