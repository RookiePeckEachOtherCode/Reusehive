package com.reusehive;

import com.reusehive.entity.database.Message;
import com.reusehive.service.ChatService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class test {
    @Resource
    ChatService chatService;

//    @Test
//    public void gg(){
//        Message message=new Message();
//        message.setContent("114");
//        message.setId(null);
//        message.setFromid(2L);
//        message.setToid(1L);
//        message.setCreateTime(LocalDateTime.now());
//        chatService.AddMessage(message);
//        List<Message> messageList = chatService.getMessageList("1", "2");
//        System.out.println(messageList);
//    }

}
