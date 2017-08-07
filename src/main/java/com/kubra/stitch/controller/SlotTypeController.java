package com.kubra.stitch.controller;

import com.kubra.stitch.dto.SlotTypeDTO;
import com.kubra.stitch.model.SlotType;
import com.kubra.stitch.service.SlotTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/slotTypes")
public class SlotTypeController {

    final private SlotTypeService slotTypeService;
    final private ModelMapper mapper;

    public SlotTypeController(SlotTypeService slotTypeService, ModelMapper mapper){
        this.mapper = mapper;
        this.slotTypeService = slotTypeService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SlotTypeDTO create(@RequestBody SlotTypeDTO slotTypeDTO) {
        System.out.println(slotTypeDTO);
        SlotType slotType = mapper.map(slotTypeDTO, SlotType.class);
        SlotType createdSlotType = slotTypeService.create(slotType);
        return mapper.map(createdSlotType, SlotTypeDTO.class);
    }
}
