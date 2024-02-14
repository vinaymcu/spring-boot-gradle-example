package com.sqs.controller;

import com.sqs.model.AppResponse;
import com.sqs.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @PostMapping("save")
    public ResponseEntity<AppResponse> saveCustomer(@RequestBody Customer customer) {
        System.out.println("saveArticle Title " + customer.getFirstName());
        AppResponse appResponse = new AppResponse();
        //appResponse.setArticleId(art.getArticleId());
        appResponse.setStatusCode(HttpStatus.OK.name());
        appResponse.setMessage("Create/Update Article is " );
        return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
    }
 @GetMapping("get")
 public ResponseEntity<AppResponse>   getCustomer() {
    // System.out.println("saveArticle Title " + customer.getFirstName());
     AppResponse appResponse = new AppResponse();
     //appResponse.setArticleId(art.getArticleId());
     appResponse.setStatusCode(HttpStatus.OK.name());
     appResponse.setMessage("Create/Update Article is " );
     return new ResponseEntity<AppResponse>(appResponse, HttpStatus.OK);
 }


}
