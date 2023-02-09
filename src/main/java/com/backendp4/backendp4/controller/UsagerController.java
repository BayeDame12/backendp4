package com.backendp4.backendp4.controller;

import com.backendp4.backendp4.dto.UsagerDto;
import com.backendp4.backendp4.dto.VptDto;
import com.backendp4.backendp4.dto.VtoDto;
import com.backendp4.backendp4.model.Usager;
import com.backendp4.backendp4.model.Vpt;
import com.backendp4.backendp4.model.Vto;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Log4j2

@RestController
//ToDO a configurer dans spring securite
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class UsagerController {
    private final ModelMapper modelMapper;
    private final UsagerService usagerService;
    private final VptService vptService;
    private final VtoService vtoService;
    private final UsagerMapStruct usagerMapStruct;
    private final VtoMapStruct vtoMapStruct;
    private final VptMapStruct vptMapStruct;

    public UsagerController(ModelMapper modelMapper, UsagerService usagerService, UsagerRepository usagerRepository, VptService vptService, VtoService vtoService, UsagerMapStruct usagerMapStruct, VtoMapStruct vtoMapStruct, VptMapStruct vptMapStruct) {
        this.modelMapper = modelMapper;

        this.usagerService = usagerService;
        this.vptService = vptService;
        this.vtoService = vtoService;

        this.usagerMapStruct = usagerMapStruct;
        this.vtoMapStruct = vtoMapStruct;
        this.vptMapStruct = vptMapStruct;
    }

    //GET ALL UASAGER & USERS
    @GetMapping("/{type}")
    public List<UsagerDto> getAllUsager(@PathVariable String type) {
        if (type.equalsIgnoreCase("usager")) {
            return usagerService.getAllUsager().stream().map(usager -> modelMapper.map(usager, UsagerDto.class)).collect(Collectors.toList());
        } else if (type.equalsIgnoreCase("vto")) {
            return vtoService.getAllVto().stream().map(vto -> modelMapper.map(vto, UsagerDto.class)).collect(Collectors.toList());
        } else if (type.equalsIgnoreCase("vpt")) {
            return vptService.getAllVpt().stream().map(vtp -> modelMapper.map(vtp, UsagerDto.class)).collect(Collectors.toList());
        }
        return null;
    }
    //GET USAGER & USERS BY ID

    @GetMapping("/{type}/{id}")
    public ResponseEntity<UsagerDto> getUserById(@PathVariable(name = "id") Long id, @PathVariable String type) {
        if (type.equalsIgnoreCase("vto")) {
            Vto vto = vtoService.getVtoById(id);
            VtoDto postResponse = vtoMapStruct.toDto(vto);
            return ResponseEntity.ok().body(postResponse);
        } else if (type.equalsIgnoreCase("vpt")) {
            Vpt vpt = vptService.getVptById(id);
            UsagerDto postResponse = vptMapStruct.toDto(vpt);
            return ResponseEntity.ok().body(postResponse);
        } else if (type.equalsIgnoreCase("usager")) {
            log.info("bonjour ");
            Usager usager = usagerService.getUsagerById(id);
            UsagerDto postResponse = usagerMapStruct.toDto(usager);
            return ResponseEntity.ok().body(postResponse);
        }
        return null;
    }

    // *****************************UPDATE METHOD*****************************

    @PutMapping("/{type}/{id}")
    public ResponseEntity<UsagerDto> updateUser(@PathVariable Long id, @RequestBody UsagerDto usagerDto, @PathVariable String type) {
        if (type.equalsIgnoreCase("usager")) {
            log.info("id:{},usagerDto:{}", id, usagerDto);
            Usager usagerResquest = usagerMapStruct.toEntity(usagerDto);
            Usager usager = usagerService.updateUsager(id, usagerResquest);
            UsagerDto usagerResponse = usagerMapStruct.toDto(usager);
            return ResponseEntity.ok().body(usagerResponse);
        }
        return null;
    }
    // *****************************END UPDATE METHOD*****************************

    // *****************************DELETE METHOD*****************************

    @DeleteMapping("/{type}/{id}")
    public ResponseEntity<?> deletUsager(@PathVariable(name = "id") Long id, @PathVariable String type) {
        if (type.equalsIgnoreCase("usager")) {
            usagerService.deleteUsager(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return null;
    }
    // *****************************END DELETE METHOD*****************************

    // *****************************ADD METHOD*****************************
    @PostMapping("/vto")
    public ResponseEntity<VtoDto> createVto(@RequestBody VtoDto vtoDto) {
        Vto vtoResquest = vtoMapStruct.toEntity(vtoDto);
        Vto vto = vtoService.createVto(vtoResquest);
        VtoDto vtoResponse = vtoMapStruct.toDto(vto);
        return ResponseEntity.ok().body(vtoResponse);
    }

    @PostMapping("/vpt")
    public ResponseEntity<VptDto> createVpt(@RequestBody VptDto vptDto) {
        Vpt vptResquest = vptMapStruct.toEntity(vptDto);
        Vpt vtp = vptService.createVpt(vptResquest);
        VptDto vptResponse = vptMapStruct.toDto(vtp);
        return ResponseEntity.ok().body(vptResponse);
    }
    // *****************************END ADD METHOD*****************************

}



