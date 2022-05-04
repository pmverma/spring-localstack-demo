package com.example.springlocalstackdemo;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;

@Service
public class S3Service {
    private final AmazonS3 amazonS3;

    public S3Service(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    public Bucket createBucket(String bucketName) {
        return amazonS3.createBucket(bucketName);
    }

    public S3Object getObject(String bucketName, String key) {
        return amazonS3.getObject(bucketName, key);
    }

    public PutObjectResult store(String bucketName, String key, String value) {
        return amazonS3.putObject(bucketName, key, value);
    }
}