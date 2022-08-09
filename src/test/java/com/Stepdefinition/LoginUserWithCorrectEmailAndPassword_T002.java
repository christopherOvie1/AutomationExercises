package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.NavigationPage;
import com.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUserWithCorrectEmailAndPassword_T002 extends BaseClass{

    @Test
    public void loginUserWithCorrectEmailAndPassword() throws InterruptedException {

        String email = "christophodibo@yahoo.com";
        String password= "Father60";
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage register = new RegistrationPage(driver);
        NavigationPage navigation = new NavigationPage(driver);

        //2
        driver.get(baseURL);

        //3. Verify that home page is visible successfully
        //Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4 .Click on 'Signup / Login' button  //Signup / Login
        /// homePage.goToLoginPage();
        navigation.NavigateTo("Signup / Login");

        loginPage.loginAsValidUser(email,password);

        //6  Verify that 'Logged in as username' is visible

       // loginPage.verifyThatLoggedusernameIsVisible();
       // System.out.println(loginPage.verifyThatLoggedusernameIsVisible());
       // Assert.assertTrue(loginPage.verifyThatLoggedusernameIsVisible());

   boolean status= loginPage.verifyThatLoggedusernameIsVisible();
   if(status){
       System.out.println("logged in user is visible");
   }
   else{
       System.out.println("logged in user is not visible");
   }
        Assert.assertTrue(loginPage.verifyThatLoggedusernameIsVisible());


        //9  Click 'Delete Account' button

        loginPage.ClickDeleteAccountButton();


    }
}
