package com.backendcode.assignment.service;

import com.backendcode.assignment.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> saveItems(List<Item> items);
    List<Item> getItems( Integer noOfItems, String queryParam);
}
