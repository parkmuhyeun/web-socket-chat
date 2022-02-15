package com.muto.websocketproject.controller;

import com.muto.websocketproject.model.MessageModel;
import com.muto.websocketproject.model.RoomModel;
import com.muto.websocketproject.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final RoomRepository repository;

    @MessageMapping(value = "/chat/enter")
    public void enter(MessageModel message){

        log.info("참여 메시지 나오나??");
        message.setMessage(message.getSender() + "님이 채팅방에 참여하였습니다.");
        simpMessagingTemplate.convertAndSend("/topic/messages/room/" + message.getRoomId(), message);
    }

    @MessageMapping("/chat/message")
    public void sendMessage(MessageModel message) {
        RoomModel room = repository.findRoomById(message.getRoomId());
        if (room != null) {
            simpMessagingTemplate.convertAndSend("/topic/messages/room/" + message.getRoomId(), message);
        }
    }
}
