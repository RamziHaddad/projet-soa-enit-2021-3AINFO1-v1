	package com.enit.soa.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Command{

	public enum Status{
		 READY,
		 NOTREADY
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Status status;
	
	@OneToMany(targetEntity = CommandDetails.class,cascade=CascadeType.ALL)
	private List<CommandDetails> commandDetails=new ArrayList<CommandDetails>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<CommandDetails> getCommandDetails() {
		return commandDetails;
	}

	public void setCommandDetails(List<CommandDetails> commandDetails) {
		this.commandDetails = commandDetails;
	}
	
	
	
	
	
}