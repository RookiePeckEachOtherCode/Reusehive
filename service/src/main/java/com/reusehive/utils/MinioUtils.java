package com.reusehive.utils;

import com.reusehive.config.props.MinioConfigProp;
import com.reusehive.consts.MinioConst;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.errors.*;
import io.minio.http.Method;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Slf4j
@Component
public class MinioUtils {
    @Resource
    private MinioConfigProp minioConfigProp;
    @Resource
    private MinioClient minioClient;

    /* upload方法拿的url是永久访问链接，前提是要开启bucket的永久开放权限 */


    public String UploadUserIcon(MultipartFile file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return UploadImg(file, MinioConst.BUCKET_USER_ICON_IMG);
    }

    public String UploadItemBackImg(MultipartFile file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return UploadImg(file, MinioConst.BUCKET_ITEM_BACK_IMG);
    }


    public String UploadUserBackImg(MultipartFile file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return UploadImg(file, MinioConst.BUCKET_USER_BACK_IMG);
    }

    public void DeleteUserIcon(String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        DeleteImg(fileName, MinioConst.BUCKET_USER_ICON_IMG);
    }

    public void DeleteUserBackImg(String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        DeleteImg(fileName, MinioConst.BUCKET_USER_BACK_IMG);
    }

    private String UploadImg(MultipartFile file, String bucket) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String fileName = file.getOriginalFilename();
        assert fileName != null;

        String fileCode = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf('.'));

        PutObjectArgs objectArgs = PutObjectArgs.builder().bucket(bucket).object(fileCode)
                .stream(file.getInputStream(), file.getSize(), -1).contentType("image/png").contentType("image/jpeg").build();
        minioClient.putObject(objectArgs);


        return minioConfigProp.getImgHost() + "/" + bucket + "/" + fileCode;
    }

    private void DeleteImg(String fileName, String bucket) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        var args = RemoveObjectArgs.builder().bucket(bucket).object(fileName).build();
        minioClient.removeObject(args);
    }



    /* preview方法拿的url是临时访问链接 */

    public String PreviewImg(String fileName, String bucketName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        GetPresignedObjectUrlArgs build = new GetPresignedObjectUrlArgs.Builder()
                .bucket(bucketName)
                .object(fileName)
                .method(Method.GET)
                .build();

        return minioClient.getPresignedObjectUrl(build);
    }

}
