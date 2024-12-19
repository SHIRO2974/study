package chapter02;

import java.util.Scanner;

public class E_Practice {
    public static void main(String[] args) {

/**     1. 점수에 따른 학점 출력 (if, else if, else 사용)
           사용자로부터 점수를 입력받아 아래 기준에 따라 학점을 출력하세요.
           0 미만 또는 100 초과인 경우: 유효하지 않은 점수입니다.
           90 이상: A
           80 이상: B
           70 이상: C
           \60 이상: D
             외: F
 */

        Scanner scan = new Scanner(System.in);
        System.out.println("점수를 입력하세요 (0 ~ 100) : ");
        int score = scan.nextInt();

        if (score < 0 || score > 100) {
            System.out.println("유효하지 않은 점수 입니다.");

        } else if (score >= 90) {
            System.out.println("학점 A");

        } else if (score >= 80) {
            System.out.println("학점 B");

        } else if (score >= 70) {
            System.out.println("학점 C");

        } else if (score >= 60) {
            System.out.println("학점 D");

        } else
            System.out.println("학점 F");



/**         2. 삼각형 모양의 별(*) 출력 (중첩 for 사용)
 (1)
 *
 **
 ***
 ****
 *****

 (2)
 *
 **
 ***
 ****
 *****
 */

        for (int i = 1; i <= 5; i++) { // 줄 수 (1부터 5까지 증가)

            for (int j = 1; j <= i; j++) { // 각 줄의 별 개수 (각 줄의 별 개수는 각 줄의 수 보다 "이하"의 값
                System.out.print("*");
            }

            System.out.println(); // 줄 바꿈 처리를 담당
        }

        for (int i = 1; i <= 5; i++) {  // 1에서 5까지 공백이 증가

            for (int j = 1; j <= 5 -i; j++){    // 5에서 1까지 공백이 감소
                System.out.print(" ");
            }
            for (int star = 1; star <= i; star++){  // 1에서 5까지 별이 증가
                System.out.print("*");
            }
            System.out.println();   // 줄 바꿈 처리
        }


    }
    }





















