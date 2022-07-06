package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
    //interface에 대한 구현체가 하나밖에 없을때는 인터페이스+impl 을 써서 클래스를 만든다.

    private final MemberRepository memberRepository;

    @Autowired // ac.getBean(MemberRepository.class) 와 같은 역할 자동으로 의존관계 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }


    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
