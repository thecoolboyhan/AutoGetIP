package com.example.autogetip.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoService {
    public List<String> getIP() throws InterruptedException {
        List<String> res=new ArrayList<>();
        EdgeDriver driver = new EdgeDriver();
        driver.get("http://localhost:9200/#/status/online");
        try {
            String title = driver.getTitle();
            System.out.println(title);
            driver.findElement(By.xpath("//*[@placeholder=\"Email\"]")).sendKeys("hanyongfa2013@163.com");
            driver.findElement(By.xpath("//*[@type=\"button\"]")).click();
            Thread.sleep(3000);
//            WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/section/div/div/div[3]/table/tbody/tr[1]/td[3]/div"));
            String path="/html/body/div/div/div[2]/section/div/div/div[3]/table/tbody/tr";
            for (WebElement demoElement : driver.findElements(By.xpath(path))) {
                StringBuilder sb=new StringBuilder();
                sb.append(demoElement.findElement(By.xpath("./td[2]/div")).getText()).append(" : ");
                sb.append(demoElement.findElement(By.xpath("./td[3]/div")).getText());
                res.add(sb.toString());
            }
            for (String str : res) {
                System.out.println(str);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw  e;
        }finally {
            driver.quit();
        }
        return res;
    }
}
