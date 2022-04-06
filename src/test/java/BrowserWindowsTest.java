import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BrowserWindowsPage;

public class BrowserWindowsTest extends TestBase{

    private static Logger log = LoggerFactory.getLogger("FormPopTest.class");

    @Test
    public void windowsBrowser(){
        driver.get("https://seleniumui.moderntester.pl/windows-tabs.php");

        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
        browserWindowsPage
                .newBrowserButton()
                .switchTo()
                .mountains()
                .close()
                .newWindowMessage()
                .switchTo()
                .text()
                .close()
                .newBrowserTabButton()
                .switchTo()
                .mountains()
                .close();
    }
}
