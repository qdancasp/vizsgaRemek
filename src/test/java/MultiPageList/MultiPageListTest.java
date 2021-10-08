package MultiPageList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.JavaNewsPage;
import pages.JavaPage;
import Base.BaseTests;

@DisplayName("Több oldalas lista bejárása ")
public class MultiPageListTest extends BaseTests {

    @Test
    @DisplayName("TC-17: Több oldalas lista bejárása")
    public void multiPageTest(){
        homePage = new HomePage(driver);
        javaPage = new JavaPage(driver);
        javaNewsPage = new JavaNewsPage(driver);

        doLogin();
        homePage.selectJava();
        javaPage.clickOnNews();
        javaNewsPage.loopThroughPages();
        javaNewsPage.isNextButtonVisible();

        boolean expected = true;
        boolean result = javaNewsPage.isNextButtonVisible();
        System.out.println(expected);
        System.out.println(result);

        Assertions.assertTrue(expected, String.valueOf(result));
    }
}
