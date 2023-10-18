package com.example.ItemModule.repositories;

import com.example.ItemModule.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iItemRepository extends JpaRepository<Item, Long> {

}
