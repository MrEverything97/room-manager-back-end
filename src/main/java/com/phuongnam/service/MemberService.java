package com.phuongnam.service;

import com.phuongnam.model.Member;
import com.phuongnam.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    List<Member> findAll();
    Optional<Member> findById(Long id);
    void save(Member member);
    void remove(Long id);
}
