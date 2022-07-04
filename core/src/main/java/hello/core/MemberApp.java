package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService1 = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        // 1L 에서 L을 준 이유는 타입이 Long 타입이라서 그렇다. 안주면 에러난다.
        // long ? Long? 같은 건가? -> 랩퍼변수
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
