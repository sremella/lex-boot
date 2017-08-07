package com.kubra.stitch.service;

import com.kubra.stitch.dao.MessageDao;
import com.kubra.stitch.model.Message;
import com.kubra.stitch.util.CustomBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

    final private MessageDao messageDao;

    @Autowired
    public MessageServiceImpl(MessageDao messageDao){
        Assert.notNull(messageDao, "MessageServiceImpl()::messageDao must not be null");
        this.messageDao = messageDao;
    }

    @Override
    public Message create(Message message) {
        return messageDao.save(message);
    }

    @Override
    public Message getById(Long id) {
        return messageDao.findOne(id);
    }

    @Override
    public Message update(Long id, Message newMessage) {
        Message oldMessage = messageDao.findOne(id);
        CustomBeanUtils.copyPropertiesIgnoreNull(newMessage, oldMessage);
        return messageDao.save(oldMessage);
    }

    @Override
    public void delete(Long id) {
        messageDao.delete(id);
    }

    @Override
    public List<Message> getAll() {
        return messageDao.findAll();
    }

}
