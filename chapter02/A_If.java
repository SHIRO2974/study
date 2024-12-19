package chapter02;

//  조건문 프로그램의 흐름을 제어하는 데 사용

/*  제어문: 조건문(Condition), 반복문(Loop)

    조건문 종류
    if, else, else if
    switch, case, default
    + continue, break
*/

import java.util.Scanner;

public class A_If {
    public static void main(String[] args) {

/*      1. if 문

        if(조건식) {
            조건이 참일 때 실행할 코드

            } else{
            조건이 거짓일 때 실행할 코드
            }
 */
        int age = 14;

        if (age > 19) {
            System.out.println("성인 입니다.");

        } else if(age > 13) {
            // 13 <= age <= 19
            System.out.println("청소년 입니다.");

        } else {
            System.out.println("미성년자 입니다.");
        }

//      실행될 코드 블럭에 코드가 하나의 구문이라면 {} 생략 가능
        if (age > 19) System.out.println("주류");
        else if (age > 13) System.out.println("탄산");
        else System.out.println("쥬스");

/**           == 조건문 예제 ==
            : 함수 위치 구하기 문제
           1. 스캐너를 사용하여 x, y 변수에 데이터를 저장
           2. (x, y) 좌표가 1, 2, 3, 4 사분기 중 어느 위치에 있는지 검사
           >> 조건문
*/
//      스캐너 생성
        Scanner scan = new Scanner(System.in);

        String functonscope = null; //비워있다.

        System.out.printf("x : ");
        int x = scan.nextInt();

        System.out.printf("y : ");
        int y = scan.nextInt();

        //조건문 작성
        if (x > 0 && y > 0) {
            functonscope = "제 1 사분면";

        }else if (x < 0 && y > 0) {
            functonscope = "제 2 사분면";

            } else if (x < 0 && y < 0) {
            functonscope = "제 3 사분면";

        }   else {
            functonscope = "제 4 사분면";
            System.out.println();

        }
            System.out.println(" 결과 : " + functonscope);

//      스캐너 종료
        scan.close();
    }
    }


