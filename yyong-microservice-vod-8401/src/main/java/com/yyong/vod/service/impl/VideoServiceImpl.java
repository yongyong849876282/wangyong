package com.yyong.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.*;
import com.yyong.common.constants.ResultCodeEnum;
import com.yyong.common.exception.MyException;
import com.yyong.vod.service.VideoService;
import com.yyong.vod.util.AliyunVodSDKUtils;
import com.yyong.vod.util.ConstantPropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@Slf4j
public class VideoServiceImpl implements VideoService {

    @Override
    public String uploadVideo(MultipartFile file) {

        String videoId = null;
        try{
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            String title = fileName.substring(0, fileName.lastIndexOf("."));

            //创建请求对象
            UploadStreamRequest request = new UploadStreamRequest(
                    ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET,
                    title,
                    fileName,
                    inputStream);

            //创建文件上传器
            UploadVideoImpl uploader = new UploadVideoImpl();

            //执行文件上传，得到响应对象
            UploadStreamResponse response = uploader.uploadStream(request);

            //得到视频的videoId
            videoId = response.getVideoId();

        }catch (IOException e){
            throw new MyException(ResultCodeEnum.VIDEO_UPLOAD_TOMCAT_ERROR);
        }

        return videoId;
    }

    @Override
    public void removeVideo(String videoId) {

        DefaultAcsClient client = null;
        try {
            client = AliyunVodSDKUtils.initVodClient(
                    ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);

            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(videoId);

            DeleteVideoResponse response = client.getAcsResponse(request);

        } catch (ClientException e) {
            throw new MyException(ResultCodeEnum.VIDEO_DELETE_ALIYUN_ERROR);
        }

    }

    /**
     * 获取上传凭证和上传地址
     * @param title
     * @param fileName
     * @return
     */
    @Override
    public CreateUploadVideoResponse getUploadAuthAndAddress(String title, String fileName) {

        try {
            //创建请求对象
            DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(
                    ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET
            );

            //为请求对象组织私有参数
            CreateUploadVideoRequest request = new CreateUploadVideoRequest();
            request.setTitle(title);
            request.setFileName(fileName);

            //发送请求，获取响应对象
            CreateUploadVideoResponse response = client.getAcsResponse(request);

            //从响应对象中获取返回值
            return response;

        }catch (ClientException e){
            throw  new MyException(ResultCodeEnum.VIDEO_UPLOAD_ALIYUN_ERROR);
        }

    }

    @Override
    public RefreshUploadVideoResponse refreshUploadAuthAndAddress(String videoId) {

        try {
            //创建请求对象
            DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(
                    ConstantPropertiesUtil.ACCESS_KEY_ID, ConstantPropertiesUtil.ACCESS_KEY_SECRET
            );

            //为请求对象组织私有参数
            RefreshUploadVideoRequest request = new RefreshUploadVideoRequest();
            request.setVideoId(videoId);

            //发送请求，获取响应对象
            RefreshUploadVideoResponse response = client.getAcsResponse(request);

            //从响应对象中获取返回值
            return response;

        }catch (ClientException e){
            throw  new MyException(ResultCodeEnum.VIDEO_UPLOAD_TOMCAT_ERROR);
        }
    }

/*    @Override
    public String testGetVideoPlayAuth(String videoId) throws ClientException {
        //初始化客户端、请求对象和相应对象
        DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(ConstantPropertiesUtil.ACCESS_KEY_ID,
                ConstantPropertiesUtil.ACCESS_KEY_SECRET);
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();

        //设置请求参数
        request.setVideoId(videoId);
        //获取请求响应
        response = client.getAcsResponse(request);

        //输出请求结果
        //播放凭证
        //System.out.print("PlayAuth = " + response.getPlayAuth() + "\n");

        return response.getPlayAuth();
    }*/
}
