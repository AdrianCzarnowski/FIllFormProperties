import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.TablesPage;




public class TablesTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger("TablesTest.class");

    @Test
    public void mountainsInSwitzerland() {
        driver.get("https://seleniumui.moderntester.pl/table.php");
        TablesPage tablesPage = new TablesPage(driver);
                   tablesPage.pickMountain();
        }
    }

