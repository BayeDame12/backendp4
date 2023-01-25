package com.backendp4.backendp4.service;

import com.backendp4.backendp4.model.User;
import com.backendp4.backendp4.repository.UserRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Recupere la Liste des VtoDto
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    //creer un VtoDto
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    //mettre ajour un VtoDto

    @Override
    public User updateUser(long id, User userRequest) {
        User user=userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("la tentative de mise a jour na pas abouti"));
        user.setLogin(userRequest.getLogin());
        return userRepository.save(user);
    }
    //Archiver un vto

    @Override
    public void deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("lUtilisateur que vous tenter de supprimer n existe pas!!!"));
        userRepository.delete(user);
    }
    //recuperer un VtoDto
    @Override
    public User getUserById(long id) {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("L'utilisateur checher n existe pas!!!");
        }

    }


}
