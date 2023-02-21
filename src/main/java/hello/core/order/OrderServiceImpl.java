package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository;


//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();   // FixDiscountPolicy라는 구현체를 직접 넣음으로써 선언했기 때문에 정책을 수정할 때 impl 클래스를 수정해야 함(문제점)
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;  // final로 선언하려면 값이 할당되어 있어야 함 -> final 제거 or 생성자 선언

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
