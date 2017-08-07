package com.kubra.stitch.lex;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lexmodelbuilding.AmazonLexModelBuilding;
import com.amazonaws.services.lexmodelbuilding.AmazonLexModelBuildingAsyncClientBuilder;
import com.amazonaws.services.lexmodelbuilding.model.*;
import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.AmazonLexRuntimeClientBuilder;

import java.util.Arrays;
import java.util.List;

public class SampleTest {

    public static void main(String[] args){
        AmazonLexRuntime lexRuntime = AmazonLexRuntimeClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new ProfileCredentialsProvider())
                .build();

        AmazonLexModelBuilding lexModel = AmazonLexModelBuildingAsyncClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new ProfileCredentialsProvider())
                .build();

        Statement conclusion = new Statement().withMessages(new Message().withContent("Ok, Bye!")
        .withContentType("PlainText"));
        Statement rejection = new Statement().withMessages(new Message().withContent("Ok, I will not place your order!")
                .withContentType("PlainText"));
        Prompt confirmation = new Prompt().withMessages(new Message().withContent("Okay, Your order will be place, Does this sound okay?!").withContentType("PlainText"))
                .withMaxAttempts(2);
        Prompt dateElicit = new Prompt().withMessages(new Message().withContent("Which day?!").withContentType("PlainText"))
                .withMaxAttempts(2);
        Prompt timeElicit = new Prompt().withMessages(new Message().withContent("What time?").withContentType("PlainText"))
                .withMaxAttempts(2);
        List<String> utterances = Arrays.asList("I would like to order flowers", "order flowers");
        Slot pickupDate = new Slot().withName("PickupDate")
                .withSlotType("AMAZON.DATE")
                .withSlotConstraint(SlotConstraint.Required)
                .withValueElicitationPrompt(dateElicit);
        Slot pickupTime = new Slot().withName("PickupTime")
                .withSlotType("AMAZON.TIME")
                .withSlotConstraint(SlotConstraint.Required)
                .withValueElicitationPrompt(timeElicit);

        List<Slot> slots = Arrays.asList(pickupDate, pickupTime);
        PutIntentRequest intentRequest = new PutIntentRequest()
                .withName("OrderFruits")
                .withSampleUtterances(utterances)
                .withConclusionStatement(conclusion)
                //.withConfirmationPrompt(confirmation)
                .withRejectionStatement(rejection)
                //.withChecksum("26a5304a-014d-46f0-a12e-62f464013bf2")
                .withSlots(slots);


        Intent intent = new Intent().withIntentName("OrderFruits")
                .withIntentVersion("$LATEST")
                ;
        List<Intent> intents = Arrays.asList(intent);
        Prompt clarification = new Prompt().withMessages(new Message().withContent("Hi, I din't understand, try agian!").withContentType("PlainText"))
                .withMaxAttempts(2);
        Statement abort = new Statement().withMessages(new Message().withContent("Sorry, try again later!")
                .withContentType("PlainText"));
        PutBotRequest botRequest = new PutBotRequest().withName("YClient")
                .withIdleSessionTTLInSeconds(120)
                .withChildDirected(true)
                .withLocale(Locale.EnUS)
                .withClarificationPrompt(clarification)
                .withAbortStatement(abort)
                .withIntents(intents)
                .withChecksum("8faac8de-a65d-46c7-a4f3-242f83f8a745");

        //PutBotResult botResult = lexModel.putBot(botRequest);
        //System.out.println(botResult);

        //System.out.println(intentRequest);
        //PutIntentResult intentResult = lexModel.putIntent(intentRequest);
        //System.out.println(intentResult);

        //PutBotResult botResult = lexModel.putBot(botRequest);
        //System.out.println(botResult);

       /*PostTextRequest textRequest=new PostTextRequest().withBotName("YClient")
                .withBotAlias("$LATEST")
                .withUserId("Me")
                .withInputText("I would like to order fruits");
        PostTextResult testResult = lexRuntime.postText(textRequest);
        System.out.println(testResult);
        textRequest.withInputText("tomorrow");
        testResult=lexRuntime.postText(textRequest);
        System.out.println(testResult);
        textRequest.withInputText("9:00 am");
        testResult=lexRuntime.postText(textRequest);
        System.out.println(testResult);*/

       GetBotRequest getBotRequest = new GetBotRequest().withName("XBot").withVersionOrAlias("$LATEST");
        System.out.println(lexModel.getBot(getBotRequest));

      /* GetIntentRequest getIntentRequest = new GetIntentRequest().withName("OrderFruits")
                .withVersion("$LATEST");
        System.out.println(lexModel.getIntent(getIntentRequest));*/



    }

}