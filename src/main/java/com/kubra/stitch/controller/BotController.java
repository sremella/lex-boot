package com.kubra.stitch.controller;

import com.kubra.stitch.dto.BotDTO;
import com.kubra.stitch.model.Bot;
import com.kubra.stitch.service.BotService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/bots")
public class BotController {

    final private BotService botService;
    final private ModelMapper mapper;

    @Autowired
    public BotController(BotService botService, ModelMapper mapper){
        this.botService = botService;
        this.mapper = mapper;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public BotDTO create(@RequestBody BotDTO botDTO) {
        System.out.println(botDTO);
        Bot bot = mapper.map(botDTO, Bot.class);
        Bot createdBot = botService.create(bot);
        return mapper.map(createdBot, BotDTO.class);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BotDTO update(@PathVariable("id") Long id, @RequestBody BotDTO employeeDTO) {
        Bot employee = mapper.map(employeeDTO, Bot.class);
        Bot updateEmp = botService.update(id, employee);
        return mapper.map(updateEmp, BotDTO.class);
    }
}
