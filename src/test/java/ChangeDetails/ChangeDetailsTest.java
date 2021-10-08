package ChangeDetails;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountOptions;
import pages.AccountOptionsPersonal;
import pages.HomePage;
import Base.BaseTests;

@DisplayName("Meglévő adat módosítás")
public class ChangeDetailsTest extends BaseTests {

    @Test
    @DisplayName("TC-21: Meglévő adat módosítása; Profil szerkesztése")
    public void testingChanges() throws InterruptedException {
        homePage = new HomePage(driver);
        accountOptions = new AccountOptions(driver);
        accountOptionsPersonal = new AccountOptionsPersonal(driver);

        doLogin();
        homePage.selectOptions();
        accountOptions.clickOnPersonal();
        accountOptionsPersonal.changeComment();
        accountOptionsPersonal.submitChanges();

        String expected = "Automatizált teszteket írok";
        String result = accountOptionsPersonal.validateChanges();

        System.out.println(result);

        Assertions.assertNotEquals(expected,result);
    }
}
