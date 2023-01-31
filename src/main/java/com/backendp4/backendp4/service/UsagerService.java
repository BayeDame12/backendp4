package com.backendp4.backendp4.service;

import com.backendp4.backendp4.model.Usager;

import java.util.List;

public interface UsagerService {
    List<Usager> getAllUsager();

    Usager createUsager(Usager usager);

    Usager updateUsager(long id, Usager usager);

    void deleteUsager(long id);

    Usager getUsagerById(long id);

}
