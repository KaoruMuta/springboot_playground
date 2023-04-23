package com.example.okhttp_sample.service;

import com.example.okhttp_sample.common.ConnpassConfiguration;
import com.example.okhttp_sample.dto.ConnpassEvent;
import com.example.okhttp_sample.repository.ConnpassRepository;
import com.example.okhttp_sample.repository.ConnpassRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class ConnpassService {

    private final ConnpassRepository connpassRepository;

    private final ConnpassConfiguration connpassConfiguration;

    public ConnpassService(final ConnpassConfiguration connpassConfiguration) {
        this.connpassRepository = new ConnpassRepositoryImpl();
        this.connpassConfiguration = connpassConfiguration;
    }

    public ConnpassEvent fetchEvent() throws Exception {
        return connpassRepository.fetchEvent(connpassConfiguration.getUrl());
    }
}
