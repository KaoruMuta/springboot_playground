package com.example.okhttp_sample.controller;

import com.example.okhttp_sample.dto.ConnpassEvent;
import com.example.okhttp_sample.service.ConnpassService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConnpassController {

    private static final Logger logger = LoggerFactory.getLogger(ConnpassController.class);

    private final ConnpassService connpassService;

    @GetMapping("/event")
    public ConnpassEvent getEvent() throws Exception {
        logger.info("Response:{}", connpassService.fetchEvent());
        return connpassService.fetchEvent();
    }
}
