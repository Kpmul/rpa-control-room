package com.km.rpa_control_room.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.km.rpa_control_room.entity.Bot;

public interface BotRepository extends JpaRepository<Bot, Long> {

    public List<Bot> findAllByOrderByUploadTimeDesc();
}
