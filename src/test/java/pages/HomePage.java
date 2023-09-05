package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = " //div//label[contains(text(),'Ara Amazon.com.tr')]")
    public WebElement homePageValidate;
    @FindBy(xpath = "//div[@class='navFooterLine navFooterLinkLine navFooterPadItemLine']//ul//li")
    public List<WebElement> countriesValidate;
    @FindBy(xpath = "//div[@class='navFooterLinkCol navAccessibility']")
    public List<WebElement> aboutUs;
    @FindBy(xpath = "//span[contains(text(),'Başa dön')]")
    public WebElement backToTop;
    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    public WebElement allCategories;
    @FindBy(xpath = "//*[@id='nav-hamburger-menu']")
    public WebElement all;


}
