package com.jt.controller;

import com.jt.service.FileService;
import com.jt.vo.ImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
    @Autowired
    private FileService fileService;
    @RequestMapping("/pic/upload")
    @ResponseBody
    public ImageVO uploadFile(MultipartFile uploadFile){
        return fileService.updateFile(uploadFile);
    }
}
