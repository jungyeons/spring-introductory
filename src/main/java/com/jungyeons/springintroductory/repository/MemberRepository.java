package com.jungyeons.springintroductory.repository;

import com.jungyeons.springintroductory.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member>  findAll();
    public void clearStore() ;
}
