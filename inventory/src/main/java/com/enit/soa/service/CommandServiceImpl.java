package com.enit.soa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.enit.soa.domain.Command;
import com.enit.soa.domain.Command.Status;
import com.enit.soa.domain.CommandDetails;
import com.enit.soa.domain.Product;
import com.enit.soa.domain.Stock;
import com.enit.soa.repository.CommandProductRepository;
import com.enit.soa.repository.CommandRepository;
import com.enit.soa.repository.StockRepository;

@ApplicationScoped
public class CommandServiceImpl implements CommandService {

	@Inject
	CommandRepository commandRepository;

	@Inject
	ProductService productService;

	@Inject
	StockService stockService;

	@Override
	public void cancelCommand(long id) throws Exception {
		Optional<Command> findById = commandRepository.findById(id);
		if (findById.isPresent()) {

			// update the stock
			findById.get().getCommandDetails().forEach((c) -> {

				Product product = productService.getProduct(c.getProduct().getId()).get();
				try {
					stockService.editStock(product.getStock().getId(),
							product.getStock().getQuantity() + c.getQuantity());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

		} else {
			throw new Exception("Command does not exists");
		}
	}

	@Override
	public Command createCommand() {
		Command command = new Command();
		command.setStatus(Status.NOTREADY);
		return commandRepository.save(command);
	}

	@Override
	public Command editCommand(long id, CommandDetails commandDetails) {
         Optional<Command> findById = commandRepository.findById(id);
           List<Boolean> found=new ArrayList<Boolean>();
         if(findById.isPresent()) {
        	 long productId=commandDetails.getProduct().getId();
        	 System.out.println("hello");
        	 findById.get().getCommandDetails().forEach(c->{
            	 System.out.println("hello2");

        		 if(c.getProduct().getId()==productId) {
        			 try {
        				 found.add(true);
						stockService.editStock(c.getProduct().getStock().getId(),c.getProduct().getStock().getQuantity()- commandDetails.getQuantity());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		 }
        	 });
        	 if(found.get(0)==false) {
					try {
						stockService.editStock(commandDetails.getProduct().getStock().getId(),
								stockService.findStock().stream().filter(c->c.getId()==commandDetails.getProduct().getStock().getId()).findFirst().get().getQuantity()-commandDetails.getQuantity());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

        	 }
        	 
        	 findById.get().getCommandDetails().add(commandDetails);
        	 commandRepository.save(findById.get());
         }
		
		return null;
	}

	public List<Command> getAll() {
		return commandRepository.findAll();
	}

}
