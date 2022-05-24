package com.zjadlemtrzeci;

import com.zjadlem.Browser;
import com.zjadlem.Pages;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RemoveOpinion {
    @BeforeEach
    public void resize() throws InterruptedException {
    }
    @Test
    @Order(1)
    public void RemoveOpionionPresenceNonModerator() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clean();
        Browser.resize();
        Browser.loginNonModerator();
        Browser.clickOnElementByClassAndIndex("nav-item",0);
        Browser.clickOnElementById("sopotSel");
        Browser.clickOnElementAjaxByXPath("(//button[@id='szczegoly'])[2]");
        Assertions.assertFalse(Browser.assertNoElementPresent("usunOp"));
        Browser.logout();
    }
    @Test
    @Order(2)
    public void RemoveOpionionCancel() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.loginModerator();
        Browser.clickOnElementByClassAndIndex("nav-item",0);
        Browser.clickOnElementById("sopotSel");
        Browser.clickOnElementAjaxByXPath("(//button[@id='szczegoly'])[2]");
        Browser.clickOnElementById("usunOp");
        Browser.clickOnElementAjaxByXPath("//div[@id='bv-modal-usuwanie___BV_modal_body_']/div[2]/button");
        Browser.assertTextByXPath("//div[contains(text(),'testuser@test.com')]","testuser@test.com");
    }
    @Test
    @Order(3)
    public void RemoveOpionion() throws InterruptedException{
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",0);
        Browser.clickOnElementById("sopotSel");
        Browser.clickOnElementAjaxByXPath("(//button[@id='szczegoly'])[2]");
        Browser.clickOnElementById("usunOp");
        Browser.clickOnElementAjaxByXPath("//div[@id='bv-modal-usuwanie___BV_modal_body_']/div[2]/button[2]");
        Assertions.assertTrue(Browser.assertNoElementPresentByCss(".alert"));
    }
    @AfterAll
    public static void cleanUp() throws InterruptedException {
        Browser.clickOnElementByCss("div > .vue-star-rating > .vue-star-rating > .vue-star-rating-pointer:nth-child(4) polygon:nth-child(4)");
        Browser.clickOnElementByXpath("//button[contains(text(),'Oceń')]");
        Browser.logout();
    }
}
