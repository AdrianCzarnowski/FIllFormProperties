package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BrowserWindowsPage {
    private static Logger log = LoggerFactory.getLogger("BrowserWindowsPage.class");

    @FindBy(css="#newBrowserWindow")
    WebElement newBrowserWindowButton;
    @FindBy(css="#newMessageWindow")
    WebElement newWindowMessage;
    @FindBy(css ="body")
    WebElement textNewWebsite;
    @FindBy(css="#newBrowserTab")
    WebElement newBrowserTabButton;

    public BrowserWindowsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public BrowserWindowsPage newBrowserButton () {
        newBrowserTabButton.click();
        return this;
    }

    public BrowserWindowsPage newWindowMessage () {
        newWindowMessage.click();
        return  this;
    }

    public BrowserWindowsPage text () {
        String text = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
        assertThat(textNewWebsite.getText(), equalTo(text));
        return this;
    }
    public BrowserWindowsPage newBrowserTabButton () {
        newBrowserTabButton.click();
        return this;
    }




}
