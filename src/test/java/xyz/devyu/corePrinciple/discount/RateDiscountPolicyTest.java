package xyz.devyu.corePrinciple.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import xyz.devyu.corePrinciple.member.Grade;
import xyz.devyu.corePrinciple.member.Member;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10% 할인이 되어야 한다.")
    public void 퍼센트할인_검증() {
        // given
        Member min = new Member(1L, "min", Grade.VIP);
        // when
        int discount = rateDiscountPolicy.discount(min, 11000);
        // then
        assertThat(discount).isEqualTo(1100);
    }

    @Test
    @DisplayName("vip가 아니면 할인이 적용되지 않아야 한다.")
    public void 퍼센트할인_미적용_검증() {
        // given
        Member min = new Member(2L, "gyu", Grade.BASIC);
        // when
        int discount = rateDiscountPolicy.discount(min, 11000);
        // then
        assertThat(discount).isEqualTo(0);
    }

}