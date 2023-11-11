package gdsc.springstudy;

import gdsc.springstudy.discount.DiscountPolicy;
import gdsc.springstudy.discount.RateDiscountPolicy;
import gdsc.springstudy.member.MemberService;
import gdsc.springstudy.member.MemberServiceImpl;
import gdsc.springstudy.member.MemoryMemberRepository;
import gdsc.springstudy.order.OrderService;
import gdsc.springstudy.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {return new MemberServiceImpl(memberRepository());}

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
