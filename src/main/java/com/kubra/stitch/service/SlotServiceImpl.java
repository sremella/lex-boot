package com.kubra.stitch.service;

import com.kubra.stitch.dao.SlotDao;
import com.kubra.stitch.model.Slot;
import com.kubra.stitch.util.CustomBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service("slotService")
public class SlotServiceImpl implements SlotService {

    final private SlotDao slotDao;

    @Autowired
    public SlotServiceImpl(SlotDao slotDao){
        Assert.notNull(slotDao, "SlotServiceImpl()::slotDao must not be null");
        this.slotDao = slotDao;
    }

    @Override
    public Slot create(Slot slot) {
        return slotDao.save(slot);
    }

    @Override
    public Slot getById(Long id) {
        return slotDao.findOne(id);
    }

    @Override
    public Slot update(Long id, Slot newSlot) {
        Slot oldSlot = slotDao.findOne(id);
        CustomBeanUtils.copyPropertiesIgnoreNull(newSlot, oldSlot);
        return slotDao.save(oldSlot);
    }

    @Override
    public void delete(Long id) {
        slotDao.delete(id);
    }

    @Override
    public List<Slot> getAll() {
        return slotDao.findAll();
    }

}
