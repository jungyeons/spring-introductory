package com.jungyeons.springintroductory;

import com.jungyeons.springintroductory.repository.JdbcTemplateMemberRepository;
import com.jungyeons.springintroductory.repository.MemberRepository;
import com.jungyeons.springintroductory.repository.MemoryMemberRepository;
import com.jungyeons.springintroductory.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

 //   private final MemberRepository memberRepository;
    private DataSource dataSource;

//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository);
//    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
    }

}