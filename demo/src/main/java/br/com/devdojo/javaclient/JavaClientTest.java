package br.com.devdojo.javaclient;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class JavaClientTest {
    public static void main(String[] args) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url= new URL("http://localhost:8080/protected/students/1");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            new BufferedReader( new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonSB= new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                jsonSB.append(line);
            }
            System.out.println(jsonSB.toString());
        }catch (Exception e) {
            IOUtils.closeQuietly(reader);
            if(connection != null){
                connection.disconnect();
            }
        }
    }
}
