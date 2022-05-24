package com.zjadlem;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FriendProfilePage {

    @BeforeEach
    public void resize() throws InterruptedException {

    }

    @Test
    @Order(1)
    public void CheckFriendProfilePageAt() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clean();
        Browser.resize();
        Browser.loginModerator();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Browser.clickOnElementAjaxByXPath("//a[contains(text(),'Moi Znajomi')]");
        Browser.clickOnElementAjaxByXPath("//td/span");
        Assertions.assertTrue(Browser.assertTitle("Zjadłem.pl | Profil znajomego"));
    }
    @Test
    @Order(2)
    public void CheckFriendProfilePageReviews() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Browser.clickOnElementAjaxByXPath("//a[contains(text(),'Moi Znajomi')]");
        Browser.clickOnElementAjaxByXPath("//td/span");
        Assertions.assertTrue(Browser.assertTextByXPath("//td","CHIŃSKI WIATR STARÓWKA"));
    }
    @AfterAll
    public static void cleanUp() throws InterruptedException {
        Browser.logout();
        Browser.clean();

    }
}
