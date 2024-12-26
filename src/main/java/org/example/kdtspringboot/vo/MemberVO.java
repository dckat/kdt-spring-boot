package org.example.kdtspringboot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // get/set/toString
@AllArgsConstructor     // 모든 변수를 넣은 생성자
@NoArgsConstructor      // 기본 생성자
public class MemberVO {
    private String id;
    private String pw;
    private String name;
    private String tel;

    // set: 값을 넣을때
    // 스프링이 클라이언트로부터 받은 데이터를 vo의 각 set 메소드를 불러서 넣어줌
    // set 메소드가 반드시 구현되어 있어야 함
}
