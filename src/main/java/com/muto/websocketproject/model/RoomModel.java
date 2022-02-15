package com.muto.websocketproject.model;

import java.util.UUID;

public class RoomModel {

    private String roomId;
    private String name;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static RoomModel create(String name){
        RoomModel room = new RoomModel();

        room.roomId = UUID.randomUUID().toString();
        room.name = name;
        return room;
    }
}
