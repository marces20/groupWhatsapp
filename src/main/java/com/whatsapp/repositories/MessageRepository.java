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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.whatsapp.models.Group;
import com.whatsapp.models.Message;

public interface MessageRepository extends PagingAndSortingRepository<Message, Integer> {

  @Query("select p from Message p where p.groupRecipient = ?1")
  public Page<Message> findByGrupo(Group group, Pageable pageable);
}
