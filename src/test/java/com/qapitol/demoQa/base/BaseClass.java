package com.qapitol.demoQa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {


    public WebDriver driver;
    @BeforeClass
    public void beforeTest() throws IOException {
        driver = new ChromeDriver();
        System.out.println("Before Test");
        //FileInputStream fis = new FileInputStream("./resources/config/commonData.properties");
        FileInputStream fis = new FileInputStream("C:\\Users\\Qapitol QA\\IdeaProjects\\MavenProject\\src\\main\\resources\\config\\commonData.properties");
        Properties properties = new Properties();
        properties.load(fis);
        driver.get(properties.getProperty("url"));
       // driver.get("https://demoqa.com/elements");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @AfterClass
    public void afterTest(){
        System.out.println("After Test");
       // driver.close();
    }

}
