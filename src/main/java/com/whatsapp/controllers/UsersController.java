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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.models.User;
import com.whatsapp.services.IUserService;

@RestController
@RequestMapping("/user")
public class UsersController {

  @Autowired
  IUserService userService;

  @GetMapping("/users")
  public Page<User> findAll() {
    // retornará todos los usuarios
    Pageable pageRequest = PageRequest.of(0, 10000);
    return userService.findAll(pageRequest);
  }
}
