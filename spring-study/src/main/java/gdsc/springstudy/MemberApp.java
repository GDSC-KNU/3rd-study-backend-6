package gdsc.springstudy;

import gdsc.springstudy.member.Grade;
import gdsc.springstudy.member.Member;
import gdsc.springstudy.member.MemberService;
import gdsc.springstudy.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
