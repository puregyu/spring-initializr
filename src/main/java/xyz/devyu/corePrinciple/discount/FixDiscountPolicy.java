package xyz.devyu.corePrinciple.discount;

import xyz.devyu.corePrinciple.member.Grade;
import xyz.devyu.corePrinciple.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    // 1000원 고정 할인금액
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }

}
