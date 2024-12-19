package chapter10.Practice2.repository;

import chapter10.Practice2.entity.Item;

import java.util.HashSet;
import java.util.Set;

public interface ItemRepository {
    void addItem(Item item);
    void removeItem(String itemId);
    Item findById(String itemId);
    Set<Item> findAll();
}


