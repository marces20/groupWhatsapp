/*
 * Copyright (C) Intraway Corporation - All Rights Reserved (2020)
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 *
 * Proprietary and confidential
 *
 * This file is subject to the terms and conditions defined in file LICENSE.txt, which is part of this source code
 * package.
 */
package com.whatsapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.models.Group;
import com.whatsapp.models.Message;
import com.whatsapp.services.IGroupService;
import com.whatsapp.services.IMessageService;
import com.whatsapp.services.IUserService;

@RestController
@RequestMapping("/message")
public class MessagesController {


  private static final Logger logger = LoggerFactory.getLogger(MessagesController.class);

  @Autowired
  IMessageService messageService;

  @Autowired
  IGroupService groupService;

  @Autowired
  IUserService userService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Message> save(@RequestBody Message message) {

    return new ResponseEntity<>(messageService.save(message), HttpStatus.CREATED);
  }


  @GetMapping("/idGroup/{idGroup}")
  public Page<Message> findByIdGrupo(@PathVariable("idGroup") int idGroup) {

    Pageable pageRequest = PageRequest.of(0, 10000, Sort.by("datesent").ascending());

    Group g = groupService.findById(idGroup);

    return messageService.findByGrupo(g, pageRequest);
  }

}
