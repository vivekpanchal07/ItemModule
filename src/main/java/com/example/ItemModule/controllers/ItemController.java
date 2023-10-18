package com.example.ItemModule.controllers;

import com.example.ItemModule.models.Item;
import com.example.ItemModule.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/items")
public class ItemController implements iItemController{
    @Autowired
    private ItemService itemService;

    @PostMapping
    @Override
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @GetMapping("/{id}")
    @Override
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping
    @Override
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @PutMapping("/{id}")
    @Override
    public Item updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        return itemService.updateItem(id, updatedItem);
    }

    @DeleteMapping("/{id}")
    @Override
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
