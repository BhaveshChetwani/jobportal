package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.model.Clients;
import com.jobportal.repos.ClientsRepo;

@Service
public class ClientsService {

	@Autowired
	ClientsRepo clientsRepo;

	public Clients saveJobDescription(Clients clients) {
		Clients clientsNew = clientsRepo.save(clients);
		return clientsNew;

	}
	
	public Clients findClientsbyId(int clientsId) {
		Optional<Clients> clients = clientsRepo.findById(clientsId);
		return clients.get();

	}
	
	public List<Clients> findAllClients() {
		List<Clients> clientsList = new ArrayList<Clients>();
		Iterable<Clients> clients = clientsRepo.findAll();
		for(Clients client : clients) {
			clientsList.add(client);
		}
		return clientsList;
	}
}
