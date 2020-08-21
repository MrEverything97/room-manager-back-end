package com.phuongnam.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int peopleNumber;
    @ManyToOne
    private Member member;
    private Date dayIn;

    @ManyToOne
    private Orders Orders;

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getDayIn() {
        return dayIn;
    }

    public void setDayIn(Date dayIn) {
        this.dayIn = dayIn;
    }

    public com.phuongnam.model.Orders getOrders() {
        return Orders;
    }

    public void setOrders(com.phuongnam.model.Orders orders) {
        Orders = orders;
    }
}
