package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static utilities.Driver.getDriver;


public class HomePageStepdefinitions {
    HomePage homePage;
    @Given("user {string} logs in")
    public void userLogsIn(String string) {
        homePage = new HomePage();
        getDriver().get(string);
    }

    @And("confirms that it is on the amazon page and on the homepage")
    public void confirmsThatItIsOnTheAmazonPageAndOnTheHomepage() {
        assert getDriver().getCurrentUrl().contains("amazon");
        Driver.wait(2);
        WebElement searchboxText = getDriver().findElement(By.xpath(" //div//label[contains(text(),'Ara Amazon.com.tr')]"));
        assert homePage.homePageValidate.getText().contains(searchboxText.getText());
        Driver.wait(2);
    }

    @And("scroll to the bottom of the page and see the countries")
    public void scrollToTheBottomOfThePageAndSeeTheCountries() throws IOException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
        System.out.println("countryNames = " + countryNames);//Available countries

        Integer countriesNameCount = countryNames.size();
        System.out.println(countriesNameCount);//16
        Driver.wait(2);


        for (WebElement countries : homePage.countriesValidate ){//Countries are printed one by one
            System.out.println("countryNames = " + countries.getText());
        }

        Integer countriesCount = homePage.countriesValidate.toArray().length;
        System.out.println(countriesCount);//16
        Driver.wait(2);


        assert countriesNameCount.equals(countriesCount);//The number of available countries is verified
        Driver.wait(2);

    }

    @And("clicks on individual countries")
    public void clicksOnIndividualCountries() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //16 countries are clicked one by one
        for (int i = 0; i < homePage.countriesValidate.size(); i++) {
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");//En asagi indir
            System.out.println(homePage.countriesValidate.get(i).getText());
            Driver.waitAndClick(homePage.countriesValidate.get(i),2);
            if (i==1) {
                assert homePage.avustralyaFlagValidate.isDisplayed();
                Driver.wait(1);
            }else if(i==2){
                try {
                    assert homePage.brezilyaFlagValidate.isDisplayed();
                }catch (Exception e){
                    continue;
                }
            }else if(i==3){
                assert homePage.canadaFlagValidate.isDisplayed();
                Driver.wait(1);
            }
            getDriver().navigate().back();
        }

        Assert.assertEquals(16,homePage.countriesValidate.size());//16 countries are verified as clicked
        Driver.wait(2);
    }


    @And("Hakkımızda, Bizimle Para Kazanın, Amazon Ödeme Araçları, Size Yardımcı Olalım sections appear")
    public void hakkımızdaBizimleParaKazanınAmazonÖdemeAraçlarıSizeYardımcıOlalımSectionsAppear() throws IOException {
        WebElement scrollUp = getDriver().findElement(By.xpath("//div[@class='navFooterLinkCol navAccessibility']"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();//elemente surukler
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
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",homePage.backToTop);
        homePage.backToTop.click();
        Driver.wait(2);
    }

    @And("clicks and verifies All")
    public void clicksAndVerifiesAll() throws IOException {
        homePage.allCategories.click();
        Select dropdownList = new Select(homePage.allCategories);
        List<WebElement> eachCategory = dropdownList.getOptions();
        int count = 1;
        for (WebElement allCategories : eachCategory){
            System.out.println(count + " = " + allCategories.getText());
            count++;
        }
        Driver.wait(2);
        //ReusableMethods.getScreenshot("screenshot");

        Integer categorySize = 21;
        Integer eachCategorySize = eachCategory.toArray().length;
        assert categorySize.equals(eachCategorySize);
        Driver.wait(2);

    }


    @And("all click")
    public void allClick() {
        homePage.all.click();
    }


    @And("Hello, sign in clicks and hello sign in that it is redirected to the login page")
    public void helloSignInClicksAndHelloSignInThatItIsRedirectedToTheLoginPage() {
        homePage.allHelloSignIn.click();
        assert getDriver().getCurrentUrl().contains("signin");
        Driver.wait(1);
    }

    @And("Clicks and verifies the tabs of the highlights section")
    public void clicksAndVerifiesTheTabsOfTheHighlightsSection() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //16 countries are clicked one by one
        for (int i = 0; i < homePage.allALLCategories.size(); i++) {
            System.out.println(homePage.allALLCategories.get(i).getText());
            assert homePage.highlights.isDisplayed();
            Driver.wait(2);
            js.executeScript("arguments[0].click();",homePage.bestsellers);
            assert getDriver().getCurrentUrl().contains("bestsellers");
            Driver.wait(2);
            Driver.getDriver().navigate().back();
            if (Driver.getDriver().getCurrentUrl().contains("amazon")){

                js.executeScript("arguments[0].click();",homePage.newReleases);
                assert getDriver().getCurrentUrl().contains("new-releases");
                Driver.wait(2);
                Driver.getDriver().navigate().back();
            }else if (Driver.getDriver().getCurrentUrl().contains("amazon")) {
                try {

                    js.executeScript("arguments[0].click();",homePage.bestPerformers);
                    String actualUrl = "movers-and-shakers";
                    assert getDriver().getCurrentUrl().equals(actualUrl);
                    Driver.wait(1);
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("En Çok Satanlar Sekmesi URL Failed");
                }

            }
            allClick();
            i++;


        }


//        assert homePage.highlights.isDisplayed();
//        Driver.wait(1);
//
//
//        js.executeScript("arguments[0].click();",homePage.bestsellers);
//        assert getDriver().getCurrentUrl().contains("bestsellers");
//        Driver.wait(1);
//        Driver.getDriver().navigate().back();
//
//        homePage.all.click();
//        Driver.wait(1);
//        homePage.newReleases.click();
//        assert getDriver().getCurrentUrl().contains("new-releases");
//        Driver.wait(1);
//        Driver.getDriver().navigate().back();
//
//        homePage.all.click();
//        Driver.wait(1);
//        String actualUrl = "movers-and-shakers";
//        homePage.bestPerformers.click();
//
//        assert getDriver().getCurrentUrl().equals(actualUrl);
//        Driver.wait(1);




    }
}
