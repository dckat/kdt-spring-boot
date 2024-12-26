package org.example.kdtspringboot.controller;

import org.example.kdtspringboot.vo.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// 스프링에 컨트롤러 등록
// method + url을 and 조건으로 체크하여 함수 호출
@Controller
public class MemberController {

    @GetMapping("create")
    public String create() {
        System.out.println("create GET 요청");
        return "/member/create";
    }

    @GetMapping("delete")
    public String delete(String id, Model model) {
        System.out.println("delete GET 요청");
        System.out.println(id);
        model.addAttribute("id", id);
        return "member/delete";
    }

    @GetMapping("update")
    public String update(String id, Model model) {
        System.out.println("update GET 요청");
        System.out.println(id);
        model.addAttribute("id", id);
        return "member/update";
    }

    @PostMapping("read")
    public String read(int id) {
        // http의 body로 전달된 id=100을 받아야 함
        // String id = request.getParameter("id");
        // int id2 = Integer.parseInt(id);
        System.out.println("read POST 요청");
        System.out.println("ID = " + id);
        return "/member/read";
    }


    @PostMapping("create2")
    public String create2(MemberVO memberVO, Model model) {
        // public String create2(String id, String pw, String name, String tel) {
        // id=apple&pw=1234&name=park&tel=9999
        // parameter 이름과 호출되는 함수의 매개변수명은 같아야함
        // input name="파라미터명"
        // input의 name="이름"과 호출되는 매개변수명은 같아야함
        System.out.println(memberVO);

        // Model 클래스: html에 값을 전달할 때 사용
        // pre-loading 되어있음 (메소드를 실행할때만 사용하기 때문)
        // 파라미터로 선언하면 스프링이 찾아서 주소를 넣어줌
        // model 변수에 N번에 있다고 주소를 넣어줌
        // 객체(부품)은 부품만 알면 객체의 기능을 사용할 수 있음
        // html에 전달할 값을 지정
        // model.addAttribute("id", memberVO.getId());
        // model.addAttribute("pw", memberVO.getPw());
        // model.addAttribute("name", memberVO.getName());
        // model.addAttribute("tel", memberVO.getTel());

        model.addAttribute("memberVO", memberVO);

        // 회원가입 결과를 html에 보내야 함
        // html 내부에는 controller가 보낸 결과를 출력
        return "member/create2";
    }
}
