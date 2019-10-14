package com.framework.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Model class for User
 */
@Entity
@Table(name = "AppUser", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username", name = "appuser_username_unique"),
		@UniqueConstraint(columnNames = "email", name = "appuser_email_unique") })
public class AppUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "userId", length = 32)
	private String Id;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "client", foreignKey = @ForeignKey(name = "FK_AppUser_Client"))
	private Client client;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "organization", foreignKey = @ForeignKey(name = "FK_AppUser_Organizations"))
	private Organization organization;
	
	@Type(type = "yes_no")
	@Column(name = "active", nullable = false, length = 1)
	private Boolean active = true;

	@Column(name = "created", nullable = false)
	private Date created = new Date();

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "createdBy", foreignKey = @ForeignKey(name = "FK_AppUser_createdBy"))
	private AppUser createdBy;

	@Column(name = "updated", nullable = false)
	private Date updated = new Date();

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "updatedBy", foreignKey = @ForeignKey(name = "FK_AppUser_updatedBy"))
	private AppUser updatedBy;

	@Column(name = "username", nullable = false, length = 60)
	private String username;

	@Column(name = "email", nullable = false, length = 60)
	private String email;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@OneToMany(mappedBy = "createdBy")
	private Set<AppUser> createdByList = new HashSet<AppUser>();

	@OneToMany(mappedBy = "updatedBy")
	private Set<AppUser> updatedByList = new HashSet<AppUser>();
	
	
	
	public AppUser() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AppUser getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(AppUser createdBy) {
		this.createdBy = createdBy;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public AppUser getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(AppUser updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Set<AppUser> getCreatedByList() {
		return createdByList;
	}

	public void setCreatedByList(Set<AppUser> createdByList) {
		this.createdByList = createdByList;
	}

	public Set<AppUser> getUpdatedByList() {
		return updatedByList;
	}

	public void setUpdatedByList(Set<AppUser> updatedByList) {
		this.updatedByList = updatedByList;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@Override
	public String toString() {
		return "User [userId=" + Id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}
}
