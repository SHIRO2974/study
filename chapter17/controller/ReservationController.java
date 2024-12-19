package chapter17.controller;


import chapter17.entity.Reservation;
import chapter17.service.ReservationServiceImpl;
import chapter17.service.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

// 사용자 요청 처리 및 서비스 호출
public class ReservationController {

    private final UserServiceImpl userService;
    private final ReservationServiceImpl reservationService;

    public ReservationController() {
        this.userService = new UserServiceImpl();
        this.reservationService = new ReservationServiceImpl(userService);
    }

    public void run() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getChoice(scan);

            if (!processChoice(choice, scan)) {
                break;
            }
        }


    }

    private void displayMenu() {
        System.out.println("1. 사용자 등록 | 2. 로그인 | 3. 로그아웃");
        System.out.println("4. 예약 등록 | 5. 예약 확인 | 6. 예약 취소");
        System.out.println("7. 종료");
        System.out.println("선택: ");
    }

    private int getChoice(Scanner scan) {

//      Scanner 클래스의 hasNextInt() 메서드
//      Scanner 객체에 입력된 값이 int 값일 경우에는 true, 그렇지 않으면 false 반환
        while (!scan.hasNextInt()) {

//          입력 값이 정수가 아닌경우
            System.out.println("숫자를 입력해주세요.");
            scan.nextInt();

        }
        return scan.nextInt();
    }

    private boolean processChoice(int choice, Scanner scan) {
        scan.nextLine();    // 정수 값을 입력받고 남은 버퍼 처리

        switch (choice) {

            case 1:  // 사용자 등록
                userService.registerUser(
                        input(scan, "사용자 ID"),
                        input(scan, "사용자 비밀번호"),
                        input(scan, "사용자 이름"),
                        input(scan, "사용자 이메일")
                );

                break;

            case 2: // 사용자 로그인
                userService.login(
                        input(scan, "사용자 ID"),
                        input(scan, "사용자 비밀번호")
                );
                break;

            case 3: // 사용자 로그아웃
                userService.logout();
                break;

            case 4:  // 예약 등록
               reservationService.createReservation(
                       input(scan, "예약 ID"),
                       input(scan, "사용자 ID")
               );
                break;

            case 5: // 예약 확인
               List<Reservation> results = reservationService.getReservationsByUserId(
                        input(scan, "사용자 ID")
                );
                results.forEach(System.out::println);
                break;

            case 6: // 예약 취소
                reservationService.cancelReservation(input(scan, "예약 ID"));
            break;

            case 7:
                System.out.println("프로그램을 종료합니다.");
                return false;

            default:
                System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
        }
        return true;
    }

    private String input(Scanner scan, String prompt) {
        System.out.print(prompt + ": ");
        return scan.nextLine();
    }
}
