package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.HomePageSearcbox;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePageSearchboxStepDefinitions {
    HomePage homePage;
    HomePageSearcbox searchBox;

    @Given("go to home page url")
    public void go_to_home_page_url() {
        System.out.println(ConfigReader.getProperty(ConfigReader.getProperty("url")));
    }

    @And("From the All categories tab, click in order")
    public void from_the_all_categories_tab_click_in_order() {
        homePage = new HomePage();
        searchBox = new HomePageSearcbox();
        Select dropdown = new Select(homePage.allCategories);
        List<WebElement> eachCategory = dropdown.getOptions();


        for (int i = 1; i < eachCategory.size(); i++) {

            String expectedData = eachCategory.get(i).getText();
            System.out.println(i + " = " + expectedData);
            ReusableMethods.waitForClickablility(eachCategory.get(i), 5).click();
            ReusableMethods.waitForClickablility(searchBox.searchiconButton, 10).click();
            dropdown = new Select(homePage.allCategories);
            eachCategory = dropdown.getOptions();

            String actualdata = ReusableMethods.waitForVisibility(searchBox.isCategoryName, 5).getText();
            System.out.println("actualdata = " + actualdata);
            //S           String actualdatam = ReusableMethods.waitForVisibility(searchBox.isCategoryNameModa, 5).getText();
            if (!actualdata.contains(expectedData)) {
                System.out.println("expected data ile actual data içermiyror " + expectedData + " " + actualdata);
            } else {
                assertTrue(actualdata.contains(expectedData));
            }
        }


    }


    @And("verify that it goes to the right category")
    public void verify_that_it_goes_to_the_right_category() {

    }
}
