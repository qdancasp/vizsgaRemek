package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Prog.hu ikon melletti legördülő menüből nyíló Társalgó oldal
public class ForumList {

    WebDriver driver;

    private final By FORUM_TITLE = By.xpath("//*[@class=\"contenttitle entry-title\"]//*[@href=\"/tarsalgo/\"]");

    //Keresés helyének validálása
    public boolean isForumTitlePresent(){
        boolean result = driver.findElement(FORUM_TITLE).isDisplayed();
        return result;
    }

    public ForumList(WebDriver driver){
        this.driver = driver;
    }
}
