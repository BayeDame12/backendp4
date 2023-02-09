package com.backendp4.backendp4.service;

import com.backendp4.backendp4.model.Vpt;
import com.backendp4.backendp4.repository.VptRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VptServiceImpl implements VptService {
    private final VptRepository vptRepository;
    private final ModelMapper modelMapper;

    public VptServiceImpl(VptRepository vptRepository, ModelMapper modelMapper) {
        this.vptRepository = vptRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Vpt> getAllVpt() {
        return vptRepository.findAll();
    }

    @Override
    public Vpt createVpt(Vpt vpt) {
        vpt.setType("vpt");
        return vptRepository.save(vpt);
    }

    @Override
    public Vpt updateVpt(long id, Vpt vptRequest) {
        Vpt vpt = vptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("la tentative de mise a jourdu VPT na pas abouti"));
        vpt.setLogin(vpt.getLogin());
        vpt.setGeolatitude(vptRequest.getGeolatitude());
        vpt.setGeolongititude(vptRequest.getGeolongititude());
        vpt.setNumeroContact(vptRequest.getNumeroContact());
        vpt.setMsisdn(vptRequest.getMsisdn());
        vpt.setPrenom(vptRequest.getPrenom());
        vpt.setType(vptRequest.getType());
        vpt.setNom(vptRequest.getNom());


        return vptRepository.save(vpt);
    }

    @Override
    public void deleteVpt(long id) {
        Vpt vpt = vptRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("le VPT que vous tenter de supprimer n existe pas"));
        vptRepository.delete(vpt);
    }

    @Override
    public Vpt getVptById(long id) {
        Optional<Vpt> result = vptRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("le VPT que vous checher n existe pas!!!");
        }
    }
}
