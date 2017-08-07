package com.kubra.stitch.service;

import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.services.lexruntime.model.PostTextResult;

public interface TextMessageService {

    public PostTextResult send(PostTextRequest textRequest);
}
