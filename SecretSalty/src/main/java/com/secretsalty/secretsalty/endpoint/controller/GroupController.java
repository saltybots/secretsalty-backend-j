package com.secretsalty.secretsalty.endpoint.controller;

import com.secretsalty.secretsalty.repository.GroupRepository;
import com.secretsalty.secretsalty.repository.model.Group;
import java.util.List;
import java.util.UUID;
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
@RequestMapping(path = "/groups", produces = MediaType.APPLICATION_JSON_VALUE)
public class GroupController {

  private final GroupRepository groupRepository;

  @Autowired
  public GroupController(GroupRepository groupRepository) {
    this.groupRepository = groupRepository;
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public Group create(@RequestBody Group newGroup) {
    return this.groupRepository.create(newGroup);
  }

  @DeleteMapping("/{uuid}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable final UUID uuid) {
    this.groupRepository.delete(uuid);
  }

  @GetMapping
  public List<Group> readAll() {
    return this.groupRepository.readAll();
  }

  @GetMapping("/{uuid}")
  public Group readByUuid(@PathVariable final UUID uuid) {
    return this.groupRepository.readByUUID(uuid);
  }

  @PutMapping
  public Group update(@RequestBody Group newGroup) {
    return this.groupRepository.update(newGroup);
  }
}
