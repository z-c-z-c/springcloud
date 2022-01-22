package com.example.springbootdemo1;

import com.example.wafdemo1.dao.QrcodeUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;

/**
 * @author zc
 */
@SpringBootApplication
public class SpringbootDemo1Application {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringbootDemo1Application.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
