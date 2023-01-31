package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.dto.VptDto;
import com.backendp4.backendp4.model.Usager;
import com.backendp4.backendp4.model.Vpt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VptMapStructImpl implements VptMapStruct {

    private final ModelMapper modelMapper;

    public VptMapStructImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UsagerDto toDto(Usager usager) {
        UsagerDto usagerDto = modelMapper.map(usager, UsagerDto.class);
        return usagerDto;
    }

    @Override
    public Usager toEntity(UsagerDto usagerDto) {
        Usager usager = modelMapper.map(usagerDto, Usager.class);
        return usager;
    }
}
