package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxNegativeTests {
    @BeforeAll
    static void setUp(){
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 45000;
    }

    @Test
    void checkFormValidation(){
        open("/automation-practice-form");

        Selenide.executeJavaScript("document.getElementById('fixedban').hidden = 'true'");
        executeJavaScript("$('footer').remove()");

        $("[id=submit]").click();

        // Asserts
        $("#userForm").shouldHave(attribute("class", "was-validated"));
    }

    @Test
    void checkPhoneNumberValidation(){
        String correctMobile = "7778889911";
        String inCorrectMobile = "777888991100";

        open("/automation-practice-form");

        Selenide.executeJavaScript("document.getElementById('fixedban').hidden = 'true'");
        executeJavaScript("$('footer').remove()");

        $("[id=userNumber]").setValue(inCorrectMobile);

        // Asserts
        $("#userNumber").shouldHave(value(correctMobile));
    }
}
