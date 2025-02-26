package com.km.rpa_control_room.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    
    boolean fileExists(MultipartFile file);
}
