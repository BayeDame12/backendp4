package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.model.Usager;

public interface UsagerMapStruct {
    //Mappage d l entity Usager pour envoyer
    UsagerDto toDto(Usager usager);
    //Mappage d l entity Usager pour retourner
    Usager toEntity(UsagerDto usagerDto);
}
