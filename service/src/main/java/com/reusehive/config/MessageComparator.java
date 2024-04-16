package com.reusehive.config;

import com.reusehive.entity.database.Message;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MessageComparator implements Comparator<Message> {
    @Override
    public int compare(Message msg1, Message msg2) {
        // 比较 createTime 属性
        return msg1.getCreateTime().compareTo(msg2.getCreateTime());
    }
}