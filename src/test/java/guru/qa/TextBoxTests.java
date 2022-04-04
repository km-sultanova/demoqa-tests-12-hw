package guru.qa;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;

import com.codeborne.selenide.Selenide;
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
        Configuration.pageLoadTimeout = 45000;
    }


    @Test
    void fillFormTest(){
        String firstName = "first";
        String lastName = "last";
        String email = "mail@mail.com";
        String mobile = "7778889911";
        String date = "29 November,1992";
        Integer month = 10;
        Integer year = 92;
        String subjects = "English";
        String currentAddress = "address";
        String state = "NCR";
        String city = "Delhi";
        String image = "catImage.jpeg";

        open("/automation-practice-form");

        Selenide.executeJavaScript("document.getElementById('fixedban').hidden = 'true'");
        executeJavaScript("$('footer').remove()");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $(by("for", "gender-radio-2")).click();
        $("[id=userNumber]").setValue(mobile);
        $("[id=subjectsInput]").setValue(subjects).pressEnter();
        $(by("for", "hobbies-checkbox-2")).click();
        $(by("for", "hobbies-checkbox-3")).click();
        $("[id=currentAddress]").setValue(currentAddress);
        File catImage = $("#uploadPicture").uploadFromClasspath(image);
        $("[id=react-select-3-input]").setValue(state).pressEnter();
        $("[id=react-select-4-input]").setValue(city).pressEnter();
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(month);
        $("[class=react-datepicker__year-select]").selectOption(year);
        $(by("aria-label", "Choose Sunday, November 29th, 1992")).click();
        $("[id=submit]").click();

        // Asserts

        $(".table-responsive").shouldHave(text("Student Name	" + firstName + " " + lastName),
                text("Mobile " + mobile), text("Picture	" + image), text("Student Email " + email),
                text("Gender Female"), text("Date of Birth " + date), text("Subjects " + subjects),
                text("Hobbies Reading, Music"), text("Address " + currentAddress), text("State and City " + state + " " + city));
    }
}
