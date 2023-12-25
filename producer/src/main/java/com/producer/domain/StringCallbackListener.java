package com.producer.domain;

import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class StringCallbackListener implements ListenableFutureCallback<SendResult<String, String>> {
    @Override
    public void onFailure(Throwable ex) {
        System.out.println("Failed " + ex.getMessage());
    }

    @Override
    public void onSuccess(SendResult<String, String> result) {
        if (result == null || result.getRecordMetadata() == null) {
            throw new RuntimeException("Cannot!");
        }
        System.out.println("Success! " + result.getRecordMetadata().topic() + "\nOffset: "
         + result.getRecordMetadata().offset() + "\nPartition: "
        + result.getRecordMetadata().partition());
    }
}
