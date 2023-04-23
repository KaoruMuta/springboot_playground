package com.example.okhttp_sample.repository;

import com.example.okhttp_sample.dto.ConnpassEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ConnpassRepositoryImpl implements ConnpassRepository {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public ConnpassEvent fetchEvent(String url) throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            final ResponseBody body = response.body();
            if (body == null) {
                throw new Exception("Response is null");
            }
            return mapper.readValue(body.string(), ConnpassEvent.class);
        }
    }
}
