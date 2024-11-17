package com.qapitol.demoQa.pages;

import com.qapitol.demoQa.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BookStore extends BaseClass {

    @Test
    public void bookStore() {
       WebElement bookStrore = driver.findElement(By.xpath("//div[text()='Book Store Application']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", bookStrore);
        bookStrore.click();

      WebElement Login = driver.findElement(By.xpath("//span[text()='Login']"));
      js.executeScript("arguments[0].scrollIntoView(true);", Login);
      js.executeScript("arguments[0].click();", Login);

        driver.findElement(By.id("userName")).click();
        driver.findElement(By.id("password")).click();
       WebElement Login1 =driver.findElement(By.xpath("//button[text()='Login']"));
       js.executeScript("arguments[0].scrollIntoView(true);", Login1);
       js.executeScript("arguments[0].click();", Login1);

         }
         @Test
         public void bookStore2() {
         WebElement bookStore2=driver.findElement(By.xpath("//span[text()='Book Store']"));
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView(true);", bookStore2);
         js.executeScript("arguments[0].click();", bookStore2);
         driver.findElement(By.id("searchBox")).sendKeys("Book Store");
         driver.findElement(By.id("login")).click();

         }
         @Test
         public void profile() {
        WebElement profileText=driver.findElement(By.xpath("//span[text()='Profile']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", profileText);
        js.executeScript("arguments[0].click();", profileText);
         }
         @Test
         public void bookStoreAPI() {
        WebElement bookStoreAPI=driver.findElement(By.xpath("//span[text()='Book Store API']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", bookStoreAPI);
        js.executeScript("arguments[0].click();", bookStoreAPI);

         }

}
