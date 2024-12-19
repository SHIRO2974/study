package chapter12;

/*      도서 관리 시스템
        1. 새로운 도서 추가
        2. 모든 도서의 정보 출력
        3. 도서 검색 (도서 제목으로 검색)

        model (도서 정보 담당)
        Book  클래스 (제목, 저자, 출판사)

        view (사용자 인터페이스 UI 담당)
        Book view 클래스
            (사용자의 입력을 받아, Controller 에서 받은 정보를 출력

        Controller (사용자의 입력을 받아 Model 과 View 사이에서 중재)
        BookController 클래스
            (사용자의 입력에 따라 적절한 Model 메서드를 호출)
*/


import chapter12.model.Book;
import chapter12.view.BookView;

public class Main {
    BookView bookView = new BookView();



}
