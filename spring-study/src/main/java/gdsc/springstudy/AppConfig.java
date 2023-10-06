package gdsc.springstudy;

import gdsc.springstudy.discount.DiscountPolicy;
import gdsc.springstudy.discount.RateDiscountPolicy;
import gdsc.springstudy.member.MemberService;
import gdsc.springstudy.member.MemberServiceImpl;
import gdsc.springstudy.member.MemoryMemberRepository;
import gdsc.springstudy.order.OrderService;
import gdsc.springstudy.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
