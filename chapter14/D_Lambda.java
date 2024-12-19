package chapter14;

import java.util.ArrayList;
import java.util.List;
/*      람다 표현식

        함수형 인터페이스
        단 하나의 추상 메서드만 가지는 인터페이스
        @FunctionalInterface 어노테이션
        - 디폴트 메서드, static 메서드는 포함가능

        1. 람다식 기본 형태
           (params) -> {실행문}

        1)  파라미터: 함수형 인터페이스에서 메서드와 동일한 파라미터를 사용
        2)  화살표 연산자(->): 파라미터와 실행문(바디)을 구분

           일반 메서드 (함수)
           반환타입 메서드명(params) {실행문}
*/
@FunctionalInterface
interface MyFunctionalInterface {

    void doSomething();
//  void anotherDoSomething();
//  @FunctionalInterface 는 하나의 추상 메서드만 가짐
}

// === 람다식 사용 예제 ===
// 1) 기본 표현: 여러 개의 파라미터, 하나의 실행문
interface Calculator {
    int add(int a, int b);
}

// 2) 파라미터가 없는 경우
@FunctionalInterface
interface NoParams {
    void sayHello();
}

// 파라미터가 한 개인 경우: 소괄호 생략 가능
@FunctionalInterface
interface OneParam {
    void print(String message);
}

// 4) 실행문이 여러 줄인 경우: 중괄호 작성
@FunctionalInterface
interface Operation {
    void operation(int a, int b);
}

// 5) 반환값이 있는 경우
@FunctionalInterface
interface StringLength {
    int getLength(String str);
}

public class D_Lambda {
    public static void main(String[] args) {

        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("안녕");
        myFunctionalInterface.doSomething();    // 안녕

//      익명 클래스 방식
        Calculator calculator = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        System.out.println("익명 클래스 결과: " + calculator.add(3, 5));   // 익명 클래스 결과: 8

//      람다 방식
//      1) 기본 형태
        Calculator calculator2 = (a, b) -> a + b;
        System.out.println("람다식 결과: " + calculator2.add(3, 5)); // 람다식 결과: 8

//      2) 파라미터가 없는 형태
        NoParams noParams = () -> System.out.println("안녕하세요");
        noParams.sayHello();    // 안녕하세요

//      3) 파라미터가 하나인 형태
        OneParam oneParam = message -> System.out.println("출력 메세지: " + message);
        oneParam.print("안녕");   // 출력 메세지: 안녕

//      4) 출력문이 여러 줄인 방식
        Operation operation = (a, b) -> {
            System.out.println("합: " + (a + b));
            System.out.println("차: " + (a - b));
        };
        operation.operation(1, 2);
//        합: 3
//        차: -1


//      5) 반환값이 있는 형태
        StringLength stringLength = str -> str.length();
        System.out.println("문자열 길이: " + stringLength.getLength("Lambda"));  // 문자열 길이: 6
//      여러 줄의 코드가 실행문에 작성될 경우 return 필요

        List<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(2);
        number.add(3);

        System.out.println(number); // [1, 2, 3]

        for (Integer num : number) {
            System.out.println(num);
        }

        // 입력 값을 받아 소비(출력 & 상태 변경) 하는 데 사용
        number.forEach(num -> System.out.println(num));

    }
}

