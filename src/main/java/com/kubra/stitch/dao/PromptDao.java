package com.kubra.stitch.dao;

import com.kubra.stitch.model.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromptDao extends JpaRepository<Prompt, Long> {
}
