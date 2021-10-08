package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//Java videók oldala
public class JavaVideoPage {

    WebDriver driver;

    private final By NEXT_BUTTON = By.xpath("//*[@class=\"next\"]");
    private final By TITLE_LIST = By.xpath("//*[@class=\"videolist\"]//h2");

    //Következő gomb lenyomása,és a videók címének txt fájlba írása
    public void writeTitlesToFile() throws IOException {
        List<WebElement> buttonsList = driver.findElements(NEXT_BUTTON);
        FileWriter myWriter = new FileWriter("videotitles.txt", false); //false = overwrite,true=folytatja
        for (int i = 0; i < buttonsList.size(); i++) {
            List<WebElement> videoList = driver.findElements(TITLE_LIST);
            for (int j = 0; j < videoList.size(); j++) {
                String titles = videoList.get(j).getText();
                myWriter.write(titles + "\n");
            }
            try {
                driver.findElement(NEXT_BUTTON).click();
            } catch (Exception e) {
                break;
            }
        }
        myWriter.close();
    }

    //Txt fájl kiolvasása
    public String readTitlesFile(){
        String title= "";
        try{
            File file = new File("videotitles.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                title += scanner.nextLine() + "\n";
            }
        }catch(FileNotFoundException e){
            e.getMessage();
        }
        if((title !=null)&&(title.length()>0)){
            title = title.substring(0,title.length() -1);
        }
        return title;
    }

    public JavaVideoPage(WebDriver driver){
        this.driver = driver;
    }
}
