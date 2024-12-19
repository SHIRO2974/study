package chapter14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//        == 컬렉션 프레임워크 & 스트림 API 람다 표현식 & 메서드 참조 ==


@AllArgsConstructor
@Getter
@ToString
class StudentClass {
    private String name;
    private int age;
    private double grade;


}
public class H_Practice {
    public static void main(String[] args) {

        // 1. 학생 목록 필터링 & 정렬
        List<StudentClass> studentClasses = Arrays.asList(
                new StudentClass("이재현", 24, 4.0),
                new StudentClass("아무개", 24, 3.0),
                new StudentClass("아무배", 24, 2.0)
        );

//      1-1. 학점이 3.0 이상인 학생 필터링
        List<StudentClass> filteredStudents = studentClasses.stream()
                .filter(studentClass -> studentClass.getGrade() >= 3.0)
                .collect(Collectors.toList());

        System.out.println("학점이 3.0 이상인 학생: ");
        filteredStudents.forEach(System.out::println);
//      StudentClass(name=이재현, age=24, grade=4.0)
//      StudentClass(name=아무개, age=24, grade=3.0)

//      1-2. 학생 이름 목록만 추출
        List<String> studentNames = studentClasses.stream()
//                .map(studentClass -> studentClass.getName())
                .map(StudentClass::getName)
                .collect(Collectors.toList());

        System.out.println("학생 이름 목록: ");
        System.out.println(studentNames);   // [이재현, 아무개, 아무배]

//      1-3. 학생들을 점수순으로 정렬
        List<StudentClass> sortedStudent = studentClasses.stream()
                // 컬렉션 프레임워크의 중간 연산: .sorted: (정렬)
                // Comparator 클래스의 .comparingDouble 정적 메서드 활용
                // 실수값 비교
                // StudentClass::getGrade
                .sorted(Comparator.comparingDouble(StudentClass::getGrade))
             // .sorted(Comparator.comparingDouble(StudentClass::getGrade)).reversed())
                .collect(Collectors.toList());

        System.out.println("점수 순으로 정렬: ");
        sortedStudent.forEach(System.out::println);
/*      StudentClass(name=아무배, age=24, grade=2.0)
        StudentClass(name=아무개, age=24, grade=3.0)
        StudentClass(name=이재현, age=24, grade=4.0)
*/
        // 1-4. 학생들 중 '지' 단어가 이름에 포함된 학생 필터링
        List<StudentClass> studentsWithJi = studentClasses.stream()
                .filter(studentClass -> studentClass.getName().contains("현"))
                .collect(Collectors.toList());

        System.out.println("이름에 '현'이 포함된 학생: ");
        studentsWithJi.forEach(System.out::println);
        // StudentClass(name=이재현, age=24, grade=4.0)

    }


}
