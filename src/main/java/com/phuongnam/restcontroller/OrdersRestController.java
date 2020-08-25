package com.phuongnam.restcontroller;

import com.phuongnam.model.Orders;
import com.phuongnam.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order")
public class OrdersRestController {
    @Autowired
    private OrdersService ordersService;
    @GetMapping("/list")
    public ResponseEntity<List<Orders>> getOrdersList(){
        List<Orders> ordersList;
        ordersList = ordersService.findAll();
        if (ordersList.isEmpty()){
            return new ResponseEntity<List<Orders>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Orders>>(ordersList,HttpStatus.OK);
        }
    }  @PostMapping(value = "/create")
    public ResponseEntity<Void> createOrders(@RequestBody Orders orders){
        ordersService.save(orders);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Orders> findOrdersById(@PathVariable Long id){
        Optional<Orders> orders = ordersService.findById(id);
        Orders orders1 = orders.get();
        if (orders1 == null){
            return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
        }else {
            ordersService.save(orders1);
            return new ResponseEntity<Orders>(orders1,HttpStatus.OK);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Orders> updateOrders(@PathVariable Long id, @RequestBody Orders orders){
        Optional<Orders> orders1 = ordersService.findById(id);
        Orders orders2 = orders1.get();
        if (orders2 == null){
            return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
        }else {
            orders2.setMonth(orders.getMonth());
            orders2.setPowerNumber(orders.getPowerNumber());
            orders2.setWaterNumber(orders.getWaterNumber());
            ordersService.save(orders2);
            return new ResponseEntity<Orders>(orders2,HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Orders> deleteOrders(@PathVariable Long id){
        Optional<Orders> orders = ordersService.findById(id);
        if (orders == null){
            return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
        }else {
            ordersService.remove(id);
            return new ResponseEntity<Orders>(HttpStatus.NO_CONTENT);
        }
    }
}
