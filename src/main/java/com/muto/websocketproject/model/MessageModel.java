package com.muto.websocketproject.model;

public class MessageModel {

    private String roomId;
    private String message;
    private String sender;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "MessageModel{" +
                "roomId='" + roomId + '\'' +
                ", message='" + message + '\'' +
                ", fromLogin='" + sender + '\'' +
                '}';
    }
}
