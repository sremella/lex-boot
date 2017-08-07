package com.kubra.stitch.controller;

import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.services.lexruntime.model.PostTextResult;
import com.kubra.stitch.lex.InputMessage;
import com.kubra.stitch.lex.OutputMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

//A utility controller that serves as the end-point for a demo application at http://localhost:8080/
@Controller
public class ChatController {

    final private AmazonLexRuntime lexClient;

    @Autowired
    public ChatController(AmazonLexRuntime lexClient) {
        this.lexClient = lexClient;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(final InputMessage inputMessage) throws Exception {
        PostTextRequest textRequest=new PostTextRequest().withBotName("NotifiTest")
                .withBotAlias("$LATEST")
                .withUserId(inputMessage.getFrom())
                .withInputText(inputMessage.getText());
        PostTextResult testResult = lexClient.postText(textRequest);
        System.out.println(testResult);
        return new OutputMessage("Notifi", testResult.getMessage());
    }
}