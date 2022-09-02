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
        // 1 & 2
        driver.get(baseURL);

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4 .Click on 'Signup / Login' button  //Signup / Login
        navigation.NavigateTo("Signup / Login");

        //5. Verify 'Login to your account' is visible
         loginPage.verifyloginIntoAccountText();
         Assert.assertTrue(loginPage.verifyloginIntoAccountText(),"Login to your account text not found");

        // 6 & 7 Enter correct email address and password click login
        loginPage.loginAsValidUser(email,password);

        //8. Verify that 'Logged in as username' is visible
        boolean status= loginPage.verifyThatLoggedusernameIsVisible();
        if(status){
            System.out.println("logged in user is visible");
        }
        else{
            System.out.println("logged in user is not visible");
        }
        Assert.assertTrue(loginPage.verifyThatLoggedusernameIsVisible());

        //9. Click 'Delete Account' button
       navigation.NavigateTo("Logout");

     //10. Verify that user is navigated to login page
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());
    }

}
