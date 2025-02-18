package com.km.rpa_control_room.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bot")
public class Bot {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "bot_name")
    private String botName;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "uploader")
    private String uploader;

    public Bot(){}

    public Bot(Long theId, String theFilePath, String theBotName,
                String theFileType, String theUploader){
            
            id = theId;
            filePath = theFilePath;
            botName = theBotName;
            fileType = theFileType;
            uploader = theUploader;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long theId) {
        id = theId;
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

    @Override
    public String toString() {
        return "Bot [id=" + id + ", filePath=" + filePath + ", botName=" + botName + ", fileType=" + fileType
                + ", uploader=" + uploader + "]";
    }
}
