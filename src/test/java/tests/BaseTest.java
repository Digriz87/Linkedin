package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.time.Duration;

public abstract class BaseTest {
    public static WebDriver driver;
    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp(){
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/home");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name="dataProvider")
    public Object[][] dataProviderMethod(){
        return new  Object [][] {{"test@gmail.com","test"}};
    }

    @DataProvider(name="dataForSearchPosition")
    public Object[][] dataForSearchPosition(){
        return new  Object [][] {{"QA"}};
    }
}
