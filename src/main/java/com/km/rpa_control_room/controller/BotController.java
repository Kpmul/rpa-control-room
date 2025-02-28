package com.km.rpa_control_room.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.km.rpa_control_room.dto.BotDTO;
import com.km.rpa_control_room.entity.Bot;
import com.km.rpa_control_room.service.BotService;
import com.km.rpa_control_room.service.FileService;

@Controller
public class BotController{

    private final BotService botService;
    private final FileService fileService;

    private static final String BOT_STORAGE_DIRECTORY = System.getProperty("user.home") + "/Desktop/bot-storage/";

    // @InitBinder

    @Autowired
    public BotController(BotService theBotService, FileService theFileService){
        botService = theBotService;
        fileService = theFileService;
    }

    @GetMapping("/home")
    public String getHomepage(Model model){

        model.addAttribute("theDate",LocalDateTime.now());
        model.addAttribute("pageType", "full");

        return "home";
    }

    @GetMapping("/all")
    public String getAllBots(Model model){

        model.addAttribute("theDate", LocalDateTime.now());
        
        List<Bot> bots = botService.findAll();
        model.addAttribute("allBotsList", bots);

        return "allbots";
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadBot(@ModelAttribute BotDTO botDTO){

        MultipartFile theFile = botDTO.getFile();

        if(!fileService.fileExists(theFile)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty!");
        }

        String orginalFileName = theFile.getOriginalFilename();

        String botName = orginalFileName.substring(0, orginalFileName.lastIndexOf("."));

        String filePath = BOT_STORAGE_DIRECTORY + orginalFileName;

        try{
            theFile.transferTo(new File(filePath));
        }catch(IOException ioe){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }

        String fileType = orginalFileName.substring(orginalFileName.lastIndexOf(".") + 1);
        
        Bot theBot = new Bot(filePath, botName, fileType, LocalDateTime.now());

        botService.save(theBot);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bot uploaded");
    }

    @PutMapping("/{id}/file")
    public ResponseEntity<String> editBot(@PathVariable("id") Long theId, @RequestParam("file") MultipartFile file){

        Bot dbBot = botService.findById(theId);

        if(file == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bot not found!");
        }

        File fileToDelete = new File(dbBot.getFilePath());

        if(!fileToDelete.delete()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't delete old file!");
        }

        String originalFileName = file.getOriginalFilename();

        String filePath = BOT_STORAGE_DIRECTORY + originalFileName;

        try{
            file.transferTo(new File(filePath));
        }
        catch(IOException ioe){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");   
        }

        String fileType = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);

        dbBot.setFileType(fileType);
        dbBot.setFilePath(filePath);
        dbBot.setUploadTime(LocalDateTime.now());

        botService.save(dbBot);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bot successfully updated!");
    }

    @PutMapping("{id}/name")
    public ResponseEntity<String> editBotName(@PathVariable("id") Long theId, @RequestParam("name") String name){

        Bot dbBot = botService.findById(theId);

        if(dbBot == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bot not found!");
        }

        dbBot.setName(name);
        botService.save(dbBot);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bot name updated!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBot(@PathVariable("id") Long theId){

        Bot dbBot = botService.findById(theId);

        if(dbBot == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bot not found!");
        }

        botService.deleteById(theId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bot has been deleted successfully!");
    }
}
