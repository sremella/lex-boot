package com.kubra.stitch.dao;

import com.kubra.stitch.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotDao extends JpaRepository<Slot, Long> {
}
