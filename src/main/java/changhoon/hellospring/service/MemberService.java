package changhoon.hellospring.service;

import changhoon.hellospring.domain.Member;
import changhoon.hellospring.repository.MemberRepository;
import changhoon.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;


public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository)
    {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member)
    {
        //같은 이름이 있는 중복회원은 안된다
        /*Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m-> { //만약 같은 이름이 있으면
            throw new IllegalStateException("이미 존재하는 이름입니다.");
        });*/ //->리펙토링 전 코드

        vaildateDuplicateMember(member); //중복회원 검증

        //과거에는 if(null) 로 했지만 이제는 null일 가능성이 있으면 Optional로 한번 감싸서 포장을 해주고 그 덕분에 ifPresent 등 메소드를 사용할 수 있다
        //자바 문법 및 라이브러리에 대한 공부 필요할 듯
        //코드 리펙토링하고 함수로 만들어 주는데.. 그건 넘어갈까  밑에 만들어 줍니당


        memberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicateMember(Member member)
    {
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체회원 조회
     */
    public List<Member> findMembers()
    {
        return memberRepository.findALL();
    }

    public  Optional<Member> findOne(Long memberId)
    {
        return memberRepository.findByid(memberId);
    }
}
