package com.jzweb.httputils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JzwebHttputilsApplicationTests {

    @Test
    void contextLoads() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello lambda");
            }
        }).start();

        new Thread(()->System.out.println("Hello lambda")).start();

        new Thread(()->{System.out.println("Hello lambda");}).start();

    }

}
