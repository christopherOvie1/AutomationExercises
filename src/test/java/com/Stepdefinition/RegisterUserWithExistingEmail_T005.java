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

        String name= "test", email= "christophodibo@yahoo.com";
        String errorEmailMessage= "Email Address already exist!";

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage register = new RegistrationPage(driver);
        NavigationPage navigation = new NavigationPage(driver);


        //2
        driver.get(baseURL);

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4 .Click on 'Signup / Login' button  //Signup / Login
        /// homePage.goToLoginPage();
        navigation.NavigateTo("Signup / Login");

        ///5.Verify 'New User Signup!' is visible
        boolean h = loginPage.verifyNewUserSignupIsVisible();
        System.out.println(h);
        Assert.assertTrue(h);

        //6 Enter name and already registered email address
loginPage.EnterNameAndAlreadyRegisteredEmailAddress(name,email);
//7. Click 'Signup' button

        loginPage.loginIntoRegistrationPage();

        //8. Verify error 'Email Address already exist!' is visible
  String actualEmailErrorMessage=loginPage.verifyEmailErrorMessageIsVisible();
  String expectedEmailErrorMessage= errorEmailMessage;

  Assert.assertEquals(actualEmailErrorMessage,expectedEmailErrorMessage);



    }
}
