package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page_Wishlist {
    WebDriver driver;

    public Page_Wishlist(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public int wishListItems(){
        int size = driver.findElements(By.cssSelector("div[class=\"wishlist-content\"]")).size();
        return size;
    }
}
