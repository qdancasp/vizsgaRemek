package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Beállítások; Felhasználói fiók oldala
public class AccountOptions {

    WebDriver driver;

    private final By PERSONAL = By.xpath("//a[@href=\"/azonosito/?op=options&tab=personal\"]");

    //Felhasználó fiók aloldalról átnavigálás a Személyes adatokra
    public void clickOnPersonal(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-350)", "");
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(PERSONAL));
        driver.findElement(PERSONAL).click();
    }

    public AccountOptions(WebDriver driver){
        this.driver = driver;
    }
}
