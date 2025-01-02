package com.example.kdtspringboot.board.controller;

import com.example.kdtspringboot.board.service.BoardService;
import com.example.kdtspringboot.board.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller //싱글톤객체생성 + 아래에 나온 주소와 함수를 스프링에 등록
@RequestMapping("board") //contextpath/board
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("board") //contextpath/board/board
    public String board(Model model) {
        System.out.println("board 화면 요청>>>>>>>>>>>>>>>> ");

        List<BoardVO> list = boardService.selectBoardAll();
        System.out.println("list size(): " + list.size());
        System.out.println("------------list------------");
        System.out.println(list);

        // model은 templates 파일까지 list 데이터 전달 (주소값으로)
        model.addAttribute("list", list);

        return "board/board";
    }

    @GetMapping("create")
    public String create() {
        return "board/create";      // 글쓰기 화면 요청
    }

    @GetMapping("read")
    public String read(int no, Model model) {
        BoardVO boardVO = boardService.selectBoardByNo(no);
        model.addAttribute("boardVO", boardVO);
        return "board/read";
    }

    @GetMapping("update")
    public String update(int no, Model model) {
        BoardVO boardVO = boardService.selectBoardByNo(no);
        System.out.println(boardVO);
        model.addAttribute("boardVO", boardVO);
        return "board/update";
    }

    @GetMapping("delete")
    public String delete(int no, Model model) {
        boardService.deleteBoard(no);
        return "redirect:/board/board";
    }

    @PostMapping("create2")
    public String create2(BoardVO boardVO) {
        boardService.insertBoard(boardVO);
        return "redirect:/board/board";
    }

    @PostMapping("update2")
    public String update2(BoardVO boardVO) {
        System.out.println("boardVO >>>>>>>>>>>>>>> " + boardVO);
        int result = boardService.updateBoard(boardVO);
        if (result > 0) {
            return "board/update2";
        }
        else {
            return "error/error";
        }
    }
}
