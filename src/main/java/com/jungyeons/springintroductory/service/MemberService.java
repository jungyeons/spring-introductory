package com.jungyeons.springintroductory.service;

import com.jungyeons.springintroductory.domain.Member;
import com.jungyeons.springintroductory.repository.MemberRepository;
import com.jungyeons.springintroductory.repository.MemoryMemberRepository;

public class MemberService {
    private MemberRepository memberRepository = new MemoryMemberRepository();
    //회원 가입
    public Long join(Member member) {
    memberRepository.save(member);
    return member.getId();
    }
}
