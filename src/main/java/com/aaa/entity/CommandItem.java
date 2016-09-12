package com.aaa.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class CommandItem {
	private UUID id;
	private UUID group_id;
	private String name;
	private Integer run_index;
	private String command;
	private String remark;
	private Date create_date;
	private Integer status;//0停用1启用

	public CommandItem() {
		super();
	}

	public CommandItem(UUID group_id, String name, Integer run_index, String command, String remark) {
		super();
		this.group_id = group_id;
		this.name = name;
		this.run_index = run_index;
		this.command = command;
		this.remark = remark;
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

	@Type(type = "uuid-char")
	public UUID getGroup_id() {
		return group_id;
	}

	public void setGroup_id(UUID group_id) {
		this.group_id = group_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRun_index() {
		return run_index;
	}

	public void setRun_index(Integer run_index) {
		this.run_index = run_index;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
