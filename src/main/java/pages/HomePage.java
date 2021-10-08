package pages;

import org.openqa.selenium.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

//Prog.hu weboldal
public class HomePage {

    WebDriver driver;

    private final By COOKIES = By.xpath("//*[@id=\"cookieconsentbar\"]/div/a");
    private final By COOKIE_CONTENT = By.xpath("//*[@class=\"content\"]");
    private final By TERMS_OPTIONS = By.xpath("//*[contains(@aria-label,'Beállítások kezelése')]/*[contains(@class,'fc-button-label')]");
    private final By TERMS_OPTIONS_TITLES = By.xpath("//*[@class=\"fc-dialog fc-data-preferences-dialog\"]//h2");
    private final By TERMS_ACCEPT_CONFIRM = By.xpath("//*[@class=\"fc-button fc-confirm-choices fc-primary-button\"]");
    private final By LOGIN = By.id("pageloginlink");
    private final By EMAIL = By.name("email");
    private final By PASSWORD = By.name("password");
    private final By SUBMIT = By.xpath("//*[@id=\"login-site\"]//*[contains(@name,'login-site')]");
    private final By USERNAME_MENU = By.id("usernickname");
    private final By OPTIONS = By.xpath("//*[@id=\"userbarcontainer\"]//*[@id='usernickname']//*[@class='profile']");
    private final By LOGOUT = By.xpath("//*[@id=\"userbarcontainer\"]//*[@id='usernickname']//*[@class='logout']");
    private final By MENU_BAR = By.xpath("//*[@id=\"pagemenu\"]/span");
    private final By MENU_BAR_NEWS = By.xpath("//*[@id=\"mainmenu\"]//*[@href=\"/hirek/\"]");
    private final By MENU_BAR_VIDEOS = By.xpath("//*[@id=\"mainmenu\"]//*[@href=\"/mediatar/\"]");
    private final By MENU_BAR_FORUM = By.xpath("//*[@id=\"mainmenu\"]//*[@href=\"/tarsalgo/\"]");
    private final By MENU_BAR_KNOWLEDGE_BASE = By.xpath("//*[@id=\"mainmenu\"]//*[@href=\"/tudastar/\"]");
    private final By MENU_BAR_ARTICLES = By.xpath("//*[@id=\"mainmenu\"]//*[@href=\"/cikkek/\"]");
    private final By SEARCH_BAR = By.id("expr");
    private final By PRESS_SEARCH = By.xpath("//*[@id=\"pagesearchform\"]//*[@type = \"submit\"]");
    private final By WRONG_EMAIL_OR_PASSWORD_MESSAGE = By.xpath("//*[@class=\"messageline error\"][1]");
    private final By MENU_BAR_JAVA = By.xpath("//*[@href=\"/cimkek/java\"]");
    private final By REGISTRATION = By.id("pageregisterlink");
    private final By REGISTRATION_NICK = By.name("NAME");
    private final By REGISTRATION_EMAIL = By.name("EMAIL");
    private final By REGISTRATION_SUBSCRIBE_CHECKBOX = By.name("subscribe");
    private final By REGISTRATION_ACCEPT_TERMS_CHECKBOX = By.name("accept");
    private final By REGISTRATION_SUBMIT = By.name("login-midcol");
    private final By REGISTRATION_COMPLETED = By.xpath("//*[@class=\"contenttitle entry-title\"]");
    private final By REGISTRATION_ERROR = By.xpath("//*[@class=\"error\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Adatvédelmi nyilatkozat elfogadása
    public void acceptTerms(){
        try{
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.elementToBeClickable(TERMS_OPTIONS));
            driver.findElement(TERMS_OPTIONS).click();
            wait.until(ExpectedConditions.elementToBeClickable(TERMS_ACCEPT_CONFIRM));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350)");
            driver.findElement(TERMS_ACCEPT_CONFIRM).click();
        }catch(Exception ignore){
            ignore.printStackTrace();
        }
    }

    //Sütik elfogadása
    public void acceptCookies(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(COOKIES));
        wait.until(ExpectedConditions.elementToBeClickable(COOKIES));
        driver.findElement(COOKIES).click();
    }

    //Süti elfogadás validálása
    public boolean isCookieContentVisible(){
        boolean button;
        try{
            driver.findElement(COOKIE_CONTENT).isDisplayed();
            button = false;
        }catch(WebDriverException e){
            button = true;
        }
        return button;
    }

    //Adatvédelmi nyilatkozat beállításaira navigálás
    public void termsOptions(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(TERMS_OPTIONS));
        driver.findElement(TERMS_OPTIONS).click();
    }

    //Adatvédelmi nyilatkozat címeinek kinyerése
    public List<String> getTermsTitles(){
        List<String> result = new ArrayList<>();
        List<WebElement> titleList = driver.findElements(TERMS_OPTIONS_TITLES);
        for (WebElement webElement : titleList){
            result.add(webElement.getText());
        }
        return result;
    }

    //Minden adatvédelmi nyilatkozati pont elfogadása
    public void acceptAllTerms() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(TERMS_ACCEPT_CONFIRM));
        driver.findElement(TERMS_ACCEPT_CONFIRM).click();
    }
}
