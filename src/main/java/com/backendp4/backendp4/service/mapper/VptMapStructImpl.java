package com.backendp4.backendp4.service.mapper;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.dto.VptDto;
import com.backendp4.backendp4.model.Usager;
import com.backendp4.backendp4.model.Vpt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VptMapStructImpl implements VptMapStruct{
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public VptMapStructImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UsagerDto toDto(Usager usager) {
        VptDto newVptDto=new VptDto();
        newVptDto.setLogin(usager.getLogin());
        newVptDto.setPassword(usager.getPassword());
        newVptDto.setId(usager.getId());
        newVptDto.setGeolatitude(usager.getGeolatitude());
        newVptDto.setGeolongititude(usager.getGeolongititude());
        newVptDto.setPrenom(usager.getPrenom());
        newVptDto.setNom(usager.getNom());
        newVptDto.setNumeroContact(usager.getNumeroContact());
        newVptDto.setMsisdn(usager.getMsisdn());
        return newVptDto;
    }

    @Override
    public Usager toEntity(UsagerDto usagerDto) {
        Vpt newVpt=new Vpt();
        newVpt.setLogin(usagerDto.getLogin());
        newVpt.setPassword(bCryptPasswordEncoder.encode(usagerDto.getPassword()));
        newVpt.setGeolatitude(usagerDto.getGeolatitude());
        newVpt.setGeolongititude(usagerDto.getGeolongititude());
        newVpt.setMsisdn(usagerDto.getMsisdn());
        newVpt.setNumeroContact(usagerDto.getNumeroContact());
        newVpt.setNom(usagerDto.getNom());
        newVpt.setPrenom(usagerDto.getPrenom());
        return newVpt;
    }
}
