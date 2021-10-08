package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Beállítások; Személyes adatok oldala
public class AccountOptionsPersonal {

    WebDriver driver;

    private final By FAMILY_NAME = By.name("FAMILYNAME");
    private final By FIRST_NAME = By.name("FIRSTNAME");
    private final By COMMENT = By.name("COMMENT");
    private final By ADDRESS = By.name("ADDRESS");
    private final By GOOGLE_MAPS_BUTTON = By.xpath("//*[@class=\"pac-container\"]//*[@class=\"dismissButton\"]");
    private final By SUBMIT_CHANGES = By.name("settings-personal");

    //Vezetéknév mező kitöltése
    public void addFamilyName(String FaName){
        driver.findElement(FAMILY_NAME).click();
        driver.findElement(FAMILY_NAME).clear();
        driver.findElement(FAMILY_NAME).sendKeys(FaName);
    }

    //Keresztnév kitöltése
    public void addFirstName(String FiName){
        driver.findElement(FIRST_NAME).click();
        driver.findElement(FIRST_NAME).clear();
        driver.findElement(FIRST_NAME).sendKeys(FiName);
    }

    //Bemutatkozás kitöltése
    public void addComment(String CommentText){
        driver.findElement(COMMENT).click();
        driver.findElement(COMMENT).clear();
        driver.findElement(COMMENT).sendKeys(CommentText);
    }

    //Jelenlegi lakhely hozzáadása
    public void addAddress(String MyAddress){
        driver.findElement(ADDRESS).click();
        driver.findElement(ADDRESS).clear();
        driver.findElement(ADDRESS).sendKeys(MyAddress);
    }

    //Felugró ablak Google maps ablak leokézása. Headlessben nincs rá szükség
    public void acceptGoogle(){
        try{
            driver.findElement(GOOGLE_MAPS_BUTTON).click();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Változások mentése gomb klikkelése
    public void submitChanges() throws InterruptedException {
        driver.findElement(SUBMIT_CHANGES).click();
        Thread.sleep(1000);
    }

    //kitöltött Vezetéknév mező validálása
    public String getFieldName(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FAMILY_NAME));
        String result = driver.findElement(FAMILY_NAME).getAttribute("value");
        return result;
    }

    //Bemutatkozó mező kiegészítése
    public void changeComment(){
        driver.findElement(COMMENT).click();
        driver.findElement(COMMENT).sendKeys(",és ez nagyon boldoggá tesz!");
    }

    //Bemutatkozó mező kiegészítésének validálása
    public String validateChanges() {
        String result = driver.findElement(COMMENT).getText();
        return result;
    }

    //Vezetéknév eltávolítása
    public void removeFamilyName(){
        driver.findElement(FAMILY_NAME).click();
        driver.findElement(FAMILY_NAME).clear();
    }

    //Keresztnév eltávolítása
    public void removeFirstName(){
        driver.findElement(FIRST_NAME).click();
        driver.findElement(FIRST_NAME).clear();
    }

    //Bemutatkozás eltávolítása
    public void removeComment(){
        driver.findElement(COMMENT).click();
        driver.findElement(COMMENT).clear();
    }

    //Jelenlegi lakhely eltávolítása
    public void removeAddress(){
        driver.findElement(ADDRESS).click();
        driver.findElement(ADDRESS).clear();
    }

    //Eltávolított Vezetéknév mező validálása
    public String getRemovedFieldName(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FAMILY_NAME));
        String result = driver.findElement(FAMILY_NAME).getAttribute("value");
        return result;
    }

    public AccountOptionsPersonal(WebDriver driver){
        this.driver = driver;
    }
}
