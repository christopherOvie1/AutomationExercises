package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CommonPage {
    public static WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean validatePageURL(String pageName) {
        ;
        return driver.getCurrentUrl().endsWith(pageName);
    }

    public boolean validatePageurl(String urlPart) {
        ;
        return driver.getCurrentUrl().contains(urlPart);
    }

    @FindBy(css = "div[class='productinfo text-center'] p")
    List<WebElement> viewAllItems;

    @FindBy(css = ".choose > .nav.nav-justified.nav-pills  a")
    List<WebElement> viewProductLink;

    public void selectAnyProductAndLogIntoProductDetailsPge(String ele) {

        String itemsNeeded[] = {"Blue Top", "Men Tshirt", "Sleeveless Dress", "Stylish Dress", "Winter Top"};
        List<String> myItemsNeededInList = Arrays.asList(itemsNeeded);
        List<WebElement> allProductsButton = viewAllItems;
        int f = viewAllItems.size();

        for (int i = 0; i < allProductsButton.size(); i++) {
            allProductsButton.get(i).getText();
        }
        if (myItemsNeededInList.contains(ele)) {
            //selecting the fifth product
            driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-justified']/li")).get(4).click();
            // driver.findElement(By.xpath("//ul[@class='nav nav-pills nav-justified']/li")).click();
        }
    }

    public void selectAnyProductAndLogIntoProductDetails() {
        List<WebElement> allProductsButton = viewAllItems;
        for (int i = 0; i < allProductsButton.size(); i++) {
            allProductsButton.get(i).getText();
            driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-justified']/li")).get(26).click();
        }
    }

 /*   public void selectAnyProductAndLogIntoProduc(int k) {
        List<WebElement> allProductsButtons = viewProductLink;
        for (int k=0;k<allProductsButtons.size();k++){
            allProductsButtons.get(k).click();
        }
    }*/

    public void selectRandomProduct() {

        // Find and click on a random product
        List<WebElement> allProducts = viewAllItems;
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();
        driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-justified']/li")).get(26).click();


    }


    public boolean validateURL(String url) {
        return driver.getCurrentUrl().endsWith(url);
    }


    public void getDifferentProducts() {
        int j = 0;
        String[] expectedProducts = {"Blue Top", "Men Tshirt", "Sleeveless Dress"};
        List<WebElement> allProductName = driver.findElements(By.cssSelector("div[class='productinfo text-center'] p"));
        // ArrayList<String> obj = new ArrayList<String>(Arrays.asList(expectedProducts));
        //System.out.println("Elements Present in ArrayList are :"+obj);

        for (int i = 0; i < allProductName.size(); i++) {
            j++;
            String name = allProductName.get(i).getText();

            if (name.contains("Sleeveless Dress")) {
                driver.findElement(By.cssSelector(".choose > .nav.nav-justified.nav-pills  a")).click();
                j++;
            }
            break;
        }
    }

    //function to get random products
    public void clickRandomProducts() {

        List<WebElement> recommendedAddToClick = driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-justified']/li"));
        Random rand = new Random();
        int randomRecommendedAddToClick = rand.nextInt(recommendedAddToClick.size());//getting a random value between 0 and size
        recommendedAddToClick.get(randomRecommendedAddToClick).click();
    }

}





