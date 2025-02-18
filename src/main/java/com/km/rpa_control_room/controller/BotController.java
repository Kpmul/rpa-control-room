package com.km.rpa_control_room.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<String> uploadBot(@RequestParam("file") MultipartFile file,
                                            @RequestParam("uploader") String uploader){

        String fileName = file.getOriginalFilename();

        String fileType = fileName.substring(fileName.lastIndexOf(".")+1);

        String botName = fileName.substring(0, fileName.lastIndexOf("."));

        String filePath = BOT_STORAGE_DIRECTORY + "fileName";

        try{
            file.transferTo(new File(filePath));
        }catch(IOException ioe){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }

        Bot bot = new Bot(filePath, botName, fileType, uploader, file);
    }
}
