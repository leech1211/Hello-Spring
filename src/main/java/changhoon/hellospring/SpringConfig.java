package changhoon.hellospring;

import changhoon.hellospring.repository.JDBCTemplateMemberRepository;
import changhoon.hellospring.repository.JdbcMemberRepository;
import changhoon.hellospring.repository.MemberRepository;
import changhoon.hellospring.repository.MemoryMemberRepository;
import changhoon.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JDBCTemplateMemberRepository(dataSource);
    }
}

