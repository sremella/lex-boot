package com.kubra.stitch.service;

import com.amazonaws.services.lexmodelbuilding.AmazonLexModelBuilding;
import com.amazonaws.services.lexmodelbuilding.model.*;
import com.kubra.stitch.dao.IntentDao;
import com.kubra.stitch.model.Intent;
import com.kubra.stitch.util.CustomBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service("intentService")
public class IntentServiceImpl implements IntentService {

    final private IntentDao intentDao;
    final private AmazonLexModelBuilding lexModel;

    @Autowired
    public IntentServiceImpl(IntentDao intentDao, AmazonLexModelBuilding lexModel){
        Assert.notNull(intentDao, "IntentServiceImpl()::intentDao must not be null");
        this.intentDao = intentDao;
        this.lexModel = lexModel;
    }

    @Override
    public Intent create(Intent intent) {
        System.out.println(intent);
        PutIntentRequest intentRequest = getIntentRequest(intent);
        System.out.println(intentRequest);
        PutIntentResult intentResult = lexModel.putIntent(intentRequest);
        System.out.println(intentResult);
        //If success save or else throw custom rest error!
        intent.setChecksum(intentResult.getChecksum());
        return intentDao.save(intent);
    }

    @Override
    public Intent getById(Long id) {
        return intentDao.findOne(id);
    }

    @Override
    public Intent update(Long id, Intent newIntent) {
        Intent oldIntent = intentDao.findOne(id);
        CustomBeanUtils.copyPropertiesIgnoreNull(newIntent, oldIntent);
        System.out.println(oldIntent);
        PutIntentRequest intentRequest = getIntentRequest(oldIntent);
        intentRequest.withChecksum(oldIntent.getChecksum());//***
        System.out.println(intentRequest);
        PutIntentResult intentResult = lexModel.putIntent(intentRequest);
        System.out.println(intentResult);
        //If success save or else throw custom rest error!
        oldIntent.setChecksum(intentResult.getChecksum());
        return intentDao.save(oldIntent);
    }

    @Override
    public void delete(Long id) {
        intentDao.delete(id);
    }

    @Override
    public List<Intent> getAll() {
        return intentDao.findAll();
    }

    private PutIntentRequest getIntentRequest(Intent intent){

        List<Message> rejectionMessages = new ArrayList<Message>();
        for(com.kubra.stitch.model.Message message: intent.getRejectionStatement().getMessages()){
            rejectionMessages.add(new Message().withContentType(message.getContentType())
                    .withContent(message.getContent()));
        }
        Statement rejectionStatement = new Statement()
                .withMessages(rejectionMessages);

        List<Message> confirmationMessages = new ArrayList<Message>();
        for(com.kubra.stitch.model.Message message: intent.getConfirmationPrompt().getMessages()){
            confirmationMessages.add(new Message().withContentType(message.getContentType())
                    .withContent(message.getContent()));
        }
        Prompt confirmationPrompt = new Prompt()
                .withMessages(confirmationMessages)
                .withMaxAttempts(intent.getConfirmationPrompt().getMaxAttempts());
        
        
        List<String> sampleUtterances = new ArrayList<>();
        for(com.kubra.stitch.model.Utterance utterance: intent.getSampleUtterances()){
            sampleUtterances.add(utterance.getUtterance());
        }
        List<Slot> slots = new ArrayList<Slot>();
        for (com.kubra.stitch.model.Slot slot : intent.getSlots()) {
            com.kubra.stitch.model.Prompt valPrompt = slot.getValueElicitationPrompt();
            List<Message> valMsgs = new ArrayList<Message>();
            for(com.kubra.stitch.model.Message message: valPrompt.getMessages()){
                valMsgs.add(new Message().withContentType(message.getContentType())
                        .withContent(message.getContent()));
            }
            Prompt valueElicitPrompt = new Prompt().
                    withMaxAttempts(valPrompt.getMaxAttempts())
                    .withMessages(valMsgs);
            List<String> samplUtterances = new ArrayList<>();
            for(com.kubra.stitch.model.Utterance utterance: slot.getSampleUtterances()){
                samplUtterances.add(utterance.getUtterance());
            }
            slots.add(new Slot()
                    .withName(slot.getName())
                    .withDescription(slot.getDescription())
                    .withSlotType(slot.getSlotType())
                    .withSlotTypeVersion(slot.getSlotTypeVersion())
                    .withPriority(slot.getPriority())
                    .withSlotConstraint(slot.getSlotConstraint())
                    .withValueElicitationPrompt(valueElicitPrompt)
                    .withSampleUtterances(samplUtterances));
        }
        FulfillmentActivity fulfillmentActivity = new FulfillmentActivity()
                .withType(intent.getFulfillmentActivity().getType());
        return new PutIntentRequest()
                .withName(intent.getName())
                .withRejectionStatement(rejectionStatement)
                .withConfirmationPrompt(confirmationPrompt)
                .withSampleUtterances(sampleUtterances)
                .withSlots(slots)
                .withFulfillmentActivity(fulfillmentActivity);
    }

}
