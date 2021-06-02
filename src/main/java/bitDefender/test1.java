package bitDefender;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class test1 implements ITestListener {

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
    }
    // Going to email address field
    @Test(priority = 1)
    public void toEmail() {
        driver.findElement(By.cssSelector(".btn.primary.solid")).click();
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://login.bitdefender.com/central/login.html?redirect_url=https:%2F%2Fcentral.bitdefender.com%2Fdashboard&lang=en_US&ref=https:%2F%2Fcentral.bitdefender.com%2F&partner_id=com.bitdefender";
        Assert.assertEquals(actualURL, expectedURL);
    }
    // Enter email address
    @Test(priority = 2)
    public void enterEmail() throws InterruptedException {

        WebElement email = driver.findElement(By.cssSelector("#username"));
        email.click();
        email.sendKeys("test+13-15@mailinator.com");
        WebElement next = driver.findElement(By.cssSelector("#login-next"));
        next.click();
        Thread.sleep(3000);
        String actualURL = driver.findElement(By.id("password-sign-in")).getText();
        String expectedURL = "SIGN IN";
        Assert.assertEquals(actualURL, expectedURL);
    }
    // Enter wrong password
    @Test(priority = 3)
    public void enterWrongPass() throws InterruptedException, IOException {
        driver.findElement(By.id("password_input")).sendKeys("Password1234");
        driver.findElement(By.id("password-sign-in")).click();
        WebElement textInvalid = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/div/div[3]"));
        Thread.sleep(1000);
        System.out.println(textInvalid.getText());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("C:\\Users\\Silviu\\Desktop\\Homework_Capraru\\ScreenShots\\b.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The screenshot is taken");
    }

}


