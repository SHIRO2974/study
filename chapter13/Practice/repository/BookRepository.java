package chapter13.Practice.repository;



import chapter13.Practice.model.Book;

import java.util.ArrayList;
import java.util.List;

// 도서를 저장하고 검색 및 삭제하는 데이터 베이스
public class BookRepository {

    private List<Book> books = new ArrayList<>();   // 데이터베이스

    public void save(Book book) {
        books.add(book);    // 북스 리스트에 저장
    }

    public void deleteById(int id) {
/*      Book bookToRemove = null;   // 삭제할 책 담기

        for (Book book : books) {

            if (book.getId() == id) {
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {
            books.remove(bookToRemove);
        }
    }
*/
        for (Book book : books) {

            if (book.getId() == id) {

                books.remove(book);
                break;
            }
        }
    }

    public Book findById(int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                return book;
            }
        }
        return null;    // 해당 ID 의 책이 없을 경우
    }

    public List<Book> findAll() {
        return books;
    }

}
