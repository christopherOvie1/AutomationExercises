package com.Stepdefinition;

import com.pages.ContactUsPage;
import com.pages.HomePage;
import com.pages.NavigationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.pages.ContactUsPage.acceptAlert;

public class ContactUs_T006 extends BaseClass{

//String homepageLink= "";
   @Test

    public void navigateToContactUsPage() {
 String name= "chris",email="abc@gmail.com",subject="math",message="please confirm";

       HomePage homePage = new HomePage(driver);
       NavigationPage navigation = new NavigationPage(driver);
       ContactUsPage contactUs = new ContactUsPage(driver);

//
       driver.get(baseURL);

       navigation.NavigateTo("Contact us");

     //3 Verify 'GET IN TOUCH' is visible
       //System.out.println(contactUs.VerifyGETINTOUCHisVisible());
       //Assert.assertTrue(contactUs.VerifyGETINTOUCHisVisible());

       //2  Verify that home page is visible successfully
       System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
       Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

       //4  Enter name, email, subject and message

       contactUs.fillContactUsForm(name,email,subject,message);
       contactUs.clickSubmitButton();
       contactUs.AcceptAlerts(driver);
       //ContactUsPage.acceptAlert(driver);

       //confirm receiving succcessful message
       System.out.println(contactUs.isSuccessMessagePresent());
       Assert.assertTrue(contactUs.isSuccessMessagePresent());

       //Click 'Home' button and verify that landed to home page successfully
       contactUs.clickBackButton();

       System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
       Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());














    }
}
