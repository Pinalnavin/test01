package org.example;

import com.sun.corba.se.spi.monitoring.StringMonitoredAttributeBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sun.font.EAttribute;

import javax.xml.stream.events.Attribute;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Test1 {
    protected static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");

        //open chrome browser:
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        // click on register button
        //  driver.findElement(By.className("ico-register")).click();
        clickOnElement(By.className("ico-register"));

        //enter firstname
        // driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Automation");
        typeText(By.xpath("//input[@name='FirstName']"), "Autoamation");
        //enter lastname
        // driver.findElement(By.id("Lastname")).sendKeys("LastnameTest");
        typeText(By.id("LastName"), "LastNameTest");
        //enter email 
        // driver.findElement(By.id("Email")).sendKeys("xyz22@yahoo.com");
        typeText(By.id("Email"), "xyz22" + randomDate() + "@yahoo.com");

        //enter password

        // driver.findElement(By.id("Password")).sendKeys("12345@abc");
        typeText(By.id("Password"), "12345@abc");

        //enter confirm password

        //  driver.findElement(By.id("ConfirmPassword")).sendKeys("12345@abc");
        typeText(By.id("ConfirmPassword"), "12345@abc");


        //enter register
        //  driver.findElement(By.name("register-button")).click();
        clickOnElement(By.name("register-button"));
        //enter password
//
//        //select male or female
//        //select gender
//       driver.findElement(By.xpath("//input[@id=\"gender-female\")]")).click();
        //enter first name
//        driver.findElement(By.id("LastName")).sendKeys("Joshi");



        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.className("result")).getText();
        Assert.assertEquals(expectedMessage,actualMessage,"Your registration is NOT successful");

    }



    public static void clickOnElement(By by) {

        driver.findElement(by).click();

    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    public static String randomDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        return formatter.format(date);
    }

    public static void waitForClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static String getTextFormElement(By by) {
        return driver.findElement(by).getText();

    }

    public static void driverWaitSelectElement(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    public static void driverWait(int time, By by, String urlName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(urlName));
    }

    public static void driveWaitUrlContains(int time, By by, String urlName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(urlName));
    }

    public static void driverWaitUntilPresentOfElement(By by, int time) {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait2.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static void DriverWait(int time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    public static void driverWaitAttributeContains(int time, String Attribute, String value, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeContains(by, Attribute, value));
    }

    public static void driverWaitPresenceOfAllElementsLocatedBy(int time, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static void driverWait(int time, By by, String Attribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBe(by, Attribute, value));
    }

}






