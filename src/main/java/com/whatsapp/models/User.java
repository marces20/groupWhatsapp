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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
  @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq", allocationSize = 1)
  private Integer id;

  @NotNull
  @NotEmpty
  private String name;

  @NotNull
  @NotEmpty
  private String username;

  @NotNull
  @NotEmpty
  private String phone;

  @NotNull
  @NotEmpty
  private String password;

  @NotNull
  @NotEmpty
  @Email
  private String mail;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "message", fetch = FetchType.LAZY)
  private List<Message> messages;


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
   * @return the name
   */
  public String getName() {
    return name;
  }


  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }


  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }


  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }


  /**
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }


  /**
   * @param phone the phone to set
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }


  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }


  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }


  /**
   * @return the mail
   */
  public String getMail() {
    return mail;
  }


  /**
   * @param mail the mail to set
   */
  public void setMail(String mail) {
    this.mail = mail;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((mail == null) ? 0 : mail.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((phone == null) ? 0 : phone.hashCode());
    result = prime * result + ((username == null) ? 0 : username.hashCode());
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
    User other = (User) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (mail == null) {
      if (other.mail != null)
        return false;
    } else if (!mail.equals(other.mail))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (phone == null) {
      if (other.phone != null)
        return false;
    } else if (!phone.equals(other.phone))
      return false;
    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;
    return true;
  }

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

}
