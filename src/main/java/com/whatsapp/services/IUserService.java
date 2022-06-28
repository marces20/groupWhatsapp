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
package com.whatsapp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.whatsapp.models.User;

public interface IUserService {

  User findById(Integer idUser);

  Page<User> findAll(Pageable pageable);
}
