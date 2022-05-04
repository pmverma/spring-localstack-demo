package com.example.springlocalstackdemo;

import com.amazonaws.services.s3.model.S3Object;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringLocalstackDemoApplicationTests {
    private static final String bucketName = "mybucket";
    @Autowired
    private S3Service s3Service;
    @Test
    void shouldStoreAndRetrieveDataFromS3Bucket() {
        s3Service.createBucket(bucketName);
        s3Service.store(bucketName, "my-key-1", "my-value-1");
        S3Object s3Object = s3Service.getObject(bucketName, "my-key-1");
        assertThat(s3Object.getObjectContent()).hasSameContentAs(new ByteArrayInputStream("my-value-1".getBytes()));
    }

}
