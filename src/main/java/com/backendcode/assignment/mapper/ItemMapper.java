package com.backendcode.assignment.mapper;

import com.backendcode.assignment.entity.ItemEntity;
import com.backendcode.assignment.model.Item;
import com.backendcode.assignment.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ItemMapper {
    private final ChannelRepository channelRepository;

    public EntityModelMapper<ItemEntity, Item> entityToModel(){
        return entity-> new Item()
                .setId(entity.getId())
                .setDescription(entity.getDescription())
                .setGuid(entity.getGuid())
                .setLink(entity.getLink())
                .setTitle(entity.getTitle())
                .setChannelId(entity.getChannel().getId());
    }

    public EntityModelMapper<Item, ItemEntity> modelToEntity(){
        return model -> new ItemEntity()
                .setId(model.getId())
                .setGuid(model.getGuid())
                .setDescription(model.getDescription())
                .setLink(model.getLink())
                .setTitle(model.getDescription())
                .setChannel(channelRepository.findById(model.getChannelId()).get());
    }
}
