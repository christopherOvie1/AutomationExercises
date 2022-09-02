package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.NavigationPage;
import com.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUserWithincorrectEmailAndPasswords_T003 extends BaseClass{


    @Test
    public  void loginWithIncorrectEmailIDAndPassword(){

        String email = "christoophodibo@yahoo.com";
        String password= "Fat0";


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


        //  6 & 7  Enter incorrect email address and password
        loginPage.loginAsValidUser(email,password);

        //8. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(loginPage.isErrorMessageTextVisible());
    }
}
