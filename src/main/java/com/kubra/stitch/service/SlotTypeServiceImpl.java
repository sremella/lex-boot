package com.kubra.stitch.service;

import com.amazonaws.services.lexmodelbuilding.AmazonLexModelBuilding;
import com.amazonaws.services.lexmodelbuilding.model.*;
import com.kubra.stitch.dao.SlotTypeDao;
import com.kubra.stitch.model.SlotType;
import com.kubra.stitch.model.SlotTypeDefinition;
import com.kubra.stitch.util.CustomBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service("slotTypeService")
public class SlotTypeServiceImpl implements SlotTypeService {

    final private SlotTypeDao slotTypeDao;
    final private AmazonLexModelBuilding lexModel;

    @Autowired
    public SlotTypeServiceImpl(SlotTypeDao slotTypeDao, AmazonLexModelBuilding lexModel){
        Assert.notNull(slotTypeDao, "SlotTypeServiceImpl()::slotTypeDao must not be null");
        this.slotTypeDao = slotTypeDao;
        this.lexModel = lexModel;
    }

    @Override
    public SlotType create(SlotType slotType) {
        System.out.println(slotType);
        PutSlotTypeRequest slotTypeRequest = getSlotTypeRequest(slotType);
        System.out.println(slotTypeRequest);
        PutSlotTypeResult slotTypeResult = lexModel.putSlotType(slotTypeRequest);
        System.out.println(slotTypeResult);
        //If success save or else throw custom rest error!
        slotType.setChecksum(slotTypeResult.getChecksum());
        return slotTypeDao.save(slotType);
    }

    @Override
    public SlotType getById(Long id) {
        return slotTypeDao.findOne(id);
    }

    @Override
    public SlotType update(Long id, SlotType newSlotType) {
        SlotType oldSlotType = slotTypeDao.findOne(id);
        CustomBeanUtils.copyPropertiesIgnoreNull(newSlotType, oldSlotType);
        System.out.println(oldSlotType);
        PutSlotTypeRequest slotTypeRequest = getSlotTypeRequest(oldSlotType);
        slotTypeRequest.withChecksum(oldSlotType.getChecksum());//***
        System.out.println(slotTypeRequest);
        PutSlotTypeResult slotTypeResult = lexModel.putSlotType(slotTypeRequest);
        System.out.println(slotTypeResult);
        //If success save or else throw custom rest error!
        oldSlotType.setChecksum(slotTypeResult.getChecksum());
        return slotTypeDao.save(oldSlotType);
    }

    @Override
    public void delete(Long id) {
        slotTypeDao.delete(id);
    }

    @Override
    public List<SlotType> getAll() {
        return slotTypeDao.findAll();
    }

    private PutSlotTypeRequest getSlotTypeRequest(SlotType slotType){
        List<EnumerationValue> enumerationValues = new ArrayList<>();
        for(SlotTypeDefinition definition: slotType.getEnumerationValues()){
            enumerationValues.add(new EnumerationValue().withValue(definition.getValue()));
        }
        return new PutSlotTypeRequest()
                .withName(slotType.getName())
                .withDescription(slotType.getDescription())
                .withEnumerationValues(enumerationValues);
    }

}
