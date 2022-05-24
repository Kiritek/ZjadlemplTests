package com.zjadlemdrugi;

import com.zjadlem.Browser;
import com.zjadlem.Pages;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProfilePage {
    @BeforeEach
    public void resize() throws InterruptedException {
    }

    @Test
    @Order(1)
    public void testProfile() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.resize();
        Browser.loginModerator();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Assertions.assertTrue(Browser.assertTextByXPath("//h1[contains(text(),'Twój profil Smakosza')]","TWÓJ PROFIL SMAKOSZA"));
    }
    @Test
    @Order(2)
    public void testProfileOceny() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Browser.clickOnElementByCss(".table-b-table-default:nth-child(4) > div");
        Assertions.assertTrue(Browser.assertTextByXPath("//div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]","1"));

    }
    @Test
    @Order(3)
    public void testProfileRestauracje() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Browser.clickOnElementByCss(".table-b-table-default:nth-child(1) > div");
        Assertions.assertTrue(Browser.assertTextByXPath("//div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]","GRUBY BENEK"));
    }
    @Test
    @Order(4)
    public void testProfileAddFriendCorrectly() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Browser.clickOnElementAjaxByXPath("//a[contains(text(),'Dodaj znajomego')]");
        Browser.clickOnElementByXpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/div[2]/div[2]/div[1]/input[1]");
        Browser.enterDataByXPath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/div[2]/div[2]/div[1]/input[1]","ozdzinskipiotr@gmail.com");
        Browser.clickOnElementByXpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/div[2]/div[2]/div[1]/input[2]");
        Browser.enterDataByXPath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/div[2]/div[2]/div[1]/input[2]","12345");
        Browser.clickOnElementByCss("div.card.theCard:nth-child(2) div.card-body.text-center.interior div.menuSmakosza div.tabs:nth-child(3) div.tab-content.mt-3:nth-child(2) div.tab-pane.active:nth-child(4) div.panel div.kolumna:nth-child(2) div:nth-child(2) > button.btn.btn-outline-secondary.btn-sm.rounded-pill");
        Assertions.assertTrue(Browser.assertPresentByCss(".bi-check path"));
    }

    @Test
    @Order(5)
    public void testProfileAddFriendIncorrectly() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Browser.clickOnElementAjaxByXPath("//a[contains(text(),'Dodaj znajomego')]");
        Browser.clickOnElementByXpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/div[2]/div[2]/div[1]/input[1]");
        Browser.enterDataByXPath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/div[2]/div[2]/div[1]/input[1]","ozdzinskipiotr@gmail.com");
        Browser.clickOnElementByXpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/div[2]/div[2]/div[1]/input[2]");
        Browser.enterDataByXPath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/div[2]/div[2]/div[1]/input[2]","123457");
        Browser.clickOnElementByCss("div.card.theCard:nth-child(2) div.card-body.text-center.interior div.menuSmakosza div.tabs:nth-child(3) div.tab-content.mt-3:nth-child(2) div.tab-pane.active:nth-child(4) div.panel div.kolumna:nth-child(2) div:nth-child(2) > button.btn.btn-outline-secondary.btn-sm.rounded-pill");
        Assertions.assertTrue(Browser.assertPresentByCss(".bi-x path"));
    }
    @Test
    @Order(6)
    public void testProfileAddFriendCodeCorrectly() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Browser.clickOnElementAjaxByXPath("//a[contains(text(),'Dodaj znajomego')]");
        Browser.clickOnElementByXpath("//div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/div[2]/div[1]/div[2]/form[1]/div[1]/input[1]");
        Browser.enterDataByXPath("//div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/div[2]/div[1]/div[2]/form[1]/div[1]/input[1]","12345");
        Browser.clickOnElementAjaxById("button_zmienKod");
        Browser.clickOnElementAjaxByXPath("//button[contains(text(),'Pokaż/ukryj')]");
        Browser.clickOnElementByCss("div.card.theCard:nth-child(2) div.card-body.text-center.interior div.menuSmakosza div.tabs:nth-child(3) div.tab-content.mt-3:nth-child(2) div.tab-pane.active:nth-child(4) div.panel div.kolumna:nth-child(1) div:nth-child(1) span:nth-child(1) > strong:nth-child(1)");
        Assertions.assertTrue(Browser.assertTextByXPath("//strong[contains(text(),'12345')]","12345"));

    }
    @Test
    @Order(7)
    public void testProfileAddFriendCodeIncorrectly() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Browser.clickOnElementAjaxByXPath("//a[contains(text(),'Dodaj znajomego')]");
        Browser.clickOnElementByXpath("//div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/div[2]/div[1]/div[2]/form[1]/div[1]/input[1]");
        Browser.enterDataByXPath("//div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]/div[2]/div[1]/div[2]/form[1]/div[1]/input[1]","123457882423421312412412234213213");
        Assertions.assertTrue(Browser.assertTextByXPath("//div[contains(text(),'Podaj kod (Minimum 5 znaków, maksimum 20)')]","PODAJ KOD (MINIMUM 5 ZNAKÓW, MAKSIMUM 20)"));

    }
    @AfterAll
    public static void cleanUp() throws InterruptedException {
        Browser.logout();
        Browser.clean();
    }
}
