package chapter10.Practice2.repository;

import chapter10.Practice2.entity.Item;

import java.util.HashSet;
import java.util.Set;

public class InMemoryItemRepository implements ItemRepository {
    private Set<Item> items = new HashSet<>();

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void removeItem(String itemId) {
        Item target = null;

        for (Item items : items) {

            if (items.getId().equals(itemId)) { // 입력한 ID 값이 itemId 와 일치한다면
                target = items;                 // 타겟터 값에 items 를 넣고
                break;                          // 종료
            }
        }

        if (target != null) {                   // 타겟터 값에 아이템 값이 아니라면 ( 타겟터 값에 아이템이 들어갔다면)
            items.remove(target);               // 아이템 타겟터 값을 삭제한다
        }

    }

    @Override
    public Item findById(String itemId) {

        for (Item item : items) {
            if (item.getId().equals(itemId)) {  // 사용자가 입력한 ID 값이 itemId와 일치한다면
                return item;                    // 해당 item 객체를 반환 한다
            }
        }
        return null;                            // 일치하는 값이 없다면 null 값을 넣어준다.
    }


    @Override
    public Set<Item> findAll() {
        return new HashSet<>(items);
    }
}
