package com.kubra.stitch.dao;

import com.kubra.stitch.model.Bot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BotDao extends JpaRepository<Bot, Long> {
}
