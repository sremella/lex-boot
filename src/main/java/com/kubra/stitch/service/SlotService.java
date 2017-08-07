package com.kubra.stitch.service;

import com.kubra.stitch.model.Slot;

import java.util.List;

public interface SlotService {
    public Slot create(Slot intent);
    public Slot getById(Long id);
    public Slot update(Long id, Slot newSlot);
    public void delete(Long id);
    public List<Slot> getAll();
}
