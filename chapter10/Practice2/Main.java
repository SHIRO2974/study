package chapter10.Practice2;


/* 기능
    상품 추가 수정 삭제 카테고리별 검색 가격 또는 이름으로 정렬

    사용 컬렉션
    Set : 상품관리 (중복 상품 방지)
    Map : 카테고리별 상품 분류 ( Kye : 카테고리명, Value : 상품목록
    추상 클래스 (Item) 모든 상품의 공통 필드 포함
    인터페이스 : 할인 로직 제공
    +)

    CRUD (크루드)
    Create, Read, Update, Delete
    소프트웨어 개발에서 데이터를 처리하여 기본적인 네 가지 작업
*/

import chapter10.Practice2.entity.Electronics;
import chapter10.Practice2.entity.Furniture;
import chapter10.Practice2.entity.Item;
import chapter10.Practice2.repository.InMemoryItemRepository;
import chapter10.Practice2.service.InventoryService;
import chapter10.Practice2.service.InventoryServiceImIpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InventoryService inventoryService = new InventoryServiceImIpl(new InMemoryItemRepository());
       // Scanner scan = new Scanner(System.in);

        Item laptop = new Electronics(
                     "E001"
                , "Laptop"
                , 20000
                , 10
                , "Apple"
                , 12);

        Item laptop2 = new Electronics(
                     "E002"
                , "Laptop2"
                , 20000
                , 10
                , "Apple"
                , 12);


        inventoryService.addItem(laptop);
        inventoryService.addItem(laptop2);
        inventoryService.addItem(new Furniture("F001", "Sofa", 10000, 15
                , "Fabric"
                , "2인"));
        inventoryService.addItem(new Furniture("F002", "Sofa2", 20000, 14
                , "Fabric"
                , "4인"));


        // 카테고리별 상품 검색
        List<Item> electronics = inventoryService.getItemsByCategory("Electronics");
        List<Item> furniture = inventoryService.getItemsByCategory("Furniture");

        System.out.println("All Electronics");

        for (Item item : electronics){
            System.out.println(item);
        }
        System.out.println("All Furniture");

        for (Item item : furniture) {
            System.out.println(item);
        }

        inventoryService.updateItemPrice("E001",27000);
        System.out.println("Updated price");

        for (Item item : inventoryService.getItemsByCategory("Electronics") ) {
            System.out.println(item);
        }

    }
}
