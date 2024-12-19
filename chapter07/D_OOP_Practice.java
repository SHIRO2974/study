package chapter07;

// 도서 관리 시스템
    class Book {
       private String title;    // 책 제목
       private  String author;  // 책 저자
       private  boolean isAvailable = true; // 책 대여 및 반납

        // 사용자 정의
       Book(String title, String author) {
           this.title = title;
           this.author = author;
       }

       void borrowBook() {
           if (isAvailable) {
               isAvailable = false;
               System.out.println(" 책 대여가 성공적으로 완료되었습니다.");
           }else {
               System.out.println("현재 대여 중입니다.");
           }
       }

       // 책 반납 메서드
        public final void returnBook() {
           if(!isAvailable) {
               // 책이 대여중인 상태
               isAvailable = true;
               System.out.println("책 반납이 성공적으로 완료되었습니다.");
           }else {
               System.out.println("이미 반납된 상태입니다.");
           }
        }

        // 책 정보 출력 메서드
        void displayInfo() {
            System.out.println("제목: " + title + ", 저자: " + author + ", 대여 가능 여부: " + (isAvailable ? "대여 가능" : "대여중"));
        }

}
    class Ebook extends Book {

        private double fileSize;

        Ebook(String title, String author, double fileSize) {
            super(title, author);
            this.fileSize = fileSize;
        }

        // 오버라이딩 책 정보출력
        @Override
        void displayInfo() {
            super.displayInfo(); // 부모 클래스의 메서드 호출
            System.out.println("파일 크기: " + fileSize + "MB");
        }

    }


public class D_OOP_Practice {
    public static void main(String[] args) {
        // Book 객체 생성
        Book book1 = new Book("작별하지 않는다.", "한강");
        book1.displayInfo();   // 제목: 작별하지 않는다., 저자: 한강, 대여 가능 여부: 대여 가능
        book1.borrowBook();    // 책 대여가 성공적으로 완료되었습니다.
        book1.borrowBook();    // 현재 대여 중입니다.
        book1.returnBook();    // 책 반납이 성공적으로 완료되었습니다.
        book1.returnBook();    // 이미 반납된 상태입니다.

        // Ebook 객체 생성
        Ebook ebook = new Ebook("달러구트 꿈 백화점", "이미예", 867.00);
        ebook.displayInfo();    // 제목: 달러구트 꿈 백화점, 저자: 이미예, 대여 가능 여부: 대여 가능 파일 크기: 867.0MB
        ebook.borrowBook();     // 책 대여가 성공적으로 완료되었습니다.



    }
}
