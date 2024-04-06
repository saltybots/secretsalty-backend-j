package com.secretsalty.secretsalty.endpoint.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.secretsalty.secretsalty.repository.ParticipantRepository;
import com.secretsalty.secretsalty.repository.model.Participant;
import java.security.Principal;
import java.util.List;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping(path = "/app", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestAuthController {

  private final FirebaseAuth firebaseAuth;
  private final ParticipantRepository participantRepository;

  @Autowired
  public TestAuthController(
      FirebaseAuth firebaseAuth, ParticipantRepository participantRepository) {
    this.firebaseAuth = firebaseAuth;
    this.participantRepository = participantRepository;
  }

  @GetMapping(path = "/test")
  public String test(Principal principal) throws FirebaseAuthException {
    log.debug("User got endpoint test: {}", principal.getName());
    return "hello, " + firebaseAuth.getUser(principal.getName()).getEmail();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Participant create(@RequestBody Participant participant) {
    return this.participantRepository.create(participant);
  }

  @GetMapping(path = "/allForUser/{userUuid}")
  public List<Participant> readAllForUser(@PathVariable UUID userUuid) {
    return this.participantRepository.readAllByUser(userUuid);
  }

  @GetMapping(path = "/allForGroup/{groupUuid}")
  public List<Participant> readAllForGroup(@PathVariable UUID groupUuid) {
    return this.participantRepository.readAllForGroup(groupUuid);
  }

  @PutMapping
  public Participant update(@RequestBody Participant participant) {
    return this.participantRepository.update(participant);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@RequestParam UUID userUuid, @RequestParam UUID groupUuid) {
    this.participantRepository.delete(userUuid, groupUuid);
  }
}
