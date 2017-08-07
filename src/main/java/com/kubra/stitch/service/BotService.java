package com.kubra.stitch.service;

import com.kubra.stitch.model.Bot;

import java.util.List;

public interface BotService {
    public Bot create(Bot bot);
    public Bot getById(Long id);
    public Bot update(Long id, Bot newBot);
    public void delete(Long id);
    public List<Bot> getAll();
}
