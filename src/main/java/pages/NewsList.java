package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Prog.hu ikon melletti legördülő menüből nyíló Hírek oldal
public class NewsList {

    WebDriver driver;

    private final By NEWS_TITLE = By.xpath("//*[@class=\"contenttitle entry-title\"]//*[@href=\"/hirek/\"]");

    //Keresés helyének validálása
    public boolean isNewsTitlePresent(){
        boolean result = driver.findElement(NEWS_TITLE).isDisplayed();
        return result;
    }

    public NewsList(WebDriver driver){
        this.driver = driver;
    }
}
