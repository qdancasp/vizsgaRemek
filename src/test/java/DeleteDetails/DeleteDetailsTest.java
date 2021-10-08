package DeleteDetails;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountOptions;
import pages.AccountOptionsPersonal;
import pages.HomePage;
import Base.BaseTests;

@DisplayName("Adat vagy adatok törlése")
public class DeleteDetailsTest extends BaseTests {

    @Test
    @DisplayName("TC-22: Adatok törlése; Profil adatainak törlése")
    public void testRemovingDetails() throws InterruptedException {
        homePage = new HomePage(driver);
        accountOptions = new AccountOptions(driver);
        accountOptionsPersonal = new AccountOptionsPersonal(driver);

        doLogin();
        homePage.selectOptions();
        accountOptions.clickOnPersonal();
        accountOptionsPersonal.removeFamilyName();
        accountOptionsPersonal.removeFirstName();
        accountOptionsPersonal.removeComment();
        accountOptionsPersonal.removeAddress();
        accountOptionsPersonal.acceptGoogle();
        accountOptionsPersonal.submitChanges();

        String expected = "";
        String actual = accountOptionsPersonal.getRemovedFieldName();
        System.out.println(actual);

        Assertions.assertEquals(expected,actual);
    }
}
