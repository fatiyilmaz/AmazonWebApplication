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
    @FindBy(xpath = "//span[@class='icp-nav-flag icp-nav-flag-au icp-nav-flag-lop']")
    public WebElement avustralyaFlagValidate;
    @FindBy(xpath = "//span[@class='icp-nav-flag icp-nav-flag-br icp-nav-flag-lop']")
    public WebElement brezilyaFlagValidate;
    @FindBy(xpath = "//span[@class='icp-nav-flag icp-nav-flag-ca icp-nav-flag-lop']")
    public WebElement canadaFlagValidate;
    @FindBy(xpath = "//div[@class='navFooterLinkCol navAccessibility']")
    public List<WebElement> aboutUs;
    @FindBy(xpath = "//span[contains(text(),'Başa dön')]")
    public WebElement backToTop;
    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    public WebElement allCategories;
    @FindBy(xpath = "//*[@id='nav-hamburger-menu']")
    public WebElement all;
    @FindBy(xpath = "//div[@id='hmenu-customer-name']")
    public WebElement allHelloSignIn;
    @FindBy(xpath = "//div[@id='hmenu-content']//ul//li")
    public List<WebElement> allALLCategories;
    @FindBy(xpath = "//div[contains(text(),'öne çıkanlar')]")
    public WebElement highlights;
    @FindBy(xpath = "//div[@id='hmenu-content']//a")
    public WebElement bestsellers;
    @FindBy(xpath = "//div[@id='hmenu-content']//ul//li[3]")
    public WebElement newReleases;
    @FindBy(xpath = "//div[@id='hmenu-content']//ul//li[4]")
    public WebElement bestPerformers;



}
