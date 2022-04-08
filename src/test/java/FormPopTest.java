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
        FormPage formPage = new FormPage(driver);

        formPage.setFirstName(System.getProperty("firstName"))
                .setLastName(System.getProperty("lastName"))
                .setEmail(System.getProperty("email"))
                .setAge(Integer.parseInt(System.getProperty("age")))
                .selectRandomGender()
                .selectRandomExperience()
                .selectRandomProfession()
                .selectContinents()
                .selectCommands()
                .setFile()
                .setSingInButton();
        assertThat(formPage.getValidationMsg(), equalTo(System.getProperty("message")));

    }
}
