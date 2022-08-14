package com.backendcode.assignment.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(indexes = @Index(name = "description", columnList = "description"))
public class ItemEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String link;
    private String description;
    private String guid;
    @ManyToOne
    @JoinColumn(name="channel_id", nullable=false)
    private ChannelEntity channel;
}
