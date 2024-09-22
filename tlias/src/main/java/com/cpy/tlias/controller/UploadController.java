package com.cpy.tlias.controller;

import com.cpy.tlias.polo.Result;
import com.cpy.tlias.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
//    @PostMapping("/upload")
//    public Result upload(String name, int age, MultipartFile image){
//        log.info("name{},age{},image{}",name,age,image);
//        return Result.success();
//    }

    /**
     * 上传图片，将图片交给阿里云oss管理
     * @param image 图片文件
     *
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        // 调用阿里云工具类，接收返回值，返回值为云服务器图片url
        String url = aliOSSUtils.upload(image);
        log.info("上传图片，url为{}",url);
        return Result.success(url);
    }
}
