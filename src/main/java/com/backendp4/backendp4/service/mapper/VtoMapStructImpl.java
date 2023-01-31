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
    public UsagerDto toDto(Usager usager) {
        //utiliser pour les Method Get pour recuper les donnes
        UsagerDto usagerDto = modelMapper.map(usager, UsagerDto.class);
        return usagerDto;
    }

    @Override
    public Usager toEntity(UsagerDto usagerDto) {
        Usager usager = modelMapper.map(usagerDto, Usager.class);
        return usager;
    }
}
