package com.phuongnam.restcontroller;

import com.phuongnam.model.Member;

import com.phuongnam.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/member")
public class MemberRestController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/list")
    public ResponseEntity<List<Member>> getMemberList(){
        List<Member> memberList;
        memberList = memberService.findAll();
        if (memberList.isEmpty()){
            return new ResponseEntity<List<Member>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Member>>(memberList,HttpStatus.OK);
        }
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createMember(@RequestBody Member member){
        memberService.save(member);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Member> findMemberById(@PathVariable Long id){
        Optional<Member> member = memberService.findById(id);
        Member member1 = member.get();
        if (member1 == null){
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
        }else {
            memberService.save(member1);
            return new ResponseEntity<Member>(member1,HttpStatus.OK);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member){
        Optional<Member> member1 = memberService.findById(id);
        Member member2 = member1.get();
        if (member2 == null){
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
        }else {
            member2.setFirstName(member.getFirstName());
            member2.setLastName(member.getLastName());
            member2.setIdCard(member.getIdCard());
            member2.setPhoneNumber(member.getPhoneNumber());
            member2.setProvince(member.getProvince());
            memberService.save(member2);
            return new ResponseEntity<Member>(member2,HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Member> deleteMember(@PathVariable Long id){
        Optional<Member> member = memberService.findById(id);
        if (member == null){
            return new ResponseEntity<Member>(HttpStatus.NOT_FOUND);
        }else {
            memberService.remove(id);
            return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
        }
    }
}
