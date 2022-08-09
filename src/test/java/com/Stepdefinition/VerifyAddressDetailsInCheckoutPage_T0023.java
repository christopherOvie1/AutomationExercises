package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.NavigationPage;
import com.pages.RegistrationPage;
import org.testng.annotations.Test;

public class VerifyAddressDetailsInCheckoutPage_T0023 extends BaseClass{

    @Test
    public void verifyAddressDetailsInCheckoutPage(){
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



    }
}
