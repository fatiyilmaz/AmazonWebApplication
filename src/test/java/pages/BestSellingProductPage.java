package pages;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BestSellingProductPage {
    public BestSellingProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindAll({
            @FindBy(xpath = "//a[@aria-label='Daha fazlasını gör Kitap kategorisinde en çok satanlar']"),
            @FindBy(xpath = "//span[@aria-label='Daha fazla gör  Çok satanlar']"),
            @FindBy(xpath = "//span[@aria-label='Daha fazla gör  Çok satanlar']")
    })
    public WebElement getBestSellingProduct;
    @FindBy(xpath = "//div[@class='a-cardui _cDEzb_grid-cell_1uMOS expandableGrid p13n-grid-content']")
    public WebElement tenBestSellingProduct;
}