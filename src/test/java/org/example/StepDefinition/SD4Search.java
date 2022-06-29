package org.example.StepDefinition;

import org.example.Pages.Page_Home;
import org.example.Pages.Page_Search;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class SD4Search {
    Page_Home home;
    Page_Search search;

    @Given("user click on search bar")
    public void user_click_on_searchbar() {
        home = new Page_Home(Hooks.driver);
        search = new Page_Search(Hooks.driver);
        home.searchBar().click();
    }

    @When("user search for product \"(.*)\"$")
    public void user_search_for_product(String search) {
        home.searchBar().sendKeys(search);
    }

    @And("user click on search Button")
    public void user_click_on_searchButton() {
        home.searchButton().click();
    }

    @Then("user search successfully and go to search page")
    public void search_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=Nokia"), "search URL");
        // Second Assertion
        int size = search.productsList();
        soft.assertTrue(size > 0,"Search Result");
        // Assert All
        soft.assertAll();
    }

    @Then("user search successfully with SKU")
    public void search_with_sku_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q=AP_MBP_13"), "URL after search");
        // Second Assertion
        int size = search.productsList();
        soft.assertTrue(size > 0,"Search Result");
        // Assert All
        soft.assertAll();
    }

    @Then("user not search")
    public void no_products_found() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(search.noProducts().isDisplayed(), "No products");
    }
}
