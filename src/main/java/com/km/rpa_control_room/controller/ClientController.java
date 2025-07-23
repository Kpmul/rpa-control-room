package com.km.rpa_control_room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.km.rpa_control_room.entity.Client;
import com.km.rpa_control_room.service.ClientService;

@Controller
public class ClientController {

   private final ClientService clientService;

   @Autowired
   public ClientController(ClientService theClientService) {
      clientService = theClientService;
   }

   @GetMapping("/clients/all")
   public String getAllClients(Model model) {

      model.addAttribute("pageType", "full");

      List<Client> clients = clientService.findAll();

      model.addAttribute("allClientsList", clients);

      return "all-clients";
   }
}
