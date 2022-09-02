package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ViewCartBrandProducts_T0019 extends BaseClass {


    @Test
    public void viewCartBrandProducts() {

        String brand1 = "Polo", brand2 = "H&M";

        HomePage homePage = new HomePage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        CommonPage common = new CommonPage(driver);

        //1 & 2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //2  Verify that home page is visible successfully
        System.out.println(homePage.VerifyThatHomePageIsVisibleSuccessfully());
        Assert.assertTrue(homePage.VerifyThatHomePageIsVisibleSuccessfully());

        //3. Click on 'Products' button
        navigation.NavigateTo("Products");

        //4. Verify that Brands are visible on left side bar
        boolean brand = homePage.verifyThatBrandsAreVisibleOnLeftSideBar();
        System.out.println(brand);
        Assert.assertTrue(homePage.verifyThatBrandsAreVisibleOnLeftSideBar());

        //5. Click on any brand name
        homePage.clickOnAnyBrandName(brand1);

        //6. Verify that user is navigated to brand page and brand products are displayed
        Assert.assertTrue(common.validatePageURL(brand1));

        //7. On left side bar, click on any other brand link
        homePage.clickOnAnyBrandName(brand2);

        //  8. Verify that user is navigated to that brand page and can see products
        Assert.assertTrue(common.validatePageURL(brand2));


    }


}
