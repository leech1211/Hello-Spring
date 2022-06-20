package changhoon.hellospring.service;

import changhoon.hellospring.domain.Member;
import changhoon.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach()
    {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach()
    {
        memberRepository.clearStore();
    }

    @Test
    //테스트는 과감하게 한글로 바꾸셔도 됩니다 직관적이잖아요? 빌드할때 테스트코드는 포함되지 않아요
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);   //join의 return값은 id값

        //then
        Member findMember = memberService.findOne(saveId).get();
        org.assertj.core.api.Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    //테스트는 주로 무엇이 주어졌을때 (given)
    //무언갈 실행했을때 (when)
    //결과가 이렇다 (then)

    //join시 예외처리되는 부분도 확인
    @Test
    public void 중복회원예외()
    {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
       IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

       assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
       /* try
        {
            memberService.join(member2);
            fail();
        }catch (IllegalStateException e)
        {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        //then


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}