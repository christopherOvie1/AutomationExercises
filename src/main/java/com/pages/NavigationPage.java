package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage {

    WebDriver driver;
    public NavigationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//web actions
    public void NavigateTo(String section)
    {
        WebElement homePageLinks=  driver.findElement(By.xpath("//a[contains(.,'" + section + "')]"));
        homePageLinks.click();
    }

}
