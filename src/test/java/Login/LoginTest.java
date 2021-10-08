package Login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import Base.BaseTests;

@DisplayName("Bejelentkezés")
public class LoginTest extends BaseTests {

    @Test
    @DisplayName("TC-5: Bejelentkezés; helyes adatokkal")
    public void testLogin(){
        homePage = new HomePage(driver);

        homePage.acceptTerms();
        homePage.acceptCookies();
        homePage.selectLogin();
        homePage.typeEmail(email);
        homePage.typePassword(pw);
        homePage.submitButton();
        homePage.getLoggedInText();
        String expected = "dancas";
        String result = homePage.getLoggedInText();
        System.out.println(expected);
        System.out.println(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("TC-6: Bejelentkezés; üres e-mail cím mezővel")
    public void testLoginEmptyEmail(){
        homePage = new HomePage(driver);

        String emptyEmail = " ";
        homePage.acceptTerms();
        homePage.acceptCookies();
        homePage.selectLogin();
        homePage.typeEmail(emptyEmail);
        homePage.typePassword(pw);
        homePage.submitButton();
        homePage.wrongDatas();
        String expected = "Hibás e-mail cím vagy jelszó!";
        String result = homePage.wrongDatas();
        System.out.println(expected);
        System.out.println(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("TC-7: Bejelentkezés; üres jelszó mezővel")
    public void testLoginEmptyPassword(){
        homePage = new HomePage(driver);

        String emptyPassword = " ";
        homePage.acceptTerms();
        homePage.acceptCookies();
        homePage.selectLogin();
        homePage.typeEmail(email);
        homePage.typePassword(emptyPassword);
        homePage.submitButton();
        homePage.wrongDatas();
        String expected = "Hibás e-mail cím vagy jelszó!";
        String result = homePage.wrongDatas();
        System.out.println(expected);
        System.out.println(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("TC-8: Bejelentkezés; rossz e-mail címmel")
    public void testLoginWrongEmail(){
        homePage = new HomePage(driver);

        String wrongEmail = "dani@gmail.com";
        homePage.acceptTerms();
        homePage.acceptCookies();
        homePage.selectLogin();
        homePage.typeEmail(wrongEmail);
        homePage.typePassword(pw);
        homePage.submitButton();
        homePage.wrongDatas();
        String expected = "Hibás e-mail cím vagy jelszó!";
        String result = homePage.wrongDatas();
        System.out.println(expected);
        System.out.println(result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("TC-9: Bejelenetkezés; rossz jelszóval")
    public void testLoginWrongPassword(){
        homePage = new HomePage(driver);

        String wrongpw = "87654321";
        homePage.acceptTerms();
        homePage.acceptCookies();
        homePage.selectLogin();
        homePage.typeEmail(email);
        homePage.typePassword(wrongpw);
        homePage.submitButton();
        homePage.wrongDatas();
        String expected = "Hibás e-mail cím vagy jelszó!";
        String result = homePage.wrongDatas();
        System.out.println(expected);
        System.out.println(result);
        Assertions.assertEquals(expected, result);
    }
}
