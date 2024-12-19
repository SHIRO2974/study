package chapter10.Practice;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LibraryManager implements Manageable {

    private List<Item> items = new ArrayList<>();

    @Override
    public void add(Item item) {

        items.add(item);
        System.out.println("Item added: " + item.getName());
    }

    @Override
    public void remove(String id) {

        boolean removed = false;    // 삭제 여부 확인용 데이터

        int size = items.size();
        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getId().equals(id)) { // 입력한 id 와 items id 가 같다면

                items.remove(i);    // 해당 아이템을 리스트에서 제거
                removed = true;     // 삭제 확인
                System.out.println("Item with ID: " + id + " removed"); // 삭제된 아이템의 ID를 출력
                break;
            }
        }
        if (!removed) {     // 해당 id를 가진 아이템이 없다면
            System.out.println("No item found with ID: " + id); // 아이템을 찾지 못했을때 출력
        }
    }

    @Override
    public List<Item> search(String keyword) {
        List<Item> foundItems = new ArrayList<>();

        for (Item item : items) {

            if (item.getName().contains(keyword)    // 아이템 이름과 키워드 이름이 포함되었거나
                || (item instanceof Book && ((Book)item).getAuthor().contains(keyword)
            && ((Book)item).getPublisher().contains(keyword)))      // 아이템이 북 클래스의 인스턴스라면
                                                                    // 다운캐스팅하여 책 저자 이름과 출판사 이름에
                                                                    // 모두 키워드가 있는지 확인
            {
                foundItems.add(item);   // 조건을 만족하는 item 을 결과 리스트에 추가
            }
        }
        if (foundItems.isEmpty()) {
            // 배열.isEmpty(): 비워진 경우 true 반환
            throw new NoSuchElementException("No item found for keyword: " + keyword);
        }
        return foundItems;
    }

    @Override
    public List<Item> searchByCategory(String category) {
        List<Item> result = new ArrayList<>();

        for (Item item : items) {

            if (item instanceof Book && ((Book)item).getCategory().equalsIgnoreCase(category)){
                result.add(item);  //아이템이 Book 클래스의 인스턴스인지 확인 후,
                                  // 맞다면 다운캐스팅하여 객체의 카테고리가
                                 // 사용자가 정의한 카테고리와 일치하는지 확인
            }
        }
        return result;  // 조건을 만족하는 아이템을 리스트에 추가한다
    }

    @Override
    public List<Item> searchByPriceRange(int mimPrice, int maxPrice) {
        List<Item> result = new ArrayList<>();

        for (Item item : items) {

            if (item instanceof Book) {                         // item 이 Book 클래스의 인스턴스라면

                int price = ((Book)item).getPrice();            // Book 객체로 다운캐스팅하여 Price 값을 입력
                if (price >= mimPrice && price <= maxPrice) {   // price 가 mimPrice 보다 크거나 같고
                                                                // maxPrice 보다 값이 작거나 같다면
                    result.add(item);                           // 조건을 만족하는 item 을 리스트에 추가한다
                }
            }
        }
        return result;  // 조건에 맞는 모든 item 을 포함한 리스트를 반환
    }


    @Override
    public void updateStock(String id, int quantity) {
        for (Item item : items) {

            if (item.getId().equals(id) && item instanceof Book) {  // 입력한 Id 값이 item id 값이 일치하고
                                                                    // item 이 Book 클래스 인스턴스라면
                ((Book)item).updateStock(quantity);                 // Book 클래스로 다운캐스팅하여 재고를 수정한다
                System.out.println("Stock updated for ID: " + id + ((Book)item).getStock());
                return;
            }
        }
        System.out.println("No item found with ID: + " + id);   // ID가 일치하는 item 이 없으면 해당 메시지 출력
    }

    public void listAll() {

        if (items.isEmpty()) {       // items 가 비어 있다면
            System.out.println("no items in the library");  // "라이브러리에 아이템이 없습니다"라는 메시지를 출력

        } else {
            System.out.println("=== Library Items ===");    // "라이브러리 아이템 목록"을 출력

            for (Item item : items){    // items 리스트에 있는 각 item 을 순차적으로 반복
               item.display();          // item 을 출력한다
            }
        }
    }
}
