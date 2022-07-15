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

    //@FindBy(xpath="//h2[contains(.,'New User Signup!')]")
    //WebElement newUserSignUpText;
   /* @FindBy(xpath="//span[contains(.,'" + links + "')]")
    WebElement homePagelinks;

    public void navigateToNewPage(String link){
        homePagelinks.click(link);
    }*/


    public void NavigateTo(String section)
    {
       // Reporting.Log.AppendLine("Navigating to " + section);
        //WebElement sectionSelector = By.XPath("//span[contains(.,'" + section + "')]");
       // Interactions.Click(sectionSelector);
      WebElement homePageLinks=  driver.findElement(By.xpath("//a[contains(.,'" + section + "')]"));
        homePageLinks.click();
    }
}
