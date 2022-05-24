package com.zjadlempierwszy;

import com.zjadlem.Browser;
import com.zjadlem.Pages;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestaurantSearch {
    @BeforeEach
    public void resize() throws InterruptedException {

    }
    @Test
    @Order(1)
    public void CorrectrestaurantsFromSelectedCity() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clean();
        Browser.resize();
        Browser.clickOnElementByClassAndIndex("nav-item",0);
        Browser.clickOnElementById("gdanskSel");
        Assertions.assertTrue(Browser.assertTextByXPath("//div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/span[2]","GDAŃSK"));
    }
    @Test
    @Order(2)
    public void IncorrectrestaurantsFromSelectedCity() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",0);
        Browser.clickOnElementById("gdyniaSel");
        Assertions.assertFalse(Browser.assertTextByXPath("//div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/span[2]","GDAŃSK"));
    }
    @Test
    @Order(3)
    public void CorrectRestaurantCategory() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",0);
        Browser.clickOnElementById("gdanskSel");
        Browser.clickOnElementAjaxByXPath("//button[contains(text(),'Polska')]");
        Assertions.assertTrue(Browser.assertTextByXPath("//body/div[@id='app']/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[2]","POLSKA"));
    }
    @Test
    @Order(4)
    public void InCorrectRestaurantCategory() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",0);
        Browser.clickOnElementById("gdanskSel");
        Browser.clickOnElementAjaxByXPath("//button[contains(text(),'Polska')]");
        Assertions.assertFalse(Browser.assertTextByXPath("//body/div[@id='app']/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[2]","SUSHI"));
    }
}
