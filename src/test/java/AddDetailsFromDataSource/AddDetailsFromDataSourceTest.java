package AddDetailsFromDataSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AccountOptions;
import pages.AccountOptionsPersonal;
import pages.HomePage;
import Base.BaseTests;

@DisplayName("Ismételt és sorozatos adatbevitel adatforrásból")
public class AddDetailsFromDataSourceTest extends BaseTests {

    @Test
    @DisplayName("TC-20: Ismételt és sorozatos adatbevitel adatforrásból; Profil kitöltése")
    public void testAddingDetails() throws InterruptedException {
        homePage = new HomePage(driver);
        accountOptions = new AccountOptions(driver);
        accountOptionsPersonal = new AccountOptionsPersonal(driver);

        doLogin();
        homePage.selectOptions();
        accountOptions.clickOnPersonal();
        accountOptionsPersonal.addFamilyName(FaName);
        accountOptionsPersonal.addFirstName(FiName);
        accountOptionsPersonal.addComment(CommentText);
        accountOptionsPersonal.addAddress(MyAddress);
        accountOptionsPersonal.acceptGoogle();
        accountOptionsPersonal.submitChanges();

        String expected = "Mátyási";
        String result = accountOptionsPersonal.getFieldName();
        System.out.println(expected);
        System.out.println(result);

        Assertions.assertEquals(expected,result);
    }
}
