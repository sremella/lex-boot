package com.kubra.stitch.dao;

import com.kubra.stitch.model.SlotType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotTypeDao extends JpaRepository<SlotType, Long> {
}
