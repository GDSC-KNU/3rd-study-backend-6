package gdsc.springstudy.order;

import gdsc.springstudy.discount.DiscountPolicy;
import gdsc.springstudy.discount.FixDiscountPolicy;
import gdsc.springstudy.member.Member;
import gdsc.springstudy.member.MemberRepository;
import gdsc.springstudy.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemprice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemprice);

        return new Order(memberId, itemName, itemprice, discountPrice);
    }
}
