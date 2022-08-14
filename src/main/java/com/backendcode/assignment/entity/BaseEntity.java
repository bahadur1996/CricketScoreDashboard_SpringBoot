package com.backendcode.assignment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@MappedSuperclass
public class BaseEntity {
    @Column(updatable = false)
    private Long created = Instant.now().toEpochMilli();
    private Long updated = Instant.now().toEpochMilli();
}

