package com.reusehive.utils;

import com.reusehive.config.props.MinioConfigProp;
import com.reusehive.consts.MinioConst;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import io.minio.http.Method;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Slf4j
@Component
public class MinioUtils {
    @Resource
    private MinioConfigProp minioConfigProp;
    @Resource
    private MinioClient minioClient;

    /* upload方法拿的url是永久访问链接，前提是要开启bucket的永久开放权限 */


    public String UploadUserIcon(MultipartFile file, String user_id) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        PutObjectArgs objectArgs = PutObjectArgs.builder().bucket(MinioConst.BUCKET_USER_ICON_IMG).object(user_id)
                .stream(file.getInputStream(), file.getSize(), -1).contentType("image/png").build();
        minioClient.putObject(objectArgs);

        return minioConfigProp.getEndpoint() + "/" + MinioConst.BUCKET_USER_ICON_IMG + "/" + user_id;

    }

    public String UploadItemBackImg(MultipartFile file, String item_id) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        PutObjectArgs objectArgs = PutObjectArgs.builder().bucket("item-back-img").object(item_id)
                .stream(file.getInputStream(), file.getSize(), -1).contentType("image/png").build();
        minioClient.putObject(objectArgs);


        return minioConfigProp.getEndpoint() + "/" + MinioConst.BUCKET_ITEM_BACK_IMG + "/" + item_id;
    }


    public String UploadUserBackImg(MultipartFile file, String user_id) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        PutObjectArgs objectArgs = PutObjectArgs.builder().bucket("user-back-img").object(user_id)
                .stream(file.getInputStream(), file.getSize(), -1).contentType("image/png").build();
        minioClient.putObject(objectArgs);
        return minioConfigProp.getEndpoint() + "/" + MinioConst.BUCKET_USER_BACK_IMG + "/" + user_id;
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
