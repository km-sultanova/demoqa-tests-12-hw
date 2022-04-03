package guru.qa;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selectors.by;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void setUp(){
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillFormTest(){
        String firstName = "first";
        String lastName = "last";
        String email = "mail@mail.com";
        String mobile = "7778889911";
        Integer month = 10;
        Integer year = 92;
        String subjects = "subject";
        String currentAddress = "address";
        String state = "NCR";
        String city = "Delhi";

        open("/automation-practice-form");

        System.out.println("before selector");
        Selenide.executeJavaScript("document.getElementById('fixedban').hidden = 'true'");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $(by("for", "gender-radio-2")).click();
        $("[id=userNumber]").setValue(mobile);

        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(month);
        $("[class=react-datepicker__year-select]").selectOption(year);
        $(by("aria-label", "Choose Sunday, November 29th, 1992")).click();
        $("[id=subjectsInput]").setValue(subjects).pressEnter();
        $(by("for", "hobbies-checkbox-2")).click();
        $(by("for", "hobbies-checkbox-3")).click();
        $("[id=currentAddress]").setValue(currentAddress);
        File catImage = $("#uploadPicture").uploadFromClasspath("catImage.jpeg");

        $("[id=react-select-3-input]").setValue(state).pressEnter();
        $("[id=react-select-4-input]").setValue(city).pressEnter();

        $("[id=submit]").click();

        System.out.println("after selector");
    }
}
