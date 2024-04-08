package com.reusehive.config;

import com.reusehive.config.props.MinioConfigProp;
import io.minio.MinioClient;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfiguration {
    @Resource
    private MinioConfigProp minioConfigProp;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(minioConfigProp.getEndpoint())
                .credentials(minioConfigProp.getAccessKey(), minioConfigProp.getSecretKey()).build();
    }
}
