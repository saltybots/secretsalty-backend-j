package com.secretsalty.secretsalty.endpoint.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.secretsalty.secretsalty.repository.UserRepository;
import com.secretsalty.secretsalty.repository.model.User;
import java.security.Principal;
import java.util.List;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Log4j2
public class UserController {

  private final UserRepository userRepository;

  private final FirebaseAuth firebaseAuth;

  @Autowired
  public UserController(UserRepository userRepository, FirebaseAuth firebaseAuth) {
    this.userRepository = userRepository;
    this.firebaseAuth = firebaseAuth;
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public User create(@RequestBody User newUser) {
    log.debug("Creating new user: {}", newUser);
    return this.userRepository.create(newUser);
  }

  @DeleteMapping("/{uuid}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable final UUID uuid) {
    this.userRepository.delete(uuid);
  }

  @GetMapping
  public List<User> readAll() {
    return this.userRepository.readAll();
  }

  @GetMapping("/{uuid}")
  public User readByUuid(@PathVariable final UUID uuid) {
    return this.userRepository.readById(uuid);
  }

  @GetMapping("/me")
  public User currentUser(Principal principal) throws FirebaseAuthException {
    final var currentUid = firebaseAuth.getUser(principal.getName()).getUid();

    return this.userRepository.findByFirebaseUID(currentUid);
  }

  @PutMapping
  public User update(@RequestBody User user) {
    return this.userRepository.update(user);
  }
}
