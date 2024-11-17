package com.qapitol.demoQa.pages;

import ObjectRepository.InteractionsPage;
import com.qapitol.demoQa.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Interactions extends BaseClass {

    @Test
    public void InteractionsTest() throws InterruptedException {

        WebElement SelectMenu = driver.findElement(By.xpath("//div[text()='Interactions']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        js.executeScript("arguments[0].click();", SelectMenu);

       WebElement Sortable = driver.findElement(By.xpath("//span[text()='Sortable']"));
       js.executeScript("arguments[0].click();", Sortable);

      WebElement grid =driver.findElement(By.xpath("//a[text()='Grid']"));
      js.executeScript("arguments[0].click();", grid);
     // driver.findElement(By.xpath("//div[text()='Two']")).click();

    }
    @Test
    public void Selectable() throws InterruptedException {
     WebElement Selectable =  driver.findElement(By.xpath("//span[text()='Selectable']"));
     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0,300)");
     js.executeScript("arguments[0].click();", Selectable);
     driver.findElement(By.xpath("//li[text()='Cras justo odio']")).click();
    // driver.findElement(By.xpath("//li[text()='Dapibus ac facilisis in']")).click();
     driver.findElement(By.xpath("//li[text()='Morbi leo risus']")).click();


    }
    @Test
    public void Resizable() throws InterruptedException {
      WebElement Resizable = driver.findElement(By.xpath("//span[text()='Resizable']"));
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,300)");
      js.executeScript("arguments[0].click();", Resizable);

     WebElement resize_loc= driver.findElement(By.xpath("//div[@id='resizable']"));
     System.out.println(resize_loc.getSize().getHeight());
     Actions action = new Actions(driver);
     action.clickAndHold(resize_loc).moveByOffset(100,100).release().build().perform();
     Thread.sleep(2000);
        WebElement resize_loc1= driver.findElement(By.xpath("//div[@id='resizable']"));

        System.out.println(resize_loc1.getSize().getHeight());

    }
 @Test
    public void Droppable() throws InterruptedException {

     WebElement Droppable = driver.findElement(By.xpath("//span[text()='Droppable']"));
     JavascriptExecutor js = (JavascriptExecutor) driver;

     js.executeScript("arguments[0].click();", Droppable);
     Thread.sleep(2000);
     js.executeScript("window.scrollBy(0,2000)");
     WebElement dragme =  driver.findElement(By.id("draggable"));
    WebElement dropMe = driver.findElement(By.id("droppable"));
   // Thread.sleep(2000);

     Actions action = new Actions(driver);
      action.dragAndDrop(dragme, dropMe).perform();
     System.out.println(dropMe.getText());


 }





    @Test
    public void Dragabble() throws InterruptedException {

        WebElement Dragabble = driver.findElement(By.xpath("//span[text()='Dragabble']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        WebElement dragText= driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement dropText= driver.findElement(By.xpath("//a[text()='Container Restricted']"));
        Actions a=new Actions(driver);
        a.dragAndDrop(dragText,dropText).perform();

    }


}