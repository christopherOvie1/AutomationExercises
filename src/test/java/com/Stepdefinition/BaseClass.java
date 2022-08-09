package com.Stepdefinition;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    String baseURL=  "https://www.automationexercise.com/";

    public static WebDriver driver;

    @BeforeClass

  public  void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       //driver.manage().timeouts().implicitlyWait(5l,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().pageLoadTimeout(5)
      //  WebDriverWait wait = new WebDriverWait(driver, 30);
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("csspath")));
//new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("wait")));
 //new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.id("wait")));
    }

}
