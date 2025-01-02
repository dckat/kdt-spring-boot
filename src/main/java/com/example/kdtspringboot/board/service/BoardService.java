package com.example.kdtspringboot.board.service;

import com.example.kdtspringboot.board.dao.BoardMapper;
import com.example.kdtspringboot.board.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    // BoardMapper 인터페이스에 따라 생성된 dao의
    // 주소를 찾아서 변수에 저장
    private final BoardMapper boardMapper;

    public int insertBoard(BoardVO boardVO) {
        return boardMapper.insertBoard(boardVO);
    }

    public BoardVO selectBoardByNo(int no) {
        return boardMapper.selectBoardByNo(no);
    }

    public List<BoardVO> selectBoardAll() {
        return boardMapper.selectBoardAll();
    }

    public int updateBoard(BoardVO boardVO) {
        return boardMapper.updateBoard(boardVO);
    }

    public int deleteBoard(int no) {
        return boardMapper.deleteBoard(no);
    }

    List<BoardVO> getBoardByContent(String find) {
        return boardMapper.getBoardByContent(find);
    }
}
