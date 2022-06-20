package changhoon.hellospring;

import changhoon.hellospring.repository.MemberRepository;
import changhoon.hellospring.repository.MemoryMemberRepository;
import changhoon.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService()
    {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository()
    {
        return new MemoryMemberRepository();
    }
}
