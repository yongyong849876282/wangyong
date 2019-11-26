package com.yyong.vod.service;

import com.aliyuncs.vod.model.v20170321.CreateUploadVideoResponse;
import com.aliyuncs.vod.model.v20170321.RefreshUploadVideoResponse;
import org.springframework.web.multipart.MultipartFile;

public interface VideoService {

    /**
     * 调用阿里云java sdk执行文件上传
     * @param file
     * @return 文件的videoId
     */
    String uploadVideo(MultipartFile file);

    void removeVideo(String videoId);

    CreateUploadVideoResponse getUploadAuthAndAddress(String title, String fileName);

    RefreshUploadVideoResponse refreshUploadAuthAndAddress(String videoId);
}
