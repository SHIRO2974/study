package chapter07;

/*      final 키워드
        변수, 메서드, 클래스에서 사용 가능

        1) 변수: 값을 변경할 수 없는 상수를 선언
        2) 메서드: 자식 클래스에서 오버라이드 할 수 없는 메서드 선언
        3) 클래스: 상속될 수 없는 클래스 선언
*/
    class MyFinalClass {
/*      1. final 변수
        2. 상수를 지정하는 키워드
        >> 한번만 초기화 가능 (선언과 동시에 초기화), 재할당 불가능
        >> 변수명을 대문자로 작성, 단어 사이에 언더스코어(_)를 사용
*/
    final int FINAL_VALIABLE = 30;

/*      2. final 메서드
          자식 클래스에서 오버라이드 할 수 없는 메서드
          접근제한자 final 반환타입 메서드명(){}
*/
    public  final void myMethod() {
        System.out.println("재정의 할 수 없는 메서드");
    }
}
    class ChildClass extends MyFinalClass {
/*     'myMethod()' cannot override 'myMethod()' in 'chapter07.MyFinalClass'; overridden method is final
        public void myMethod(){}

        상속받은 final 메서드는 사직 클래스에서 재정의 X
        >> 생략된 형태로만 사용 가능
        ChildClass.myMethod();

        3. final 클래스
          final class 클래스명{}
          더 이상 상속될  수 없는 클래스
          >> final 클래스를 부모 클래스로 사용 할 수 없음
*/
    }
    final class Example1{}
/*
    class Examplel2 extends Example1{}
    Cannot inherit from final 'chapter07.Example1'
*/

public class C_Final {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        childClass.myMethod();  // 재정의 할 수 없는 메서드

/*      final 장단점
        1) 장점: 불변성
        2) 단점: 유연성 감소 (상속X, 오버라이딩 X, 그 자체로 사용가능)
*/
    }
}
