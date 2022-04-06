import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class TablesTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger("TablesTest.class");

    @Test
    public void mountainsInSwitzerland() {
        driver.get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

        for (WebElement row : rows){

            int height = Integer.parseInt(row.findElement(By.xpath("./td[4]")).getText());
            String state = row.findElement(By.xpath("./td[3]")).getText();

            if (height >4000 && state.contains("Switzerland")) {
                List<WebElement> cols = row.findElements(By.cssSelector("td"));
                List<WebElement> cols1 = row.findElements(By.cssSelector("th"));
                List<WebElement> range = row.findElements(By.cssSelector("td:nth-child(3)"));
                log.info("Rank: " + cols1.get(0).getText() + " <<Peak: " + cols.get(0).getText() + " <<Mountain rage: " + range.get(0).getText());
            }

        }
    }
}
