package com.kryptonite.aws;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.process.Pipe;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;


public class AWSHelper {
	private static final String UPLOAD_REQ_BUCKET = "nutped2/";
	private static AWSHelper s_self = null;
	private static AmazonS3 s3client = null;
	AWSHelper() {
	}

	public synchronized static AWSHelper getInstance() {
		if (s_self == null) {
			s_self = new AWSHelper();
			String accessKey = "AKIAJYGPZVMSIIMV7E7Q";
			String secretKey = "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";
			AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
			s3client = new AmazonS3Client(credentials);
		}
		return s_self;
	}


	public boolean doesBucketExists(String bucketName) {
		return s3client.doesBucketExist(bucketName);
	}


	public String uploadImage2AWS (InputStream image) {
			String key = null;
			try {
				 key = "nutped_"+ new Date().getTime()+ ".JPG";	 			
				
				PutObjectRequest putObjectRequest = new PutObjectRequest(UPLOAD_REQ_BUCKET, key, image,new ObjectMetadata());
				PutObjectResult result = s3client.putObject(putObjectRequest); 
				} catch (AmazonServiceException ase) {
				System.out.println("Caught an AmazonServiceException, which " +
						"means your request made it " +
						"to Amazon S3, but was rejected with an error response" +
						" for some reason.");
				System.out.println("Error Message:    " + ase.getMessage());
				System.out.println("HTTP Status Code: " + ase.getStatusCode());
				System.out.println("AWS Error Code:   " + ase.getErrorCode());
				System.out.println("Error Type:       " + ase.getErrorType());
				System.out.println("Request ID:       " + ase.getRequestId());
			} catch (AmazonClientException ace) {
				System.out.println("Caught an AmazonClientException, which " +
						"means the client encountered " +
						"an internal error while trying to " +
						"communicate with S3, " +
						"such as not being able to access the network.");
				System.out.println("Error Message: " + ace.getMessage());
			}
		
		return key;
	}

	public InputStream downloadFileFromwAWS(String key) {
		return s3client.getObject(new GetObjectRequest(UPLOAD_REQ_BUCKET, key)).getObjectContent();
	}


	public void downloadFileToLocal( String key, String localFile) {
		S3Object object = s3client.getObject(new GetObjectRequest(UPLOAD_REQ_BUCKET, key));
		try {
			File lFile = new File(localFile);
			InputStream reader = new BufferedInputStream(object.getObjectContent());	   
			OutputStream writer = new BufferedOutputStream(new FileOutputStream(lFile));
			int read = -1;
			while ((read = reader.read()) != -1) {
				writer.write(read);
			}
			writer.flush();
			writer.close();
			reader.close(); 
		} catch (FileNotFoundException fnfe){
		} catch (IOException ie) {
		}
	}
	
	public boolean deleteFile( String key) {
		try {
		s3client.deleteObject(new DeleteObjectRequest(UPLOAD_REQ_BUCKET, key));
		return true;
		} catch (Exception e){
			return false;	
		}

	}
}
