package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Kereső mezőben keresés utáni hírek oldal
public class SearchNews {

    WebDriver driver;

    private final By SEARCH_BOX = By.xpath("//*[@class = \"newinputform default\"]");
    private final By VALIDATE_TITLE = By.xpath("//*[@class=\"input\"]//*[@name=\"oc\"]/*[@value=\"9\"]");
    private final By FALSE_TITLE = By.xpath("//*[@class=\"input\"]//*[@name=\"oc\"]/*[@value=\"20\"]");

    //Keresőfeltételeken belüli Keresés helyének validálása
    public boolean validateSearch(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_BOX));
        boolean title = driver.findElement(VALIDATE_TITLE).isSelected();
        return title;
    }

    //Keresőfeltételeken belüli Keresés helyének validálása
    public boolean falseSearch(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_BOX));
        boolean title = driver.findElement(FALSE_TITLE).isSelected();
        return title;
    }

    public SearchNews(WebDriver driver) {
        this.driver = driver;
    }
}
