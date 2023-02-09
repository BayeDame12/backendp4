package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.dto.VtoDto;
import com.backendp4.backendp4.model.Usager;
import com.backendp4.backendp4.model.Vto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VtoMapStructImpl implements VtoMapStruct {
    private final ModelMapper modelMapper;

    public VtoMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public VtoDto toDto(Vto vto) {
        //utiliser pour les Method Get pour recuper les donnes
        VtoDto vtoDto = modelMapper.map(vto, VtoDto.class);
        return vtoDto;
    }

    @Override
    public Vto toEntity(VtoDto vtoDto) {
        Vto vto = modelMapper.map(vtoDto, Vto.class);
        return vto;
    }
}
