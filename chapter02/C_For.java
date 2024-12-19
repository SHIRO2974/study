package chapter02;

/**  반복문
    특정 조건이 만족할때까지 동일한 작업을 반복적으로 실행할 때 사용

    종류
    for, while, do-while
*/

import java.sql.PseudoColumnUsage;

public class C_For {
    public static void main(String[] args) {

/**      for 문
 특정 조건이 만족할때까지 블럭을 반복 실행
 횟수가 정해져있을때 많이 사용

 for (초기화; + 조건식; + 증감) {
 조건이 만족 될 때 실행할 코드
 }
 */
        for (int num = 1; num <= 5; num++) {
            System.out.println(num);
        }

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        System.out.println();


//          구구단
        System.out.println("구구단");

        // 반복하고 싶은 횟수를 명확하게 확인
        // 초기화를 0으로, 조건을 횟수 미만으로 설정

        for (int i = 2; i < 10; i++) {      // 2단부터 9단까지 반복
            System.out.println("\n");       // 단이 끝날때 줄바꿈
            System.out.println(i + "단");    // 단이 시작할때 표기
            for (int j = 1; j <= 9; j++) {

                System.out.println(i + "x" + j + "=" + i * j);


            }
        }
    }
}