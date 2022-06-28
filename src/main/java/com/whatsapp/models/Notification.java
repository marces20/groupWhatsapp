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
@Table(name = "notifications")
public class Notification implements Serializable {


  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notifications_seq_gen")
  @SequenceGenerator(name = "notifications_seq_gen", sequenceName = "notifications_id_seq", allocationSize = 1)
  private Integer id;

  @NotEmpty
  @NotNull
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  @Column(name = "date_create", nullable = false)
  private Date dateCreate;

  @ManyToOne
  @JoinColumn(name = "user_recipient_id", nullable = false)
  private User userRecipient;

  @ManyToOne
  @JoinColumn(name = "group_recipient_id", nullable = false)
  private Group groupRecipient;

  private String message;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "notification_type_id", nullable = false)
  private NotificationType notificationType;


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
   * @return the dateCreate
   */
  public Date getDateCreate() {
    return dateCreate;
  }


  /**
   * @param dateCreate the dateCreate to set
   */
  public void setDateCreate(Date dateCreate) {
    this.dateCreate = dateCreate;
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
   * @return the notification_type
   */
  public NotificationType getNotificationType() {
    return notificationType;
  }


  /**
   * @param notification_type the notification_type to set
   */
  public void setNotificationType(NotificationType notificationType) {
    this.notificationType = notificationType;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((dateCreate == null) ? 0 : dateCreate.hashCode());
    result = prime * result + ((groupRecipient == null) ? 0 : groupRecipient.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((message == null) ? 0 : message.hashCode());
    result = prime * result + ((notificationType == null) ? 0 : notificationType.hashCode());
    result = prime * result + ((userRecipient == null) ? 0 : userRecipient.hashCode());
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
    Notification other = (Notification) obj;
    if (dateCreate == null) {
      if (other.dateCreate != null)
        return false;
    } else if (!dateCreate.equals(other.dateCreate))
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
    if (notificationType == null) {
      if (other.notificationType != null)
        return false;
    } else if (!notificationType.equals(other.notificationType))
      return false;
    if (userRecipient == null) {
      if (other.userRecipient != null)
        return false;
    } else if (!userRecipient.equals(other.userRecipient))
      return false;
    return true;
  }

  /**
  * 
  */
  private static final long serialVersionUID = 1L;


}
