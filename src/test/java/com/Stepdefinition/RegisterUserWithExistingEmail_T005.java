package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.NavigationPage;
import com.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserWithExistingEmail_T005 extends BaseClass{


    @Test
    public void registerUserWithExistingEmail(){

        //Test data
        String name= "test", email= "christophodibo@yahoo.com";
        String errorEmailMessage= "Email Address already exist!";

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage register = new RegistrationPage(driver);
        NavigationPage navigation = new NavigationPage(driver);


        //1 & 2
        driver.get(baseURL);

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4 .Click on 'Signup / Login' button  //Signup / Login
        navigation.NavigateTo("Signup / Login");

        ///5.Verify 'New User Signup!' is visible
        boolean newUser = loginPage.verifyNewUserSignupIsVisible();
        System.out.println(newUser);
        Assert.assertTrue(newUser,"new user text is not visible");

        //6 Enter name and already registered email address
         loginPage.EnterNameAndAlreadyRegisteredEmailAddress(name,email);

         //7. Click 'Signup' button
        loginPage.loginIntoRegistrationPage();

        //8. Verify error 'Email Address already exist!' is visible
  String actualEmailErrorMessage=loginPage.verifyEmailErrorMessageIsVisible();
  String expectedEmailErrorMessage= errorEmailMessage;
  Assert.assertEquals(actualEmailErrorMessage,expectedEmailErrorMessage,"actualEmailErrorMessage,does not match expectedEmailErrorMessage");



    }
}
