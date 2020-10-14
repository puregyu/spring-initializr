package xyz.devyu.springinitialize.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.devyu.springinitialize.domain.Member;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    public void vaildateDuplicateMemberTest() {
        // given
        Member member1 = new Member();
        member1.setName("devyu");

        Member member2 = new Member();
        member2.setName("devyu");

        // when
        memberService.join(member1);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원명 입니다.");

    }
}
