package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
    public static WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);}

    public boolean validatePageURL(String pageName) {;
        return  driver.getCurrentUrl().endsWith(pageName);
    }

    public boolean validateURL(String url) {


       return driver.getCurrentUrl().endsWith(url);
    }

}
