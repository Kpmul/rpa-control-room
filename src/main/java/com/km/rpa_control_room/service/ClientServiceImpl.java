package com.km.rpa_control_room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.km.rpa_control_room.dao.ClientRepository;
import com.km.rpa_control_room.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

   private ClientRepository clientRepository;

   @Autowired
   public ClientServiceImpl(ClientRepository theClientRepository) {
      clientRepository = theClientRepository;
   }

   public List<Client> findAll() {
      return clientRepository.findAllByOrderByName();
   }

   public void save(Client theClient) {
      clientRepository.save(theClient);
   }
}
