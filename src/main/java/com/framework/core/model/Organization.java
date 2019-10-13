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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * Model class for Client
 */
@Entity
@Table(name = "Organization")
public class Organization implements Serializable{

	private static final long serialVersionUID = 3666516236791355396L;
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "organizationId", length = 32)
	private String Id;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "client", foreignKey = @ForeignKey(name = "FK_Organization_client"))
	private Client client;

	@Type(type = "yes_no")
	@Column(name = "active", nullable = false, length = 1)
	private Boolean active = true;

	@Column(name = "created", nullable = false)
	private Date created = new Date();

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "createdBy", foreignKey = @ForeignKey(name = "FK_Organization_createdBy"))
	private AppUser createdBy;

	@Column(name = "updated", nullable = false)
	private Date updated = new Date();

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "updatedBy", foreignKey = @ForeignKey(name = "FK_Organization_updatedBy"))
	private AppUser updatedBy;
	
	@Column(name = "value", nullable = false, length = 60)
	private String value;

	@Column(name = "name", nullable = false, length = 60)
	private String name;

	@Type(type = "yes_no")
	@Column(name = "ready", nullable = false, length = 1)
	private Boolean ready = false;
	
	@Type(type = "yes_no")
	@Column(name = "summaryLevel", nullable = false, length = 1)
	private Boolean summaryLevel = false;
	
	@OneToMany(mappedBy = "createdBy")
	private Set<AppUser> createdByList = new HashSet<AppUser>();

	@OneToMany(mappedBy = "updatedBy")
	private Set<AppUser> updatedByList = new HashSet<AppUser>();
	
	@OneToMany(mappedBy = "client")
	private Set<Client> clientList = new HashSet<Client>();

	public Organization() {

	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public AppUser getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(AppUser createdBy) {
		this.createdBy = createdBy;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getReady() {
		return ready;
	}

	public void setReady(Boolean ready) {
		this.ready = ready;
	}

	public Boolean getSummaryLevel() {
		return summaryLevel;
	}

	public void setSummaryLevel(Boolean summaryLevel) {
		this.summaryLevel = summaryLevel;
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

	public Set<Client> getClientList() {
		return clientList;
	}

	public void setClientList(Set<Client> clientList) {
		this.clientList = clientList;
	}
	
	
}
