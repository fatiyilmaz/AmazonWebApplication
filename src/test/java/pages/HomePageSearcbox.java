package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePageSearcbox {
    public HomePageSearcbox(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//span[@class='a-size-base a-color-base apb-browse-refinements-indent-1 a-text-bold']")
    public WebElement isCategoryName;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    public WebElement searchiconButton;
}
