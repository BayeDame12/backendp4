package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.model.Usager;

public interface UsagerMapStruct {
    //Mappage d l entity Usager
    UsagerDto toDto(Usager usager);

    Usager toEntity(UsagerDto usagerDto);
}
