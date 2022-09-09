package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.How.*;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
       this.driver=driver;
        PageFactory.initElements(driver,this);}

    //webelements
    @FindBy(xpath="//div[@id='slider-carousel']/div/div[1]/div[1]/h2[.='Full-Fledged practice website for Automation Engineers']")
    WebElement  visibleTextOnScreen;

    @FindBy(css="li:nth-of-type(4) > a")
    WebElement  signUpLink;

    @FindBy(css="i[class='fa fa-angle-up']")
    WebElement  movingArrow;

    @FindBy(id="susbscribe_email")
    WebElement  emailID;

    @FindBy(css="i[class*='fa-arrow-circle-o-right']")
    WebElement  arrowTab;

    @FindBy(css="div[class='logo pull-left'] a img")
    WebElement logoBanner;

    @FindBy(css="div[class='single-widget']>h2")
    WebElement subscriptionText;

    @FindBy(xpath="//*[contains(text(),'You have been successfully subscribed!')]")
    WebElement messsageText;

    @FindBy(css="div[class='left-sidebar'] > h2")
    WebElement  categoryText;

    @FindBy(xpath="//a[contains(@href, '#Women')]")
    WebElement  womenFilter;

    ////div[@id='Women']//ul/li[' + "index" + ']
    @FindBy(xpath="//div[@id='Women']//ul/li[1]")
    WebElement  dressButton;

    @FindBy(xpath="//a[contains(@href, '#Men')]")
    WebElement  menFilter;

    @FindBy(xpath="//a[contains(.,'Polo')]")
    WebElement  poloBrand;

    @FindBy(xpath="//*[contains(text(),'You have been successfully subscribed!')]")
    WebElement  subscribedSuccessMessage;



//web actions
    public boolean VerifyThatHomePageIsVisibleSuccessfully() {
        return logoBanner.isDisplayed();
    }

    public void goToLoginPage() {
       signUpLink.click();}

    public void ScrollDownToFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(500,document.body.scrollHeight)");
    }


    public void scrollUpPageToTop(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }

    public String verifyTextSUBSCRIPTION(){
       return subscriptionText.getText();

    }

    public void enterEmailAndNavigateToNextPage(String email){
        emailID.sendKeys(email);
        arrowTab.click();
    }

public void clickMovingArrow()
{
    movingArrow.click();

}

public void confirmMessageSent(WebDriver driver) {

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
    // try  invisibilityOfElementLocated condition
      w.until(ExpectedConditions.
              visibilityOfElementLocated(By.xpath("//*[contains(text(),'You have been successfully subscribed!')]")));

}

public String subsribedVerifidMessage(){
   return    subscribedSuccessMessage.getText();
}


public String confirmVisibleTextOnScreen(){
   return visibleTextOnScreen.getText();
}

public String verifyThatCategoriesAreVisibleOnLeftSideBar(){
     String text=  categoryText.getText();
     return text;
}
public void clickOnWomenCategory(){
        Actions act= new Actions(driver);
    act.click(womenFilter).build().perform();
}
    public void ClickOnAnyCategoryLinkUnderWomenCategoryForExampleDress(){
       Actions act1= new Actions(driver);
        act1.contextClick(dressButton).build().perform();
        //dressButton.click();
    }

    public void clickOnMenCategory(){
        Actions act= new Actions(driver);
        act.click(menFilter).build().perform();
    }
    public void clickOnCategoryFilters(String sections){
        WebElement categoryLinks=  driver.findElement(By.xpath("//a[contains(@href, '" + sections + "')]"));
        categoryLinks.click();
    }

    public String verifyThatUserIsNavigatedToThatCategoryPage(String text){
        WebElement categoryText=  driver.findElement(By.xpath("//h2[contains(.,'" + text + "')]"));
        return categoryText.getText();
    }
    //4. Verify that Brands are visible on left side bar
    public boolean verifyThatBrandsAreVisibleOnLeftSideBar() {
        boolean visibleProduct = true;
        List<WebElement> visibleProducts = driver.findElements(By.xpath("//*[@class= 'nav nav-pills nav-stacked']//li"));
        for (WebElement brands : visibleProducts) {
            brands.isDisplayed();
        }
        return visibleProduct;
    }

    public void clickOnAnyBrandName(String section)
    {
        WebElement brand=  driver.findElement(By.xpath("//a[contains(.,'"  +  section  + "')]"));
        brand.click();
    }
    public void clickPolo(){
        poloBrand.click();
    }

}
