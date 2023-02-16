package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.controller.StudentNotFound;
import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.repository.RoomRepository;
import com.codecool.hogwartshouses.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    private final StudentRepository studentRepository;

    public RoomService(RoomRepository roomRepository, StudentRepository studentRepository) {
        this.roomRepository = roomRepository;
        this.studentRepository = studentRepository;
    }

    public Room createNewEmptyRoom() {
        return new Room(HouseType.GRYFFINDOR, null);
    }

    public List<Room> getEmptyRooms() {
        List<Room> allRoom = roomRepository.findAll();
        List<Room> emptyRooms = new ArrayList<>();
        for (Room room : allRoom) {
            if (room.getStudents().size() == 0) {
                emptyRooms.add(room);
            }
        }
        return emptyRooms;
    }

    public void assignStudentToRoom(Long studentId) throws StudentNotFound {
        List<Room> emptyRooms = getEmptyRooms();
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFound("This student does not go to this school."));
        Room firstEmptyRoom = emptyRooms.stream().findFirst().orElse(null);
        Set<Student> students = new HashSet<>();
        students.add(student);
        assert firstEmptyRoom != null;
        firstEmptyRoom.setStudents(students);
        roomRepository.save(firstEmptyRoom);
    }

    public List<Room> findSafeRoomForRonsRat() {
        List<Room> safeRooms = new ArrayList<>();
        List<Room> allRooms = roomRepository.findAll();
        for (Room room : allRooms) {
            for (Student student : room.getStudents()) {
                if (student.getPetType() != PetType.CAT && student.getPetType() != PetType.OWL) {
                    safeRooms.add(room);
                }
            }
        }
        return safeRooms;
    }

}
