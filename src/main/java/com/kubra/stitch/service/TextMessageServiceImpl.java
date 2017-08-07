package com.kubra.stitch.service;

import com.amazonaws.services.lexruntime.AmazonLexRuntime;
import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.services.lexruntime.model.PostTextResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("textMessageService")
public class TextMessageServiceImpl implements TextMessageService {

    final private AmazonLexRuntime lexClient;

    @Autowired
    public TextMessageServiceImpl(AmazonLexRuntime lexClient) {
        this.lexClient = lexClient;
    }

    public PostTextResult send(PostTextRequest textRequest){
        return lexClient.postText(textRequest);
    }
}
