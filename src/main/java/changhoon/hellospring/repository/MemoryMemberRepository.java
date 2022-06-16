package changhoon.hellospring.repository;

import changhoon.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    //save할때 저장하는 공간
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;  //0,1,2.. key값을 생성해주는 친구


    @Override
    public Member save(Member member) {
        member.setId(++sequence);               //member의 id값을 세팅
        store.put(member.getId(),member);       //member를 store에 추가
        return member;
        //name은 사용자가 입력하는 것이고 id는 시스템이 정해주는 것
    }

    @Override
    public Optional<Member> findByid(Long id) {
        //return store.get(id); //이렇게 하면 NULL이 반환될 가능성이 있음
        return Optional.ofNullable(store.get(id));  //이렇게 하면 NULL이어도 감싸서 반환 할 수 있다
    }

    @Override
    public Optional<Member> findByName(String name) {
        //자바관련된 내용이라 자바를 공부해야함
        //store에서 loop를 돌림 member의 이름이 name 과 같으면 반환
        //findAny()는 하나만 찾는것
       return store.values().stream()
               .filter(member -> member.getName().equals(name))
               .findAny();
    }

    @Override
    public List<Member> findALL() {
        return new ArrayList<>(store.values());
    }
}
