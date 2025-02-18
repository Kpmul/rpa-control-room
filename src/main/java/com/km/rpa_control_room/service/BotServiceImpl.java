package com.km.rpa_control_room.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.km.rpa_control_room.dao.BotRepository;
import com.km.rpa_control_room.entity.Bot;

public class BotServiceImpl implements BotService {

    private BotRepository botRepository;

    public void setBotRepository(BotRepository theBotRepository){
        botRepository = theBotRepository;
    }

    @Autowired
    public BotServiceImpl(BotRepository theBotRepository){
        botRepository = theBotRepository;
    }

    @Override
    public List<Bot> findAll(){

        return botRepository.findAllByOrderByUploadTimeDesc(); 
    }

    @Override
    public Bot findById(Long theId){

        Optional<Bot> result = botRepository.findById(theId);

        Bot theBot = null;

        if(result.isPresent()){
            theBot = result.get();
        }
        else{
            throw new RuntimeException("Did not find the bot with id - " + theId);
        }

        return theBot;
    }

    
}
