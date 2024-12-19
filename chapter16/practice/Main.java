package chapter16.practice;


import chapter16.practice.entite.Category;
import chapter16.practice.entite.Item;
import chapter16.practice.service.LibraryManager;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

// chapter 13 - practice (도서 관리 시스템에 Enum 자료형 사용 추가)
public class Main {
    public static void main(String[] args) {

        LibraryManager manager = new LibraryManager();
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("=== 라이브러리 시스템 ===");
            System.out.println("1. 카테고리 검색");

            System.out.println("Select an option: ");

            try {
                int choice = Integer.parseInt(scan.nextLine());
                // parseInt(String s)

                switch (choice) {

                    case 1:
                        System.out.print("카테고리를 검색하세요.");
                        String searchCategory = scan.nextLine();

                        try {
                           Category searchCategoryEnum =  Category.fromString(searchCategory);
                          List<Item> categoryResults = manager.searchByCategory(searchCategoryEnum);

                            if (categoryResults.isEmpty()) {
                                System.out.println("카테고리가 없습니다: " + searchCategoryEnum);

                            } else {
                                categoryResults.forEach(Item::display);
                            }

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("please enter a valid number");
                // serr: 인자 내의 문자열을 오류로 인식하고 출력

            } catch (NoSuchElementException e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
