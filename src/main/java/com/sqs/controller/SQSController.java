package com.sqs.controller;

import com.sqs.model.AppResponse;
import com.sqs.model.Customer;
import com.sqs.model.ExpenseRequest;
import com.sqs.service.MessageQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sqs")
public class SQSController {

    @Autowired
    MessageQueueService messageQueueService;
    @PostMapping("publish")
    public ResponseEntity<AppResponse> saveCustomer(@RequestBody ExpenseRequest expenseRequest) {
        System.out.println("Publish Title " + expenseRequest.getType());

        messageQueueService.publishExpense(expenseRequest);
        AppResponse appResponse = new AppResponse();
        //appResponse.setArticleId(art.getArticleId());
        appResponse.setStatusCode(HttpStatus.OK.name());
        appResponse.setMessage("Publish Expense is " );
        return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
    }
}
