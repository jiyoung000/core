package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();

//        MemberService memberService = new MemberServiceImpl();  // step1. Service가 직접 구현체를 선언
//        OrderService orderService = new OrderServiceImpl();     // step1
//        MemberService memberService = appConfig.memberService();  // step2. AppConfig에 등록한 생성자를 통해 DI 구현
//        OrderService orderService = appConfig.orderService();     // step2

        // step3. 기존 appConfig를 통해 선언하던 방식을 spring을 이용해서 선언하는 방식으로 변경
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
