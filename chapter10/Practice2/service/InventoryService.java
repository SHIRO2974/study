package chapter10.Practice2.service;

import chapter10.Practice2.entity.Item;

import java.util.List;

public interface InventoryService {
    void addItem(Item item);
    void updateItemPrice(String itemId, int newPrice);
    void deleteItem(String itemId);
    List<Item> getItemsByCategory(String category);
}
