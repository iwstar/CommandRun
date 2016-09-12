package com.aaa.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class CommandGroup {
	private UUID id;
	private String name;
	private Date create_date;
	private Integer status;//0停用1启用

	public CommandGroup() {
		super();
	}

	public CommandGroup(UUID id, String name, Date create_date, Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.create_date = create_date;
		this.status = status;
	}

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
