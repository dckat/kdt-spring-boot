package org.example.kdtspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// mvc 중에서 컨트롤러 역할을 담당하는 것으로 설정
// 주소 + method 인식해서 처리하는 함수를 호출하는 코드
@Controller
public class HomeController {

    // 요청 하나당 함수는 1개
    // 1. get 방식 + test 주소
    @GetMapping("test")
    public String test() {
        System.out.println("test get 요청 들어옴.");
        return "test";      // html 파일 반환!! test.html 파일을 호출해서 응답
    }

    // 2. get 방식 + member 주소
    @GetMapping("member")
    public String member() {
        System.out.println("member get 요청 들어옴.");
        return "/member/member";    // html 파일 반환!! member.html 파일을 호출해서 응답
    }

    @GetMapping("board")
    public String board() {
        System.out.println("board get 요청 들어옴.");
        return "/post/board";
    }
}
