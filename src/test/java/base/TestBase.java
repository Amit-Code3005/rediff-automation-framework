package base;

import listeners.UnifiedListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TestBase {

    public static WebDriver driver;

    @BeforeClass
    public void setup() {

        WebDriver original = new ChromeDriver();

        driver = new EventFiringDecorator(new UnifiedListener())
                .decorate(original);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.rediff.com");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
