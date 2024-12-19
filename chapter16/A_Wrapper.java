package chapter16;

/*      === Wrapper 클래스 ===
            기본 데이터 타입을 객체로 다루기 위해 사용되는 클래스

            기본 데이터 타입:
                    >> 각 데이터 타입에 해당하는 Wrapper 클래스가 존재

            java.lang 패키지에 정의
            사용 용도 예시) 컬렉션 크레임워크에서는 객체만 저장 가능!
                    >> 기본 데이터 형태를 저장하려면 Wrapper 클래스로 변환하여 저장

            참조 데이터 타입


            +) 박싱(Boxing) & 언박싱(Unboxing)
             기본 타입과 해당 타입의 Wrapper 클래스 간의 자동 변환
             자바 컴파일러에 의해 자동으로 처리

             1) 박싱(Boxing)
              기본 타입과 해당 타입의 Wrapper 클래스 간의 자동 변환
              - 자바 컴파일러에 의해 자동으로 처리

             2) 언박싱(Unboxing)
              Wrapper 클래스의 객체를 해당하는 기본 데이터 타입으로 변환하는 과정
              Integer 객체의 값을 int 데이터 타입으로 변환하는 것

             +) 박싱과 언박싱의 장단점
                장점
                 기본 타입과 객체 타입 간의 변환을 자동으로 처리, 코드 작성이 용이함
                 컬렉션 프레임워크와 같이 객체만 요구하는 API 와 호환성이 높음

                단점
                 객체를 생성하는 과정에서 추가적인 메모리 사용량이 증가되어
                  박싱, 언박싱 과정에서 성능 저하
                 null 값이 할당 될 수 있는 Wrapper 객체를 언박싱 할 경우
                 NullPointerException 발생 위험이 있음

              Wrapper 클래스의 sout 출력
              System.out.println() 함수를 사용하여 Wrapper 클래스의 객체 호출 시
               해당 객체의 toString() 메서드가 자동으로 호출되어
               객체가 보유하고 있는 실제 값이 출력
*/



public class A_Wrapper {
    public static void main(String[] args) {

//      1) 박싱
        int i = 5;
        System.out.println(i);  // 5

//      자동 박싱: 기본 타입의 값을 Integer 객체로 변환
        Integer integerObject = i;
        System.out.println(integerObject);  // 5

//      2) 언박싱
        Integer integer = new Integer(10);
        System.out.println(integer);    // 10

//      자동 언박싱: Integer 객체를 기본 타입 int 값으로 변환
        int num = integer;
        System.out.println(num);    // 10

//      === Integer 클래스 ===
//         int 값을 내부에 저장, 관련 유용한 메서드를 제공

//      1) 생성자
        new Integer(67);

//      Integer(String s) -
//      문자열이 정수로 변환될 수 없는 경우 NumberFormatException 이 발생

        new Integer("123");
//      new Integer("Hello :)");

//      2) 주요 메서드
//      intValue(): Integer 객체를 기본 int 타입으로 변환
        Integer myInteger = new Integer(100);
        int myInt = myInteger.intValue();

        System.out.println(myInt);  // 100

//      parseInt(String s): 문자열을 기본 int 타입으로 피싱
        String numberStr = "250";
        int parsedInt = Integer.parseInt(numberStr);

        System.out.println(parsedInt);  // 250

//      valueOf(int i): int 값을 가진 Integer 객체를 반환
        Integer anotherInteger = Integer.valueOf(500);

        System.out.println(anotherInteger); // 500

//      compareTo: 두 Integer 객체를 비교하여 같으면 0
//      , 호출 객체가 더 크면 양수, 더 작으면 음수를 반환
        int result = myInteger.compareTo(anotherInteger);

        System.out.println(result); // -1   호출 객체 (myInteger) 가 더 작음
    }
}
