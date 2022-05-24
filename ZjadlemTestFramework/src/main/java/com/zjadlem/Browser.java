package com.zjadlem;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Browser {

    //region Base webdriver operations
    static WebDriver driver = new ChromeDriver();

    public static void goTo(String url) {
        driver.get(url);
    }

    public static String title() {
        return driver.getTitle();
    }

    public static void close() {
        driver.close();
    }

    public static void clean() {

        driver.manage().deleteAllCookies();
    }

    public static void resize() {
        driver.manage().window().maximize();
    }

    //endregion

    //region Language change functions

    public static void changeLanguageToEnglish() throws InterruptedException {
        if (assertTitle("Zjadłem.pl | Podziel się swoją opinią!")) {
            Browser.clickOnElementById("profilePic");
            Browser.clickOnElementAjaxByXPath("(//button[@type='button'])[3]");
            Browser.clickOnElementAjaxByXPath("//div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/span[1]/span[1]/span[1]");
            Browser.clickOnElementById("profilePic");
        }

    }

    public static void changeLanguageToPolish() throws InterruptedException {
            Browser.clickOnElementById("profilePic");
            Browser.clickOnElementAjaxByXPath("(//button[@type='button'])[3]");
            Browser.clickOnElementAjaxByXPath("//font[contains(text(),'Polish')]");
    }
    //endregion

    //region Click operations

        //By ID
    public static void clickOnElementById(String id) {
        driver.findElement(By.id(id)).click();
    }

    public static void clickOnElementAjaxById(String id) {
        WebElement loginProfile = driver.findElement(By.id(id));
        Actions builder = new Actions(driver);
        builder.moveToElement(loginProfile).click().build().perform();
    }

        //By Css
    public static void clickOnElementByClassAndIndex(String clickClass, int index) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.className(clickClass)));
        List<WebElement> classClicks = driver.findElements(By.className(clickClass));
        classClicks.get(index).click();
    }

    public static void clickOnElementByCss(String css) {
        driver.findElement(By.cssSelector(css)).click();
    }

        // By XPath
    public static void clickOnElementAjaxByXPath(String xPath) {
        WebElement xPathAjaxClick = driver.findElement(By.xpath(xPath));
        Actions builder = new Actions(driver);
        builder.moveToElement(xPathAjaxClick).click().build().perform();
    }

    public static void clickOnElementByXpath(String xPath) {
        driver.findElement(By.xpath(xPath)).click();
    }

        //Mixed

    public static void clickOnElementByCssWithXPath(String xPath, String css) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        driver.findElement(By.cssSelector(css)).click();
    }

        //By name

    public static void clickOnElementByName(String name) {
        driver.findElement(By.name(name)).click();
    }


    //endregion

    //region Hoover

        //By Css

    public static void hooverOverElementByCss(String css) {
        WebElement hooverOverOnClassName = driver.findElement(By.cssSelector(css));
        Actions builder = new Actions(driver);
        builder.moveToElement(hooverOverOnClassName).perform();
    }

        //By Id

    public static void hooverOverElementById(String id) {
            WebElement hooverOverOnClassName = driver.findElement(By.id(id));
            Actions builder = new Actions(driver);
            builder.moveToElement(hooverOverOnClassName).perform();
        }

    //endregion

    //region Login operations

    public static void loginModerator() throws InterruptedException {
        Browser.clickOnElementByClassAndIndex("nav-item",3);

        if (Browser.assertTitle("Sign In with Auth0")){
            login("redacted","redacted"); // There were real credentials before upload to github.
        }
        Thread.sleep(1500);
    }

    public static void loginNonModerator() throws InterruptedException{
        Browser.clickOnElementByClassAndIndex("nav-item",3);

        if (Browser.assertTitle("Sign In with Auth0")){
            login("redacted","redacted"); There were real credentials before upload to github
        }
    }

    public static void checkLogin() throws InterruptedException {

        Browser.clickOnElementByClassAndIndex("nav-item",3);
        if (!Browser.assertTitle("Sign In with Auth0")){
            logout();
            Browser.clickOnElementByClassAndIndex("nav-item",3);
        }


    }

    public static void login(String login, String password) throws InterruptedException {

        Browser.delayForElementId("1-email");
        Browser.clickOnElementById("1-email");
        Browser.enterDataById("1-email",login);
        Browser.clickOnElementById("1-password");
        Browser.enterDataById("1-password",password);
        Browser.clickOnElementById("1-submit");
    }
    public static void logout() throws InterruptedException {
        Browser.clickOnElementAjaxById("profilePic");
        Browser.clickOnElementAjaxById("logout");
    }
    //endregion

    //region Assertions

    public static boolean checkIfDisabledByXPath(String xPath) {
        return driver.findElement(By.xpath(xPath)).getAttribute("aria-disabled").equals("true");
    }

    public static boolean assertTextByXPath(String xPath, String value) {
        return driver.findElement(By.xpath(xPath)).getText().equals(value);
    }

    public static boolean assertTextById(String id, String value) {
        List<WebElement> classClicks = driver.findElements(By.id(id));
        return !classClicks.get(1).equals(value);
    }

    public static boolean assertHrefByXPath(String xPath, String hRef) {
        return driver.findElement(By.xpath(xPath)).getAttribute("href").equals(hRef);
    }

    public static boolean assertTextByCss(String css, String value) {
        return driver.findElement(By.cssSelector(css)).equals(value);
    }

    public static boolean assertTextByClass(String clickClass, String value) {
        return driver.findElement(By.className(clickClass)).equals(value);
    }

    public static boolean assertTitle(String title) {
        return driver.getTitle().equals(title);
    }

    public static boolean assertNoElementPresent(String id) throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.id(id));
        return elements.size() > 0;
    }

    public static boolean assertNoElementPresentByCss(String css) throws InterruptedException {
        List<WebElement> elements = driver.findElements(By.cssSelector(css));
        return elements.size() > 0;
    }

    public static boolean asertTextByCss(String css, String value) {
        return !driver.findElement(By.cssSelector(css)).equals(value);
    }

    public static boolean assertPresentByXPath(String xPath) {
        return driver.findElement(By.xpath(xPath)).isDisplayed();
    }

    public static boolean assertPresentByCss(String css) {
        return driver.findElement(By.cssSelector(css)).isDisplayed();
    }

    //endregion

    //region Support for entering data

    public static void enterDataById(String id, String data) {
        driver.findElement(By.id(id)).sendKeys(data);
    }

    public static void enterDataByXPath(String xPath, String data) {
        driver.findElement(By.xpath(xPath)).sendKeys(data);
    }

    public static void delayForElementId(String id) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    //endregion

    //region Scrolling
    public static void scrollToXPath(String xPath) {
        WebElement n = driver.findElement(By.xpath(xPath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", n);
    }

    //endregion


}
