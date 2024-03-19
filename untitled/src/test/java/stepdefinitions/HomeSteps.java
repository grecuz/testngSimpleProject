package stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeSteps {

    WebDriver driver;

    @BeforeSuite
    void setupChromeDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void goToWomenSection(){

        String womenSection = "#header > div > div > div > nav > a:nth-child(1)";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = driver.findElement(By.cssSelector(womenSection));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    @Test(priority = 1)
    public void iOpenSite() {

        driver.get("https://www.debugbear.com/test/website-speed");
    }

    @AfterSuite
    public void after(){
        driver.quit();
    }
}
