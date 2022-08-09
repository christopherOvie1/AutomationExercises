package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Paymentage {

    public static WebDriver driver;
    public Paymentage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }





}

