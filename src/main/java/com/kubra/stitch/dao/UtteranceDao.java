package com.kubra.stitch.dao;

import com.kubra.stitch.model.Utterance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtteranceDao extends JpaRepository<Utterance, Long> {
}
