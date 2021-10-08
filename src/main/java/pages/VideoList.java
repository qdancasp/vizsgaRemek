package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Prog.hu ikon melletti legördülő menüből nyíló Videók oldal
public class VideoList {

    WebDriver driver;

    private final By VIDEO_TITLE = By.xpath("//*[@class=\"contenttitle entry-title\"]//*[@href=\"/mediatar/\"]");

    //Keresés helyének validálása
    public boolean isVideoTitlePresent(){
        boolean result = driver.findElement(VIDEO_TITLE).isDisplayed();
        return result;
    }

    public VideoList(WebDriver driver){
        this.driver = driver;
    }
}