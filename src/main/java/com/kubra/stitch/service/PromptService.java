package com.kubra.stitch.service;

import com.kubra.stitch.model.Prompt;

import java.util.List;

public interface PromptService {
    public Prompt create(Prompt prompt);
    public Prompt getById(Long id);
    public Prompt update(Long id, Prompt newPrompt);
    public void delete(Long id);
    public List<Prompt> getAll();
}
