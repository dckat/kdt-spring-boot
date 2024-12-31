package org.example.kdtspringboot.member.service;

import org.example.kdtspringboot.member.dao.MemberMapper;
import org.example.kdtspringboot.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

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
}
