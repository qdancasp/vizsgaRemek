package SaveToTxt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.JavaPage;
import pages.JavaVideoPage;
import Base.BaseTests;
import java.io.IOException;

@DisplayName("Adatok lementése felületről ")
public class SaveToTxtTest extends BaseTests {

    @Test
    @DisplayName("TC-23: Adatok lementése felületről; Elérhető videók listázása")
    public void saveToTxtTest() throws IOException {
        homePage = new HomePage(driver);
        javaPage = new JavaPage(driver);
        javaVideoPage = new JavaVideoPage(driver);

        doLogin();
        homePage.selectJava();
        javaPage.clickOnVideo();
        javaVideoPage.writeTitlesToFile();

        String expected = "LadyJava Music Video for JavaZone (High quality)\n" +
                "Amit minden fejlesztőnek tudnia kell a JVM-alapú nyelvekről\n" +
                "Íme a bizonyíték: bugos a Java rendezőeljárása\n" +
                "Java és Python klienskönyvtárat adott ki a Maps API-khoz a Google\n" +
                "A Java 8 újdonságai a nyelvben és a standard könyvtárakban\n" +
                "Kisebb és gyorsabb lett a Scala legújabb verziója\n" +
                "JBoss Developer Studio 7: jQuery Mobile\n" +
                "JavaFX in NetBeans 7.4 Beta\n" +
                "JavaZone 2013: Javapocalypse\n" +
                "Introducing CodeSpells\n" +
                "Quick Intro to Collide: Google's Collaborative IDE\n" +
                "mysql.com hacked to serve malware: video report to accompany blog post\n" +
                "Visual COBOL R3 Launch Video\n" +
                "Code Bubbles: Rethinking the User Interface Paradigm of Integrated Development Environments\n" +
                "Speed Tracer Tutorial\n" +
                "Google Web Toolkit 2.0 New Features";
        String result = javaVideoPage.readTitlesFile();

        System.out.println(expected+"\n");
        System.out.println(result);

        Assertions.assertEquals(expected,result);
    }
}
