package com.jungyeons.springintroductory.repository;

import com.jungyeons.springintroductory.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
    repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("jungyeons");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("jungyeons1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("jungyeons2");
        repository.save(member2);

        Member result = repository.findByName("jungyeons1").get();
        assertThat(member1).isEqualTo(result);


    }
    @Test
    public void findAll(){

        Member member1 = new Member();
        member1.setName("jungyeons1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("jungyeons2");
        repository.save(member2);
        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
