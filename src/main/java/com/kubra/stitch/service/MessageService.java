package com.kubra.stitch.service;

import com.kubra.stitch.model.Message;

import java.util.List;

public interface MessageService {
    public Message create(Message message);
    public Message getById(Long id);
    public Message update(Long id, Message newMessage);
    public void delete(Long id);
    public List<Message> getAll();
}
