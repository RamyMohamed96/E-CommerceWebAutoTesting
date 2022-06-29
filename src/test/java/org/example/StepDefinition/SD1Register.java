package org.example.StepDefinition;

import org.example.Pages.Page_Home;
import org.example.Pages.Page_Register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class SD1Register {
    Page_Register register;
    Page_Home home;

    @Given("user navigate to register page")
    public void user_navigate_to_register_page() {
        register = new Page_Register(Hooks.driver);
        home = new Page_Home(Hooks.driver);
        home.Navigate_to_RegisterPage().click();
    }

    @And("user choose male or female")
    public void user_choose_Gender_Option (){
        register.maleGender().click();
}

    @And("user enter valid data")
    public void user_enter_first_name(){
        register.firstName().sendKeys("Ramy");

        register.lastName().sendKeys("Mohamed");

        Select select = new Select(register.birthDay());
        select.selectByIndex(30);

        select = new Select(register.birthMonth());
        select.selectByVisibleText("August");

        select = new Select(register.birthYear());
        select.selectByValue("1996");


        register.email().sendKeys("ramorionly96@gmail.com");

        register.companyName().sendKeys("Student");

        register.password().sendKeys("Password");
        register.confirmPassword().sendKeys("Password");
    }

    @Then("user click on register button")
    public void user_register_successfully(){
        register.registerB().click();
    }

    @And("user Register Successfully")
    public void register_successfully() {
        // 1st Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(register.successfulMsg().isDisplayed(), "Success Message");
        // 2nd Assertion
        String actual = register.successfulMsg().getCssValue("color");
        String expected = "rgba(76, 177, 124, 1)";
        soft.assertEquals(actual, expected, "color is correct");
        // Assert All
        soft.assertAll();
    }
}
