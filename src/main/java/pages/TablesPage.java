package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TablesPage {
    private static Logger log = LoggerFactory.getLogger("TablesPage.class");

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;
//    @FindBy(xpath = "./td[4]")
//    WebElement height;
//    @FindBy(xpath = "./td[3]")
//    WebElement state;
//    @FindBy(xpath = "td")
//    WebElement rank;

    public TablesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public TablesPage pickMountain() {
        for (WebElement row : rows) {

            int height = Integer.parseInt(row.findElement(By.xpath("./td[4]")).getText());
            String state = row.findElement(By.xpath("./td[3]")).getText();

            if (height >4000 && state.contains("Switzerland")) {
                List<WebElement> ranks = row.findElements(By.cssSelector("th"));
                List<WebElement> peaks = row.findElements(By.cssSelector("td"));
                List<WebElement> ranges = row.findElements(By.cssSelector("td:nth-child(3)"));
                log.info("Rank: " + ranks.get(0).getText() + " <<Peak: " + peaks.get(0).getText() + " <<Mountain rage: " + ranges.get(0).getText());
            }
        }
        return this;
    }
}

