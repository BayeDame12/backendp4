package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.dto.VptDto;
import com.backendp4.backendp4.model.Usager;
import com.backendp4.backendp4.model.Vpt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VptMapStructImpl implements VptMapStruct{


    @Override
    public UsagerDto toDto(Usager usager) {
        VptDto newVptDto=new VptDto();
        newVptDto.setLogin(usager.getLogin());
        newVptDto.setId(usager.getId());
        newVptDto.setGeolatitude(usager.getGeolatitude());
        newVptDto.setGeolongititude(usager.getGeolongititude());
        newVptDto.setPrenom(usager.getPrenom());
        newVptDto.setNom(usager.getNom());
        newVptDto.setNumeroContact(usager.getNumeroContact());
        newVptDto.setMsisdn(usager.getMsisdn());
        newVptDto.setType(usager.getType());
        return newVptDto;
    }

    @Override
    public Usager toEntity(UsagerDto usagerDto) {
        Vpt newVpt=new Vpt();
        newVpt.setLogin(usagerDto.getLogin());
        newVpt.setGeolatitude(usagerDto.getGeolatitude());
        newVpt.setGeolongititude(usagerDto.getGeolongititude());
        newVpt.setMsisdn(usagerDto.getMsisdn());
        newVpt.setNumeroContact(usagerDto.getNumeroContact());
        newVpt.setNom(usagerDto.getNom());
        newVpt.setType("vpt");
        newVpt.setPrenom(usagerDto.getPrenom());
        return newVpt;
    }
}
