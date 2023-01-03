package com.backendp4.backendp4.service;

import com.backendp4.backendp4.model.Vto;

import java.util.List;

public interface VtoService {
    List<Vto> getAllVto();

    Vto createVto(Vto vto);

    Vto updateVto(long id, Vto vto);

    void deleteVto(long id);

    Vto getVtoById(long id);
}
