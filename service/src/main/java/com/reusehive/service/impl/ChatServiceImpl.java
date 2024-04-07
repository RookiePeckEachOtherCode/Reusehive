package com.reusehive.service.impl;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import com.reusehive.entity.database.Message;
import com.reusehive.entity.database.table.MessageTableDef;
import com.reusehive.mapper.MessageMapper;
import com.reusehive.service.ChatService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Component
@Slf4j
public class ChatServiceImpl implements ChatService {
    @Resource
    private MessageMapper messageMapper;

    @Override
    public List<Message> getMessageList(String username, String tousername) {
        QueryWrapper queryWrapper=QueryWrapper.create()
                .select(MessageTableDef.MESSAGE.ALL_COLUMNS)
                .from(MessageTableDef.MESSAGE)
                .where(MessageTableDef.MESSAGE.FROMUSERNAME.eq(username).and(MessageTableDef.MESSAGE.TOUSERNAME.eq(tousername)));
        List<Message> messages = messageMapper.selectListByQuery(queryWrapper);
        queryWrapper=QueryWrapper.create()
                .select(MessageTableDef.MESSAGE.ALL_COLUMNS)
                .from(MessageTableDef.MESSAGE)
                .where(MessageTableDef.MESSAGE.FROMUSERNAME.eq(tousername).and(MessageTableDef.MESSAGE.TOUSERNAME.eq(username)));

        messages.addAll(messageMapper.selectListByQuery(queryWrapper));
        return messages;
    }

    @Override
    public void AddMessage(Message message) {
        messageMapper.insert(message);
    }
}
