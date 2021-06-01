package bitDefender;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class test3 {

    public String url = "https://central.bitdefender.com/";
    String driverPath = "C:\\Users\\Silviu\\Desktop\\Homework_Capraru\\chromedriver.exe";
    public WebDriver driver;

    @BeforeTest
    public void launchBrowser() {

        System.out.println("Launching Chrome Browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void emailLogin() {

        driver.findElement(By.cssSelector(".btn.primary.solid")).click();
    }

    @Test(priority = 2)
    public void passwordEmail() throws InterruptedException {
        long start = System.currentTimeMillis();
        WebElement email = driver.findElement(By.cssSelector("#username"));
        email.click();
        email.sendKeys("test+13-15@mailinator.com");
        WebElement next = driver.findElement(By.cssSelector("#login-next"));
        next.click();
        Thread.sleep(1000);

        driver.findElement(By.id("password_input")).sendKeys("gJFjyfd$^%U7EDf");
        driver.findElement(By.id("password-sign-in")).click();
    }

    @Test(priority = 3)
    public void contTrials() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("btn_1597825507")).click();
    }

    @Test(priority = 4)
    public void myDevices() throws InterruptedException {
        driver.findElement(By.id("a_1580325650")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(" #btn_1599662556_0")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='btn_1608305123']")).click();
        Thread.sleep(1000);
    }

    // Punctul 1/e/i/ii/iii/iv/v
    @Test(priority = 5)
    public void compareDevice() throws InterruptedException {
        //Vendor
        String vendor = driver.findElement(By.xpath("//card-body/table[1]/tr[1]")).getText();
        String expectedVendor = "Vendor:\n" + "VMware, Inc.";
        Assert.assertEquals(vendor, expectedVendor);
        //Mac Address
        String mac = driver.findElement(By.xpath("//card-body/table[1]/tr[2]")).getText();
        String expectedMac = "MAC Address:\n" + "00:0C:29:58:45:70";
        Assert.assertEquals(mac, expectedMac);
        //Operating System
        String os = driver.findElement(By.xpath("//card-body/table[1]/tr[3]")).getText();
        String expectedOS = "Operating System:\n" + "Microsoft Windows 10.0.19042.";
        Assert.assertEquals(os, expectedOS);
        //Rename device
        driver.findElement(By.id("btn_1608304995_0")).click();
        Thread.sleep(1000);
        WebElement rename = driver.findElement(By.name("deviceName"));
        rename.clear();
        rename.click();
        rename.sendKeys("New Machine Name");
        //driver.findElement(By.xpath("//button[contains(text(),'SAVE')]")).click();
        //Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("C:\\Users\\Silviu\\Desktop\\Homework_Capraru\\ScreenShots\\1ev.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}