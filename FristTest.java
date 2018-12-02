package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://auth.mail.ru/cgi-bin/auth?from=splash\n");
    }
    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"mailbox:login\"]"));
        loginField.sendKeys("xek317@mail.ru");
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"mailbox:password\"]"));
        passwordField.sendKeys("parol");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"mailbox:submit\"]/input"));
        loginButton.click();

    }
    @AfterClass
    public static void tearDown() {
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"PH_logoutLink\"]"));
        logoutButton.click();
        driver.quit();
    }
}
