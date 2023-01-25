package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.dto.VtoDto;
import com.backendp4.backendp4.model.Usager;
import com.backendp4.backendp4.model.Vto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VtoMapStructImpl implements VtoMapStruct{

    @Override
    public UsagerDto toDto(Usager usager) {
        //utiliser pour les Method Get pour recuper les donnes
        VtoDto newvtoDto=new VtoDto();
        newvtoDto.setId(usager.getId());
        newvtoDto.setLogin(usager.getLogin());
        newvtoDto.setNumeroContact(usager.getNumeroContact());
        newvtoDto.setMsisdn(usager.getMsisdn());
        newvtoDto.setGeolatitude(usager.getGeolatitude());
        newvtoDto.setGeolongititude(usager.getGeolongititude());
        newvtoDto.setType(usager.getType());
        newvtoDto.setPrenom(usager.getPrenom());
        newvtoDto.setNom(usager.getNom());

        return newvtoDto;
    }

    @Override
    public Usager toEntity(UsagerDto usagerDto) {
        Vto newVto=new Vto();
       newVto.setLogin(usagerDto.getLogin());
       newVto.setPrenom(usagerDto.getPrenom());
       newVto.setNom(usagerDto.getNom());
       newVto.setMsisdn(usagerDto.getMsisdn());
       newVto.setNumeroContact(usagerDto.getNumeroContact());
       newVto.setGeolatitude(usagerDto.getGeolatitude());
       newVto.setType("vto");
       newVto.setGeolongititude(usagerDto.getGeolongititude());
        return newVto;
    }
}
