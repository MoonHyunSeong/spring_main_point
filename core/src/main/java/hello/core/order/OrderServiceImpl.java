package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;


public class OrderServiceImpl implements OrderService {


////    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    //위에 내용처럼 pdf 참고하면서 보면 impl code를 우리가 지금 수정했다. 이 자체가 지금 우리는 (fix,rate)discountpolicy에
//    // 의존하고 있다는 것을 보여주는 것으로 ocp, dip 를 못 지켰음을 보여준다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // 이런식으로 수정해서 DIP를 피한다.
    // DI -> 의존관계 주입이라고 부른다. 굉장히 중요하다.


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
