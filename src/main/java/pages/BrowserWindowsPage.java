package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BrowserWindowsPage extends BasePage {
    private static Logger log = LoggerFactory.getLogger("BrowserWindowsPage.class");

    @FindBy(css="#newBrowserWindow")
    WebElement newBrowserWindowButton;
    @FindBy(css="#newMessageWindow")
    WebElement newWindowMessage;
    @FindBy(css ="body")
    WebElement textNewWebsite;
    @FindBy(css="#newBrowserTab")
    WebElement newBrowserTabButton;
    String winHandle = driver.getWindowHandle();

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public BrowserWindowsPage newBrowserButton () {
        winHandle = driver.getWindowHandle();
        newBrowserWindowButton.click();
        return this;
    }

    public BrowserWindowsPage newWindowMessage () {
        winHandle = driver.getWindowHandle();
        newWindowMessage.click();
        return  this;
    }

    public BrowserWindowsPage text () {
        log.info(textNewWebsite.getText());
        return this;
    }
    public BrowserWindowsPage newBrowserTabButton () {
        winHandle = driver.getWindowHandle();
        newBrowserTabButton.click();
        return this;
    }
    public BrowserWindowsPage switchTo() {
        for (String s : driver.getWindowHandles()) {
            driver.switchTo().window(s);
        }
        return this;
    }
    public BrowserWindowsPage mountains() {
        TablesPage tablesPage = new TablesPage(driver);
        tablesPage.pickMountain();
        return this;
    }
    public BrowserWindowsPage close() {
        driver.close();
        driver.switchTo().window(winHandle);
        return this;
    }
}
