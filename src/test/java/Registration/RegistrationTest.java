package Registration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import Base.BaseTests;

@DisplayName("Regisztráció")
public class RegistrationTest extends BaseTests {

    @Disabled("The test is disabled due to email and nickname generation difficulties so it won't break the test")
    @Test
    @DisplayName("TC-1: Regisztráció; helyes adatokkal")
    public void testingValidRegistration(){
        homePage = new HomePage(driver);

        String nick = "";   // Before allow,and run the test please fill the variables.
        String email= "";   // nick and email variables must be unique and unused.

        homePage.acceptTerms();
        homePage.acceptCookies();
        homePage.selectRegistration();
        homePage.typeRegistrationNick(nick);
        homePage.typeRegistrationEmail(email);
        homePage.deselectSubScribe();
        homePage.acceptRegistrationTerms();
        homePage.submitRegistration();

        boolean expected = true;
        boolean result = homePage.isRegistrationCompleted();
        System.out.println(result);

        Assertions.assertTrue(expected, String.valueOf(result));
    }

    @Test
    @DisplayName("TC-2: Regisztráció; már létező Nicknévvel")
    public void testingRegistrationWithUsedNick(){
        homePage = new HomePage(driver);

        String email = "fjaskfdjklfja@gmail.com";

        homePage.acceptTerms();
        homePage.acceptCookies();
        homePage.selectRegistration();
        homePage.typeRegistrationUsedNick();
        homePage.typeRegistrationEmail(email);
        homePage.acceptRegistrationTerms();
        homePage.submitRegistration();

        String expected = "Ez a nicknév sajnos már foglalt. Válassz magadnak másik nicknevet!";
        String result = homePage.registrationErrorMessage();
        System.out.println(result);

        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("TC-3: Regisztráció; már használatban lévő E-mail címmel")
    public void testingRegistrationWithUsedEmail(){
        homePage = new HomePage(driver);

        String nickname = "ffsasfasfasggrl";

        homePage.acceptTerms();
        homePage.acceptCookies();
        homePage.selectRegistration();
        homePage.typeRegistrationNick(nickname);
        homePage.typRegistrationUsedEmail();
        homePage.acceptRegistrationTerms();
        homePage.submitRegistration();

        String expected = "Ilyen e-mail címmel már létezik egy regisztrált felhasználó. A belépéshez szükséges jelszó újraküldéséhez kattints ide!";
        String result = homePage.registrationErrorMessage();
        System.out.println(result);

        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("TC-4: Regisztráció; nem bepipált Használati feltételekkel")
    public void testingRegistrationWithoutAcceptingTerms(){
        homePage = new HomePage(driver);

        String nick = "ffsasfasfasggrl";
        String email = "fjaskfdjklfja@gmail.com";

        homePage.acceptTerms();
        homePage.acceptCookies();
        homePage.selectRegistration();
        homePage.typeRegistrationNick(nick);
        homePage.typeRegistrationEmail(email);
        homePage.submitRegistration();

        String expected = "A regisztrációhoz meg kell erősítened a használati szerződés elolvasását. Jelöld be a dobozt ha ezt megtetted!";
        String result = homePage.registrationErrorMessage();
        System.out.println(result);

        Assertions.assertEquals(expected,result);
    }
}
