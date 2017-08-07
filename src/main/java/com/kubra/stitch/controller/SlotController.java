package com.kubra.stitch.controller;

import com.kubra.stitch.dto.SlotDTO;
import com.kubra.stitch.model.Slot;
import com.kubra.stitch.service.SlotService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/slots")
public class SlotController {

    final private SlotService slotService;
    final private ModelMapper mapper;

    public SlotController(SlotService slotService, ModelMapper mapper){
        this.mapper = mapper;
        this.slotService = slotService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SlotDTO create(@RequestBody SlotDTO slotDTO) {
        System.out.println(slotDTO);
        Slot slot = mapper.map(slotDTO, Slot.class);
        Slot createdSlot = slotService.create(slot);
        return mapper.map(createdSlot, SlotDTO.class);
    }
}
