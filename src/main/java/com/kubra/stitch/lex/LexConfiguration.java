package com.kubra.stitch.lex;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lexmodelbuilding.AmazonLexModelBuilding;
import com.amazonaws.services.lexmodelbuilding.AmazonLexModelBuildingAsyncClientBuilder;
import com.amazonaws.services.lexmodelbuilding.model.PutBotRequest;
import com.amazonaws.services.lexmodelbuilding.model.PutIntentRequest;
import com.amazonaws.services.lexmodelbuilding.model.PutSlotTypeRequest;
import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.AmazonLexRuntimeClientBuilder;
import com.kubra.stitch.dto.*;
import com.kubra.stitch.model.*;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LexConfiguration {
    @Bean("lexRuntime")
    public AmazonLexRuntime lexRuntime(){
        return AmazonLexRuntimeClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new ProfileCredentialsProvider())
                .build();
    }
    @Bean("lexModel")
    public AmazonLexModelBuilding lexModel(){
        return AmazonLexModelBuildingAsyncClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new ProfileCredentialsProvider())
                .build();
    }

    @Bean("botMap")
    public PropertyMap<Bot, BotDTO> botMap(){
       return new PropertyMap<Bot, BotDTO>() {
            protected void configure() {
                map(source.getId(), destination.getId());
            }
        };
    }

    @Bean("intentMap")
    public PropertyMap<Intent, IntentDTO> intentMap(){
        return new PropertyMap<Intent, IntentDTO>() {
            protected void configure() {
                map(source.getId(), destination.getId());
            }
        };
    }

    @Bean("slotMap")
    public PropertyMap<Slot, SlotDTO> slotMap(){
        return new PropertyMap<Slot, SlotDTO>() {
            protected void configure() {
                map(source.getId(), destination.getId());
            }
        };
    }

    @Bean("promptMap")
    public PropertyMap<Prompt, PromptDTO> promtMap(){
        return new PropertyMap<Prompt, PromptDTO>() {
            protected void configure() {
                map(source.getId(), destination.getId());
            }
        };
    }

    @Bean("messageMap")
    public PropertyMap<Message, MessageDTO> promptMap(){
        return new PropertyMap<Message, MessageDTO>() {
            protected void configure() {
                map(source.getId(), destination.getId());
            }
        };
    }

    @Bean("statementMap")
    public PropertyMap<Statement, StatementDTO> statementMap(){
        return new PropertyMap<Statement, StatementDTO>() {
            protected void configure() {
                map(source.getId(), destination.getId());
            }
        };
    }


    //-------------------------------

    @Bean("putBotRequestMap")
    public PropertyMap<Bot, PutBotRequest> putBotRequestMap(){
        return new PropertyMap<Bot, PutBotRequest>() {
            protected void configure() {
                map(source.getName(), destination.getName());
            }
        };
    }

    @Bean("putIntentRequestMap")
    public PropertyMap<Intent, PutIntentRequest> putIntentRequestMap(){
        return new PropertyMap<Intent, PutIntentRequest>() {
            protected void configure() {
                map(source.getName(), destination.getName());
            }
        };
    }

    @Bean("putSlotTypeRequestMap")
    public PropertyMap<SlotType, PutSlotTypeRequest> putSlotTypeRequestMap(){
        return new PropertyMap<SlotType, PutSlotTypeRequest>() {
            protected void configure() {
                map(source.getName(), destination.getName());
            }
        };
    }

    @Bean("promptLexMap")
    public PropertyMap<Prompt, com.amazonaws.services.lexmodelbuilding.model.Prompt> promptLexMap(){
        return new PropertyMap<Prompt, com.amazonaws.services.lexmodelbuilding.model.Prompt>() {
            protected void configure() {
                map(source.getMessages(), destination.getMessages());
            }
        };
    }

    @Bean("messageLexMap")
    public PropertyMap<Message, com.amazonaws.services.lexmodelbuilding.model.Message> messageLexMap(){
        return new PropertyMap<Message, com.amazonaws.services.lexmodelbuilding.model.Message>() {
            protected void configure() {
                map(source.getContentType(), destination.getContentType());
            }
        };
    }

    @Bean("statementLexMap")
    public PropertyMap<Statement, com.amazonaws.services.lexmodelbuilding.model.Statement> statementLexMap(){
        return new PropertyMap<Statement, com.amazonaws.services.lexmodelbuilding.model.Statement>() {
            protected void configure() {
                map(source.getMessages(), destination.getMessages());
            }
        };
    }
    
    
}
