package org.example.kdtspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// 스프링에 컨트롤러 등록
// method + url을 and 조건으로 체크하여 함수 호출
@Controller
public class MemberController {

    // 함수 4개
    // get 요청 3개
    @GetMapping("create")
    public String create() {
        System.out.println("create GET 요청");
        return "/member/create";
    }

    @GetMapping("delete")
    public String delete() {
        System.out.println("delete GET 요청");
        return "/member/delete";
    }

    @GetMapping("update")
    public String update() {
        System.out.println("update GET 요청");
        return "/member/update";
    }

    // post 요청 1개
    @PostMapping("read")
    public String read(int id) {
        System.out.println("read POST 요청");
        return "/member/read";
    }
}
