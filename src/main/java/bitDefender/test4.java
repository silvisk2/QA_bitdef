package bitDefender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Cookie;

public class test4 {

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
    //Cookies Extraction
    @Test(priority = 4)

    public void cookiesExtraction () {

        System.out.println(driver.manage().getCookieNamed("_cbct"));




    }



}
