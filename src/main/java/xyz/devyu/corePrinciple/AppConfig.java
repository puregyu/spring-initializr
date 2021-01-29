package xyz.devyu.corePrinciple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.devyu.corePrinciple.discount.DiscountPolicy;
import xyz.devyu.corePrinciple.discount.FixDiscountPolicy;
import xyz.devyu.corePrinciple.discount.RateDiscountPolicy;
import xyz.devyu.corePrinciple.member.MemberRepository;
import xyz.devyu.corePrinciple.member.MemberService;
import xyz.devyu.corePrinciple.member.MemberServiceImpl;
import xyz.devyu.corePrinciple.member.MemoryMemberRepository;
import xyz.devyu.corePrinciple.order.OrderService;
import xyz.devyu.corePrinciple.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }

}
