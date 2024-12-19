package chapter05;

/*  === static 메서드 ===

        클래스의 "필드"
        인스턴스 필드 VS static 필드

        클래스의 "메서드"
        인스턴스 메서드 VS static 메서드
        - 인스턴스 메서드: 객채를 생성한 후 호출할 수 있는 메서드

        static 메서드: 객체 생성 없이 호출 가능한 메서드

        static 메서드란?
        static 키워드를 메서드 앞에 붙여 정의된 메서드
        클래스 이름으로 직접 호출이 가능

        1. 정적 메서드 사용법
        static 반환타입 메서드명() {}
        클래스명.메서드명();

        2. static 메서드 특징
        인스턴스 변수에 의존하지 X
        클래스 수준에서 공유되는 데이터를 다룰 때 적합

        3. static 메서드 권장 사항
         공통 데이터 사용: 모든 인스턴스에서 공유되는 데이터를 다룰 때
         독립적인 사용: 인스턴스 변수와 관계없이 파라미터만으로 작업을 처리할 때
*/
        class Operator{
            int a, b;

//          인스턴스 메서드
            int add(){
                return a + b;
    }
            int subtract() {
                return a - b;
            }

            // static 메서드
            static int multiply(int a, int b) {
                return a * b;
            }
            static int divide(int a, int b) {
                return b != 0 ? a / b : b;
            }
}
public class Metod04 {
    public static void main(String[] args) {

        System.out.println(" === 인스턴스 메서드 ===");
        Operator operator = new Operator();
        operator.a = 10;
        operator.b = 20;

        System.out.println(operator.add());     // 30
        System.out.println(operator.subtract());    // -10

        System.out.println("=== static 메서드 ===");
//        클래스명.메서드명(인자);
        int result1 = Operator.multiply(10, 20);
        int result2 = Operator.divide(20, 10);
        int result3 = Operator.divide(20, 0);

        System.out.println(result1);    // 200
        System.out.println(result2);    // 2
        System.out.println(result3);    // 0
    }
}
