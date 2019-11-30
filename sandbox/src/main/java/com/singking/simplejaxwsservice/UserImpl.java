package com.singking.simplejaxwsservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

@XmlType(name = "UserType", propOrder = { "id", "firstName", "lastName" })
@XmlAccessorType(XmlAccessType.FIELD)
public class UserImpl implements User {
	@XmlElement(required = true)
	private Long id;
	@XmlElement(required = true)
	private String firstName;
	@XmlElement(required = true)
	private String lastName;

	/**
	*
	*/
	public UserImpl() {
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 */
	public UserImpl(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jaxws.server.hello.User#getId()
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jaxws.hello.server.User#getName()
	 */
	public String getName() {
		return firstName + " " + lastName;
	}

	/**
	*
	*/
	protected static class UserAdapter extends XmlAdapter<UserImpl, User> {
		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.
		 * Object)
		 */
		@Override
		public UserImpl marshal(User u) throws Exception {
			return (UserImpl) u;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.
		 * Object)
		 */
		@Override
		public User unmarshal(UserImpl v) throws Exception {
			return v;
		}
	}
}