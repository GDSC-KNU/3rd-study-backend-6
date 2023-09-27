package gdsc.springstudy;

import gdsc.springstudy.member.Grade;
import gdsc.springstudy.member.Member;
import gdsc.springstudy.member.MemberService;
import gdsc.springstudy.member.MemberServiceImpl;
import gdsc.springstudy.order.Order;
import gdsc.springstudy.order.OrderService;
import gdsc.springstudy.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.BASIC);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = "+order);
    }
}
