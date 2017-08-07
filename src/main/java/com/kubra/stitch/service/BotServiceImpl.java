package com.kubra.stitch.service;

import com.amazonaws.services.lexmodelbuilding.AmazonLexModelBuilding;
import com.amazonaws.services.lexmodelbuilding.model.*;
import com.kubra.stitch.dao.BotDao;
import com.kubra.stitch.model.Bot;
import com.kubra.stitch.util.CustomBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service("botService")
public class BotServiceImpl implements BotService {

    final private BotDao botDao;

    final private AmazonLexModelBuilding lexModel;

    @Autowired
    public BotServiceImpl(BotDao botDao, AmazonLexModelBuilding lexModel){
        Assert.notNull(botDao, "BotServiceImpl()::botDao must not be null");
        this.botDao = botDao;
        this.lexModel = lexModel;
    }

    @Override
    public Bot create(Bot bot) {
        System.out.println(bot);
        PutBotRequest botRequest = getBotRequest(bot);
        System.out.println(botRequest);
        PutBotResult botResult = lexModel.putBot(botRequest);
        System.out.println(botResult);
        //TODO: If success save or else throw custom rest error!
        bot.setStatus(botResult.getStatus());
        bot.setChecksum(botResult.getChecksum());
        bot.setFailureReason(botResult.getFailureReason());
        return botDao.save(bot);
    }

    @Override
    public Bot getById(Long id) {
        return botDao.findOne(id);
    }

    @Override
    public Bot update(Long id, Bot newBot) {
        Bot oldBot = botDao.findOne(id);
        CustomBeanUtils.copyPropertiesIgnoreNull(newBot, oldBot);
        System.out.println(oldBot); 
        PutBotRequest botRequest = getBotRequest(oldBot);//This should be replaced with Model Mapping
        botRequest.withChecksum(oldBot.getChecksum());//***
        System.out.println(botRequest);
        PutBotResult botResult = lexModel.putBot(botRequest);
        System.out.println(botResult);
        //If success save or else throw custom rest error!
        oldBot.setStatus(botResult.getStatus());
        oldBot.setChecksum(botResult.getChecksum());
        oldBot.setFailureReason(botResult.getFailureReason()); 
        return botDao.save(oldBot);
    }

    @Override
    public void delete(Long id) {
        botDao.delete(id);
    }

    @Override
    public List<Bot> getAll() {
        return botDao.findAll();
    }

    private PutBotRequest getBotRequest(Bot bot){//Refactor with Java8
        List<Intent> botIntents = new ArrayList<Intent>();
        for(com.kubra.stitch.model.Intent intent: bot.getIntents()){
            botIntents.add(new Intent().withIntentName(intent.getName()).withIntentVersion(intent.getVersion()));
        }
        List<Message> botClarificationMessages = new ArrayList<Message>();
        for(com.kubra.stitch.model.Message message: bot.getClarificationPrompt().getMessages()){
            botClarificationMessages.add(new Message().withContentType(message.getContentType())
                    .withContent(message.getContent()));
        }
        Prompt clarificationPrompt = new Prompt();
        clarificationPrompt.withMaxAttempts(bot.getClarificationPrompt().getMaxAttempts())
                .withMessages(botClarificationMessages);
        List<Message> botAbortMessages = new ArrayList<Message>();
        for(com.kubra.stitch.model.Message message : bot.getAbortStatement().getMessages()){
            botAbortMessages.add(new com.amazonaws.services.lexmodelbuilding.model.Message().withContentType(message.getContentType())
                    .withContent(message.getContent()));
        }
        Statement abortStatement = new Statement()
                .withMessages(botAbortMessages);
        return new PutBotRequest()
                .withName(bot.getName())
                .withLocale(bot.getLocale())
                .withIdleSessionTTLInSeconds(bot.getIdleSessionTTLInSeconds())
                .withChildDirected(bot.getChildDirected())
                .withIntents(botIntents)
                .withClarificationPrompt(clarificationPrompt)
                .withAbortStatement(abortStatement);
    }

}
