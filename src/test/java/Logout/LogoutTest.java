package Logout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import Base.BaseTests;

@DisplayName("Kijelentkezés")
public class LogoutTest extends BaseTests {

    @Test
    @DisplayName("TC-24: Kijelentkezés")
    public void testLogout(){
        homePage = new HomePage(driver);

        doLogin();
        homePage.userLogout();
        homePage.isNickNameVisible();

        boolean expected = true;
        boolean result = homePage.isNickNameVisible();
        System.out.println(expected);
        System.out.println(result);

        Assertions.assertTrue(expected, String.valueOf(result));
    }
}
