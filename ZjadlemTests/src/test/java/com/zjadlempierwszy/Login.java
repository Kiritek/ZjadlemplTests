package com.zjadlempierwszy;

import com.zjadlem.Browser;
import com.zjadlem.Pages;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Login {
    @BeforeEach
    public void resize() throws InterruptedException {

    }

    @Test
    @Order(1)
    public void loginWithGoogle() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clean();
        Browser.resize();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Browser.clickOnElementByClassAndIndex("auth0-lock-social-big-button",1);
        Assertions.assertTrue(Browser.assertTitle("Logowanie – Konta Google"));
    }
    @Test
    @Order(2)
    public void usernameWithoutPassword() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Browser.delayForElementId("1-email");
        Browser.clickOnElementById("1-email");
        Browser.enterDataById("1-email","testuser@test.com");
        Browser.clickOnElementById("1-submit");
        Browser.assertTextByClass("auth0-lock-error-invalid-hint","Password can't be blank");
    }
    @Test
    @Order(3)
    public void passwordWithoutUserName() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Browser.delayForElementId("1-password");
        Browser.clickOnElementById("1-password");
        Browser.enterDataById("1-password","testtest1234!@#$");
        Browser.clickOnElementById("1-submit");
        Browser.assertTextByClass("auth0-lock-error-invalid-hint","Email can't be blank");
    }

    @Test
    @Order(4)
    public void loginWithZjadlemThroughProfile() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementAjaxById("profilePic");
        Browser.clickOnElementAjaxById("login");
        Browser.delayForElementId("1-email");
        Browser.clickOnElementById("1-email");
        Browser.enterDataById("1-email","testuser@test.com");
        Browser.clickOnElementById("1-password");
        Browser.enterDataById("1-password","testtest1234!@#$");
        Browser.clickOnElementById("1-submit");
        Browser.clickOnElementAjaxById("profilePic");
        Browser.assertTextByCss("#loggedUser > span","Witaj testuser@test.com!");
        Browser.clickOnElementAjaxById("logout");
    }
    @Test
    @Order(5)
    public void loginWithZjadlemThroughMyZjadlem() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Browser.delayForElementId("1-email");
        Browser.clickOnElementById("1-email");
        Browser.enterDataById("1-email","testuser@test.com");
        Browser.clickOnElementById("1-password");
        Browser.enterDataById("1-password","testtest1234!@#$");
        Browser.clickOnElementById("1-submit");
        Browser.clickOnElementAjaxById("profilePic");
        Browser.assertTextByCss("#loggedUser > span","Witaj testuser@test.com!");
        Browser.clickOnElementAjaxById("logout");
    }

}
