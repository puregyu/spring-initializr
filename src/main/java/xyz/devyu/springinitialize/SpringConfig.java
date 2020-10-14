package xyz.devyu.springinitialize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.devyu.springinitialize.aop.TimeTraceAOP;
import xyz.devyu.springinitialize.ropository.JdbcTemplateMemberRepository;
import xyz.devyu.springinitialize.ropository.MemberRepository;
import xyz.devyu.springinitialize.ropository.MemoryMemberRepository;
import xyz.devyu.springinitialize.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // 스프링 빈 수동 등록
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    // 스프링 빈 수동 등록
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }

    // AOP 등록
//    @Bean
//    public TimeTraceAOP timeTraceAOP() {
//        return new TimeTraceAOP();
//    }


}
