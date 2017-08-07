package com.kubra.stitch.service;

import com.kubra.stitch.model.Statement;

import java.util.List;

public interface StatementService {
    public Statement create(Statement statement);
    public Statement getById(Long id);
    public Statement update(Long id, Statement newStatement);
    public void delete(Long id);
    public List<Statement> getAll();
}
