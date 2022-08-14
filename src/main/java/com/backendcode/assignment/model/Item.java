package com.backendcode.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class Item {
    @JsonIgnore
    private Long id;
    private String title;
    private String link;
    private String description;
    private String guid;
    @JsonIgnore
    private Long channelId;
}
