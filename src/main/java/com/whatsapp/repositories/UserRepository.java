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
package com.whatsapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.whatsapp.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

  @Query("select p from User p where p.id in(?1)")
  public List<User> buscarPorIds(List<Integer> ids);

}
