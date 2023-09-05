package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class HomePageStepdefinitions {
    HomePage homePage;
    @Given("user {string} logs in")
    public void userLogsIn(String string) {
        homePage = new HomePage();
        Driver.getDriver().get(string);
    }

    @And("confirms that it is on the amazon page and on the homepage")
    public void confirmsThatItIsOnTheAmazonPageAndOnTheHomepage() {
        assert Driver.getDriver().getCurrentUrl().contains("amazon");
        Driver.wait(2);
        WebElement searchboxText = Driver.getDriver().findElement(By.xpath(" //div//label[contains(text(),'Ara Amazon.com.tr')]"));
        assert homePage.homePageValidate.getText().contains(searchboxText.getText());
        Driver.wait(2);
    }

    @And("scroll to the bottom of the page and see the countries")
    public void scrollToTheBottomOfThePageAndSeeTheCountries() throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");//En asagi indir

        //ReusableMethods.getScreenshot("screenshot");
        //Driver.wait(2);

        LinkedList<String> countryNames = new LinkedList<>();
        countryNames.add("Avustralya");
        countryNames.add("Brezilya");
        countryNames.add("Kanada");
        countryNames.add("Çin");
        countryNames.add("Fransa");
        countryNames.add("Almanya");
        countryNames.add("Hindistan");
        countryNames.add("İtalya");
        countryNames.add("Japonya");
        countryNames.add("Meksika");
        countryNames.add("Hollanda");
        countryNames.add("İspanya");
        countryNames.add("Birleşik Arap Emirlikleri");
        countryNames.add("Birleşik Krallık");
        countryNames.add("ABD");
        countryNames.add("Singapur");
        System.out.println("countryNames = " + countryNames);

        Integer countriesNameCount = countryNames.size();
        System.out.println(countriesNameCount);
        Driver.wait(2);


        for (WebElement countries : homePage.countriesValidate ){
            System.out.println("countryNames = " + countries.getText());
        }

        Integer countriesCount = homePage.countriesValidate.toArray().length;
        System.out.println(countriesCount);
        Driver.wait(2);


        assert countriesNameCount.equals(countriesCount);
        Driver.wait(2);

    }

    @And("Hakkımızda, Bizimle Para Kazanın, Amazon Ödeme Araçları, Size Yardımcı Olalım sections appear")
    public void hakkımızdaBizimleParaKazanınAmazonÖdemeAraçlarıSizeYardımcıOlalımSectionsAppear() throws IOException {
        WebElement scrollUp = Driver.getDriver().findElement(By.xpath("//div[@class='navFooterLinkCol navAccessibility']"));
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();//elemente surukler
        js.executeScript("arguments[0].scrollIntoView(true);",scrollUp);
        Driver.wait(2);

        int count = 1;
        for (WebElement about: homePage.aboutUs){
            System.out.println(count + " = " + about.getText());
            count++;
        }
        //ReusableMethods.getScreenshot("screenshot");
        //Driver.wait(2);
    }


    @And("backToTop click")
    public void backtotopClick() {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",homePage.backToTop);
        homePage.backToTop.click();
        Driver.wait(2);
    }

    @And("clicks and verifies All")
    public void clicksAndVerifiesAll() {
        homePage.allCategories.click();
        Select dropdownList = new Select(homePage.allCategories);
        List<WebElement> eachCategory = dropdownList.getOptions();
        int count = 1;
        for (WebElement allCategories : eachCategory){
            System.out.println(count + " = " + allCategories.getText());
            count++;
        }

        Driver.wait(2);
        Integer categorySize = 21;
        Integer eachCategorySize = eachCategory.toArray().length;
        assert categorySize.equals(eachCategorySize);
        Driver.wait(2);
    }


    @And("all click")
    public void allClick() {
        homePage.all.click();
    }
}
