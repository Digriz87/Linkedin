package tests;

import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.SearchPositionsPage;

public class CommonTest extends BaseTest {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    SearchPositionsPage searchPositionsPage = new SearchPositionsPage();

    @Test(dataProvider = "dataProvider")
    public void openLinkedInAndLogin(String login, String password) throws InterruptedException{
        authorizationPage.clickBtnLogin();
        authorizationPage.fillFieldsLogin(login, password);
        authorizationPage.pressEnter();

    }

    @Test(dataProvider = "dataForSearchPosition")
    public void searchPosition(String position) throws InterruptedException{
        searchPositionsPage.clickBtnVacancies();
        searchPositionsPage.goToSearch();
        searchPositionsPage.checkThatResultsContainsText(position);
    }

    @Test
    public void goToUrlAndClickSubmitCV(){
        searchPositionsPage.goToEachLinkVacanciesAndSendCV();
    }

}
