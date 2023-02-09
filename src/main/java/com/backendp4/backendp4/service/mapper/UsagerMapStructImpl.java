package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.model.Usager;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsagerMapStructImpl implements UsagerMapStruct {
    private final ModelMapper modelMapper;
    public UsagerMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UsagerDto toDto(Usager usager) {

        UsagerDto usagerDto = modelMapper.map(usager, UsagerDto.class);
        return usagerDto;
        //utiliser pour les Method Get pour recuper les donnes
    }

    @Override
    public Usager toEntity(UsagerDto usagerDto) {
        //utiliser pour les Method Post pour envoyer les donnes
        Usager usager = modelMapper.map(usagerDto, Usager.class);
        return usager;
    }
}
