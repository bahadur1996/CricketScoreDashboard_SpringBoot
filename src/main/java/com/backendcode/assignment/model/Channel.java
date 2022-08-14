package com.backendcode.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
@Setter
@Getter
@Accessors(chain = true)
public class Channel {
    @JsonIgnore
    private Long id;
    private String title;
    private Integer ttl;
    private String link;
    private String description;
    private String copyright;
    private String language;
    private String pubDate;
    @JsonIgnore
    private Long pubTimestamp;
    @JsonProperty("item")
    private List<Item> items;
}
