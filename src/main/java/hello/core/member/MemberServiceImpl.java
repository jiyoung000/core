package hello.core.member;

public class MemberServiceImpl implements MemberService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();  // null로 선언하면 뒤에서 NPE 발생
    private final MemberRepository memberRepository;  // 구현체를 직접 넣지 않기 위해 이렇게 수정 + 생성자 선언(AppConfig에서 MemberService가 MemberServiceImpl을 생성하는 생성자에 구현체를 담아서 생성 = 생성자 주입)

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
}
