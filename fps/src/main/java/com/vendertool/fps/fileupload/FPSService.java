package com.vendertool.fps.fileupload;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.vendertool.common.service.BaseVenderToolServiceImpl;
import com.vendertool.sharedtypes.core.FileInformation;
import com.vendertool.sharedtypes.rnr.FileUploadRequest;

@Path("/fps")
public class FPSService extends BaseVenderToolServiceImpl {

	@POST
	@Path("/upload")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response uploadFile(FileUploadRequest fileUploadRequest) {
		
		uploadFile2AWS(fileUploadRequest);

		/*// TODO file path.
		String uploadedFileLocation = "d://uploaded/"
				+ fileDetail.getFileName();// TODO Amazon
		// save it
		FPSHelper.getInstance().writeToFile(uploadedInputStream,
				uploadedFileLocation);
		String output = "File uploaded to : " + uploadedFileLocation;*/
		return Response.status(200).entity("").build();
	}
	
	private void uploadFile2AWS (FileUploadRequest fileRequest) {
        AmazonS3 s3 = new AmazonS3Client(new ClasspathPropertiesFileCredentialsProvider());
		Region usWest2 = Region.getRegion(Regions.US_WEST_2);
		s3.setRegion(usWest2);
		
		String bucketName = "uploadfiles-" + "username";
		
		try {
			//TODO find the bucket already exists then don't create it
			//if (s3.listObjects(bucketName) == null) {
			if (!isBucketExists(s3.listBuckets(), bucketName)) {
	            System.out.println("Creating bucket " + bucketName + "\n");
	            s3.createBucket(bucketName);
			}

            System.out.println("Uploading a new object to S3 from a file\n");
            List<FileInformation> files = fileRequest.getFiles();
            for (FileInformation file : files) {
                Long contentLength = Long.valueOf(file.getFileSize());

                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentLength(contentLength);
                InputStream fileIStream = new ByteArrayInputStream(file.getFileData());
            	s3.putObject(new PutObjectRequest(bucketName, file.getFileName(), fileIStream, metadata));
            }
			
		} catch (AmazonServiceException ase) {
	            System.out.println("Caught an AmazonServiceException, which means your request made it "
	                    + "to Amazon S3, but was rejected with an error response for some reason.");
	            System.out.println("Error Message:    " + ase.getMessage());
	            System.out.println("HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("Error Type:       " + ase.getErrorType());
	            System.out.println("Request ID:       " + ase.getRequestId());
	    } catch (AmazonClientException ace) {
	            System.out.println("Caught an AmazonClientException, which means the client encountered "
	                    + "a serious internal problem while trying to communicate with S3, "
	                    + "such as not being able to access the network.");
	            System.out.println("Error Message: " + ace.getMessage());
	    }

	}

	private boolean isBucketExists(List<Bucket> buckets, String bucketName) {
        for (Bucket bucket : buckets) {
            if (bucket != null && bucket.getName().equals(bucketName)) {
            	return true;
            }
        }
        return false;
	}
}