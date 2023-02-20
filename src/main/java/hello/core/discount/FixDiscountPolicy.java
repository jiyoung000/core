package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){    // enum은 비교할 때 ==을 쓰는 게 맞음
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
