package com.qapitol.demoQa.pages;

import com.qapitol.demoQa.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;

public class Alert_Frame_Window extends BaseClass {

    @Test
    public void checkBrowserWindow() {
        System.out.println("Handle Alert");
        WebElement frame = driver.findElement(By.xpath("//div[text()='Alerts, Frame & Windows']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", frame);
        js.executeScript("arguments[0].click()", frame);

        /*Browser windows login*/
        WebElement browserWindow = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
        js.executeScript("arguments[0].scrollIntoView(true);", browserWindow);
        js.executeScript("arguments[0].click()", browserWindow);

        WebElement newTab = driver.findElement(By.xpath("//button[text()='New Tab']"));
        js.executeScript("arguments[0].click()", newTab);
        driver.navigate().back();

        String mainTab = driver.getWindowHandle();

        Set<String> allTabs = driver.getWindowHandles();

        // Switch to the new tab
        for (String tab : allTabs) {
            if (!tab.equals(mainTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
// Switch back to the main tab
        driver.switchTo().window(mainTab);

        js.executeScript("arguments[0].scrollIntoView(true);", browserWindow);
        js.executeScript("arguments[0].click()", browserWindow);

        WebElement NewwindowMessge = driver.findElement(By.xpath("//button[text()='New Window Message']"));
        js.executeScript("arguments[0].click()", NewwindowMessge);

        String mainTab1 = driver.getWindowHandle();

        Set<String> allTabs1 = driver.getWindowHandles();

        // Switch to the new tab
        for (String tab : allTabs1) {
            if (!tab.equals(mainTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
// Switch back to the main tab
        driver.switchTo().window(mainTab1);


    }

    /*Alert operation */
    @Test
    public void checkAlertWindow() throws InterruptedException {
        System.out.println("Handle Alert");
        WebElement alert =driver.findElement(By.xpath("//span[text()='Alerts']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", alert);
        js.executeScript("arguments[0].click()", alert);

       WebElement seeAlert =driver.findElement(By.xpath("//button[text()='Click me' and @id='alertButton']"));
       js.executeScript("arguments[0].click()", seeAlert);
        // Switch to the alert
          Alert alert1 = driver.switchTo().alert();
         alert1.accept();
         Thread.sleep(10);
        WebElement seeAlert1 =driver.findElement(By.xpath("//button[text()='Click me' and @id='alertButton']"));
        js.executeScript("arguments[0].click()", seeAlert1);
        // Switch to the alert
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();

        WebElement seeAlert2 =driver.findElement(By.xpath("//button[text()='Click me' and @id='confirmButton']"));
        js.executeScript("arguments[0].click()", seeAlert2);
        // Switch to the alert
        Alert alert3 = driver.switchTo().alert();
        alert3.dismiss();

        WebElement seeAlert3 =driver.findElement(By.xpath("//button[text()='Click me' and @id='promtButton']"));
        js.executeScript("arguments[0].click()", seeAlert3);
        // Switch to the alert
        Alert alert4 = driver.switchTo().alert();
        alert4.sendKeys("hello");
        alert4.accept();

    }
    /* Handling frame*/
    @Test
    public void handleFrame() throws InterruptedException {
        System.out.println("Handle frame");

        WebElement alert =driver.findElement(By.xpath("//span[text()='Frames']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", alert);
        js.executeScript("arguments[0].click()", alert);
        //WebElement frame = driver.findElement(By.xpath("//iframe[@id='frameID']"));
          WebElement frame= driver.findElement(By.xpath("//h1[text()='This is a sample page' and @id='sampleHeading']"));
        driver.switchTo().frame(frame);
        driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
    }
    /* Handling frame*/ // i hv to do this
    @Test
    public void handleNestedFrame() throws InterruptedException {
        System.out.println("Handle nested frame");

        WebElement nestedFrame = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", nestedFrame);
        js.executeScript("arguments[0].click()", nestedFrame);


    }
    /*Handle Modal dialogs*/
    @Test
    public void modelDialogs() throws InterruptedException {
        System.out.println("Handle nested frame");

        WebElement modelDialogs = driver.findElement(By.xpath("//span[text()='Modal Dialogs']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", modelDialogs);
        js.executeScript("arguments[0].click()", modelDialogs);

        WebElement smallmodel=driver.findElement(By.xpath("//button[text()='Small modal']"));
        js.executeScript("arguments[0].click()", smallmodel);
        driver.findElement(By.xpath("//button[text()='Close']")).click();

       WebElement largeModel=driver.findElement(By.xpath("//button[text()='Large modal']"));
       js.executeScript("arguments[0].click()", largeModel);
        driver.findElement(By.xpath("//button[text()='Close']")).click();


    }
}
