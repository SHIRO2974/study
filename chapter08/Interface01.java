package chapter08;

/*      === 인터페이스 ===
          객체가 어떤 방식으로 동작해야 하는 정의하는 추상 타입
          추상화 메서드와 상수만 포함된 특수한 클래스
          모든 메서드는 추상화 메서드로 구성
          상수는 public static final 특성을 가짐
         >> 실제 구현은 인터페이스를 구현한 클래스에서 담당

       === 인터페이스 특징===
          1) 메서드
            모든 메서드는 기본적으로 public abstract 로 선언
            >> 생략 가능
          2) 필드
            모든 변수는 기본적으로 public static final 상수
           >> 생략 가능

           +) 다중 구현을 지원
             한 클래스에서 여러 인터페이스를 동시에 구현 가능
            >> 객체의 행동을 정의하는 역할

        === 추상화 클래스 VS 인터페이스 ===
        1) 추상화 클래스
          - 공통적인 기능을 제공하는 '부분적 구현'
          구성요소: 추상화 메서드. 구체 메서드, 필드, 생성자
          단일 상속만 가능 (extends)

        2) 인터페이스
           - 클래스의 행동을 정의
           구성요소: 추상화 메서드, 상수, 디폴트 메서드, 정적 메서드
           다중 구현 가능 (implements)
          >> 객체가 해야 할 동작(행위)을 정의

         == 인터페이스 구현 방법 ==
           interface 인터페이스명 {}
*/
interface PlayngCard {
/*          1. 멤버 변수
            2. 상수 선언
             public static final 특성을 가짐 (생략 가능)
*/
            int SPADE = 4;
            int DIAMOND = 3;
            int CLOVER = 2;

    /*      2. 메서드
              public abstract 특성을 가짐 (생략 가능)
             >> 모든 메서드가 추상화 메서드여야 함
             >> 해당 인터페이스 활용을 위해 모든 클래스에서 접근 가능 (public)
    */
            String getCardNumber();
            String getCardKind();

    /*      3. 디폴트 메서드
             인터페이스에 새 기능을 추가하면서 기존 구현을 포함
            >> 기본 구현 제공, 오버라이딩(재정의) 가능
    */
        default void defultMethod() {       // interface 내부에서는 default 키워드 생략 X
            System.out.println("디폴트 메서드입니다.");
        }

/*          4. static 메서드
              인터페이스에서 직접 구현
             >> 인터페이스 이름으로 직접 호출, 오버라이딩 불가능 (객체 인스턴스 없이 사용 가능)
             >> 인터페이스와 관련된 공통 동작(유틸리티) 메서드를 제공하기 위해 사용
*/
        static void staticMethod() {
            System.out.println("정적 메서드입니다.");
    }

    }

/*
*/
    class Card implements PlayngCard {
        private  String cardNumber;
        private  String cardKnd;

        Card(String cardNumber, String cardKnd) {
            this.cardKnd = cardKnd;
            this.cardNumber = cardNumber;
        }

//      인터페이스 안의 추상화 메서드를 구현한 클래스 메서드는 public 지정
   public String getCardNumber() {
        return cardNumber;
    }

   public String getCardKind() {
        return cardKnd;
    }


    @Override
   public void defultMethod() {
       System.out.println("Card 클래스에서 재정의된 디폴트 메서드");
    }

    // 인터페이스의 모든 메서드는 기본적으로 public 접근 제한자를 가짐
    // "어떤 동작을 외부에서 사용할 수 있음"을 보장
}

public class Interface01 {
    public static void main(String[] args) {
        // 인터페이스의 추상화 메서드 사용
        Card card = new Card("7","HEART");

        System.out.println(card.getCardKind());     // HEART
        System.out.println(card.getCardNumber());   // 7

        // 오버라이드는 선택적
        card.defultMethod();    // Card 클래스에서 재정의된 디폴트 메서드

        PlayngCard.staticMethod();  // 정적 메서드입니다.

        System.out.println(PlayngCard.CLOVER);  // 2
        System.out.println(PlayngCard.DIAMOND); // 3
        System.out.println(PlayngCard.SPADE);   // 4
    }


}
