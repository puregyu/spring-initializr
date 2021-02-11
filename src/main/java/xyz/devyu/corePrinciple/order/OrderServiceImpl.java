package xyz.devyu.corePrinciple.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.devyu.corePrinciple.discount.DiscountPolicy;
import xyz.devyu.corePrinciple.member.Member;
import xyz.devyu.corePrinciple.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order();
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
