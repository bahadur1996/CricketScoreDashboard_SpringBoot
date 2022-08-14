package com.backendcode.assignment.serviceimpl;

import com.backendcode.assignment.entity.ItemEntity;
import com.backendcode.assignment.mapper.ItemMapper;
import com.backendcode.assignment.model.Item;
import com.backendcode.assignment.repository.ItemRepository;
import com.backendcode.assignment.service.ItemService;
import com.backendcode.assignment.util.ListResultBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<Item> saveItems(List<Item> items) {

        List<ItemEntity> itemEntities = itemRepository.saveAll(ListResultBuilder.build(items,itemMapper.modelToEntity()));
        items = ListResultBuilder.build(itemEntities, itemMapper.entityToModel());
        return items;
    }

    @Override
    public List<Item> getItems(Integer noOfItems, String queryParam) {

        return Objects.isNull(queryParam) ? getLatestItems(noOfItems) : getItemsByQueryParam(queryParam);

    }
    public List<Item> getLatestItems(Integer noOfItems){
        List<ItemEntity> itemEntities = itemRepository.findTopItems(noOfItems);
        return ListResultBuilder.build(itemEntities, itemMapper.entityToModel());
    }
    public List<Item> getItemsByQueryParam(String queryString){
        List<ItemEntity> itemEntities = itemRepository.findByTitleContainingIgnoreCaseOrLinkContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrGuidContainingIgnoreCaseOrderByIdDesc(queryString, queryString, queryString, queryString);
        return ListResultBuilder.build(itemEntities, itemMapper.entityToModel());
    }
}
