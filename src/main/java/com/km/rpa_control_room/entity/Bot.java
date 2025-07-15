package com.km.rpa_control_room.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bot")
public class Bot {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "name")
    private String name;

    @Column(name = "file_type")
    private String fileType;

    // @Column(name = "uploader")
    // private String uploader;

    @Column(name = "upload_time")
    private LocalDateTime uploadTime;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Bot(){}

    public Bot(String theFilePath, String theName,
                String theFileType, LocalDateTime theUploadTime){
            
        filePath = theFilePath;
        name = theName;
        fileType = theFileType;
        uploadTime = theUploadTime;
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
    public String getName() {
        return name;
    }
    public void setName(String theName) {
        name = theName;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String theFileType) {
        fileType = theFileType;
    }
    public LocalDateTime getUploadTime(){
        return uploadTime;
    }
    public void setUploadTime(LocalDateTime theUploadTime){
        uploadTime = theUploadTime;
    }

    @Override
    public String toString() {
        return "Bot [id=" + id + ", filePath=" + filePath + ", name=" + name + ", fileType=" + fileType
                + "uploadTime="+uploadTime;
    }
}
