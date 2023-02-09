package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.dto.VptDto;
import com.backendp4.backendp4.dto.VtoDto;
import com.backendp4.backendp4.model.Usager;
import com.backendp4.backendp4.model.Vpt;
import com.backendp4.backendp4.model.Vto;

public interface VptMapStruct {
    VptDto toDto(Vpt vpt);
    Vpt toEntity(VptDto vptDto);
}
