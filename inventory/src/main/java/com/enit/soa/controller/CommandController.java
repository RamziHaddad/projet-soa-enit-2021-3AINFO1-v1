package com.enit.soa.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.jboss.resteasy.annotations.jaxrs.FormParam;

import com.enit.soa.domain.Command;
import com.enit.soa.domain.CommandDetails;
import com.enit.soa.service.CommandService;

import dto.CancelCommand;

@Path("/api/command")
public class CommandController {
	
	
	@Inject
	public CommandService commandService;
	
	
	
	@POST
	public Command creatCommand() {
		
		return commandService.createCommand();
	}
	
	
	
	@PUT
	@Path("/cancel")
	public void cancelCommand(CancelCommand cancelCommand) throws Exception {
		
		 commandService.cancelCommand(cancelCommand.getId());
	}
	
	@PUT
	@Path("/add/{id}")
	public Command addCommand(@PathParam("id") long id, CommandDetails command) throws Exception {
		
		 return commandService.editCommand(id, command);
	}
	
	@GET
	@Path("/all")
	public List<Command> all( ) throws Exception {
		
		return commandService.getAll();
	}

}
