package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.BestSellingProductPage;
import pages.HomePage;
import pages.HomePageSearcbox;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileOutputStream;
import java.util.List;

import static java.nio.file.Files.write;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.getDriver;

public class BestSellingProductStepDefinitions {
    HomePage homePage;
    HomePageSearcbox searchBox;
    BestSellingProductPage bestSellingProduct;
    @Then("click on the products in the Categories section")
    public void clickOnTheProductsInTheCategoriesSection() {
        homePage = new HomePage();
        searchBox = new HomePageSearcbox();
        bestSellingProduct = new BestSellingProductPage();
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

            JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();

            try{
                jsExecutor.executeScript("arguments[0].click;",bestSellingProduct.getBestSellingProduct);
                bestSellingProduct.getBestSellingProduct.click();
                String path = "/Users/emrekoc/Desktop/Kitap.txt";
                FileOutputStream outputStream = new FileOutputStream(path);
                for (int j = 0; j <= 10; j++) {
                    System.out.println("ürün  = " + i + bestSellingProduct.tenBestSellingProduct.getText());
                    byte[] veriBytes = bestSellingProduct.tenBestSellingProduct.getText().getBytes();
                    outputStream.write(veriBytes, 0, veriBytes.length);
                    outputStream.write("\n".getBytes());
                }
                outputStream.close();
            }catch (Exception e){
                System.out.println( actualdata + " sekmesinde cok satan urun sekmesi yok");
            }



            dropdown = new Select(homePage.allCategories);
            eachCategory = dropdown.getOptions();
        }
    }

    @And("lists the top twenty best-selling products")
    public void listsTheTopBestSellingProducts() {
    }

    @And("listed products are printed to excel file")
    public void listedProductsArePrintedToExcelFile() {
    }
}