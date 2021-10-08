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

    //Regisztráció gombra klikkelés
    public void selectRegistration(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(REGISTRATION));
        driver.findElement(REGISTRATION).click();
    }

    //Regisztráció oldalán nicknév beírása
    public void typeRegistrationNick(String nick){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id,\"fancybox-frame\")]")));
        driver.findElement(REGISTRATION_NICK).click();
        driver.findElement(REGISTRATION_NICK).sendKeys(nick);
    }

    //Regisztráció oldalán már beregisztrált nicknév beírása
    public void typeRegistrationUsedNick(){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id,\"fancybox-frame\")]")));
        driver.findElement(REGISTRATION_NICK).click();
        driver.findElement(REGISTRATION_NICK).sendKeys("dancas");
    }

    //Regisztrációs hibaüzenet megkapása
    public String registrationErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(REGISTRATION_ERROR));
        String error = driver.findElement(REGISTRATION_ERROR).getText();
        return error;
    }

    //Regisztráció oldalán e-mail beírása
    public void typeRegistrationEmail(String email){
        driver.findElement(REGISTRATION_EMAIL).click();
        driver.findElement(REGISTRATION_EMAIL).sendKeys(email);
    }

    //Regisztráció oldalán már beregisztrált e-mail használata
    public void typRegistrationUsedEmail(){
        driver.findElement(REGISTRATION_EMAIL).click();
        driver.findElement(REGISTRATION_EMAIL).sendKeys("daniatesztelo@gmail.com");
    }

    //Hírlevél checkbox kipipálásának levétele
    public void deselectSubScribe(){
        WebElement checkbox = driver.findElement(REGISTRATION_SUBSCRIBE_CHECKBOX);
        if(checkbox.isSelected()){
            driver.findElement(REGISTRATION_SUBSCRIBE_CHECKBOX).click();
        }else{
            System.out.println("Subscribe checkbox is not selected" );
        }
    }

    //Használati szerződés checkbox kipipálása
    public void acceptRegistrationTerms(){
        WebElement checkbox = driver.findElement(REGISTRATION_ACCEPT_TERMS_CHECKBOX);
        if(!checkbox.isSelected()){
            driver.findElement(REGISTRATION_ACCEPT_TERMS_CHECKBOX).click();
        }else{
            System.out.println("Terms and Conditions are already accepted");
        }
    }

    //Regisztráció véglegesítése
    public void submitRegistration(){
        driver.findElement(REGISTRATION_SUBMIT).click();
    }

    //Regisztráció véglegesítésének validálása
    public boolean isRegistrationCompleted(){
        boolean message;
        try{
            driver.findElement(REGISTRATION_COMPLETED).isDisplayed();
            message = true;
        }catch(WebDriverException e){
            System.out.println("Error during registration,please enter new nickname and email address");
            message = false;
        }
        return message;
    }

    //Belépésre kattintás
    public void selectLogin(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN));
        driver.findElement(LOGIN).click();
    }

    //E-mail cím mezőbe írás
    public void typeEmail(String email){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id,'fancybox-frame')]")));
        driver.findElement(EMAIL).sendKeys(email);
    }

    //Jelszó mezőbe írás
    public void typePassword(String password){
        driver.findElement(PASSWORD).click();
        driver.findElement(PASSWORD).sendKeys(password);
    }

    //Belépés gombra kattintás
    public void submitButton(){
        driver.findElement(SUBMIT).click();
    }

    //Belépés létrejöttének validálása
    public String getLoggedInText(){
        driver.switchTo().defaultContent();
        String loggedIn = driver.findElement(USERNAME_MENU).getText();
        return loggedIn;
    }

    //Belépés sikertelenségének validálása
    public String wrongDatas(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(WRONG_EMAIL_OR_PASSWORD_MESSAGE));
        String errorMessage = driver.findElement(WRONG_EMAIL_OR_PASSWORD_MESSAGE).getText();
        return errorMessage;
    }

}
