package chapter05;

/*   === 용어 정리 ===
        클래스, 객체, 인스턴스

        필드: 인스턴스 변수, static 변수)
        +) 지역변수

        메서드: 인스턴스 메서드, static 메서드

        생성자

        === 오버로딩 ===

        중복 정의
        한 클래스 내에서 같은 이름의 메서드를 여러 개 정의하는 것

        1. 오버로딩 성립 조건
        메서드 이름은 동일
        파라미터의 개수 또는 데이터타입이 달라야 함
        반환타입은 오버로딩 영향 X

        2. 오버로딩 장점
        사용자가 메서드의 파라미터 순서를 외우지 않아도 사용 가능
        작업의 본질이 동일한 메서드를 하나의 이름으로 그룹화 가능
            코드의 재사용성, 가독성 향상
        컴파일 시 타입 체크 강화
        올바른 파라미터를 가진 메서드를 자동선택

        3. 오버로딩 단점
        중복적으로 의미없이 생성하는 경우, 실질적으로 필요한 구현 메서드 찾기에 어려움 ( 복잡성)
*/
    class Calc{
        int a, b;
        int c, d;
        double x, y;

        int add(int a, int b){ return a + b;}

//      long add(int c, int d){ return c + d;} Error
        long add(long a, int b){ return  a + b;};

//      실제 값 차이 여부와 반환타입의 차이 여부는 오버로딩과 관련 X
//      반드시! 파라미터의 개수 또는 타입이 달라야 햠

///        === 파라미터의 타입 차이 ===
        double add(double x , double y){return  x + y;}
        double add(int x , double y){return  x + y;}
        double add(double x , int y){return  x + y;}

//            파라미터의 개수 차이
        int add(int a, int b, int c){return a + b + c;}

/*          오버로딩 사용 목적
        1. 매서드가 수행하는 기본적인 작업이 동일할 때, 같은 이름 사용 가능
           코드를 더 명확하고 가독성 있게 작성 가능
        2. 코드의 재사용성이 높아짐
*/



}



public class Overlooding01 {
    public static void main(String[] args) {
        Calc calc = new Calc();
        System.out.println(calc.add(10.0, 30));

        System.out.println(calc.add(10, 20));
        System.out.println(calc.add(10, 20.0));
        System.out.println(calc.add(10.5, 20.6));

        System.out.println(calc.add(10,20,30));

    }
}
