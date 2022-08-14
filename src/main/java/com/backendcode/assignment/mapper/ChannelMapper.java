package com.backendcode.assignment.mapper;

import com.backendcode.assignment.entity.ChannelEntity;
import com.backendcode.assignment.entity.ItemEntity;
import com.backendcode.assignment.model.Channel;
import com.backendcode.assignment.model.Item;
import com.backendcode.assignment.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class ChannelMapper {

    public EntityModelMapper<ChannelEntity, Channel> entityToModel(){
        return entity-> new Channel()
                .setId(entity.getId())
                .setDescription(entity.getDescription())
                .setLink(entity.getLink())
                .setTitle(entity.getTitle())
                .setCopyright(entity.getCopyright())
                .setLanguage(entity.getLanguage())
                .setTtl(entity.getTtl())
                .setPubTimestamp(entity.getPubTimestamp());
    }

    public EntityModelMapper<Channel, ChannelEntity> modelToEntity(){
        return model -> new ChannelEntity()
                .setId(model.getId())
                .setDescription(model.getDescription())
                .setCopyright(model.getCopyright())
                .setLanguage(model.getLanguage())
                .setTtl(model.getTtl())
                .setPubTimestamp(model.getPubTimestamp())
                .setLink(model.getLink())
                .setTitle(model.getTitle());
    }
}
