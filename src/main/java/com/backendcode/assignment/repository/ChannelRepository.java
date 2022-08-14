package com.backendcode.assignment.repository;

import com.backendcode.assignment.entity.ChannelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<ChannelEntity, Long> {
    ChannelEntity findByPubTimestamp(Long pubTimestamp);
}
