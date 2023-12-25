package com.producer.controller;

import com.producer.service.SenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {
    private final SenderService senderService;
    @GetMapping("/send")
    public void send(@RequestParam("key") String key, @RequestParam("value") String value) {
        senderService.sendMessage(key, value);
    }
}
