package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Java hírek oldala
public class JavaNewsPage {

    WebDriver driver;

    private final By NEXT_BUTTON = By.xpath("//*[@class=\"pages\"]//*[@class=\"next\"]");

    //Következő oldalra navigáló gomb leklikkelése
    public void loopThroughPages() {
        while(true){
            try{
                WebDriverWait wait = new WebDriverWait(driver,10);
                wait.until(ExpectedConditions.elementToBeClickable(NEXT_BUTTON));
                driver.findElement(NEXT_BUTTON).click();
            }catch(Exception e){
                break;
            }
        }
    }

    //Validálás,hogy az utolsó oldalra értünk
    public boolean isNextButtonVisible(){
        boolean nextButton = false;
        try{
            driver.findElement(NEXT_BUTTON).isDisplayed();
        }catch(WebDriverException e){
            nextButton = true;
        }
        return nextButton;
    }

    public JavaNewsPage(WebDriver driver){
        this.driver = driver;
    }
}
