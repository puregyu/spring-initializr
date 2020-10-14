package xyz.devyu.springinitialize;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.devyu.springinitialize.ropository.MemberRepository;
import xyz.devyu.springinitialize.ropository.MemoryMemberRepository;
import xyz.devyu.springinitialize.service.MemberService;

@Configuration
public class SpringConfig {

    // 스프링 빈 수동 등록
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    // 스프링 빈 수동 등록
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
