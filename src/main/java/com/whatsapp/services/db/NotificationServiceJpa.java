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

import com.whatsapp.models.Notification;
import com.whatsapp.repositories.NotificationRepository;
import com.whatsapp.services.INotificationService;

@Service
public class NotificationServiceJpa implements INotificationService {

  @Autowired
  private NotificationRepository notiRepo;

  @Override
  public Notification save(Notification notification) {
    Optional<Notification> optional = notiRepo.findById(notiRepo.save(notification).getId());
    if (optional.isPresent()) {
      return optional.get();
    }
    return null;
  }

}
