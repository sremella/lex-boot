package com.kubra.stitch.mapper;

import com.amazonaws.services.lexmodelbuilding.model.PutBotRequest;
import com.kubra.stitch.model.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Autowired
    private ModelMapper mapper;

    @Ignore
    public void testMap() {
        List<Intent> intents = Arrays.asList(new Intent("i1","v1"), new Intent("i1","v1"));
        List<Message> msgs = Arrays.asList(new Message("hi","PlainText"), new Message("hi","PlainText"));
        Prompt p = new Prompt(msgs,2,null);
        Statement s = new Statement(msgs, null);
        Bot b = new Bot("X","1.0","en-US",180,true,p,null,null,null);
        System.out.println(b);
        PutBotRequest bdto = mapper.map(b, PutBotRequest.class);
        System.out.println(bdto);
    }
}
