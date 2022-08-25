package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Collections;
import java.util.List;

public class SearchPositionsPage extends BasePage {

    private final By searchField = By.xpath("(//span[contains(@class,'jobs-home-soho-search-card__truncated-text t-14')])[1]");
    private final By btnVacancies = By.xpath("//a[@href='https://www.linkedin.com/jobs/?']");

    private final By searchElementsOfPosition = By.xpath("//div[contains(@class,'full-width artdeco-entity-lockup__title')]//a");
    List<String> allSearchFinalResult;

    private final By btnSubmitPosition = By.xpath("(//span[@class='artdeco-button__text'])[4]");

    public SearchPositionsPage() {
        super();
    }

    public void goToSearch() {
        WebElement btnVcnElement = driver.findElement(searchField);
        btnVcnElement.click();
    }

    public void clickBtnVacancies() throws InterruptedException {
        WebElement btnVcnElement = driver.findElement(btnVacancies);
        btnVcnElement.isDisplayed();
        btnVcnElement.click();
        Thread.sleep(100);
    }

    public void checkThatResultsContainsText(String position) {
        WebElement allElements = driver.findElement(searchElementsOfPosition);
        Assertions.assertThat(allElements.getText()).as("Didn`t find elements").containsIgnoringCase(position);
        List<WebElement> AllSearchResults = driver.findElements(searchElementsOfPosition);
        for (WebElement eachAnchorElem : AllSearchResults) {
            String link = eachAnchorElem.getAttribute("href");
            System.out.println(link);
            allSearchFinalResult = Collections.singletonList(link);
        }
        System.out.println("Founded Elements " + AllSearchResults.size());
    }

    public void goToEachLinkVacanciesAndSendCV(){
        WebElement btnSubmitElement = driver.findElement(btnSubmitPosition);
        for (int i = 0; i < allSearchFinalResult.size(); i++) {
            driver.navigate().to(allSearchFinalResult.get(i));
            btnSubmitElement.click();
        }
    }

}
