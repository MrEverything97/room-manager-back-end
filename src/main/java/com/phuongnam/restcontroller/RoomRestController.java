package com.phuongnam.restcontroller;

import com.phuongnam.model.Member;
import com.phuongnam.model.Room;
import com.phuongnam.service.MemberService;
import com.phuongnam.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/room")
public class RoomRestController {
    @Autowired
    private RoomService roomService;
    @GetMapping("/")
    public ResponseEntity<List<Room>> getRoomList(){
        List<Room> roomList;
        roomList = roomService.findAll();
        if (roomList.isEmpty()){
            return new ResponseEntity<List<Room>>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<List<Room>>(roomList,HttpStatus.OK);
        }
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createRoom(@RequestBody Room room){
        roomService.save(room);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Room> findSongById(@PathVariable Long id){
        Optional<Room> room = roomService.findById(id);
        Room room1 = room.get();
        if (room1 == null){
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }else {
            roomService.save(room1);
            return new ResponseEntity<Room>(room1,HttpStatus.OK);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room){
        Optional<Room> room1 = roomService.findById(id);
        Room room2 = room1.get();
        if (room2 == null){
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }else {
            room2.setName(room.getName());
            room2.setPeopleNumber(room.getPeopleNumber());
            room2.setDayIn(room.getDayIn());
            room2.setMember(room.getMember());
            room2.setOrders(room.getOrders());
            roomService.save(room2);
            return new ResponseEntity<Room>(room2,HttpStatus.OK);
        }
    }
}
