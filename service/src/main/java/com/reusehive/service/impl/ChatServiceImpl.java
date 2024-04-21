package com.reusehive.service.impl;

import com.mybatisflex.core.query.QueryWrapper;
import com.reusehive.entity.database.Message;
import com.reusehive.entity.database.table.MessageTableDef;
import com.reusehive.mapper.MessageMapper;
import com.reusehive.service.ChatService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
@CacheConfig(cacheNames = "chat")
public class ChatServiceImpl implements ChatService {
    @Resource
    private MessageMapper messageMapper;

    @Override
    @Cacheable(key = "#username+'_'+#tousername")
    public List<Message> getMessageList(String username, String tousername) {
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select(MessageTableDef.MESSAGE.ALL_COLUMNS)
                .from(MessageTableDef.MESSAGE)
                .where(MessageTableDef.MESSAGE.FROMUSERNAME.eq(username).and(MessageTableDef.MESSAGE.TOUSERNAME.eq(tousername)));
        List<Message> messages = messageMapper.selectListByQuery(queryWrapper);
        queryWrapper = QueryWrapper.create()
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
