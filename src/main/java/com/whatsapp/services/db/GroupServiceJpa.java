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
import org.springframework.stereotype.Service;

import com.whatsapp.models.Group;
import com.whatsapp.repositories.GroupRepository;
import com.whatsapp.services.IGroupService;

@Service
public class GroupServiceJpa implements IGroupService {

  @Autowired
  private GroupRepository groupRepo;

  @Override
  public Group findById(Integer idGroup) {
    Optional<Group> optional = groupRepo.findById(idGroup);
    if (optional.isPresent()) {
      return optional.get();
    }
    return null;
  }


}
