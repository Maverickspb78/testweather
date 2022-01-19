package com.example.testweather.Reader;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Component
public class ReaderWeb {

    public String readWeb() {

        try {
            URL url = new URL("https://yandex.ru/");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String temp;
            while ((temp = in.readLine()) != null) {
                if (temp.contains("weather__temp")){
                    String[] data = temp.split("<div class='weather__temp'>");
                     String[] temper = data[1].split("<");
                    System.out.println(temper[0]);
                    return temper[0];
            }
            }
            in.close();
        } catch (IOException e){
            System.out.println(e);
        }
        return "error";
    }
    }
