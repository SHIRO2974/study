package chapter14;

// 학교 클래스
import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
class School {
    private String schoolName;

    // 내부 클래스
    @AllArgsConstructor
    class Student {
        private String studentName;
        private int studentId;

        public void displayInfo() {

            System.out.println("학교명: " + schoolName + ", 학생 이름: " + studentName
            + ", 학생 ID: " + studentId);
        }
    }

    // 내부 클래스 - 교장 선생님 (싱글톤 패턴)
    static class Principal {
        private static Principal instance;

        private Principal() {}

        public static Principal getInstance() {

            if (instance == null) {
                instance = new Principal();
            }
            return instance;
        }

        public void displayInfo() {
            System.out.println("어쩌구 저쩌구");
        }
    }
}

public class B_Inner {
    public static void main(String[] args) {

        School school = new School("아무초등학교");

        School.Student student1 = school.new Student("이재현", 123);
        student1.displayInfo(); // 학교명: 아무초등학교, 학생 이름: 이재현, 학생 ID: 123

        // Principal: static 내부 클래스로 외부 클래스의 인스턴스 없이
        // 내부 static 메서드 호출이 가능
        // >> getInstance() 내부의 new 연산자 사용으로 new 키워드 생략
        School.Principal principal = School.Principal.getInstance();
        principal.displayInfo();

    }
}
