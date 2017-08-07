package com.kubra.stitch.service;

import com.kubra.stitch.dao.UtteranceDao;
import com.kubra.stitch.model.Utterance;
import com.kubra.stitch.util.CustomBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service("utteranceService")
public class UtteranceServiceImpl implements UtteranceService {

    final private UtteranceDao utteranceDao;

    @Autowired
    public UtteranceServiceImpl(UtteranceDao utteranceDao){
        Assert.notNull(utteranceDao, "UtteranceServiceImpl()::utteranceDao must not be null");
        this.utteranceDao = utteranceDao;
    }

    @Override
    public Utterance create(Utterance utterance) {
        return utteranceDao.save(utterance);
    }

    @Override
    public Utterance getById(Long id) {
        return utteranceDao.findOne(id);
    }

    @Override
    public Utterance update(Long id, Utterance newUtterance) {
        Utterance oldUtterance = utteranceDao.findOne(id);
        CustomBeanUtils.copyPropertiesIgnoreNull(newUtterance, oldUtterance);
        return utteranceDao.save(oldUtterance);
    }

    @Override
    public void delete(Long id) {
        utteranceDao.delete(id);
    }

    @Override
    public List<Utterance> getAll() {
        return utteranceDao.findAll();
    }

}
