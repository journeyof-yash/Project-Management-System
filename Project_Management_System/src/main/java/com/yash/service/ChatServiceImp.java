package com.yash.service;

import com.yash.model.Chat;
import com.yash.repository.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImp implements ChatService{

    private ChatRepository chatRepository;



    @Override
    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }




}
