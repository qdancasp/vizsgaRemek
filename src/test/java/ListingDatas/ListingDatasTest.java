package ListingDatas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;
import Base.BaseTests;

@DisplayName("Adatok listázása")
public class ListingDatasTest extends BaseTests {

    @Test
    @DisplayName("TC-12: Adatok listázása; Hírek")
    public void listingNews(){
        homePage = new HomePage(driver);
        newsList = new NewsList(driver);

        doLogin();
        homePage.selectNewsFromMenu();

        boolean expected = true;
        boolean result = newsList.isNewsTitlePresent();
        System.out.println(expected);
        System.out.println(result);

        Assertions.assertTrue(expected, String.valueOf(result));
    }

    @Test
    @DisplayName("TC-13: Adatok listázása; Videók")
    public void listingVideos(){
        homePage = new HomePage(driver);
        videoList = new VideoList(driver);

        doLogin();
        homePage.selectVideoFromMenu();

        boolean expected = true;
        boolean result = videoList.isVideoTitlePresent();
        System.out.println(expected);
        System.out.println(result);

        Assertions.assertTrue(expected, String.valueOf(result));
    }

    @Test
    @DisplayName("TC-14: Adatok listázása; Társalgó")
    public void listingForum(){
        homePage = new HomePage(driver);
        forumList = new ForumList(driver);

        doLogin();
        homePage.selectForumFromMenu();

        boolean expected = true;
        boolean result = forumList.isForumTitlePresent();
        System.out.println(expected);
        System.out.println(result);

        Assertions.assertTrue(expected, String.valueOf(result));
    }

    @Test
    @DisplayName("TC-15: Adatok listázása; Tudástár")
    public void listingKnowledgeBase(){
        homePage = new HomePage(driver);
        knowledgeList = new KnowledgeList(driver);

        doLogin();
        homePage.selectKnowledgeBaseFromMenu();

        String expected = "Tudástár";
        String result = knowledgeList.getKnowledgeTitle();
        System.out.println(expected);
        System.out.println(result);

        Assertions.assertEquals(expected,result);
    }

    @Test
    @DisplayName("TC-16: Adatok listázása; Cikkek")
    public void listingArticles(){
        homePage = new HomePage(driver);
        articleList = new ArticleList(driver);

        doLogin();
        homePage.selectArticlesFromMenu();

        String expected = "Cikkek";
        String result = articleList.getArticleTitle();
        System.out.println(expected);
        System.out.println(result);

        Assertions.assertEquals(expected,result);
    }
}
