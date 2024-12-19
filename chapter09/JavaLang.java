package chapter09;

/*      java.long 패키지
        자바 프로그램의 가장 기본적인 클래스들을 포함
       - 별도의 import 문 없이 사용 가능

       1. Object 클래스
         자바에서 모든 클래스의 최상위 클래스
        - 모든 클래스는 Object 클래스를 상속받음
*/
class Myclass extends Object {

    private int id;
    private String name;

    Myclass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*      1) toString() 메서드
              객체의 문자열 표현을 반환
              기본 구현: '객체의 클래스 이름 + @ + 메모리 주소' 반환
              오버라이딩: 원하는 정보를 반환
*/
            public String toString() {

                return "MyClass(ID: " + id + "/ NAME: " + name + ")";
            }

/*            2) equals (Object obj)
              두 객체가 동등한지 비교
              두 객체의 참조를 비교 (동일한 주소값을 가지는지 확인)
              오버라이딩: 객체 내용 기반의 비교를 구현가능)

              3) Math 클래스
                수학 연산 및 함수를 제공하는 클래스
                모든 필드와 메서드는 static!

              4) String 클래스
                문자열 조작을 위한 다양한 메서드를 제공

*/


}

public class JavaLang {
    public static void main(String[] args) {

        Myclass myclass1 = new Myclass(1, "이재현");
        System.out.println(myclass1.toString());    // chapter09.Myclass@49e4cb85
        System.out.println(myclass1.toString());    // MyClass(ID: 1/ NAME: 이재현)

        Myclass myclass2 = new Myclass(2, "이재현");
        System.out.println(myclass1.equals(myclass2));  // false

        System.out.println("========== Math 클래스 ===============");
        System.out.println(Math.abs(-10));  // 절대값 반환.abs(데이터)
        System.out.println(Math.max(100,200));  // 최대값 반환(데이터1, 데이터2)
        System.out.println(Math.min(100,200));  // 최서값 반환(데이터1, 데이터2)
        System.out.println(Math.sqrt(16));  // 제곱근 반환
        System.out.println(Math.pow(2,3));  // 제곱 값 반환: .pow(a, b) == a의 b제곱
        System.out.println(Math.random());
        // 무작위 난수를 생성: .random() - 0.0 이상 1.0 미만의 난수를 생성

        System.out.println("========== String 클래스 ===============");
        String message = "Merry Christmas!";

        System.out.println(message.length());   // 16 - 문자 및 공백, 기호까지 포함

        boolean isEquals = message.equals("Merry Christams^^");
        System.out.println(isEquals);

/*      substring(int start, int end)
        시작 인덱스(포함)부터 끝 인덱스(미포함)까지의 부분 문자열을 반환
        인덱스 번호는 0부터 시작, 공백과 기호까지 포함
 */
        System.out.println(message.substring(6,15));    // Christmas

        System.out.println(message);    // Merry Christmas! - 문자열은 불변(immutable) 데이터

        int index = message.indexOf("Christmas");
        System.out.println(index);  // 6

        char c = message.charAt(6);
        System.out.println(c);  // C
    }
}
