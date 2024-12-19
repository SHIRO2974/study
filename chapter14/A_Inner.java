package chapter14;

/*      내부(중첩) 클래스 (Inner Class, Nested Class)
        다른 클래스 내부에 선언된 클래스를 의미

        == 장점 ==
         코드의 가독성 향상 - 코드의 구조 파악 용이
         클래스 간의 관계를 명확하게 함
         - 내부 클래스는 외부 클래스의 멤버(필드, 메서드)에 접근 가능

        == 종류 ==
         1. 인스턴스 내부 클래스 - 가장 기본적인 클래스 형태
            "외부 클래스의 인스턴스" 에 속함
            >> 외부 클래스의 인스턴스 변수 및 메서드에 직접 접근 O

         2. static 내부 클래스
            "외부 클래스의 정적 멤버에 속함
             >> 외부 클래스의 인스턴스 변수에 접근 X
             >> 외부 클래스의 정적 멤버에만 접근 O

         3. 지역 클래스
            "메서드 내에 정의된 내부 클래스"
            >> 해당 메서드 내에서만 사용 가능
            >> 메서드의 지역 변수에만 접근 가능
            로컬 변수(외부 클래스 멤버 변수)가 final 인 경우 접근 가능

         4. 익명 클래스
            이름이 없는 내부 클래스
            인터페이스나 추상 클래스의 구현에 사용
            >> 즉시 객체 생성 가능
            >> 클래스의 일회성으로 사용할 때 사용
*/
class OuterClass {
    private String outerFiele = "외부 클래스의 필드";
    static String staticField = "외부 클래스의 정적 필드";

    // 1. 인스턴스 내부 클래스 - 인스턴스 멤버처럼 사용
    class InnerClass {

        void display() {
            System.out.println("외부 클래스 필드에 접근: " + outerFiele);
        }
    }

    static class staticClass {
        void display() {
            // 외부 클래스의 정적 변수 사용 시: 클래스명. 생략 가능
            System.out.println("외부 클래스 정적필드에 접근: " + staticField);
        }
    }

    // 3. 지역 클래스
    void outerMethod() {
        String finalVar = "메서드 로컬 변수";  // 암묵적으로 final 간주
        final String localFinalVar = "메서드 로컬 변수(Final)";

        class MethodClass {

            void display() {
                System.out.println("로컬 변수에 접근(Final X)" + finalVar);
                System.out.println("로컬 변수에 접근(Final O)" + localFinalVar);
            }
        }
        System.out.println("외부 클래스의 메서드를 호출!");

        // 로컬 클래스의 인스턴스화
        // 메서드 안에서만 쓰이기 때문에 인스턴스화도 내부에서 일어남
        MethodClass methodClass = new MethodClass();
        methodClass.display();

    }
}

// 추상 클래스: 하나 이상의 추상 메서드를 포함
// 추상 메서드: 구현부 {}가 없는 메서드
abstract class AbstractClass {
    abstract void display();
}
// 인터페이스
interface Greeting {
    void sayHello();
}
public class A_Inner {
    public static void main(String[] args) {

        // === 인스턴스 내부 클래스 ===
        System.out.println("=== 비정적 내부 클래스 ===");
        // 1) 외부 클래스 인스턴스화
        OuterClass outerClass1 = new OuterClass();

        // 2) 외부클래스.내부클래스
        // 외부 클래스 타입.내부 클래스 타입 변수 = 외부 인스턴스.new 내부 클래스();
        OuterClass.InnerClass innerClass = outerClass1.new InnerClass();
        innerClass.display();   // 외부 클래스 필드에 접근: 외부 클래스의 필드

        System.out.println(" ");
        System.out.println("=== 정적 내부 클래스 ===");
        // 1) 외부 클래스 인스턴스화 필요 X, 클래스를 통한 내부 클래스 생성 O
        // 외부 클래스 타입.내부 클래스 타입 변수 = new 외부 클래스명.내부 클래스();
        OuterClass.staticClass staticClass = new OuterClass.staticClass();
        staticClass.display();  // 외부 클래스 정적필드에 접근: 외부 클래스의 정적 필드

        System.out.println(" ");
        System.out.println("=== 메서드 지역 클래스 ===");
        OuterClass outerClass2 = new OuterClass();
        outerClass2.outerMethod();
        // 로컬 변수에 접근(Final X)메서드 로컬 변수
        // 로컬 변수에 접근(Final O)메서드 로컬 변수(Final)

        System.out.println(" ");
        System.out.println("=== 익명 클래스 ===");
        // 클래스타입 변수명 = new 클래스명() {메서드 구현 - 추상 클래스, 인터페이스의 추상 메서드}
        AbstractClass abstractClass1 = new AbstractClass() {
            @Override
            void display() {
                System.out.println("익명 내부 클래스");
            }
        };

        AbstractClass abstractClass2 = new AbstractClass() {
            @Override
            void display() {
                System.out.println("2번째 익명 클래스");
            }
        };

        abstractClass1.display();   // 익명 내부 클래스
        abstractClass2.display();   // 2번째 익명 클래스
        System.out.println(abstractClass1 == abstractClass2);  // false

        // 인터페이스 익명 클래스
        System.out.println("== 인터페이스");
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("안녕하세요! 인터페이스 익명 클래스입니다.");
            }
        };
        greeting.sayHello();    // 안녕하세요! 인터페이스 익명 클래스입니다.
    }
}
