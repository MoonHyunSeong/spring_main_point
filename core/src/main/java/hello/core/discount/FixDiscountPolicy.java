package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000 discount

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            //enum 의 경우는 == 쓰는게 맞다.
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
