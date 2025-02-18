package com.km.rpa_control_room.service;

import java.util.List;

import com.km.rpa_control_room.entity.Bot;

public interface BotService {

    List<Bot> findAll();

    Bot findById(Long theId);

    Bot save(Bot theBot);

    void deleteById(Long theId);
}
