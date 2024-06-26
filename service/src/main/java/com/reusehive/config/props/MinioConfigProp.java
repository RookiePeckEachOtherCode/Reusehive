package com.reusehive.config.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "minio")
@Component
public class MinioConfigProp {
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String imgHost;
}

