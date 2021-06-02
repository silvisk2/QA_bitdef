package bitDefender;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class test2 {

    public String url = "https://central.bitdefender.com/";
    String driverPath = "C:\\Users\\Silviu\\Desktop\\Homework_Capraru\\chromedriver.exe";
    public WebDriver driver;

    //Launch browser
    @BeforeTest
    public void launchBrowser() {

        System.out.println("Launching Chrome Browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    // To cred logging
    @Test(priority = 1)
    public void toEmail() {
        driver.findElement(By.cssSelector(".btn.primary.solid")).click();
    }
    // Enter email address & correct password
    @Test(priority = 2)
    public void enterEmailPassword() throws InterruptedException {
        long start = System.currentTimeMillis();
        WebElement email = driver.findElement(By.cssSelector("#username"));
        email.click();
        email.sendKeys("test+13-15@mailinator.com");
        WebElement next = driver.findElement(By.cssSelector("#login-next"));
        next.click();
        Thread.sleep(1000);

        driver.findElement(By.id("password_input")).sendKeys("gJFjyfd$^%U7EDf");
        driver.findElement(By.id("password-sign-in")).click();
        long finish = System.currentTimeMillis();
        long Total_Time = (finish - start)/1000;
        System.out.println("Total page load time:" + Total_Time + "seconds");
        if ( Total_Time > 5)
            System.out.println("NOT OK");
        else {
            System.out.println("OK");
        }
    }
    //Continue Next Step after entering credentials
    @Test(priority = 3)
    public void continueTrial() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("btn_1597825507")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("ui-card:nth-of-type(1) > .align-items-start.card-header.p-1")).click();
        Thread.sleep(3000);
        // test faill after the kit is downloaded, next option is not available
        driver.findElement(By.cssSelector(".bordered.card.clickable-card.gray.ng-star-inserted.raised > .card-header")).click();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("C:\\Users\\Silviu\\Desktop\\Homework_Capraru\\ScreenShots\\c.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The screenshot is taken");
    }
}

