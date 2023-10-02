package gdsc.springstudy.order;

import gdsc.springstudy.member.Grade;
import gdsc.springstudy.member.Member;
import gdsc.springstudy.member.MemberService;
import gdsc.springstudy.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    // 해당 코드에서 new MemberServiceImpl()과 new OrderServiceImpl()은
    // 각각 new MemoryMemberRepository()으로 서로 다른 MemoryMemberRepository 객체를 생성하고 있지만,
    // memberService에서 join한 Member를 OrderService에서도 사용할 수 있는 이유는,
    // MemberRepository의 store 변수가 static으로 선언되어 있기 떄문이다
    // MemoryMemberRepository()은 서로 다른 객체여도, store라는 static 변수를 함께 공유해서 사용하기 때문에
    // MemberService에서 등록한 Member도 OrderService에서 사용할 수 있는 것이다!

    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}