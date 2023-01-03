package com.backendp4.backendp4.service;

import com.backendp4.backendp4.model.Usager;
import com.backendp4.backendp4.repository.UsagerRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsagerServiceImpl implements UsagerService {
    private final UsagerRepository usagerRepository;

    public UsagerServiceImpl(UsagerRepository usagerRepository) {
        super();
        this.usagerRepository = usagerRepository;
    }

    //Recupere la Liste des VtoDto
    @Override
    public List<Usager> getAllUsager() {
        return usagerRepository.findAll();
    }
//creer un VtoDto
    @Override
    public Usager createVto(Usager usager) {
        return usagerRepository.save(usager);
    }
    //mettre ajour un VtoDto

    @Override
    public Usager updateUsager(long id, Usager usagerRequest) {
        Usager usager=usagerRepository.findById(id)
                .orElseThrow(()->new RuntimeException());
        usager.setLogin(usagerRequest.getLogin());
        usager.setPassword(usagerRequest.getPassword());
        usager.setGeolatitude(usagerRequest.getGeolatitude());
        usager.setGeolongititude(usagerRequest.getGeolongititude());
        usager.setNumeroContact(usagerRequest.getNumeroContact());
        usager.setMsisdn(usagerRequest.getMsisdn());
        usager.setPrenom(usagerRequest.getPrenom());
        usager.setNom(usagerRequest.getNom());

        return usagerRepository.save(usager);
    }
    //Archiver un vto

    @Override
    public void deleteUsager(long id) {
        Usager usager = usagerRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException());
         usagerRepository.delete(usager);
    }
//recuperer un VtoDto
    @Override
    public Usager getUsagerById(long id) {
        Optional<Usager> result = usagerRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException();
        }

    }

}
