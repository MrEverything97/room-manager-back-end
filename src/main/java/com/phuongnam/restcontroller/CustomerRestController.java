package com.phuongnam.restcontroller;

import com.phuongnam.model.Customer;

import com.phuongnam.service.CustormerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customer")
public class CustomerRestController {
    @Autowired
    private CustormerService custormerService;
    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getMemberList(){
        List<Customer> customerList;
        customerList = custormerService.findAll();
        if (customerList.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
        }
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createMember(@RequestBody Customer customer){
        custormerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findMemberById(@PathVariable Long id){
        Optional<Customer> member = custormerService.findById(id);
        Customer customer1 = member.get();
        if (customer1 == null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }else {
            custormerService.save(customer1);
            return new ResponseEntity<Customer>(customer1,HttpStatus.OK);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateMember(@PathVariable Long id, @RequestBody Customer customer){
        Optional<Customer> member1 = custormerService.findById(id);
        Customer customer2 = member1.get();
        if (customer2 == null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }else {
            customer2.setFirstName(customer.getFirstName());
            customer2.setLastName(customer.getLastName());
            customer2.setIdCard(customer.getIdCard());
            customer2.setPhoneNumber(customer.getPhoneNumber());
            customer2.setProvince(customer.getProvince());
            custormerService.save(customer2);
            return new ResponseEntity<Customer>(customer2,HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Customer> deleteMember(@PathVariable Long id){
        Optional<Customer> member = custormerService.findById(id);
        if (member == null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }else {
            custormerService.remove(id);
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
        }
    }
}
