package xyz.devyu.corePrinciple.discount;

import xyz.devyu.corePrinciple.member.Grade;
import xyz.devyu.corePrinciple.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    // 10% 할인금액
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }

}
