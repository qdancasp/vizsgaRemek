package NewDataWithSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.SearchNews;
import Base.BaseTests;

@DisplayName("Új adat bevitel")
public class NewDataWithSearchTest extends BaseTests {

    @Test
    @DisplayName("TC-18: Új adat bevitel; Keresés helyének validálásával")
    public void testSearch(){
        homePage = new HomePage(driver);
        searchNews = new SearchNews(driver);

        doLogin();
        homePage.searchBar(searchKeyword);

        boolean expected = true;
        boolean result = searchNews.validateSearch();
        System.out.println(expected);
        System.out.println(result);

        Assertions.assertTrue(expected, String.valueOf(result));
    }

    @Test
    @DisplayName("TC-19: Új adat bevitel; Invalid keresési hely validálásával")
    public void testWrongSearch(){
        homePage = new HomePage(driver);
        searchNews = new SearchNews(driver);

        doLogin();
        homePage.searchBar(searchKeyword);

        boolean expected = false;
        boolean result = searchNews.falseSearch();
        System.out.println(expected);
        System.out.println(result);

        Assertions.assertFalse(expected, String.valueOf(result));
    }
}
