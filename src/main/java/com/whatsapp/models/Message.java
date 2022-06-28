/*
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 *
 * Proprietary and confidential
 *
 * This file is subject to the terms and conditions defined in file LICENSE.txt, which is part of this source code
 * package.
 */
package com.whatsapp.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "messages")
public class Message implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messages_seq_gen")
  @SequenceGenerator(name = "messages_seq_gen", sequenceName = "messages_id_seq", allocationSize = 1)
  private Integer id;

  @NotNull
  @NotEmpty
  private String message;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  @Column(name = "date_sent", nullable = false)
  private Date dateSent;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_sender_id")
  private User userSender;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_recipient_id")
  private User userRecipient;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "group_recipient_id")
  private Group groupRecipient;

  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the dateSent
   */
  public Date getDateSent() {
    return dateSent;
  }

  /**
   * @param dateSent the dateSent to set
   */
  public void setDateSent(Date datesent) {
    this.dateSent = datesent;
  }

  /**
   * @return the user_sender
   */

  public User getUserSender() {
    return userSender;
  }

  /**
   * @param user_sender the user_sender to set
   */
  public void setUserSender(User userSender) {
    this.userSender = userSender;
  }

  /**
   * @return the user_recipient
   */

  public User getUserRecipient() {
    return userRecipient;
  }

  /**
   * @param user_recipient the user_recipient to set
   */
  public void setUserRecipient(User userRecipient) {
    this.userRecipient = userRecipient;
  }

  /**
   * @return the group_recipient
   */
  public Group getGroupRecipient() {
    return groupRecipient;
  }

  /**
   * @param group_recipient the group_recipient to set
   */
  public void setGroupRecipient(Group groupRecipient) {
    this.groupRecipient = groupRecipient;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dateSent == null) ? 0 : dateSent.hashCode());
    result = prime * result + ((groupRecipient == null) ? 0 : groupRecipient.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((message == null) ? 0 : message.hashCode());
    result = prime * result + ((userRecipient == null) ? 0 : userRecipient.hashCode());
    result = prime * result + ((userSender == null) ? 0 : userSender.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Message other = (Message) obj;
    if (dateSent == null) {
      if (other.dateSent != null)
        return false;
    } else if (!dateSent.equals(other.dateSent))
      return false;
    if (groupRecipient == null) {
      if (other.groupRecipient != null)
        return false;
    } else if (!groupRecipient.equals(other.groupRecipient))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (message == null) {
      if (other.message != null)
        return false;
    } else if (!message.equals(other.message))
      return false;
    if (userRecipient == null) {
      if (other.userRecipient != null)
        return false;
    } else if (!userRecipient.equals(other.userRecipient))
      return false;
    if (userSender == null) {
      if (other.userSender != null)
        return false;
    } else if (!userSender.equals(other.userSender))
      return false;
    return true;
  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


}
