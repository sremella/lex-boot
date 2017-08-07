package com.kubra.stitch.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;

public class MapperTest {
    public static void main(String[] args){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        modelMapper.getConfiguration().setSourceNamingConvention(NamingConventions.NONE);
        modelMapper.getConfiguration().setDestinationNamingConvention(NamingConventions.NONE);
       // TypeMap<Bot, BotDTO> typeMap = modelMapper.createTypeMap(Bot.class, BotDTO.class);
        //modelMapper.validate();

       /* List<Intent> intents = Arrays.asList(new Intent("i1","v1"), new Intent("i1","v1"));
        List<Message> msgs = Arrays.asList(new Message("hi","PlainText"), new Message("hi","PlainText"));
        Prompt p = new Prompt(msgs,2,null);
        Statement s = new Statement(msgs, null);
        Bot b = new Bot("X","1.0","en-US",180,true,intents,p,s,null,null,null);
        System.out.println(b);
        BotDTO bdto = modelMapper.map(b, BotDTO.class);
        System.out.println(bdto);
        Bot b2 = modelMapper.map(bdto, Bot.class);
        System.out.println(b2);*/
    }
}
