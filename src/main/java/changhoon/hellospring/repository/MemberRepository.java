package changhoon.hellospring.repository;

import changhoon.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //저장
    //Optional 은 null인경우 감싸서 반환
    Optional<Member> findById(Long id); //    id로 찾기
    Optional<Member> findByName(String name);   //name으로 찾기
    List<Member> findALL();     //모든회원 반환
}

