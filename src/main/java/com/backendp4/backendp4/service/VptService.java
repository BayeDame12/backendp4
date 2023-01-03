package com.backendp4.backendp4.service;

import com.backendp4.backendp4.model.Vpt;

import java.util.List;

public interface VptService {
    List<Vpt> getAllVpt();

    Vpt createVpt(Vpt vpt);

    Vpt updateVpt(long id, Vpt vpt);

    void deleteVpt(long id);

    Vpt getVptById(long id);
}
