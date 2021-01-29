package xyz.devyu.corePrinciple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.devyu.corePrinciple.member.Grade;
import xyz.devyu.corePrinciple.member.Member;
import xyz.devyu.corePrinciple.member.MemberService;
import xyz.devyu.corePrinciple.member.MemberServiceImpl;
import xyz.devyu.corePrinciple.order.Order;
import xyz.devyu.corePrinciple.order.OrderService;
import xyz.devyu.corePrinciple.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null, null);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "min", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "치킨볼", 3600);
        System.out.println(order.calculatePrice());

    }
}
