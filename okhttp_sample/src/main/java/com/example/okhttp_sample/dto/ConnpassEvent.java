package com.example.okhttp_sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ConnpassEvent {

    @JsonProperty("results_returned")
    private int displayedResult;
    @JsonProperty("results_available")
    private int totalResultCount;
    @JsonProperty("results_start")
    private int currentPage;
    @JsonProperty("events")
    private List<Event> events;

    @Data
    public static class Event {
        @JsonProperty("event_id")
        private int eventId;
        @JsonProperty("title")
        private String title;
        @JsonProperty("catch")
        private String remark;
        @JsonProperty("description")
        private String description;
        @JsonProperty("event_url")
        private String eventUrl;
        @JsonProperty("hash_tag")
        private String twitterHashTag;
        @JsonProperty("started_at")
        private String startedAt;
        @JsonProperty("ended_at")
        private String endedAt;
        @JsonProperty("limit")
        private int limit;
        @JsonProperty("event_type")
        private String eventType;
        @JsonProperty("series")
        private Series series;
        @JsonProperty("address")
        private String address;
        @JsonProperty("place")
        private String place;
        @JsonProperty("lat")
        private double lat;
        @JsonProperty("lon")
        private double lon;
        @JsonProperty("owner_id")
        private int ownerId;
        @JsonProperty("owner_nickname")
        private String ownerNickName;
        @JsonProperty("owner_display_name")
        private String ownerDisplayName;
        @JsonProperty("accepted")
        private int attendeeCount;
        @JsonProperty("waiting")
        private int waiterCount;
        @JsonProperty("updated_at")
        private String updatedAt;
    }

    @Data
    public static class Series {
        @JsonProperty("id")
        private int id;
        @JsonProperty("title")
        private String title;
        @JsonProperty("url")
        private String url;
    }
}
