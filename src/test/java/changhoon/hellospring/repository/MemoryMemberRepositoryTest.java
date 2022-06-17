package changhoon.hellospring.repository;

import changhoon.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach()
    {
        repository.clearStore();
    }

    @Test
    public void save()
    {
        Member member = new Member();
        member.setName("changhoon");

        repository.save(member);

        Member result = repository.findByid(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName()
    {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

       Member result =  repository.findByName("spring1").get();
       Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll()
    {
        Member member1 = new Member();
        member1.setName("test1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("test2");
        repository.save(member2);

        List<Member> result = repository.findALL();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}