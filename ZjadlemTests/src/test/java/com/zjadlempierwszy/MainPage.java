package com.zjadlempierwszy;

import com.zjadlem.Browser;
import com.zjadlem.Pages;
import org.junit.jupiter.api.*;
public class MainPage {

    @BeforeEach
    public void resize() throws InterruptedException {

    }

    @Test
    public void checkMaklowiczPresence() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clean();
        Browser.resize();
        Assertions.assertTrue(Browser.assertPresentByCss(".card:nth-child(1) .backgroundImage"));
        Assertions.assertTrue(Browser.assertPresentByCss(".card:nth-child(2) .backgroundImage"));
        Assertions.assertTrue(Browser.assertPresentByCss(".card:nth-child(3) .backgroundImage"));
    }
    @Test
    public void checkBackgroundPresence() throws InterruptedException{
        Pages.homePage().goTo();
        Assertions.assertTrue(Browser.assertPresentByXPath("//body/div[@id='app']/div[2]/div[1]/div[1]/div[2]"));
    }

    @Test
    public void checkFooter() throws  InterruptedException{
        Pages.homePage().goTo();
        Browser.scrollToXPath("//footer/div/div/div");
        Assertions.assertTrue(Browser.assertTextByXPath("//footer/div/div/div","ZJADLEM.PL 2022"));
    }
    @AfterAll
    public static void cleanUp(){
    }


}
