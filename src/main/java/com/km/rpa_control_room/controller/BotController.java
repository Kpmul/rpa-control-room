package com.km.rpa_control_room.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.km.rpa_control_room.dto.BotDTO;
import com.km.rpa_control_room.entity.Bot;
import com.km.rpa_control_room.service.BotService;

@RestController
public class BotController{

    private final BotService botService;

    private static final String BOT_STORAGE_DIRECTORY = System.getProperty("user.home") + "/Desktop/bot-storage/";

    @Autowired
    public BotController(BotService theBotService){
        botService = theBotService;
    }

    @GetMapping("/home")
    public String getHomepage(){
        return "Welcome to the RPA Control Room";
    }

    @GetMapping("/all")
    public List<Bot> getAllBots(){
        
        List<Bot> bots = botService.findAll();
        
        return bots;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadBot(@ModelAttribute BotDTO botDTO){

        System.out.println("Have received the request " + botDTO);

        String botName = botDTO.getName();

        MultipartFile theFile = botDTO.getFile();

        if(theFile ==  null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty!");
        }

        String orginalFileName = theFile.getOriginalFilename();

        String filePath = BOT_STORAGE_DIRECTORY + orginalFileName;

        try{
            botDTO.getFile().transferTo(new File(filePath));
        }catch(IOException ioe){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }

        String fileType = orginalFileName.substring(orginalFileName.lastIndexOf(".") + 1);
        
        Bot theBot = new Bot(filePath, botName, fileType, LocalDateTime.now());

        botService.save(theBot);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bot uploaded");
    }
}
