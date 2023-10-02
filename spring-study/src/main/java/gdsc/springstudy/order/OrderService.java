package gdsc.springstudy.order;

import gdsc.springstudy.member.MemberRepository;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemprice);

}
