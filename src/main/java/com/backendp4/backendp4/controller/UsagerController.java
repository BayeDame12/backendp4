package com.backendp4.backendp4.controller;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.model.Usager;
import com.backendp4.backendp4.repository.UsagerRepository;
import com.backendp4.backendp4.service.UsagerService;
import com.backendp4.backendp4.service.VptService;
import com.backendp4.backendp4.service.VtoService;
import com.backendp4.backendp4.service.mapper.UsagerMapStruct;
import com.backendp4.backendp4.service.mapper.VptMapStruct;
import com.backendp4.backendp4.service.mapper.VtoMapStruct;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2

@RestController
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("/api")
public class UsagerController {
    private final ModelMapper modelMapper;
    private final UsagerService usagerService;
    private final VptService vptService;
    private final VtoService vtoService;
    private final UsagerRepository usagerRepository;
    private final UsagerMapStruct usagerMapStruct;
    private final VtoMapStruct vtoMapStruct;
    private final VptMapStruct vptMapStruct;

    public UsagerController(ModelMapper modelMapper, UsagerService usagerService, UsagerRepository usagerRepository, BCryptPasswordEncoder bCryptPasswordEncoder, VptService vptService, VtoService vtoService, UsagerMapStruct usagerMapStruct, VtoMapStruct vtoMapStruct, VptMapStruct vptMapStruct) {
        this.modelMapper = modelMapper;
        this.usagerService = usagerService;
        this.usagerRepository = usagerRepository;
        this.vptService = vptService;
        this.vtoService = vtoService;
        this.usagerMapStruct = usagerMapStruct;
        this.vtoMapStruct = vtoMapStruct;
        this.vptMapStruct = vptMapStruct;
    }

    @GetMapping("/{type}")
    public List<UsagerDto> getAllUsager(@PathVariable String type) {
        if (type.equalsIgnoreCase("usager")) {
            return usagerService.getAllUsager().stream().map(usager -> modelMapper.map(usager, UsagerDto.class))
                    .collect(Collectors.toList());
        } else if (type.equalsIgnoreCase("vto")) {
            return vtoService.getAllVto().stream().map(vto -> modelMapper.map(vto, UsagerDto.class))
                    .collect(Collectors.toList());
        } else if (type.equalsIgnoreCase("vpt")) {
            return vptService.getAllVpt().stream().map(vtp -> modelMapper.map(vtp, UsagerDto.class))
                    .collect(Collectors.toList());
        }
            return null;


    }

    @GetMapping("/{type}/{id}")
    public ResponseEntity<UsagerDto> getUserById(@PathVariable(name = "id") Long id, @PathVariable String type) {
        if (type.equalsIgnoreCase("vto")) {
            Usager usager = vtoService.getVtoById(id);
            // convert entity to DTO
            UsagerDto postResponse = vtoMapStruct.toDto(usager);
            return ResponseEntity.ok().body(postResponse);
        } else if (type.equalsIgnoreCase("vpt")) {
            Usager usager = vptService.getVptById(id);
            // convert entity to DTO
            UsagerDto postResponse = vptMapStruct.toDto(usager);
            return ResponseEntity.ok().body(postResponse);
        }
            return null;


    }


    @PostMapping("/{type}")
    public Usager createUsager(@RequestBody UsagerDto usagerDto, @PathVariable String type) {
        if (type.equalsIgnoreCase("vto")) {

            //un log des donnes envoyer sur postman
            log.info(usagerDto);
            //un log des donne reus et envoyer dans la basse de donnes via post man
            log.info(usagerMapStruct.toEntity(usagerDto));
            return usagerRepository.save(vtoMapStruct.toEntity(usagerDto));
        } else if (type.equalsIgnoreCase("vpt")) {

            //un log des donnes envoyer sur postman
            log.info(usagerDto);
            //un log des donne reus et envoyer dans la basse de donnes via post man
            log.info(usagerMapStruct.toEntity(usagerDto));
            return usagerRepository.save(vptMapStruct.toEntity(usagerDto));
        }
            return null;


    }

    @PutMapping("/{type}/{id}")
    public ResponseEntity<UsagerDto> updateUser(@PathVariable Long id, @RequestBody UsagerDto usagerDto, @PathVariable String type) {
        if (type.equalsIgnoreCase("usager")) {
            // convert DTO to Entity
            Usager usagerResquest = usagerMapStruct.toEntity(usagerDto);
            Usager usager = usagerService.updateUsager(id, usagerResquest);
            // entity to DTO
            UsagerDto usagerResponse = usagerMapStruct.toDto(usager);
            return ResponseEntity.ok().body(usagerResponse);
        }

       return null;

    }

    @DeleteMapping("/{type}/{id}")
    public ResponseEntity<?> deletUsager(@PathVariable(name = "id") Long id, @PathVariable String type) {
        if (type.equalsIgnoreCase("usager")) {;
            usagerService.deleteUsager(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return null;

    }


}



