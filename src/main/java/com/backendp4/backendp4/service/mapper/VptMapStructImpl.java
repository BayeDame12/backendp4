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
    public VptDto toDto(Vpt vtp) {
        VptDto vptDto = modelMapper.map(vtp, VptDto.class);
        return vptDto;
    }

    @Override
    public Vpt toEntity(VptDto vptDto) {
        Vpt vpt = modelMapper.map(vptDto, Vpt.class);
        return vpt;
    }
}
