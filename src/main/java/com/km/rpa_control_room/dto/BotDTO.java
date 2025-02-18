package com.km.rpa_control_room.dto;

import org.springframework.web.multipart.MultipartFile;

public class BotDTO {
    
    private String filePath;
    private String botName;
    private String fileType;
    private String uploader;
    private MultipartFile file;

    public BotDTO(){}

    public BotDTO(String theFilePath, String theBotName, String theFileType, 
                    String theUploader, MultipartFile theFile){

        filePath = theFilePath;
        botName = theBotName;
        fileType = theFileType;
        uploader = theUploader;
        file = theFile;
    }

    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String theFilePath) {
        filePath = theFilePath;
    }
    public String getBotName() {
        return botName;
    }
    public void setBotName(String theBotName) {
        botName = theBotName;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String theFileType) {
        fileType = theFileType;
    }
    public String getUploader() {
        return uploader;
    }
    public void setUploader(String theUploader) {
        uploader = theUploader;
    }
    public MultipartFile getFile(){
        return file;
    }
}
