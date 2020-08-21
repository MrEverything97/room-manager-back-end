package com.phuongnam.service.impl;

import com.phuongnam.model.Member;
import com.phuongnam.repository.MemberRepository;
import com.phuongnam.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public List<Member> findAll() {
        return memberRepository.findAll() ;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void remove(Long id) {
        memberRepository.deleteById(id);
    }
}