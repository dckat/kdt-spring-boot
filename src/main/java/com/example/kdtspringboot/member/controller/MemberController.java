package com.example.kdtspringboot.member.controller;

import com.example.kdtspringboot.member.service.MemberService;
import com.example.kdtspringboot.member.vo.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller //싱글톤객체생성 + 아래에 나온 주소와 함수를 스프링에 등록
@RequestMapping("member") //contextpath/member
@RequiredArgsConstructor //@Autowired
//멤버변수 @Autowired로 주입해줄 것을 모두 찾아서 넣어줌.
//@Slf4j //기본으로 지정된 클래스를 써줘(log-back 사용)
@Log4j2 //Slf4j표준에 따라서 만든 클래스인 Log4j를 써줘!
public class MemberController {

    private final MemberService memberService;

    @GetMapping("create") //contextpath/member/create
    public String create() {
        log.info(">>>>>>> 화면 요청 로그기록 >>>>>>>>>");
        System.out.println("create 화면 요청>>>>>>>>>>>>>>>> ");
        return "member/create";
    }

    @PostMapping("create2")
    public String create2(MemberVO memberVO) {
        log.info(">>>>>>> 화면 요청 로그기록 >>>>>>>>>");
        System.out.println("create2 요청>>>>>>>>>>>>>>>> ");
        memberService.create(memberVO);
        return "member/member";
    }

    @GetMapping("member") //contextpath/member/member
    public String member() {
        System.out.println("member 화면 요청>>>>>>>>>>>>>>>> ");

        return "member/member";
    }

    @GetMapping("checkId")
    @ResponseBody
    //뷰인 template가지 않고 단순한데이터나 json으로 보내겠다.
    public boolean checkId(@RequestParam String id) {
        //html이 아니라 체크한 결과를 단순하게 데이터를 보내는 경우
        //컨트롤러에서 바로 템플릿안쓰고 보낼 수 있음.
        System.out.println("member id >>>>>>>>>>>>> " + id);
        boolean result = memberService.checkId(id);
        //리턴은 http body로 단순한 데이터를 보내겠다라는 의미
        return result;
    }

    @PostMapping("login")
    public String login(MemberVO memberVO,
                        HttpSession session,
                        Model model) {
        boolean result = memberService.login(memberVO);
        if (result) {
            session.setAttribute("id", memberVO.getId());
            model.addAttribute("memberVO", memberVO);
            return "member/member";
        }
        else {
            return "error/error";
        }
    }

    @GetMapping("logout") //컨텍스트패스/member/logout
    public String logout(HttpSession session) {
        session.removeAttribute("id");
        return "member/member";
    }

    @PostMapping("read")
    public String read(String id, Model model) { //<input name="id"
        MemberVO memberVO = memberService.read(id);
        model.addAttribute("memberVO", memberVO);
        return "member/read";
    }

    @GetMapping("delete")
    public String delete(String id, HttpSession session) {
        int result = memberService.delete(id);
        if (result > 0) {
            session.removeAttribute("id");
            return "member/member";
        }
        else {
            return "error/error";
        }
    }

    @GetMapping("update") //수정 화면 요청
    public String update(String id, Model model) {
        System.out.println("member id >>>>>>>>>>>>> " + id);
        MemberVO memberVO = memberService.read(id);
        model.addAttribute("memberVO", memberVO);
        return "member/update";
    }

    @PostMapping("update2") //수정 처리 요청
    public String update2(MemberVO memberVO) {
        int result = memberService.update(memberVO);
        if (result > 0) {
            return "member/member";
        }
        else {
            return "error/error";
        }
    }
}
