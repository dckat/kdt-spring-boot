package org.example.kdtspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// mvc 중에서 컨트롤러 역할을 담당하는 것으로 설정
// 주소 + method 인식해서 처리하는 함수를 호출하는 코드
// 싱글톤으로 객체 생성
@Controller
public class HomeController {

    @GetMapping("member")
    public String member() {
        System.out.println("member get 요청 들어옴.");
        // FrontController에게 결과를 넣어줄 html 파일을 알려줌
        // FrontController가 받은 파일명.html 호출
        // 호출한 html 파일에 넣어서(타임리프 활용) 만든
        // 최종 생성된 html 파일을 웹서버에 전달
        // 웹서버는 http로 만들어서 클라이언트에 전달
        return "/member/member";
    }

    // 메소드명: 요청된 주소와 동일하게 만들어 주는 편
    // html 파일명도 주소와 일치시켜주는 것이 일반적
    @GetMapping("board")
    public String board() {
        System.out.println("board get 요청 들어옴.");
        return "/board/board";
    }
}
