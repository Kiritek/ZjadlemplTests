package com.zjadlem;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ReportContent {
    @BeforeEach
    public void resize() throws InterruptedException {
    }

    @Test
    @Order(1)
    public void ReportOpinionNonLogged() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clean();
        Browser.resize();
        Browser.clickOnElementByClassAndIndex("nav-item",0);
        Browser.clickOnElementById("sopotSel");
        Browser.clickOnElementAjaxByXPath("(//button[@id='szczegoly'])[2]");
        Assertions.assertFalse(Browser.assertNoElementPresent("repOp"));
    }
    @Test
    @Order(2)
    public void ReportOpinionLoggedCancel() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.loginModerator();
        Browser.clickOnElementByClassAndIndex("nav-item",0);
        Browser.clickOnElementById("sopotSel");
        Browser.clickOnElementAjaxByXPath("(//button[@id='szczegoly'])[2]");
        Browser.clickOnElementAjaxById("repOp");
        Browser.clickOnElementAjaxByXPath("//button[contains(.,'Anuluj')]");
        Assertions.assertFalse(Browser.assertNoElementPresentByCss(".alert"));

    }
    @Test
    @Order(3)
    public void ReportOpinionLogged() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",0);
        Browser.clickOnElementById("sopotSel");
        Browser.clickOnElementAjaxByXPath("(//button[@id='szczegoly'])[2]");
        Browser.clickOnElementAjaxById("repOp");
        Browser.clickOnElementAjaxByXPath("//button[contains(.,'Zgloś')]");
        Assertions.assertTrue(Browser.assertNoElementPresentByCss(".alert"));



    }
    @AfterAll
    public static void cleanUp() throws InterruptedException {
        Browser.logout();
        Browser.clean();
    }
}
