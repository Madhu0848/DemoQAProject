package com.qapitol.demoQa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {


    public WebDriver driver;

   // @Parameters("BROWSER")
    @BeforeClass
    public void beforeTest() throws IOException {
       // String BROWSER = browser;
        // Load properties file
        FileInputStream fis = new FileInputStream("C:\\Users\\Qapitol QA\\IdeaProjects\\MavenProject\\src\\main\\resources\\config\\commonData.properties");
        Properties properties = new Properties();
        properties.load(fis);
       String BROWSER = properties.getProperty("browser");


        if(BROWSER.equals("chrome")) {
            driver = new ChromeDriver();
        }else if(BROWSER.equals("firefox")) {
            driver = new FirefoxDriver();
        }else if(BROWSER.equals("edge")) {
            driver = new EdgeDriver();
        }else {
            driver = new ChromeDriver();
        }


        // Open the specified URL and maximize the window
        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        //driver.manage().window().minimize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Before Test");

    }
    @AfterClass
    public void afterTest(){
        System.out.println("After Test");
        //driver.close();
    }

}
