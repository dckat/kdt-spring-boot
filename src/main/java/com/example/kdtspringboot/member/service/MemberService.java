package com.example.kdtspringboot.member.service;

import com.example.kdtspringboot.member.dao.MemberMapper;
import com.example.kdtspringboot.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    /*
    public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    } // 객체 생성시 생성자 호출할 때 생성자의 파라메터 값으로 두 개의 주소를 찾아서 멤버변수에 넣어주는 방식 (생성자 주입 방식)
    */

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public int create(MemberVO memberVO) {
        String pw = encodePassword(memberVO.getPw());
        memberVO.setPw(pw);
        int result = memberMapper.insertMember(memberVO);
        return result;
    }

    public boolean login(MemberVO memberVO) {
        MemberVO memberVO1 = memberMapper.selectMemberById(memberVO.getId());
        if (memberVO1 != null) {
            return passwordEncoder.matches(memberVO.getPw(), memberVO1.getPw());
        }
        return false;
    }

    public MemberVO read(String id) {
        return memberMapper.selectMemberById(id);
    }

    public int delete(String id) {
        return memberMapper.deleteMember(id);
    }

    public int update(MemberVO memberVO) {
        String pw = encodePassword(memberVO.getPw());
        memberVO.setPw(pw);
        return memberMapper.updateMember(memberVO);
    }

    public boolean checkId(String id) {
        // 가입하려는 id를 가지고 검색하여 null이 아니면
        // 해당 아이디로 이미 가입이 되어있음 --> 사용할 수 없는 아이디로 처리!
        return memberMapper.selectMemberById(id) == null;
    }
}
