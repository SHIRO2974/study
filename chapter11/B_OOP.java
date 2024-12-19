package chapter11;

/*      === SOLID 원칙 ===

        4. 인터페이스 분리 원칙 (Interface Segregation Principle, ISP)
           하나의 큰 인터페이스보다 여러 개의 작은 인터페이스를 사용하는 것을 권장
           인터페이스의 단일 책임을 강조
           - 클래스는 자신이 사용하지 않는  인터페이스에 의존하지 않아야 한다.
           SRP(단일 책임 원칙 - 하나의 클래스가 하나의 역할만 가져야 한다.)
*/
//      === ISP 설계 원칙 적용 X ===
        interface Worker {

            void work();
            void eat();
        }

        class Robot implements Worker{

            public void work() {
                System.out.println("로봇은 일을 할 수 있습니다.");
            }

            // 로봇은 먹는 행위를 필요로 하지 않지만 강제로 구현해야 함!
            public void eat() {
                System.out.println("로봇은 음식을 먹지 않습니다.");
            }
        }

//      === ISP 설계 원칙 적용 ===
        interface Workable {

            void work();

        }

        interface Eatable {

            void eat();
        }

        class WorkRobot implements Workable {

            public void work() {
                System.out.println("로봇은 일을 할 수 있습니다.");
            }
        }

        class Human implements Eatable {

            public void eat() {
                System.out.println("사람은 음식을 먹습니다.");
            }
        }

        public class B_OOP {
            public static void main(String[] args) {

            }
        }

/*      5. 의존성 역전 원칙 ((Dependency Inversion Principle, DIP)
           고수준 모듈은 저수준 모듈에 의존해서는 안 되고, 둘 다 추상화에 의존해야 한다.
           세부 구현이 아닌, 추상화된 인터페이스에 의존하도록 설계

*/
        class Keyboard {

        }

        class Computer {
            public Keyboard keyboard;

            public Computer() {
                // Computer 가 Keyboard 라는 구체적인 구현 클래스에 의존
                this.keyboard = new Keyboard();
            }
        }

        interface InputDevice {

        }

        class Mouse implements InputDevice {

        }

        // DipComputer 는 InputDevice 라는 추상화에 의존
        class DipComputer {
            public  InputDevice inputDevice;

            public DipComputer(InputDevice inputDevice) {
                this.inputDevice = inputDevice;
            }
        }
        // >> 의존 역전 원칙은 각 클래스 간의 결합도(coupling)를 낮추는 것