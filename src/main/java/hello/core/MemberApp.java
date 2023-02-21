package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        // 기존 appConfig를 통해 선언하던 방식을 spring을 이용해서 선언하는 방식으로 변경
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);  // AppConfig에 있는 설정 정보를 갖고 spring 컨테이너에 빈 등록
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // 빈이름은 메소드 이름으로 등록된다(default)

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
