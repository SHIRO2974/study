package chapter15.boardApp.View;

import chapter15.boardApp.controller.BoardController;
import chapter15.boardApp.dto.BoardRequestDto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardView {
    public static void main(String[] args) {

        BoardController boardController = new BoardController();
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("[ 게시판 관리 시스템 ]");
                System.out.println("1. 게시글 전체 조회");
                System.out.println("2. 게시글 단건 조회");
                System.out.println("3. 게시글 등록");
                System.out.println("4. 게시글 수정");
                System.out.println("5. 게시글 삭제");
                System.out.println("0. 종료");
                System.out.print("선택: ");
                int choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {

                    case 1:
                        boardController.getAllBoards();
                        break;

                    case 2:
                        System.out.print("조회할 ID: ");
                        long id = scan.nextLong();

                        boardController.getBoardById(id);
                        break;

                    case 3:
                        System.out.print("제목: ");
                        String title = scan.nextLine();

                        System.out.print("내용: ");
                        String content = scan.nextLine();

                        System.out.print("작성자: ");
                        String author = scan.nextLine();

                        boardController.createBoard(new BoardRequestDto(title, content, author));
                        break;

                    case 4:
                        System.out.print("수정할 게시글 ID: ");
                        long updateId = scan.nextLong();
                        scan.nextLine();

                        System.out.print("새 제목: ");
                        String newTitle = scan.nextLine();

                        System.out.print("새 내용: ");
                        String newContent = scan.nextLine();

                        boardController.updateBoard(updateId, new BoardRequestDto(newTitle, newContent, null));
                        break;

                    case 5:
                        System.out.print("삭제할 ID: ");
                        long deleteId = scan.nextLong();
                        boardController.deleteBoard(deleteId);
                        break;

                    case 0:
                        System.out.println("=== 종료합니다. ===");
                        scan.close();

                    default:
                        System.out.println("잘못된 선택입니다. 0~5사이의 숫자를 입력하세요.");
                }

            } catch (InputMismatchException e) {
                System.out.println("입력이 유효하지 않습니다. 숫자를 입력하세요");
                scan.nextLine();    // 유효하지 않은 값을 제거

            } catch (IllegalArgumentException e) {
                // 인수값으로 부적절한 값을 넘길때 던지는 예외
                System.out.println("오류: " + e.getMessage());
            }
        }
    }
}
