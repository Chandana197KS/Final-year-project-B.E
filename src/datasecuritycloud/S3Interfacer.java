package datasecuritycloud;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.UUID;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

/**
 *
 * @author sony
 */
public class S3Interfacer {

    AmazonS3 s3;
    //String key = "MyObjectKey";

    S3Interfacer() {
        try {
            s3 = new AmazonS3Client(new PropertiesCredentials(
                    S3Interfacer.class.getResourceAsStream("AwsCredentials.properties")));

            Main.instance.writetolog("Established connection with Amazon s3 client");

        } catch (Exception e) {
             Main.instance.writetolog("Failed creating connection to amazon s3 client");

            e.printStackTrace();
        }





    }

    void uploadFileToCloud(String filename, String key) {

File f=new File(key);
        

        s3.putObject(new PutObjectRequest("datasecuritycloud", f.getName(), new File(filename)));

        Main.instance.writetolog("Uploaded the file: " + filename + " to cloud in bucket datasecuritycloud");



    }

    void downloadFileFromCloud(String filename, String key) {
        System.out.println("Downloading an object:" + filename + "k=" + key);

        S3Object object = s3.getObject(new GetObjectRequest("datasecuritycloud", key));
        System.out.println("FilePath:" + filename);
        System.out.println("Content-Type: " + object.getObjectMetadata().getContentType());
        
        try {
            //filename+=key;
            
            displayTextInputStream(object.getObjectContent(), filename);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void displayTextInputStream(InputStream input, String file) throws IOException {

        System.out.println("File Name:" + file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        FileOutputStream outputStream =
                new FileOutputStream(new File(file));

        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = input.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }

        outputStream.close();
        
        System.out.println("Done!");
        while (true) {
        String line = reader.readLine();
        if (line == null) break;
        
        System.out.println("    " + line);
        
        //FileAppender.AppendtoFile(file, line);
        }
        
        
        System.out.println();
    }
}
