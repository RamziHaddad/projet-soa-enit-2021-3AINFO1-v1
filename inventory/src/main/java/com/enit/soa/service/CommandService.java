package com.enit.soa.service;

import java.util.List;

import com.enit.soa.domain.Command;
import com.enit.soa.domain.CommandDetails;

public interface CommandService {
	
	public void cancelCommand(long id) throws Exception;
	public Command createCommand();
	public Command editCommand(long id, CommandDetails commandDetails);
	public List<Command> getAll();

}
