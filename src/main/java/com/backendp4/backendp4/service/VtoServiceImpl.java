package com.backendp4.backendp4.service;

import com.backendp4.backendp4.model.Vto;
import com.backendp4.backendp4.repository.VtoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VtoServiceImpl implements VtoService {
    private final VtoRepository vtoRepository;
    private final ModelMapper modelMapper;

    public VtoServiceImpl(VtoRepository vtoRepository, ModelMapper modelMapper) {
        this.vtoRepository = vtoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Vto> getAllVto() {
        return vtoRepository.findAll();
    }

    @Override
    public Vto createVto(Vto vto) {
        vto.setType("vto");
        return vtoRepository.save(vto);
    }

    @Override
    public Vto updateVto(long id, Vto vtoRequest) {
        Vto vto = vtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La tentative de mise a jour du VTO na pas aboutit"));
        vto.setLogin(vto.getLogin());
        vto.setGeolatitude(vtoRequest.getGeolatitude());
        vto.setGeolongititude(vtoRequest.getGeolongititude());
        vto.setNumeroContact(vtoRequest.getNumeroContact());
        vto.setMsisdn(vtoRequest.getMsisdn());
        vto.setPrenom(vtoRequest.getPrenom());
        vto.setType(vto.getType());
        vto.setNom(vtoRequest.getNom());

        return vtoRepository.save(vto);
    }

    @Override
    public void deleteVto(long id) {
        Vto vto = vtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("le VTO que vous tenter de supprimer n existe pas"));
        vtoRepository.delete(vto);
    }

    @Override
    public Vto getVtoById(long id) {
        Optional<Vto> result = vtoRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("le VTO que vous checher n existe pas!!!");
        }    }
}
