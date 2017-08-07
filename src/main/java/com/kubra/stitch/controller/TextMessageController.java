package com.kubra.stitch.controller;

import com.amazonaws.services.lexruntime.model.PostTextRequest;
import com.amazonaws.services.lexruntime.model.PostTextResult;
import com.kubra.stitch.service.TextMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/messages/text")
public class TextMessageController {

    final private TextMessageService textMessageService;

    @Autowired
    public TextMessageController(TextMessageService textMessageService) {
        this.textMessageService = textMessageService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public PostTextResult create(@RequestBody PostTextRequest req) {
        return textMessageService.send(req);
    }

}
