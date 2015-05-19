package TestNGpackage;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSnippet {

    public static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void testSelenium() {

        driver.get("http://google.com");

        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        // alternatively WebElement searchField = driver.findElement(By.name("q"));

        searchField.sendKeys("Grid Dynamics");

        WebElement btn = driver.findElement(By.name("btnG"));
        btn.click();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        List<WebElement> snips = driver.findElements(By.xpath("//h3[@class='r']/a"));

        for (WebElement snip: snips) {
            assertTrue(StringUtils.containsIgnoreCase(snip.getText(), "grid dynamics"));
        }
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
