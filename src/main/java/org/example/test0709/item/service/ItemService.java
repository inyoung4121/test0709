package org.example.test0709.item.service;

import org.example.test0709.item.entity.Item;
import org.example.test0709.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item updateItem(Long id, Item itemDetails) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            item.setTitle(itemDetails.getTitle());
            item.setContent(itemDetails.getContent());
            item.setPrice(itemDetails.getPrice());
            item.setUsername(itemDetails.getUsername());
            return itemRepository.save(item);
        }
        return null;
    }

    public boolean deleteItem(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
