package com.kubra.stitch.dao;

import com.kubra.stitch.model.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Ignore
public class BotDaoTest {
    @Autowired
    private BotDao botDao;

    @Autowired
    private PromptDao promptDao;

    @Test
    @Rollback(false)
    public void testSave() {
        List<Intent> intents = Arrays.asList(new Intent("i1","v1"), new Intent("i1","v1"));
        List<Message> msgs = Arrays.asList(new Message("hi","PlainText"), new Message("hi","PlainText"));
        Prompt p = new Prompt(msgs,2,null);
        Statement s = new Statement(msgs, null);
        Bot b = new Bot("X","1.0","en-US",180,true,intents,p,s,null,null,null);
        System.out.println(b);
        botDao.save(b);
    }
}
