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
package com.whatsapp.services.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whatsapp.models.User;
import com.whatsapp.repositories.UserRepository;
import com.whatsapp.services.IUserService;

@Service
public class UserServiceJpa implements IUserService {

  @Autowired
  private UserRepository userRepo;

  @Override
  @Transactional(readOnly = true)
  public Page<User> findAll(Pageable pageable) {
    return userRepo.findAll(pageable);
  }

  @Override
  public User findById(Integer idUser) {
    Optional<User> optional = userRepo.findById(idUser);
    if (optional.isPresent()) {
      return optional.get();
    }
    return null;
  }


}
