package com.sqs.configuration;

import com.sqs.service.MessageQueueService;
import org.springframework.context.annotation.Configuration;
import lombok.RequiredArgsConstructor;
import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class AppConfiguration {

    private final MessageQueueService messageQueueService;

    @PostConstruct
    public void initializeMessageQueue() {
        messageQueueService.createMessageQueue();
    }

}
