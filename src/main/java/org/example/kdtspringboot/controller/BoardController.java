package org.example.kdtspringboot.controller;

import org.example.kdtspringboot.vo.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @GetMapping("createPost")
    public String createPost() {
        System.out.println("createPost GET 요청");
        return "/board/createPost";
    }

    @GetMapping("deletePost")
    public String deletePost(int no, Model model) {
        System.out.println("deletePost GET 요청");
        System.out.println(no);
        model.addAttribute("no", no);
        return "board/deletePost";
    }

    @GetMapping("updatePost")
    public String updatePost(int no, Model model) {
        System.out.println("updatePost GET 요청");
        System.out.println(no);
        model.addAttribute("no", no);
        return "board/updatePost";
    }

    @PostMapping("viewPost")
    public String viewPost() {
        System.out.println("viewPost POST 요청");
        return "board/viewPost";
    }

    @PostMapping("createPost2")
    public String createPost2(BoardVO boardVO, Model model) {
        System.out.println(boardVO);

        model.addAttribute("boardVO", boardVO);

        return "board/createPost2";
    }
}
