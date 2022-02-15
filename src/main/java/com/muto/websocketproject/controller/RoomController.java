package com.muto.websocketproject.controller;

import com.muto.websocketproject.model.RoomModel;
import com.muto.websocketproject.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class RoomController {

    private final RoomRepository repository;

    // 모든 채팅방 목록
    @GetMapping("/rooms")
    public List<RoomModel> findAllRoom(){
        return repository.findAllRooms();
    }

    // 채팅방 생성
    @PostMapping("/room")
    public RoomModel createRoom(@RequestBody String name) {
        log.info("채팅방 생성: {}", name);
        return repository.createRoom(name);
    }

}
