package com.km.rpa_control_room.dto;

import org.springframework.web.multipart.MultipartFile;

public class BotDTO {
    
    private String name;
    private MultipartFile file;

    public BotDTO(){}

    public BotDTO(String theName, MultipartFile theFile){
        name = theName;
        file = theFile;
    }

    public String getName() {
        return name;
    }
    public void setName(String theName) {
        name = theName;
    }
    public MultipartFile getFile(){
        return file;
    }
    public void setFile(MultipartFile theFile){
        file = theFile;
    }

    @Override
    public String toString() {
        return "BotDTO{name='" + name + "', file=" + (file != null ? file.getOriginalFilename() : "null") + "}";
    }
}
