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

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.whatsapp.models.Group;
import com.whatsapp.models.Message;
import com.whatsapp.models.Notification;
import com.whatsapp.repositories.MessageRepository;
import com.whatsapp.services.IMessageService;
import com.whatsapp.services.INotificationService;
import com.whatsapp.services.INotificationTypeService;

@Service
public class MessageServiceJpa implements IMessageService {

  @Autowired
  private MessageRepository messageRepo;

  @Autowired
  private INotificationService ntService;

  @Autowired
  private INotificationTypeService ntServices;

  @Override
  public Message save(Message message) {

    Optional<Message> optional = messageRepo.findById(messageRepo.save(message).getId());
    if (optional.isPresent()) {

      Notification n = new Notification();
      n.setDateCreate(new Date());
      n.setGroupRecipient(optional.get().getGroupRecipient());
      n.setUserRecipient(optional.get().getUserRecipient());
      n.setMessage("New Message");
      n.setNotificationType(ntServices.findById(1));

      ntService.save(n);

      return optional.get();
    }
    return null;


  }

  @Override
  public void delete(Integer idMessage) {
    messageRepo.deleteById(idMessage);
  }

  @Override
  public Page<Message> findByGrupo(Group group, Pageable pageable) {

    return messageRepo.findByGrupo(group, pageable);
  }

  @Override
  public Message findById(Integer idMessage) {
    Optional<Message> optional = messageRepo.findById(idMessage);
    if (optional.isPresent()) {
      return optional.get();
    }
    return null;
  }


}
