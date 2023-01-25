package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.model.Usager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsagerMapStructImpl implements UsagerMapStruct {
    @Override
    public UsagerDto toDto(Usager usager) {
        //utiliser pour les Method Get pour recuper les donnes
        UsagerDto newUsagerDto= new UsagerDto();
        newUsagerDto.setId(usager.getId());
        newUsagerDto.setMsisdn(usager.getMsisdn());
        newUsagerDto.setNumeroContact(usager.getNumeroContact());
        newUsagerDto.setLogin(usager.getLogin());
        newUsagerDto.setNom(usager.getNom());
        newUsagerDto.setPrenom(usager.getPrenom());
        newUsagerDto.setGeolatitude(usager.getGeolatitude());
        newUsagerDto.setGeolongititude(usager.getGeolongititude());
        newUsagerDto.setType(usager.getType());
        return newUsagerDto;
    }

    @Override
    public Usager toEntity(UsagerDto usagerDto) {
        //utiliser pour les Method Post pour envoyer les donnes

        Usager newUsager =new Usager();
        newUsager.setMsisdn(usagerDto.getMsisdn());
        newUsager.setNumeroContact(usagerDto.getNumeroContact());
        newUsager.setNom(usagerDto.getNom());
        newUsager.setLogin(usagerDto.getLogin());
        newUsager.setPrenom(usagerDto.getPrenom());
        newUsager.setGeolongititude(usagerDto.getGeolongititude());
        newUsager.setType(usagerDto.getType());
        newUsager.setGeolatitude(usagerDto.getGeolatitude());
        return newUsager;
    }
}
