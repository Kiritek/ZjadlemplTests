package com.zjadlemtrzeci;

import com.zjadlem.Browser;
import com.zjadlem.Pages;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AboutUsModule {
    @BeforeEach
    public void resize() throws InterruptedException {
    }

    @Test
    @Order(1)
    public void aboutUsNavbar() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clean();
        Browser.resize();
        Browser.clickOnElementByClassAndIndex("nav-item",2);
        Assertions.assertTrue(Browser.assertTitle("Zjadłem.pl | Dowiedz się więcej!"));
    }
    @Test
    @Order(2)
    public void aboutUsText() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",2);
        Assertions.assertTrue(Browser.assertTextByXPath("//div[1]/div[2]/div[1]/div[1]/div[2]/div[1]","Istnieje wiele serwisów, w których możemy oceniać filmy, gry czy np. książki. Lecz brakowało nam przestrzeni, w której otrzymalibyśmy recenzje innych, o lokalach restauracyjnych oraz ich daniach. Dlatego w tym miejscu, pojawia się młody, ambitny zespół, ze Zjadłem.pl - Nie spotkaliśmy się nigdy ze stroną, która umożliwiałaby podejrzenie menu restauracji, z podpiętymi do niej recenzjami gości, dlatego postanowiliśmy stworzy własną."));
    }
    @Test
    @Order(3)
    public void aboutUsHyperlink() throws InterruptedException {
        Pages.homePage().goTo();
        Browser.clickOnElementByClassAndIndex("nav-item",2);
        Assertions.assertTrue(Browser.assertHrefByXPath("//div[@id='app']/div[2]/div[1]/div[1]/div[2]/div[3]/a[1]","mailto:zjadlempl@gmail.com"));
    }
    @AfterAll
    public static void cleanUp() throws InterruptedException {

    }

}
