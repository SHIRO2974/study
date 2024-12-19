package chapter10.Practice;

// 도서 관리 시스템에서 관리 할 수 있는 동작 정의

import java.util.List;

public interface Manageable {
    void add(Item item);
    void remove (String id);
    List<Item> search(String keyword);
    List<Item> searchByCategory(String category);
    List<Item> searchByPriceRange(int mimPrice, int maxPrice);
    void updateStock(String id, int quantity);
    void listAll();
}
