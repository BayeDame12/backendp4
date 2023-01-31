package com.backendp4.backendp4.controller;

import com.backendp4.backendp4.dto.UserDto;
import com.backendp4.backendp4.model.User;
import com.backendp4.backendp4.repository.UserRepository;
import com.backendp4.backendp4.service.UserService;
import com.backendp4.backendp4.service.mapper.UserMapStruct;
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
@RequestMapping("/api/user")

public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapStruct userMapStruct;

    public UserController(ModelMapper modelMapper, UserService userService, UserRepository userRepository, UserMapStruct userMapStruct) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.userRepository = userRepository;
        this.userMapStruct = userMapStruct;
    }

    @GetMapping
    public List<UserDto> getAllUser() {

        return userService.getAllUser().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.getUserById(id);
        // convert entity to DTO
        UserDto postResponse = userMapStruct.toDto(user);
        return ResponseEntity.ok().body(postResponse);
    }


    @PostMapping
    public User createVto(@RequestBody UserDto userDto) {
        //un log des donnes envoyer sur postman
        log.info(userDto);
        //un log des donne reus et envoyer dans la basse de donnes via post man
        log.info(userMapStruct.toEntity(userDto));
        return userRepository.save(userMapStruct.toEntity(userDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        // convert DTO to Entity
        User userResquest = userMapStruct.toEntity(userDto);
        User user = userService.updateUser(id, userResquest);
        // entity to DTO
        UserDto userResponse = userMapStruct.toDto(user);
        return ResponseEntity.ok().body(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
