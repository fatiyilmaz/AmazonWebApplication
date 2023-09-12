package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePageSearcbox {
    public HomePageSearcbox() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindAll({
            @FindBy(xpath = "//span[@class='a-size-base a-color-base apb-browse-refinements-indent-1 a-text-bold']"),
            @FindBy(xpath = "//h1[text()='Moda']"),
            @FindBy(xpath = "//span[@class='a-size-medium-plus a-color-base a-text-bold']")
    })
    public WebElement isCategoryName;


    public WebElement isCategoryNameModa;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    public WebElement searchiconButton;
}
