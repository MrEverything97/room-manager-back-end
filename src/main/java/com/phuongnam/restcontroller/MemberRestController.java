package com.phuongnam.restcontroller;

import com.phuongnam.model.Member;
import com.phuongnam.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/member")
public class MemberRestController {
    @Autowired
    private MemberService memberService;
    @GetMapping("/")
    public ResponseEntity<List<Member>> getMemberList(){
        List<Member> memberList;
        memberList = memberService.findAll();
        if (memberList.isEmpty()){
            return new ResponseEntity<List<Member>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Member>>(memberList,HttpStatus.OK);
        }
    }
}
