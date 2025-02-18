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

    @Column(name = "filePath")
    private String filePath;

    @Column(name = "botName")
    private String botName;

    @Column(name = "fileType")
    private String fileType;

    @Column(name = "uploadedBy")
    private String uploadedBy;

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

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String theUploadedBy) {
        uploadedBy = theUploadedBy;
    }
}
