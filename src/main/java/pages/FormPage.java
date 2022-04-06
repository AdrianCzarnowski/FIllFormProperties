package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormPage extends  BasePage{

    private static Logger log = LoggerFactory.getLogger("FormPage.class");


    @FindBy(id = "inputFirstName3")
    private WebElement firstName;
    @FindBy(id = "inputLastName3")
    private WebElement lastName;
    @FindBy(id = "inputEmail3")
    private WebElement email;
    @FindBy(name = "gridRadiosSex")
    private List<WebElement> gender;
    @FindBy(id = "inputAge3")
    private WebElement fillAge;
    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> yearsOfExperience;
    @FindBy(name = "gridCheckboxProfession")
    private List<WebElement> profession;
    @FindBy(css = "#selectContinents")
    WebElement continents;
    @FindBy(css = "#selectSeleniumCommands > option:nth-child(3)")
    WebElement switchCommand;
    @FindBy(css = "#selectSeleniumCommands > option:nth-child(5)")
    WebElement webElementCommand;
    @FindBy(css = "input[type='file']")
    WebElement fileInput;
    @FindBy(css = "button.btn")
    WebElement singInButton;
    @FindBy(css = "#validator-message")
    WebElement validationMsg;

    Random random = new Random();
    private static final int NUMBER_OF_CONTINENTS = 7;
    public static int randomContinent = new Random().nextInt(NUMBER_OF_CONTINENTS);

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public FormPage setFirstName(String name) {
        this.firstName.sendKeys(name);
        return this;
    }

    public FormPage setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public FormPage setEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public FormPage setAge(int age) {
        fillAge.clear();
        fillAge.sendKeys(String.valueOf(age));
        return this;
    }

    public FormPage selectRandomGender() {
        getRandomGender(gender).click();
        return this;
    }

    public FormPage selectRandomExperience() {
        getRandomExperience(yearsOfExperience).click();
        return this;
    }

    public FormPage selectRandomProfession() {
        getRandomProfession(profession).click();
        return this;
    }

    public FormPage selectContinents() {
        Select cont = new Select(continents);
        if (randomContinent > 0) {
            cont.selectByIndex(randomContinent);
        }
        return this;
    }

    public FormPage selectCommands() {
        this.switchCommand.click();
        this.webElementCommand.click();
        return this;
    }

    public FormPage setFile() {
        File file = new File("src/main/resources/file.txt");
        this.fileInput.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage setSingInButton() {
        this.singInButton.click();
        return this;
    }

    private WebElement getRandomGender(List<WebElement> elements) {
        int size = elements.size();
        int randomIndexFromList = random.nextInt(size);
        return elements.get(randomIndexFromList);
    }

    private WebElement getRandomExperience(List<WebElement> elements) {
        int size = elements.size();
        int randomIndexFromList = random.nextInt(size);
        return elements.get(randomIndexFromList);
    }

    private WebElement getRandomProfession(List<WebElement> elements) {
        int size = elements.size();
        int randomIndexFromList = random.nextInt(size);
        return elements.get(randomIndexFromList);
    }

    public String getValidationMsg() {
        return validationMsg.getText();
    }


}

