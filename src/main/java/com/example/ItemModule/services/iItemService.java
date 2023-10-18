package com.example.ItemModule.services;

import com.example.ItemModule.models.Item;

import java.util.List;

public interface iItemService {
    Item createItem(Item item);
    Item getItemById(Long id);
    List<Item> getAllItems();
    Item updateItem(Long id, Item updatedItem);
    void deleteItem(Long id);
}
