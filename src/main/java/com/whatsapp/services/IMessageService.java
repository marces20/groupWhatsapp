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

import com.whatsapp.models.Group;
import com.whatsapp.models.Message;

public interface IMessageService {

  Message findById(Integer idMessage);

  Page<Message> findByGrupo(Group group, Pageable pageable);

  Message save(Message messsage);

  void delete(Integer idMessage);
}
