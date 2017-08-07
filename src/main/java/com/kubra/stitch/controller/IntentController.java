package com.kubra.stitch.controller;

import com.kubra.stitch.dto.IntentDTO;
import com.kubra.stitch.model.Intent;
import com.kubra.stitch.service.IntentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/intents")
public class IntentController {

    final private IntentService intentService;
    final private ModelMapper mapper;

    public IntentController(IntentService intentService, ModelMapper mapper){
        this.mapper = mapper;
        this.intentService = intentService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public IntentDTO create(@RequestBody IntentDTO intentDTO) {
        System.out.println(intentDTO);
        Intent intent = mapper.map(intentDTO, Intent.class);
        Intent createdIntent = intentService.create(intent);
        return mapper.map(createdIntent, IntentDTO.class);
    }
}
