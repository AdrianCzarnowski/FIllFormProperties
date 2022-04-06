import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.FormPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormPopTest extends TestBase {

    private static Logger log = LoggerFactory.getLogger("FormPopTest.class");

    @Test
    public void shouldFIllFormWithSuccess() {
        driver.get(URL);
        FormPage formPage = new FormPage(driver);
        formPage.setFirstName("Jan")
                .setLastName("Nowak")
                .setEmail("jannowak@wp.pl")
                .setAge(20)
                .selectRandomGender()
                .selectRandomExperience()
                .selectRandomProfession()
                .selectContinents()
                .selectCommands()
                .setFile()
                .setSingInButton();
        assertThat(formPage.getValidationMsg(), equalTo("Form send with success"));

    }
}
