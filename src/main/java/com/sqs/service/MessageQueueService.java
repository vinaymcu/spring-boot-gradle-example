package com.sqs.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import com.sqs.model.ExpenseRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageQueueService {

    @Value("${app.config.message.queue.topic}")
    private String messageQueueTopic;

    private final AmazonSQS amazonSQSClient;

    public void createMessageQueue() {
        log.info("Creating message queue on AWS SQS");
        CreateQueueRequest request = new CreateQueueRequest();
        request.setQueueName(messageQueueTopic);
        try {
            CreateQueueResult queue = amazonSQSClient.createQueue(request);
            log.info("Create Queue Response {}", queue.getQueueUrl());
        } catch (QueueNameExistsException e) {
            log.error("Queue Name Exists {}", e.getErrorMessage());
        }
    }

    public void publishExpenseWithDeadLetterQueue(ExpenseRequest createExpenseDto) {
        try {
            GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(messageQueueTopic);
            log.info("Reading SQS Queue done: URL {}", queueUrl.getQueueUrl());
            String dl_queue_name = "test_dl_queue";
            amazonSQSClient.createQueue(dl_queue_name);
            String dl_queue_url = amazonSQSClient.getQueueUrl(dl_queue_name)
                    .getQueueUrl();

            GetQueueAttributesResult queue_attrs = amazonSQSClient.getQueueAttributes(
                    new GetQueueAttributesRequest(dl_queue_url)
                            .withAttributeNames("QueueArn"));
            String dl_queue_arn = queue_attrs.getAttributes().get("QueueArn");

            String src_queue_url = amazonSQSClient.getQueueUrl(messageQueueTopic)
                    .getQueueUrl();

            SetQueueAttributesRequest request = new SetQueueAttributesRequest()
                    .withQueueUrl(src_queue_url)
                    .addAttributesEntry("RedrivePolicy",
                            "{\"maxReceiveCount\":\"5\", \"deadLetterTargetArn\":\""
                                    + dl_queue_arn + "\"}");

            amazonSQSClient.setQueueAttributes(request);

            System.out.println("--------end dl queue-----------------------------");
            SendMessageRequest sendMessageRequest=new SendMessageRequest();
            sendMessageRequest.setQueueUrl(queueUrl.getQueueUrl());
            sendMessageRequest.setMessageBody(createExpenseDto.toString());
            sendMessageRequest.setDelaySeconds(1);
            amazonSQSClient.sendMessage(sendMessageRequest);
            log.info(" ************************************");
        } catch (QueueDoesNotExistException | InvalidMessageContentsException e) {
            log.error("Queue does not exist {}", e.getMessage());
        }

    }


    public void publishExpense(ExpenseRequest createExpenseDto) {
        try {
            GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(messageQueueTopic);
            log.info("Reading SQS Queue done: URL {}", queueUrl.getQueueUrl());
            log.info(" after sent the SQS Data >>>>>");
            SendMessageRequest sendMessageRequest=new SendMessageRequest();
            sendMessageRequest.setQueueUrl(queueUrl.getQueueUrl());
            sendMessageRequest.setMessageBody(createExpenseDto.toString());
            sendMessageRequest.setDelaySeconds(1);
            amazonSQSClient.sendMessage(sendMessageRequest);
            log.info(" ************************************");
        } catch (QueueDoesNotExistException | InvalidMessageContentsException e) {
            log.error("Queue does not exist {}", e.getMessage());
        }
    }
}
