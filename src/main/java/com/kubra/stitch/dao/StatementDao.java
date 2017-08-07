package com.kubra.stitch.dao;

import com.kubra.stitch.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementDao extends JpaRepository<Statement, Long> {
}
