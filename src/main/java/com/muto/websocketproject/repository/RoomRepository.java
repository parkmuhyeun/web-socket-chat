package com.muto.websocketproject.repository;

import com.muto.websocketproject.model.RoomModel;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class RoomRepository {

    private Map<String, RoomModel> roomModelMap;

    @PostConstruct
    private void init(){
        roomModelMap = new LinkedHashMap<>();
    }

    public List<RoomModel> findAllRooms() {
        List<RoomModel> rooms = new ArrayList<>(roomModelMap.values());
        Collections.reverse(rooms);

        return rooms;
    }

    public RoomModel findRoomById(String id) {
        return roomModelMap.get(id);
    }

    public RoomModel createRoom(String name) {
        RoomModel room = RoomModel.create(name);
        roomModelMap.put(room.getRoomId(), room);

        return room;
    }
}
