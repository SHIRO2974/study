package chapter07.animalApp;

// 자식 클래스

public class Cat extends Animal {

    @Override
    void speak() {
        System.out.println("야옹!!");

        }
        // 자식 클래스 고유 메서드
    void eat() {
        System.out.println("나는 츄르가 좋아.");
    }
}
