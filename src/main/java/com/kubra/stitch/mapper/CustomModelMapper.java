package com.kubra.stitch.mapper;

import org.modelmapper.ConfigurationException;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("mapper")
public class CustomModelMapper extends ModelMapper {
    public <D> D map(Object source, Class<D> destinationType){
        try{
            return super.map(source, destinationType);
        }catch (IllegalArgumentException exp){
            System.out.println("IllegalArgumentException");
            throw new IllegalArgumentException("IllegalArgumentException");
        }catch (ConfigurationException exp){
            System.out.println("ConfigurationException");
            throw new IllegalArgumentException("ConfigurationException");
        }catch (MappingException exp){
            System.out.println("MappingException");
            throw new IllegalArgumentException("MappingException");
        }
    }
}
