package com.kubra.stitch.service;

import com.kubra.stitch.dao.StatementDao;
import com.kubra.stitch.model.Statement;
import com.kubra.stitch.util.CustomBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service("statementService")
public class StatementServiceImpl implements StatementService {

    final private StatementDao statementDao;

    @Autowired
    public StatementServiceImpl(StatementDao statementDao){
        Assert.notNull(statementDao, "StatementServiceImpl()::statementDao must not be null");
        this.statementDao = statementDao;
    }

    @Override
    public Statement create(Statement statement) {
        return statementDao.save(statement);
    }

    @Override
    public Statement getById(Long id) {
        return statementDao.findOne(id);
    }

    @Override
    public Statement update(Long id, Statement newStatement) {
        Statement oldStatement = statementDao.findOne(id);
        CustomBeanUtils.copyPropertiesIgnoreNull(newStatement, oldStatement);
        return statementDao.save(oldStatement);
    }

    @Override
    public void delete(Long id) {
        statementDao.delete(id);
    }

    @Override
    public List<Statement> getAll() {
        return statementDao.findAll();
    }

}
