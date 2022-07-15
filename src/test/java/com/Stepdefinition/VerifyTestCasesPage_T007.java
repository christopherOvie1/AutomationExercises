package com.Stepdefinition;

import com.pages.HomePage;
import com.pages.NavigationPage;
import com.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTestCasesPage_T007 extends BaseClass{

    @Test
    public void verifyTestCasesPage(){
        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        TestCasesPage testCases = new TestCasesPage(driver);

        //1  Navigate to url 'http://automationexercise.com'

        driver.get(baseURL);

        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //2  Click on 'Test Cases' button
        navigation.NavigateTo("Test Cases");

        //Verify user is navigated to test cases page successfully
        System.out.println(testCases.isTestCasePageNavigatedToSuccessfully());
        Assert.assertTrue(testCases.isTestCasePageNavigatedToSuccessfully());

    }
}
