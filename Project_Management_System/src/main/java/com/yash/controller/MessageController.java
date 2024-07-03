package com.yash.controller;

import com.yash.model.Chat;
import com.yash.model.Message;
import com.yash.model.User;
import com.yash.request.CreateMessageRequest;
import com.yash.service.MessageService;
import com.yash.service.ProjectService;
import com.yash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    private MessageService messageService;

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody CreateMessageRequest request) throws Exception{

        User user =  userService.findUserById(request.getSenderId());

        Chat chat =projectService.getProjectById(request.getProjectId()).getChat();

        if (chat==null)throw new Exception("Chats not found");

        Message sentMessage = messageService.sendMessage(request.getSenderId(),
                request.getProjectId(),
                request.getContent());
        return ResponseEntity.ok(sentMessage);

    }

    @GetMapping("/chat/{projectId}")
    public ResponseEntity<List<Message>> getMessagesByChatId(@PathVariable Long projectId)
        throws Exception{
        List<Message> messages =  messageService.getMessageByProjectId(projectId);
        return ResponseEntity.ok(messages);
    }


}
