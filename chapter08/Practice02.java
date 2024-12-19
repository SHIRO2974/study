package chapter08;

/*   === 인터페이스 ===


 */
interface Fruit {

    String color();     // 추상화 메서드

    // 오버라이딩 가능
    default void describe() {

        System.out.println("과일의 색상은" + color() + "이며, 모양은 동그랗다.");
    }

        // 오버라이딩 불가능
    static void printType() {

        System.out.println("과일(Fruit)의 타입입니다.");
    }
}

class Apple implements Fruit {

    public String color() {

        return "Red";
    }
}

class Orange implements Fruit {

    public String color() {

        return "Orange";
    }
}

class Banana implements Fruit {

    public String color() {

        return "Banana";
    }

    @Override
    public void describe() {

        System.out.println("과일의 색상은" + color() + "이며, 모양은 깁니다.");
    }
}

interface TropicalFruit extends Fruit {

    /*      extends (상속 - 확장하다)
             클래스 간, 인터페이스 간 가능

             implements (구현 - 구현하다)
             인터페이스를 클래스로 구현
    */
    default void tropicalFeature() {

        System.out.println("열대 과일은 후숙하면 더 맛있습니다.");
    }
}

class Mango implements TropicalFruit {

    public String color() {

        return "golden";
    }

    @Override
    public void describe() {

        System.out.println("과일의 색상은" + color() + "이며, 모양은 타원형입니다.");
    }
}

public class Practice02 {
    public static void main(String[] args) {

        // 다형성 적용
        Fruit apple = new Apple();
        Fruit orange = new Orange();
        Fruit banana = new Banana();
        TropicalFruit mango = new Mango();

        // == 다형성 예제 ==
        // mango 가 Fruit 로 형 변환 (업캐스팅)
        Fruit[] fruits = {apple, orange, banana, mango};

        for (Fruit fruit : fruits) {

            fruit.describe();

            if (fruit instanceof TropicalFruit) {

                TropicalFruit tropicalFruit = (TropicalFruit) fruit;    // 다운 캐스팅
                tropicalFruit.tropicalFeature();    // 열대 과일은 후숙하면 더 맛있습니다.
            }
        }

        if (mango instanceof Fruit) {

            Fruit mangoAsFruit = (Fruit) mango;
            mangoAsFruit.describe();    // 과일의 색상은 golden 이며, 모양은 타원형입니다.
        }

        if (banana instanceof TropicalFruit) {

            TropicalFruit bananaAsTropical = (TropicalFruit) banana;
            bananaAsTropical.tropicalFeature();

        } else {
            System.out.println("바나나는 열대 과일이 아닙니다.");    // 바나나는 열대 과일이 아닙니다.
        }

        Fruit.printType();  // 과일(Fruit)의 타입입니다.
    }
}
