package com.backendp4.backendp4.controller;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.model.Usager;
import com.backendp4.backendp4.repository.UsagerRepository;
import com.backendp4.backendp4.service.UsagerService;
import com.backendp4.backendp4.service.mapper.UsagerMapStruct;
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
@RequestMapping("/api/usager")
public class UsagerController {
    private final ModelMapper modelMapper;
    private final UsagerService usagerService;
    private final UsagerRepository usagerRepository;
    private final UsagerMapStruct usagerMapStruct;

    public UsagerController(ModelMapper modelMapper, UsagerService usagerService, UsagerRepository usagerRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UsagerMapStruct usagerMapStruct) {
        this.modelMapper = modelMapper;
        this.usagerService = usagerService;
        this.usagerRepository = usagerRepository;
        this.usagerMapStruct = usagerMapStruct;
    }

    @GetMapping("/{type}")
    public List<UsagerDto> getAllUsager(){

        return usagerService.getAllUsager().stream().map(usager -> modelMapper.map(usager, UsagerDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsagerDto> getUserById(@PathVariable(name = "id") Long id) {
        Usager usager = usagerService.getUsagerById(id);
        // convert entity to DTO
        UsagerDto postResponse= usagerMapStruct.toDto(usager);
        return ResponseEntity.ok().body(postResponse);
    }


    @PostMapping("/{type}")
    public Usager createUsager(@RequestBody UsagerDto usagerDto,@PathVariable String type) {
        if (type.equalsIgnoreCase("vto")) {

            //un log des donnes envoyer sur postman
            log.info(usagerDto);
            //un log des donne reus et envoyer dans la basse de donnes via post man
            log.info(usagerMapStruct.toEntity(usagerDto));
            return usagerRepository.save(usagerMapStruct.toEntity(usagerDto));
        } else{

            //un log des donnes envoyer sur postman
            log.info(usagerDto);
            //un log des donne reus et envoyer dans la basse de donnes via post man
            log.info(usagerMapStruct.toEntity(usagerDto));
            return usagerRepository.save(usagerMapStruct.toEntity(usagerDto));
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<UsagerDto>updateUser(@PathVariable Long id,@RequestBody UsagerDto usagerDto){
        // convert DTO to Entity
        Usager usagerResquest= usagerMapStruct.toEntity(usagerDto);
        Usager usager= usagerService.updateUsager(id,usagerResquest);
        // entity to DTO
        UsagerDto usagerResponse= usagerMapStruct.toDto(usager);
        return ResponseEntity.ok().body(usagerResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deletUsager(@PathVariable(name = "id")Long id){
        usagerService.deleteUsager(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}



