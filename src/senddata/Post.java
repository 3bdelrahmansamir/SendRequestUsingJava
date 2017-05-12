/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senddata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Abdelrahman Samir
 */
public class Post {

    public static void main(String[] args) throws MalformedURLException, IOException {

        URL urlconnection = new URL("http://192.168.1.13:8084/Amr/Amr");
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlconnection.openConnection();
//        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        httpURLConnection.setRequestProperty("Content-Type","application/json"); when i send to json services
        httpURLConnection.setRequestProperty("charset", "utf-8");
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);

        DataOutputStream dos = new DataOutputStream(httpURLConnection.getOutputStream());
        dos.writeBytes("name=Ahmad&");
        dos.writeBytes("pass=12345");
        dos.flush();
        dos.close();

//        another way


//        OutputStreamWriter osw = new OutputStreamWriter(httpURLConnection.getOutputStream());
//        osw.write("name=Ahmad&");
//        osw.write("pass=12345");
//        osw.flush();
//        osw.close();


        
//        another way


//        OutputStreamWriter osw = new OutputStreamWriter(httpURLConnection.getOutputStream());
//        BufferedWriter bufferedWriter = new BufferedWriter(osw);
//        bufferedWriter.write("name=Ahmad&");
//        bufferedWriter.write("pass=12345");
//        bufferedWriter.flush();
//        bufferedWriter.close();

        InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
        BufferedReader resultReader = new BufferedReader(inputStreamReader);

        StringBuilder txtBuilder = new StringBuilder();
        String line;

        while ((line = resultReader.readLine()) != null) {
            txtBuilder.append(line);
        }

        String result = txtBuilder.toString();
        System.out.println(result);

    }

}
