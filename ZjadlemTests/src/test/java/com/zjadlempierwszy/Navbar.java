package com.zjadlempierwszy;

import com.zjadlem.Browser;
import com.zjadlem.Pages;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Navbar {
    @BeforeEach
    public void resize() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clean();
        Browser.resize();
    }
    @Test
    public void areShopsDisabled() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",1);
        Assertions.assertTrue(Browser.checkIfDisabledByXPath("//div[1]/div[1]/div/nav/div[2]/ul/li[2]/ul/li[1]/a"));
        Assertions.assertTrue(Browser.checkIfDisabledByXPath("//div[1]/div[1]/div/nav/div[2]/ul/li[2]/ul/li[2]/a"));
        Assertions.assertTrue(Browser.checkIfDisabledByXPath("//div[1]/div[1]/div/nav/div[2]/ul/li[2]/ul/li[3]/a"));
    }

    @Test
    public void loginThroughMyZjadlem() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",3);
        Assertions.assertTrue(Browser.assertTitle("Sign In with Auth0"));
    }
    @Test
    public void loginThoughProfileIcon() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementAjaxById("profilePic");
        Browser.clickOnElementAjaxById("login");
        Assertions.assertTrue(Browser.assertTitle("Sign In with Auth0"));
    }

    @AfterAll
    public static void cleanUp(){
    }
}
