package gdsc.springstudy.discount;

import gdsc.springstudy.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);

}
