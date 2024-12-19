package chapter13.Practice.service;

/*      도서 관리 시스템의 비즈니스 로직을 인터페이스화

*/


import java.util.List;

public interface BookManager<T> {

    void addBook(T book);
    List<T> listAllBooks(); // 전체 조회
    T findBookById(int id); // 단권 조회
    void updateBook(int id, T updateBook);
    void removeBook(int id);

}
