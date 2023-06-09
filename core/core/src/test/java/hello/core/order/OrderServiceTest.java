package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    @DisplayName("정액할인 테스트 : VIP면 1000원을 할인해준다.")
    void createOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA" , 10000);
     

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
