package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Prog.hu ikon melletti legördülő menüből nyíló Tudástár oldal
public class KnowledgeList {

    WebDriver driver;

    private final By KNOWLEDGE_TITLE = By.xpath("//*[@class=\"contenttitle entry-title\"]//*[@href=\"/tudastar/\"]");

    //Keresés helyének validálása
    public String getKnowledgeTitle(){
        String result = driver.findElement(KNOWLEDGE_TITLE).getText();
        return result;
    }

    public KnowledgeList(WebDriver driver){
        this.driver = driver;
    }
}
