package xyz.devyu.springinitialize.service;

import org.junit.jupiter.api.Test;
import xyz.devyu.springinitialize.domain.Member;

public class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    public void vaildateDuplicateMemberTest() {
        // given
        Member member1 = new Member();
        member1.setName("devyu");

        Member member2 = new Member();
        member2.setName("devyu");

        // when
        memberService.join(member1);
        memberService.join(member2);

        // then
    }
}
