package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Menüsorból kiválasztott Java oldal
public class JavaPage {

    WebDriver driver;

    private final By TABLE_VIDEO = By.xpath("//*[@data-tabid=\"32\"]");
    private final By TABLE_NEWS = By.xpath("//*[@data-tabid='9']");

    //Almenüből a Videók kiválasztása
    public void clickOnVideo(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TABLE_VIDEO));
        driver.findElement(TABLE_VIDEO).click();
    }

    //Almenüből a Hírek kiválasztása
    public void clickOnNews(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TABLE_NEWS));
        driver.findElement(TABLE_NEWS).click();
    }

    public JavaPage(WebDriver driver){
        this.driver = driver;
    }
}
