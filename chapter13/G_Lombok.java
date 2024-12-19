package chapter13;


import lombok.Getter;
import lombok.Setter;

/*      Lombok 정의
        애노테이션을 사용하여 보일러플레이트
        (반복적이고 필수적인 코드) 생성 작업을 자동화하는 도구

        Lombok 장단점

        장점: 코드 간결화, 생산성 향상, 어노테이션 기반, 컴파일 타임 처리

        단점: 학습 곡선, 디버깅 어려움, 의존성 문제 


        사용예시
        Getter, Setter, 생성자, equals(), hashCode(), toString()
        등의 메서드를 작성하지 않고도, 애노테이션을 통해 컴파일 시점에 해당 메서드를 자동으로 생성
*/


@Getter
@Setter
class LombokExample {
    private String name;
    private int age;
}



public class G_Lombok {
    public static void main(String[] args) {

        LombokExample lombokExample = new LombokExample();
        lombokExample.setName("이재현");
        lombokExample.setAge(24);

        System.out.println(lombokExample.getName());
        System.out.println(lombokExample.getAge());

    }


}
