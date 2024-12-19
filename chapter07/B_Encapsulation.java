package chapter07;

/*      === 캡슐화(Encapsulation) ===
           객체 지향 프로그래밍에서 데이터와 해당 데이터를 처리하는
           함수를 하나로 묶는 것을 의미
           객체 내부의 구현을 숨기고 외부에서는 제공된 메서드를 통해서만 접근할 수 있게 설정
          >> 데이터 보호, 유지보수성 향상, 사용자 편의성 증대

          데이터 보호와 유지보수성 향상을 목적으로
          데이터 필드를 private 로 선언
          데이터에 접근하거나 수정할 때는 getter 과 setter 메서드를 사용함

          === get & set 메서드 ===
          캡슐화 된 데이터에 안전하게 접근하고 수정할 수 있도록 하는 기능

          getter: 특정 필드값을 읽는 메서드
            get<필드명>()'
          Ex) getName, getAeg

          setter: 특정 필드값을 설정하는 메서드
          set<필드명>();
         Ex) setName, setAge


         === 학생 관리 시스템 ===
*/

    class Student {
        private String name;    // 학생 이름
        private int age;    // 학생 나이
        private int score;  // 점수

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }
        public void setAge(int age) {

            if(age < 0 ) {
                System.out.println("유효하지 않은 나이입니다.");

            } else {
                this.age = age;
            }
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {

            if (score >= 0 && score <= 100) {
                this.score = score;

            }else {
                System.out.println("유효하지 않은 점수 입니다.");
            }
        }

}

public class B_Encapsulation {
    public static void main(String[] args) {

        Student student = new Student();
        student.setName("이재현");
        student.setScore(90);
        student.setAge(24);
        System.out.println(student.getName());  // 이재현
        System.out.println(student.getScore()); // 90
        System.out.println(student.getAge());   // 24

        student.setAge(-10);    // 유효하지 않은 나이입니다.
        student.setScore(-100); // 유효하지 않은 점수 입니다.
    }
}
