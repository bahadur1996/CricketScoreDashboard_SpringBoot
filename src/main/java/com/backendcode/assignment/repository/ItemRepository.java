package com.backendcode.assignment.repository;

import com.backendcode.assignment.entity.ChannelEntity;
import com.backendcode.assignment.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
    List<ItemEntity> findByChannel(ChannelEntity channel);
    List<ItemEntity> findByTitleContainingIgnoreCaseOrLinkContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrGuidContainingIgnoreCaseOrderByIdDesc(String title, String link, String description, String guid);
    @Query(value="select * from itementity order by id desc limit ?1", nativeQuery = true)
    List<ItemEntity> findTopItems(Integer noOfItems);
}
