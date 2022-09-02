package com.Stepdefinition;

import com.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewCategoryProducts_T0018 extends BaseClass{

    @Test
    public void viewCategoryProducts() throws InterruptedException {

        String attire = "dress";
        HomePage homePage = new HomePage(driver);
        CommonPage common = new CommonPage(driver);
        NavigationPage navigation = new NavigationPage(driver);
        CartPage cart =new CartPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        ProductDetailsPage productDetails= new ProductDetailsPage(driver);

       //1 &2 Navigate to url 'http://automationexercise.com'
        driver.get(baseURL);

        //3. Verify that categories are visible on left side bar
        System.out.println(homePage.verifyThatCategoriesAreVisibleOnLeftSideBar());
        String expectedText=homePage.verifyThatCategoriesAreVisibleOnLeftSideBar();
        String actualText= "CATEGORY";
        Assert.assertEquals(actualText,expectedText,"actual message does not match expected message");

        //4. Click on 'Women' category
        homePage.clickOnCategoryFilters("#Women");

        //5. Click on any category link under 'Women' category, for example: Dress
        navigation.NavigateTo("Dress");

        //6 . Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
      String actualProductsText=  productDetails.confirmTextWOMENTOPSPRODUCTS();
        System.out.println(actualProductsText);
     String expectedProductText = "WOMEN - DRESS PRODUCTS";
      Assert.assertEquals(actualProductsText,expectedProductText,"mismatch");

      //7. On left side bar, click on any sub-category link of 'Men' category
        homePage.clickOnCategoryFilters("#Men");

        //8. Verify that user is navigated to that category page
        navigation.NavigateTo("Tshirts");
       String actualProductTexts= homePage.verifyThatUserIsNavigatedToThatCategoryPage("Men - Tshirts Products");
      String    expectedProductTexts = "MEN - TSHIRTS PRODUCTS";
      Assert.assertEquals(actualProductTexts,expectedProductTexts,"mismaatch");


    }
}
