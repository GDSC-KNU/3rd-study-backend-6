package gdsc.springstudy.order;

import gdsc.springstudy.discount.DiscountPolicy;
import gdsc.springstudy.discount.FixDiscountPolicy;
import gdsc.springstudy.discount.RateDiscountPolicy;
import gdsc.springstudy.member.Member;
import gdsc.springstudy.member.MemberRepository;
import gdsc.springstudy.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemprice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemprice);

        return new Order(memberId, itemName, itemprice, discountPrice);
    }
}
