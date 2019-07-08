package com.artexperience.test.ArtTestSecure.web;

import com.artexperience.test.ArtTestSecure.data.UserRepositoryJpa;
import com.artexperience.test.ArtTestSecure.model.Usuarios;
import com.artexperience.test.ArtTestSecure.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserServices userServices;
    @Autowired
    private UserRepositoryJpa repository;

    public UserRestController(final UserServices userServices, final UserRepositoryJpa repository){
        this.userServices = userServices;
        this.repository = repository;
    }

    @GetMapping("/id/{id_user}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Usuarios> getUserById(@PathVariable("id_user") final Long iduser) {
        return userServices.findUsersById(iduser);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuarios> getUserById(){
        return userServices.findAllUsers();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios getUserById(@RequestBody final Usuarios user){
        return userServices.create(user);
    }

    @DeleteMapping("/delete/{id_user}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(@PathVariable("id_user") final Long user){
        userServices.deleteUserById(user);
    }

}
