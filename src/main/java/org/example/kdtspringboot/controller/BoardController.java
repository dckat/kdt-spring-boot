package org.example.kdtspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @GetMapping("createPost")
    public String createPost() {
        System.out.println("createPost GET 요청");
        return "/post/createPost";
    }

    @GetMapping("deletePost")
    public String deletePost() {
        System.out.println("deletePost GET 요청");
        return "/post/deletePost";
    }

    @GetMapping("updatePost")
    public String updatePost() {
        System.out.println("updatePost GET 요청");
        return "/post/updatePost";
    }

    @PostMapping("viewPost")
    public String viewPost() {
        System.out.println("viewPost POST 요청");
        return "/post/viewPost";
    }
}
