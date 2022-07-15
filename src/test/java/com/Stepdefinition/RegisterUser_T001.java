package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.NavigationPage;
import com.pages.RegistrationPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUser_T001 extends BaseClass{

    @Test
    public void registerTest() throws InterruptedException {
  String day= "23",month="May",year="2020";
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

        // JavaScript Executor to check ready state
        JavascriptExecutor j = (JavascriptExecutor) driver;
        if (j.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page has loaded");
        } else {
            System.out.println("Page is not loaded");
        }

        String g = loginPage.verifyNewUserSignUPVisible();
        System.out.println(g);


        ///5.Verify 'New User Signup!' is visible
        boolean h = loginPage.verifyNewUserSignupIsVisible();
        System.out.println(h);
        Assert.assertTrue(h);
        //6
        loginPage.enterRandomString();
        loginPage.enterRandomEmailField();
        //7 click sign up button
        loginPage.loginIntoRegistrationPage();

        //8
        // boolean d =   register.VerifyThatENTERACCOUNTINFORMATIONisVisible();
        //   System.out.println(d);
        //choose radio button

        register.getRadioButtons();
        register.enterPassword("ahh65bgfd");
       // Thread.sleep(3000);
      //  register.selectDateOfBirth(13, "January", 2000);
       // register.selectDay("3");
        //register.pickCountry(6);
       // register.selectDay("Canada");
        register.selectDateOfBirth(day,month,year);
        register.enterAddressInfo("garry","meg", "abc","rrr","ttt");
        //First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
       // register.pickCountry();



    }
}
