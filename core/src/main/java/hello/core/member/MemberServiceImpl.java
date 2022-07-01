package hello.core.member;

public class MemberServiceImpl implements MemberService {
    //interface에 대한 구현체가 하나밖에 없을때는 인터페이스+impl 을 써서 클래스를 만든다.

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }


    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
