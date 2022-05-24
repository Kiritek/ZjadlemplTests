package com.zjadlemdrugi;

import com.zjadlem.Browser;
import com.zjadlem.Pages;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EnglishModule {


    @Test
    @Order(1)
    public void testEnglishMainPage() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.resize();
        Browser.changeLanguageToEnglish();
        Assertions.assertTrue(Browser.assertTextByXPath("//div[2]/div[1]/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]/span[1]","RESTAURANTS"));
        Assertions.assertTrue(Browser.assertTextByXPath("//div[2]/div[1]/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]/span[1]","SHOPS"));
        Assertions.assertTrue(Browser.assertTextByXPath("//div[2]/div[1]/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]/span[1]","ABOUT US"));
        Assertions.assertTrue(Browser.assertTextByXPath(" //div[2]/div[1]/div[1]/nav[1]/div[2]/ul[1]/li[4]/a[1]","I ATE MINE"));
        Assertions.assertTrue(Browser.assertTextByXPath("//div[2]/div[1]/div[1]/nav[1]/div[1]/div[1]/div[1]/a[1]","SEARCH"));
    }
    @Test
    @Order(2)
    public void testEnglishRestaurants() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",0);
        Browser.clickOnElementById("gdanskSel");
        Assertions.assertTrue(Browser.assertTextByXPath("//div[@id='wyborKuchni']/font/font","KITCHEN:"));
        Assertions.assertTrue(Browser.assertTextByXPath("//button[@id='szczegoly']/font/font","SEE MORE"));
    }
    @Test
    @Order(3)
    public void testProfile() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.loginModerator();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Assertions.assertTrue(Browser.assertTextByXPath("//div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]","ASSESSMENT"));
        Assertions.assertTrue(Browser.assertTextByXPath("//div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/h1[1]/font[1]/font[1]","YOUR GOURMET PROFILE"));

    }
    @AfterAll
    public static void cleanUp() throws InterruptedException {
        Browser.logout();
        Browser.changeLanguageToPolish();
        Browser.clean();
    }

}
