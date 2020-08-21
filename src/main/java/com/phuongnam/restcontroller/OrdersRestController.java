package com.phuongnam.restcontroller;

import com.phuongnam.model.Member;
import com.phuongnam.model.Orders;
import com.phuongnam.service.MemberService;
import com.phuongnam.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order")
public class OrdersRestController {
    @Autowired
    private OrdersService ordersService;
    @GetMapping("/")
    public ResponseEntity<List<Orders>> getOrdersList(){
        List<Orders> ordersList;
        ordersList = ordersService.findAll();
        if (ordersList.isEmpty()){
            return new ResponseEntity<List<Orders>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Orders>>(ordersList,HttpStatus.OK);
        }
    }
}
