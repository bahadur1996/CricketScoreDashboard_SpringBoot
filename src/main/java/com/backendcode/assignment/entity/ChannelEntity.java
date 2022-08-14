package com.backendcode.assignment.entity;

import com.backendcode.assignment.model.Item;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(indexes = @Index(name = "pubTimestamp", columnList = "pubTimestamp"))
public class ChannelEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer ttl;
    private String link;
    private String description;
    private String copyright;
    private String language;
    @Column(unique = true)
    private Long pubTimestamp;
}
