package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AuthorizationPage extends BasePage{

    private final By buttonLogin = By.xpath("//a[@class='nav__button-secondary btn-md btn-secondary-emphasis']");
    private final By fieldLogin = By.xpath("//input[@id='username']");
    private final By fieldPassword = By.xpath("//input[@id='password']");
    private final By btnEnter = By.xpath("//button[@type='submit']");

    public AuthorizationPage() {
        super();
    }

    public void fillFieldsLogin(String login, String password){
        WebElement fieldLoginElement = driver.findElement(fieldLogin);
        WebElement fieldPasswordElement = driver.findElement(fieldPassword);
        fieldLoginElement.click();
        fieldLoginElement.sendKeys(login);
        fieldPasswordElement.sendKeys(password);
    }

    public void pressEnter () throws InterruptedException {
        WebElement btnElement = driver.findElement(btnEnter);
        btnElement.click();
        Thread.sleep(1000);
    }

    public void clickBtnLogin(){
       WebElement buttonLoginElement = driver.findElement(buttonLogin);
       buttonLoginElement.click();
    }
}
