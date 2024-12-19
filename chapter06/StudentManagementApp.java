package chapter06;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;

class Student {
        // 객체
        int studentId;  // 학생 ID
        String name;    // 학생 이름
        int age;    // 학생 나이
        String major;   // 전공
        double gpa; // 평균 학점

        // 메서드
        void printStudentInfo() {
            System.out.println("ID: " + studentId + ", Name: " + name + ", Age: " + age + ", Major: " + major + ", GPA: " + gpa);
        }

        public void updataGpa(double newGpa) {
            this.gpa = newGpa;
        }

        // 사용자 정의
        Student() {
            this.studentId = 0;
            this.name = "Unknown";
            this.age = 0;
            this.major = "Undeclared";
            this.gpa = 0.0;


        }

        Student(int studentId, String name, int age, String major, double gpa) {
            this.name = name;
            this.gpa = gpa;
            this.studentId = studentId;
            this.major = major;
            this.age = age;

        }

        Student(int studentId, String name, int age) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;

        }
    }


//      학생 관리 시스템
public class StudentManagementApp {
    /*           메인 메서드
       Java 프로그램이 실행될 때 가장 먼저 호출되는 메서드

       public: JVM 이 외부에서 해당 메서드를 호출할 수 있도록 설정
        프로그램이 시작 시 JVM 이 접근해야하기 때문에 반드시 설정

        static: 정적 메서드, 인스턴스 생성 없이 호출됨
                JVM 이 클래스의 객체를 생성하지 않고도 메서드를 직접 호출하기 위해 필요

*/
   static ArrayList<Student> studentList = new ArrayList<>();
    public static void main(String[] args) {
        // 학생 추가
        addStudent(1, "이재현", 28, "GPT반", 4.0);
        addStudent(2, "아무개", 24, "IOT반", 3.0);
        addStudent(3, "홍길동", 25, "GPT반", 3.5);
        addStudent(4, "이무진", 21, "빅데이터반", 3.2);

        printAllStudents();

        findStudentById(5);

        updateStudentGpa(4,3.9);
        updateStudentGpa(2,4.0);
        printAllStudents();
    }

/*        static 메서드인 이유!
            : static 메서드는 인스턴스 없이 클래스 자체에서 직접호출!
            main 메서드 내부에서 다른 메서드를 호출하려면 해당 메서드는 static 이어야 함!
    */
    // 학생 등록
    static void  addStudent(int id, String name, int age, String maJor, double gpa) {
        Student student = new Student(id, name, age, maJor, gpa);
        studentList.add(student);
        System.out.println("학생이 등록되었습니다.");
    }
    // 모든 학생 출력
    static void printAllStudents() {
        System.out.println(" === 전체 학생 목록 ===");
        for (Student student : studentList) {
            student.printStudentInfo();
        }

    }

    // 학생 검색
    static void findStudentById(int studentId){
        for (Student student : studentList) {
            if (student.studentId == studentId) {
                student.printStudentInfo();
                return;
            }
        }
        System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
    }

    // 학생 평점 업데이트
    static void updateStudentGpa(int studentId, double newGpa) {
        for (Student student : studentList) {
            if (student.studentId == studentId) {
                student.updataGpa(newGpa);
                System.out.println("평점이 업데이트 되었습니다.");
                return;
            }
        }
        System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
    }

    }

