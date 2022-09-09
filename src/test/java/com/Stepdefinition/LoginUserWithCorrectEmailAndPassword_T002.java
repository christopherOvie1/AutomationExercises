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

        //Test data
        String email = "christophodibo@yahoo.com";
        String password= "Father60";
        String name = "chris";

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

        //5 Verify that 'Logged in as username' is visible
        loginPage.verifyloginIntoAccountText();
        Assert.assertTrue(loginPage.verifyloginIntoAccountText(),"Login to your account text not found");


        //6 & 7  Enter correct email address and password
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
      //  loginPage.validateLoggedUsername("chris ovie");
        //Assert.assertEquals(loginPage.validateLoggedUsername("chris ovie"),"jj");
//Assert.assertEquals(loginPage.validateLoggedUsername());

       // Assert.assertEquals(loginPage.validLogername(),"Logged in as chris");
    loginPage.loggedInAs(name);

        //9. Click 'Delete Account' button
        loginPage.ClickDeleteAccountButton();


    }
}
