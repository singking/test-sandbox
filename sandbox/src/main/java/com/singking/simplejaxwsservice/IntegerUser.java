package com.singking.simplejaxwsservice;

import javax.xml.bind.annotation.XmlElement;


/**
*
*/
public  class IntegerUser {
 @XmlElement(name="id")
 private Integer id;
 @XmlElement(name="user")
 private User user;
 /**
  *
  */
 public IntegerUser() {}
 /**
  * @param id
  * @param user
  */
 public IntegerUser(Integer id, User user) {
    this.id = id;
    this.user = user;
 }
 /**
  * @return {@link Integer}
  */
 public Integer getId() {
    return id;
 }
 /**
  * @return {@link User}
  */
 public User getUser() {
    return user;
 }
}