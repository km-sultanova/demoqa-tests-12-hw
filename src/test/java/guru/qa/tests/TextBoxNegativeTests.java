package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.docs.RandomDataGenerator;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TextBoxNegativeTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    RandomDataGenerator generator = new RandomDataGenerator();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void checkFormValidation() {
        registrationFormPage.openPage().clickSubmit();

        //$("#userForm").shouldHave(attribute("class", "was-validated"));
        registrationFormPage.checkNegativeResult("#userForm", "class", "was-validated");
    }

    @Test
    void checkPhoneNumberValidation() {
        String correctMobile = generator.getPhoneNumber();
        String inCorrectMobile = correctMobile + "0";

        registrationFormPage.openPage().setUserNumber(inCorrectMobile);

        //$("#userNumber").shouldHave(value(correctMobile));
        registrationFormPage.checkNegativeResult("#userNumber", correctMobile);
    }
}
