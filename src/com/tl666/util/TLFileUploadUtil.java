package com.tl666.util;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

public enum TLFileUploadUtil {
    TL;

    public String upLoad(MultipartFile file, String originalFilename, String path) throws Exception {
//        String filename = UUID.randomUUID().toString().replaceAll("-","")+"."+originalFilename.split("\\.")[1];
        String filename = originalFilename.split("\\.")[0] +System.currentTimeMillis()
                 + "." + originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(new File(path + filename)));
        return filename;
    }
}

