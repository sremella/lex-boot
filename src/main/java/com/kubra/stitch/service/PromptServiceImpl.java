package com.kubra.stitch.service;

import com.kubra.stitch.dao.PromptDao;
import com.kubra.stitch.model.Prompt;
import com.kubra.stitch.util.CustomBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service("promptService")
public class PromptServiceImpl implements PromptService {

    final private PromptDao promptDao;

    @Autowired
    public PromptServiceImpl(PromptDao promptDao){
        Assert.notNull(promptDao, "PromptServiceImpl()::promptDao must not be null");
        this.promptDao = promptDao;
    }

    @Override
    public Prompt create(Prompt prompt) {
        return promptDao.save(prompt);
    }

    @Override
    public Prompt getById(Long id) {
        return promptDao.findOne(id);
    }

    @Override
    public Prompt update(Long id, Prompt newPrompt) {
        Prompt oldPrompt = promptDao.findOne(id);
        CustomBeanUtils.copyPropertiesIgnoreNull(newPrompt, oldPrompt);
        return promptDao.save(oldPrompt);
    }

    @Override
    public void delete(Long id) {
        promptDao.delete(id);
    }

    @Override
    public List<Prompt> getAll() {
        return promptDao.findAll();
    }

}
