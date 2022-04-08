import configuration.BrowserEnvironment;
import configuration.EnvironmentProperty;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    private static Logger log = LoggerFactory.getLogger("TestBase.class");
    protected static WebDriver driver;
    private static BrowserEnvironment browserEnvironment;
    private static EnvironmentProperty environmentProperty;


    @BeforeAll
    static void beforeAll() {
        environmentProperty = EnvironmentProperty.getInstance();
        browserEnvironment = new BrowserEnvironment();
        driver = browserEnvironment.getDriver();
    }

    @AfterAll
    static void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        log.debug("<<<<<<<<<<<<<<Driver CLOSE<<<<<<<<<<<<<<<<");
    }
}




