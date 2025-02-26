package com.km.rpa_control_room.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {
    
    @Override
    public boolean fileExists(MultipartFile theFile){

        if(theFile == null){
            return false;
        }
        else{
            return true;
        }
    }

}
