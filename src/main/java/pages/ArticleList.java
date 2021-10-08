package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Prog.hu ikon melletti legördülő menüből nyíló Cikkek oldal
public class ArticleList {

    WebDriver driver;

    private final By ARTICLE_TITLE = By.xpath("//*[@class=\"url\"][@href=\"/cikkek/?op=view\"]");

    //Keresés helyének validálása
    public String getArticleTitle(){
        String result = driver.findElement(ARTICLE_TITLE).getText();
        return result;
    }

    public ArticleList(WebDriver driver){
        this.driver = driver;
    }
}
