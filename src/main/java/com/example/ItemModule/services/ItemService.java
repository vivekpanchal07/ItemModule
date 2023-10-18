package com.example.ItemModule.services;

import com.example.ItemModule.exceptions.ResourceNotFoundException;
import com.example.ItemModule.models.Item;
import com.example.ItemModule.repositories.iItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService implements iItemService{
    @Autowired
    private iItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No Element with such ID")
        );
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItem(Long id, Item updatedItem) {
        if (itemRepository.existsById(id)) {
            updatedItem.setId(id);
            return itemRepository.save(updatedItem);
        }else{
            throw new ResourceNotFoundException("No Element with such ID");
        }
    }

    @Override
    public void deleteItem(Long id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        }else{
            throw new ResourceNotFoundException("No Element with such ID");
        }
    }
}
