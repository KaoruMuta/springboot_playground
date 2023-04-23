package com.example.okhttp_sample.repository;

import com.example.okhttp_sample.dto.ConnpassEvent;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnpassRepository {
    ConnpassEvent fetchEvent(final String url) throws Exception;
}
