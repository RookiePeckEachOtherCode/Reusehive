package com.reusehive.utils;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MinioUtils {
    private static final String endpoint="http://localhost:9000";
    private static final String accessKey="11451419198";
    private static final String secretKey="11451419198";
    private final MinioClient minioClient=MinioClient.builder().endpoint(endpoint)
            .credentials(accessKey,secretKey).build();
    public  String UploadUserIcon(MultipartFile file,String user_id){
        try {
            PutObjectArgs objectArgs=PutObjectArgs.builder().bucket("icon").object(user_id)
                    .stream(file.getInputStream(),file.getSize(),-1).contentType("image/png").build();
            minioClient.putObject(objectArgs);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "http://localhost:9000/icon/"+user_id;
    }
    public String UploadItemBackImg(MultipartFile file,String item_id){
        try {
            PutObjectArgs objectArgs=PutObjectArgs.builder().bucket("item").object(item_id)
                    .stream(file.getInputStream(),file.getSize(),-1).contentType("image/png").build();
            minioClient.putObject(objectArgs);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "http://localhost:9000/item/"+item_id;
    }

}
