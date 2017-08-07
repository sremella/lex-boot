package com.kubra.stitch.service;

import com.kubra.stitch.model.SlotType;

import java.util.List;

public interface SlotTypeService {
    public SlotType create(SlotType slotType);
    public SlotType getById(Long id);
    public SlotType update(Long id, SlotType newSlotType);
    public void delete(Long id);
    public List<SlotType> getAll();
}
