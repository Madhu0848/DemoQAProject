package com.qapitol.demoQa.pages;

import com.beust.ah.A;
import com.qapitol.demoQa.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import org.testng.annotations.Test;

import java.time.Duration;

public class Forms extends BaseClass {

   @Test
    public void forms() throws InterruptedException {

      WebElement formText= driver.findElement(By.xpath("//div[text()='Forms']"));
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,1000)");
      js.executeScript("arguments[0].click();", formText);

      driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
      driver.findElement(By.id("firstName")).sendKeys("Neha");
      driver.findElement(By.id("lastName")).sendKeys("Khan");
      driver.findElement(By.id("userEmail")).sendKeys("neha@gmail.com");

      WebElement gender =driver.findElement(By.xpath("//input[@id='gender-radio-2']"));
      js.executeScript("arguments[0].click();", gender);

      driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("00000000000");
     WebElement birthDay = driver.findElement(By.id("dateOfBirthInput"));
     js.executeScript("arguments[0].click();", birthDay);

    WebElement selectMonth= driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
    Select select = new Select(selectMonth);
    select.selectByValue("10");

    WebElement selectYear =driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
    Select select1=new Select(selectYear);
    select1.selectByIndex(1);
    driver.findElement(By.xpath("//div[text()='11']")).click();

    driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys("Register_Page");
    WebElement habbies= driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
    js.executeScript("arguments[0].click();", habbies);

  WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
 // js.executeScript("arguments[0].click();", uploadPicture);
  uploadPicture.sendKeys("C:\\Users\\Qapitol QA\\Downloads\\WhatsApp Image 2024-11-07 at 16.41.03.jpeg");
  driver.findElement(By.xpath("//textarea[@placeholder=\"Current Address\"]")).sendKeys("Bangalore");
  Thread.sleep(4000);

  js.executeScript("window.scrollBy(0,1000)");
  WebElement state=driver.findElement(By.xpath("//div[@aria-hidden='true' and @class=' css-tlfecz-indicatorContainer']"));

  Actions actions = new Actions(driver);
  actions.moveToElement(state).perform();
  actions.clickAndHold().perform();


  WebElement state1 =driver.findElement(By.xpath("//div[text()='Haryana']"));
  state1.click();

  WebElement  city1 = driver.findElement(By.xpath("//div[text()='Select City' ]/ancestor::div[@class=' css-yk16xz-control']/descendant::div[@aria-hidden='true']"));
  actions.moveToElement(city1).perform();
  actions.clickAndHold().perform();

  WebElement city = driver.findElement(By.xpath("//div[text()='Karnal']"));
  city.click();
  WebElement sumbitButton= driver.findElement(By.xpath("//button[@id='submit']"));
  js.executeScript("arguments[0].click();", sumbitButton);

   }

}
