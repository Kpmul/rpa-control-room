package com.km.rpa_control_room.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.km.rpa_control_room.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

   public List<Client> findAllByName();
}
