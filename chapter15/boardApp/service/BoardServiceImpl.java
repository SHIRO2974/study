package chapter15.boardApp.service;

import chapter15.boardApp.dto.BoardRequestDto;
import chapter15.boardApp.dto.BoardResponseDto;
import chapter15.boardApp.entity.Board;
import chapter15.boardApp.repository.BoardRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    public BoardServiceImpl() {
        this.boardRepository = new BoardRepository();
    }

    @Override
    public List<BoardResponseDto> findAll() {
        // DB 에서 게시판 전체 데이터 가져오기
        List<Board> boardList = boardRepository.findAll();

        // 게시판 데이터를 응답 객체로 변환
        List<BoardResponseDto> boardResponseDtos = boardList.stream()
                .map(BoardResponseDto::fromEntity)
                .collect(Collectors.toList());


        // 응답 객체 반환
        return boardResponseDtos;
    }

    @Override
    public BoardResponseDto findByID(long id) {
        // 요청: 파라미터의 id 데이터를 DB 에서 검색 후 반환
        Optional<Board> board = boardRepository.findById(id);

        BoardResponseDto boardResponseDto = board
                .map(BoardResponseDto::fromEntity)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        // 반환
        return boardResponseDto;
    }

    @Override
    public void save(BoardRequestDto boardRequestDto) {
        Board board = boardRequestDto.toEntity();
        boardRepository.save(board);
    }

    @Override
    public void update(long id, BoardRequestDto boardRequestDto) {

        Board existingBoard = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        existingBoard.setTitle(boardRequestDto.getTitle());
        existingBoard.setContent(boardRequestDto.getContent());
    }

    @Override
    public void delete(long id) {

        if (!boardRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("삭제할 게시글이 존재하지 않습니다.");
        }
        boardRepository.delete(id);
    }
}
