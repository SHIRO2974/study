package chapter13;

/*      === singleton ===
          소프트웨어 설계 패턴 중 하나
          >> 클래스의 인스턴스가 하나만 생성되도록 보장
          >> 해당 클래스의 인스턴스에 전역적 접근을 제공
          >> 하지만 일관된 상태를 유지

          == singleton 패턴의 사용 목적 ==
            1) 객체의 유일성 보장
            2) 자원의 절약

          == singleton 패턴의 장단점 ==
            1) 장점
              - 자원의 중복 생성을 방지, 메모리 사용 최적화
              - 전역 상태를 공유 + 통제된 접근

            2) 단점
              - 전역 상태를 관리 + 다른 클래스에 영향(결합의 가능성)
              - 테스트가 어려움
*/
class Singleton {
    // static 필드
    // 클래스 타입 그 자체를 가지는 필드
    private static Singleton instance;

    // 생성자를 private 으로 선언
    // 외부에서 직접적인 인스턴스화 불가!
    private Singleton() {
    }

    // 전역 접근성을 제공하는 메서드 정의 (인스턴스화 담당)

    public static Singleton getInstance() {

        if (instance == null) {     // static 필드에 아무런 값이 없다면

            instance = new Singleton(); // 인스턴스화 진행
        }
        return instance;
    }
}

class SchoolPrincipal {
    // 유일한 객체 저장할 변수
    private static SchoolPrincipal instance;

    // 1. 생성자를 private 으로 만듬

    private SchoolPrincipal() {
        System.out.println("교장 선생님 객체가 생성되었습니다.");
    }

    public static SchoolPrincipal getInstance() {

        if (instance == null) {     // 객체가 없으면 새로 생성
            instance = new SchoolPrincipal();
        }
        return instance;    // 객체를 반환
    }

    public void announce() {
        System.out.println("어쩌구 저쩌구 샬라샬라");
    }
}

public class D_Singleton {
    public static void main(String[] args) {

        SchoolPrincipal principal1 = SchoolPrincipal.getInstance();
        SchoolPrincipal principal2 = SchoolPrincipal.getInstance();

        System.out.println(principal1); // chapter13.SchoolPrincipal@49e4cb85
        System.out.println(principal2); // chapter13.SchoolPrincipal@49e4cb85
        System.out.println(principal1 == principal2);   // true

        principal1.announce();  // 어쩌구 저쩌구 샬라샬라
    }
}
