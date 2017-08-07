package com.kubra.stitch.dao;

import com.kubra.stitch.model.Intent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntentDao extends JpaRepository<Intent, Long> {
}
