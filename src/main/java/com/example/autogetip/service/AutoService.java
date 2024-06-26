package com.example.autogetip.service;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

@Service
public class AutoService {
    public void getIP(){
//        System.setProperty("webdriver.chrome.driver","browserDriver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:9200/#/status/online");
        String title = driver.getTitle();
        System.out.println(title);
    }
}
