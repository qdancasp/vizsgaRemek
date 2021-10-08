package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    public WebDriver driver;
    protected HomePage homePage;
    protected String email = "daniatesztelo@gmail.com";
    protected String pw = "12345678";

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--incognito");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--headless");
        options.addArguments("start-maximized");
        //options.addArguments("--window-size=1400,2100");
        //options.addArguments("--window-size=1920,1080");
        //options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.get("https://pcforum.hu/");
        driver.get("https://prog.hu/");
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void doLogin(){
        homePage = new HomePage(driver);

        homePage.acceptTerms();
        homePage.acceptCookies();
        homePage.selectLogin();
        homePage.typeEmail(email);
        homePage.typePassword(pw);
        homePage.submitButton();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
