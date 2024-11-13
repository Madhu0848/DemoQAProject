package com.qapitol.demoQa.pages;

import com.qapitol.demoQa.base.BaseClass;
import com.qapitol.demoQa.utility.ExtentReportUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Listeners(ExtentReportUtility.class)
public class Widgets extends BaseClass {

    @Test
    public void Widget() throws InterruptedException {

        WebElement formText = driver.findElement(By.xpath("//div[text()='Widgets']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("arguments[0].click();", formText);

        driver.findElement(By.xpath("//span[text()='Accordian']")).click();

        WebElement firstTest = driver.findElement(By.xpath("//div[text()='What is Lorem Ipsum?']"));
        js.executeScript("arguments[0].click();", firstTest);
        firstTest.click();

        WebElement secondText = driver.findElement(By.xpath("//div[text()='Where does it come from?']"));
        js.executeScript("arguments[0].click();", secondText);

        WebElement thirdText = driver.findElement(By.xpath("//div[text()='Why do we use it?']"));
        js.executeScript("arguments[0].click();", thirdText);

        WebElement information = driver.findElement(By.xpath("//p[contains(text(), 'It is a long established fact that a reader will be distracted by the readable content of a page')]"));
        System.out.println(information.getText());

    }

    /* Auto Complete */
    @Test
    public void checkAutoCompleteTest() {
        WebElement autoComplete = driver.findElement(By.xpath("//span[text()='Auto Complete']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", autoComplete);
        js.executeScript("arguments[0].click();", autoComplete);

        WebElement multipleColorField = driver.findElement(By.xpath("//input[@id='autoCompleteMultipleInput']"));
        multipleColorField.sendKeys("r");
        List<WebElement> allSuggestions = driver.findElements(By.xpath("//div[@class='auto-complete__option css-yt9ioa-option']"));

        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        }

        WebElement singleColorField = driver.findElement(By.xpath("//input[@id='autoCompleteSingleInput']"));
        singleColorField.sendKeys("p");

        WebElement singleSuggestion = driver.findElement(By.xpath("//div[@class='auto-complete__menu-list css-11unzgr']"));
        System.out.println(singleSuggestion.getText());

    }

    /* Date Picker*/
    @Test
    public void DatePickerTest() throws InterruptedException {
        WebElement datePicker = driver.findElement(By.xpath("//span[text()='Date Picker']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", datePicker);
        js.executeScript("arguments[0].click();", datePicker);

        js.executeScript("window.scrollBy(0,250)");

        WebElement selectDtate = driver.findElement(By.id("datePickerMonthYearInput"));
        selectDtate.click();
        WebElement selectMonth = driver.findElement(By.cssSelector(".react-datepicker__month-select"));

        Select select = new Select(selectMonth);
        select.selectByVisibleText("October");

        WebElement selectYear = driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
        Select select1 = new Select(selectYear);
        select1.selectByIndex(95);

        driver.findElement(By.xpath("//div[text()='12']")).click();

        WebElement selectTime = driver.findElement(By.xpath("//input[@id='dateAndTimePickerInput']"));
        selectTime.click();

        driver.findElement(By.xpath("//li[text()='16:15']")).click();

    }

    /*Slider */ //not working this
    @Test
    public void SliderTest() throws InterruptedException {
        WebElement Slider = driver.findElement(By.xpath("//span[text()='Slider']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", Slider);
        js.executeScript("window.scrollBy(0,300)");

        WebElement slider1 = driver.findElement(By.xpath("//div[text()='25' and @class='range-slider__tooltip__label']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(slider1).build().perform();
        actions.moveToElement(slider1, 56, 0).build().perform();
        // actions.moveByOffset(45,0).build().perform();
        // actions.moveToLocation(90,0).build().perform();

    }
        /*Progress Bar */ //not working this
        @Test
        public void ProgressBar() throws InterruptedException {
            WebElement ProgressBar = driver.findElement(By.xpath("//span[text()='Progress Bar']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].click();", ProgressBar);
            js.executeScript("window.scrollBy(0,300)");

            driver.findElement(By.xpath("//button[text()='Start']")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//button[text()='Reset']")).click();














    }
}