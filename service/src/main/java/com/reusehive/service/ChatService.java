package com.reusehive.service;

import com.reusehive.entity.database.Message;

import java.util.List;

public interface ChatService {
    List<Message> getMessageList(String username,String tousername);

    void AddMessage(Message message);


}
