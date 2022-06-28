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

import com.whatsapp.models.NotificationType;
import com.whatsapp.repositories.NotificationTypeRepository;
import com.whatsapp.services.INotificationTypeService;

@Service
public class NotificationTypeServiceJpa implements INotificationTypeService {

  @Autowired
  private NotificationTypeRepository notificationTypeRepo;

  @Override
  public NotificationType findById(Integer idNt) {
    Optional<NotificationType> optional = notificationTypeRepo.findById(idNt);
    if (optional.isPresent()) {
      return optional.get();
    }
    return null;
  }

}
