package chapter06;

/*      === 오버라이딩 ===
        자식 클래스가 부모 클래스에서 상속받은 '메서드'를 자신의 상황에 맞게 '재정의'
       > 상속 관계에 있는 클래스들 사이에서 사용
       > 부모 클래스의 기본 동작을 자식 클래스에서 변경하거나 확장할 때 사용
*/
    class ParentClass {
        void exercise() {
            System.out.println("달리기를 잘합니다.");
        }

}

    class Childclass extends ParentClass {
        @Override
/*      자바에서 제공하는 어노테이션(annotation, 주석)
        부모클래스의 메서드를 자식 클래스에서 재정의했다는 것을 명시적으로 나타냄

        @Override 를 생략해도 오류가 나지 않는 이유!
        자바 컴파일러가 메서드 시그니처(이름, 파라미터, 반환타입) 를 비교하여
        부모 클래스의 메서드를 자식 클래스에서 재정의했는지 판단
*/
        void exercise() {
            System.out.println("달리기도 잘하고 피구도 잘합니다.");
        }
    }
/*      1. 오버라이딩 특징
         - 메서드의 시그니처가 일치!
         >> 부모 클래스에서 정의된 메서드와 동일한 이름, 파라미터 구성을 가져야 함.
            반환 타입은 같거나 자동 형 변환이 가능하게 작성

        2. 오버라이딩 구현방법
        부모 클래스의 상속받은 메서드를 자식 클래스에서 다시 정의
        메서드명, 파라미터 일치, 반환타입은 같거나 자동 형 변환 가능하게 작성
        메서드위에 @Override 어노테이션을 작성

        3. 오버라이딩 사용 목적
          다형성 구현
          하나의 이름으로 여러 기능을 수행하는 코드 작성
          재사용성, 확장성 향상
          기존의 코드 변경 없이, 새로운 기능을 추가하거나 변경 가능
*/
    class AnimalClass{
        void sound() {
            System.out.println("동물이 소리를 냅니다.");
        }

}

    class DogClass extends AnimalClass{
            @Override
        void sound(){
                System.out.println("개가 멍멍하고 짖습니다.");
            }
    }

    class CatClas extends AnimalClass{
            @Override
        void sound() {
                System.out.println("고양이가 야옹하고 웁니다.");
            }

    }
public class Overriding {
    public static void main(String[] args) {

        AnimalClass animalClass = new AnimalClass();
        animalClass.sound();    // 동물이 소리를 냅니다.

        DogClass dog1 = new DogClass();
        dog1.sound();   // 개가 멍멍하고 짖습니다.

        CatClas cat1 = new CatClas();
        cat1.sound();   // 고양이가 야옹하고 웁니다.

/*          부모로부터 상속받은 필드나 메서드를 확장하는 개념
            해당 상태나 동작을 반드시 가지지만 상속받는 클래스 마다 차이를 두고 싶을 때

        === 오버로딩(Overloading) VS 오버라이딩(Overriding) ===
            모두 메서드의 이름을 재사용한다 (다형성)

            1) 오버로딩
            같은 클래스 내에서 같은 이름을 가진 메서드를 여러 개 정의
            메서드명 동일
            파라미터 타입, 개수, 순서중 적어도 하나 이상은 달라야함!!
            반환타입 관련 X
            메서드의 동작을 다양한 상황에 맞게 조정 (다형성)


            2) 오버라이딩
            상속 관계에 있는 클래스에서 사용
            메서드의 시그니쳐(반환타입, 이름, 파라미터) 같아야함!!
            메서드의 동작을 변경하거나 확장 (다형성)
*/

    }
}