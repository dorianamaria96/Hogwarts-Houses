package com.codecool.hogwartshouses.controller;


import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.repository.RoomRepository;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class RoomController {
    private final RoomService roomService;
    private final RoomRepository roomRepository;

    public RoomController(RoomService roomService, RoomRepository roomRepository) {
        this.roomService = roomService;
        this.roomRepository = roomRepository;
    }

    @GetMapping("rooms")
    public List<Room> get() {
        return roomRepository.findAll();
    }

    @PostMapping("rooms")
    public Room post() {
        return roomRepository.save(roomService.createNewEmptyRoom());
    }

    @GetMapping("rooms/{roomId}")
    public Optional<Room> getRoom(@PathVariable Long roomId) throws RoomNotFound {
        if (roomRepository.existsById(roomId)) {
            return roomRepository.findById(roomId);
        } else {
            throw new RoomNotFound("This room doesn't exist.");
        }
    }

    @DeleteMapping("rooms/{roomId}")
    public void deleteRoom(@PathVariable Long roomId) throws RoomNotFound {
        if (roomRepository.existsById(roomId)) {
            roomRepository.deleteById(roomId);
        } else {
            throw new RoomNotFound("This room doesn't exist.");
        }
    }

    @PutMapping("rooms/{roomId}")
    public Room updateRoom(@PathVariable Long roomId) throws RoomNotFound {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new RoomNotFound("This room does not exist."));
        room.setHouseType(HouseType.RAVENCLAW);
        return roomRepository.save(room);
    }

    @PutMapping("assignStudent/{studentId}")
    public void assignStudent(@PathVariable Long studentId) throws StudentNotFound {
        roomService.assignStudentToRoom(studentId);
    }

    @GetMapping("rooms/available")
    public List<Room> getEmptyRooms() {
        //return roomService.getEmptyRooms(); -- also a possibility
        return roomRepository.getRoomsByStudentsEmpty();
    }

    @GetMapping("/rooms/rat-owners")
    public List<Room> roomsWithoutRatOwners() {
        return roomService.findSafeRoomForRonsRat();
    }
}