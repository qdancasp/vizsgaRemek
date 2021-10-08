package PrivacyAndPolicy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import Base.BaseTests;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Adatkezelési nyilatkozat használata")
public class PrivacyAndPolicyTest extends BaseTests {

    @Disabled("Test is disabled because it doesn't run on github's servers with any settings. It requires to run on your own computer")
    @Test
    @DisplayName("TC-10: Adatkezelési nyilatkozat használata")
    public void testPrivacyTitles(){
        homePage = new HomePage(driver);

        homePage.termsOptions();

        List<String> expected = new ArrayList<>();
        expected.add("Az eszközön tárolt információk tárolása és/vagy elérése");
        expected.add("Alapvető hirdetések kiválasztása");
        expected.add("Személyre szabott hirdetési profil létrehozása");
        expected.add("Személyre szabott hirdetések kiválasztása");
        expected.add("Személyre szabott tartalomprofil létrehozása");
        expected.add("Személyre szabott tartalom kiválasztása");
        expected.add("A hirdetés teljesítményének mérése");
        expected.add("A tartalom teljesítményének mérése");
        expected.add("Piackutatás alkalmazása nézettségi adatok generálásához");
        expected.add("Termékek fejlesztése és javítása");
        expected.add("Biztonság, csalás megelőzése és hibakeresés biztosítása");
        expected.add("Hirdetés vagy tartalom technikai szolgáltatása");
        expected.add("Offline adatforrások egyeztetése és összevonása");
        expected.add("Különböző eszközök összekapcsolása");
        expected.add("Az automatikusan elküldött eszközjellemzők fogadása és felhasználása az azonosításhoz");
        expected.add("Pontos geolokációs adatok felhasználása");
        List<String> result = homePage.getTermsTitles();

        homePage.acceptAllTerms();

        System.out.println(expected);
        System.out.println(result);

        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("TC-11: Adatkezelési nyilatkozat használata; Sütik elfogadása")
    public void testAcceptCookies(){
        homePage = new HomePage(driver);

        homePage.acceptTerms();
        homePage.acceptCookies();

        boolean expected = false;
        boolean result = homePage.isCookieContentVisible();
        System.out.println(expected);
        System.out.println(result);

        Assertions.assertFalse(expected, String.valueOf(result));
    }
}
