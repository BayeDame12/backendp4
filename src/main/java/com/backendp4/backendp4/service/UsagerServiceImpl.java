package com.backendp4.backendp4.service;

import com.backendp4.backendp4.model.Usager;
import com.backendp4.backendp4.repository.UsagerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsagerServiceImpl implements UsagerService {
    private final UsagerRepository usagerRepository;
    private final ModelMapper modelMapper;

    public UsagerServiceImpl(UsagerRepository usagerRepository, ModelMapper modelMapper) {
        super();
        this.usagerRepository = usagerRepository;
        this.modelMapper = modelMapper;
    }

    //Recupere la Liste des VtoDto
    @Override
    public List<Usager> getAllUsager() {
        return usagerRepository.findAll();
    }

    //creer un VtoDto
    @Override
    public Usager createUsager(Usager usager) {
        usager.setType("usager");
        return usagerRepository.save(usager);
    }
    //mettre ajour un VtoDto

    @Override
    public Usager updateUsager(long id, Usager usagerRequest) {
        Usager usager = usagerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La tentative de mise a jour du Usager na pas aboutit"));
        usager.setLogin(usagerRequest.getLogin());
        usager.setGeolatitude(usagerRequest.getGeolatitude());
        usager.setGeolongititude(usagerRequest.getGeolongititude());
        usager.setNumeroContact(usagerRequest.getNumeroContact());
        usager.setMsisdn(usagerRequest.getMsisdn());
        usager.setPrenom(usagerRequest.getPrenom());
        usager.setNom(usagerRequest.getNom());
        usager.setType(usagerRequest.getType());
        return usagerRepository.save(usager);
    }
    //Archiver un vto

    @Override
    public void deleteUsager(long id) {
        Usager usager = usagerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("l'usager que vous tenter de supprimer n existe pas"));
        usagerRepository.delete(usager);
    }

    //recuperer un VtoDto
    @Override
    public Usager getUsagerById(long id) {
        Optional<Usager> result = usagerRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("l'usager que vous checher n existe pas!!!");
        }

    }

}
