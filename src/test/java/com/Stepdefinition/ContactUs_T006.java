package com.Stepdefinition;

import com.pages.ContactUsPage;
import com.pages.HomePage;
import com.pages.NavigationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

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
       //8. Click 'Submit' button
       contactUs.clickSubmitButton();
       contactUs.AcceptAlerts(driver);
       //ContactUsPage.acceptAlert(driver);

       // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
       boolean  successMessagDisplay= contactUs.isSuccessMessagPresent();
               Assert.assertTrue(successMessagDisplay,"successmessage is displayed");
      System.out.println(contactUs.isSuccessMessagePresent());
     //  Assert.assertTrue(contactUs.isSuccessMessagePresent());

       // 11 Click 'Home' button and verify that landed to home page successfully
       contactUs.clickBackButton();

       System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
       Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());














    }
}
