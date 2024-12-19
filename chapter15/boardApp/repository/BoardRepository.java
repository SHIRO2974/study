package chapter15.boardApp.repository;

import chapter15.boardApp.entity.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardRepository {

    // DB를 대신하여 게시글을 저장할 리스트
    private final List<Board> boardStorage = new ArrayList<>();
    private long idSequence = 1;

    public List<Board> findAll() {
        return new ArrayList<>(boardStorage);
    }

    public Optional<Board> findById(long id) {

//      findFirst() 메서드
//      Stream 에서 조건에 맞는 첫 번째 요소를 반환하기 위해 사용
//      id가 해당 객체의 고유값이라면, 더 정확하게 해당 객체를 가져오는 방법
//      Optional 타입의 객체를 반환
        return boardStorage.stream()
                .filter(board -> board.getId() == id)
                .findFirst();   // 사용자가 입력한 ID 와 findById 가
                                // 일치하면 일치하는 게시글을 주고 아니라면 예외 발생
    }

    public void save(Board board) {
        board.setId(idSequence++);  // 게시글이 추가 될때마다
        boardStorage.add(board);    // idSequence 1씩 증가
    }

    public void delete(long id) {
//      removeIf()
//      ArrayList 의 메서드
//      인자로 전달된 조건으로 리스트이 아이템을 삭제
//      조건에 부합하는 것은 삭제, 그렇지 않은 것은 리스트에 남음
        boardStorage.removeIf(board -> board.getId() == id);


    }
}
