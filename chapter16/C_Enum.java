package chapter16;

/*      Enum 메서드 오버라이딩
        - Enum 은 상수별로 다른 동작 정의
        - abstract 메서드를 선언하고 상수별로 구현 가능

        Enum 특징
        - 타입 안정성 제공: 상수에 허용되지 않은 값을 지정 방지
        - 가독성 향상: 상수의 집합을 하나의 열거형으로 표현

        Enum 제한
        - 값의 집합이 고정된 경우에만 사용!!
        - Enum 은 상속 지원 X, 인터페이스 구현은 가능

        +) Enum 과 데이터베이스
           - 어노테이션을 활용한 매핑이 가능
*/

enum Operation {

    ADD{

        public int apply(int x, int y){
            return x + y;
        }
    },

    SUBTRACT {

        public int apply(int x, int y) {
            return x - y;
        }
    };

    public  abstract int apply(int x, int y);
}

enum Season {

    SPRING("봄"), SUMMER("여름")
    , AUTUMN("가을"), WINTER("겨울");

    private final String seasonName;

    Season(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }
}

public class C_Enum {
    public static void main(String[] args) {
        System.out.println(Operation.ADD.apply(5, 5));  // 10
        System.out.println(Operation.SUBTRACT.apply(5, 5)); // 0

        Season season = Season.AUTUMN;

        switch (season) {

            case SPRING:
                System.out.println("봄이 왔네요");
                break;

            case SUMMER:
                System.out.println("다시 여름 바닷가");
                break;

            case AUTUMN:
                System.out.println("가을 타나봐");
                break;

            case WINTER:
                System.out.println("눈이 오나봐");
                break;
        }

    }
}
