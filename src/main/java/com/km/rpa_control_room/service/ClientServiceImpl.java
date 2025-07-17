package com.km.rpa_control_room.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.km.rpa_control_room.dao.ClientRepository;
import com.km.rpa_control_room.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

   private ClientRepository clientRepository;

   public List<Client> findAll() {
      return clientRepository.findAllByName();
   }
}
