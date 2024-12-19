package chapter02;

import java.util.Scanner;

public class D_While {
    public static void main(String[] args) {

/*      while 문
        반복횟수가 지정되지 않을 때 사용
        조건을 검사하고 해당 조건이 true 인 경우 블록을 실행
        > if 문 반복형태

        while(true, final) {
            조건이 참일 때 실행
           }

           초기화
           int num = 1;

           while (while 문 내부에서 증감)
           while (num <= 5){
            System.out.println(num);

            증감식
            num++

            while 문 내부에서 코드블럭을 게속해서 실행: continue;
            while 코드블록 중단 : break;
*/
        int num = 0;
        while (true) { // 무한 루프 (break; 키워드를 만나기전까지 실행

            if (num % 2 == 0){  //  짝수

                System.out.println(num);
                num++;

                continue; // continue 를 만나면 코드를 무시하고 다시 조건 검사
            }

            num++;

            if (num == 20){
                break;
            }
        }

/*      do while 문
        차이점: 최소 한번은 반드시 실행

        do {
            실행코드
            } while (조건);
*/
        // do- while 사용예제
        // 사용자 입력값을 반복적으로 받아 조건에 맞는 값을 처리할 때 유용

        Scanner scan = new Scanner(System.in);


        System.out.println("1부터 10사이의 숫자를입력하세요.");
        // 입력값이 1 ~ 18 사이일 때 종료
        int number = scan.nextInt();
        do {
            System.out.println("1부터 10사이의 숫자를입력하세요.");
            number = scan.nextInt();
        } while (number < 1 || number > 10);

        System.out.println("입력한 숫자는 : " +  number);
        scan.close();
    }
}
