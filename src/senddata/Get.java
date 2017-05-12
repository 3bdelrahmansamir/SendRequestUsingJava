/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senddata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Abdelrahman Samir
 */
public class Get {

    public static void main(String[] args) throws MalformedURLException, IOException {

        URL urlconnection = new URL("http://192.168.1.7:8084/Amr/Amr?name=peter&pass=12345");
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlconnection.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);

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