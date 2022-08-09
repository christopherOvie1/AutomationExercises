package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.NavigationPage;
import com.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutUser_T004 extends BaseClass{

    @Test
    public void logoutUser(){
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

        // 6 & 7Enter correct email address and password click login
        loginPage.loginAsValidUser(email,password);

        //9. Click 'Delete Account' button
       navigation.NavigateTo("Logout");

     //10. Verify that user is navigated to login page
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());
    }

}
