package com.km.rpa_control_room.service;

import java.util.List;

import com.km.rpa_control_room.entity.Client;

public interface ClientService {

   List<Client> findAll();

   void save(Client client);
}
