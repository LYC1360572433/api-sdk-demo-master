package com.lyc.apisdkdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class SdkDemoApplicationTests {

    @Test
    public void shiFenMiaoToSeconds() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        System.out.println(date);
    }
}

