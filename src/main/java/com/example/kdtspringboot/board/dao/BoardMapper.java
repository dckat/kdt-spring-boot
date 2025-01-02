package com.example.kdtspringboot.board.dao;

import org.apache.ibatis.annotations.Mapper;
import com.example.kdtspringboot.board.vo.BoardVO;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insertBoard(BoardVO boardVO);
    BoardVO selectBoardByNo(int no);
    List<BoardVO> selectBoardAll();
    int updateBoard(BoardVO boardVO);
    int deleteBoard(int no);
    List<BoardVO> getBoardByContent(String find);
}
