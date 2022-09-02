package com.Stepdefinition;

import com.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUser_T001 extends BaseClass {

    @Test
    public void registerTest() throws InterruptedException {
        String day = "23", month = "May", year = "2020";
        String title1 = "Nrs", title2 = "Mr";
        String firstName = "chris", lastName = "john", company = "abc ltd", addressLn1 = "4", addressLn2 = "abc st", country = "Canada", state = "ottawa", city = "test", zipcode = "23432", mobileNumber = "123455";
        String password = "test123";


        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage register = new RegistrationPage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        AccountCreatedPage accountCreated = new AccountCreatedPage(driver);
        AddressPage address =new AddressPage(driver);

        //1 & 2
        driver.get(baseURL);

        //3. Verify that home page is visible successfully
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //4 .Click on 'Signup / Login' button  //Signup / Login
        navigation.NavigateTo("Signup / Login");
        // JavaScript Executor to check ready state
        JavascriptExecutor j = (JavascriptExecutor) driver;
        if (j.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page has loaded");
        } else {
            System.out.println("Page is not loaded");
        }

        //5.Verify 'New User Signup!' is visible
        boolean newUser = loginPage.verifyNewUserSignupIsVisible();
        System.out.println(newUser);
        Assert.assertTrue(newUser);

        //6 Enter name and email address
        loginPage.enterRandomString();
        loginPage.enterRandomEmailField();

        //7 click sign up button
        loginPage.loginIntoRegistrationPage();

        //8  Verify that 'ENTER ACCOUNT INFORMATION' is visible
         boolean accountInfo =   register.VerifyThatENTERACCOUNTINFORMATIONisVisible();
          System.out.println("ENTER ACCOUNT INFORMATION is visible is "+accountInfo);
          Assert.assertTrue(accountInfo);


//9  Fill details: Title, Name, Email, Password, Date of birth
        //address.clickRad();
        address.clickEitherRadioButtons();
        register.enterPassword(password);
        register.selectDateOfBirth(day, month, year);
        register.enterAddressInfo(firstName, lastName, company, addressLn1, addressLn2, country, state, city, zipcode, mobileNumber);

//14. Verify that 'ACCOUNT CREATED!' is visible
        String actualAccCreatedText = accountCreated.verifyThatACCOUNTCREATEDIsVisible();
        String expectedAccCreatedText = "ACCOUNT CREATED!";
        Assert.assertEquals(actualAccCreatedText, expectedAccCreatedText);

        //15. Click 'Continue' button
        accountCreated.clickContinueButton();

        //16. Verify that 'Logged in as username' is visible
        loginPage.verifyThatLoggedusernameIsVisible();

        //17. Click 'Delete Account' button
        loginPage.ClickDeleteAccountButton();
    }
}
