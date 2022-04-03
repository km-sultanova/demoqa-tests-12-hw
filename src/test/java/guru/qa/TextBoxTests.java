package guru.qa;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selectors.by;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.visible;
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
        String date = "04 Apr 1992";
        Integer month = 10;
        Integer year = 92;
        String subjects = "subject";
        String currentAddress = "address";

        open("/automation-practice-form");

        System.out.println("before selector");
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $(by("for", "gender-radio-2")).click();
        $("[id=userNumber]").setValue(mobile);


        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__month-select]").selectOption(month);
        $("[class=react-datepicker__year-select]").selectOption(year);
        $(by("aria-label", "Choose Sunday, November 29th, 1992")).click();
        System.out.println("after selector");


//        $("[id=subjectsInput]").setValue(subjects);
//        $("[id=subjectsInput]").setValue(subjects);
//        $("[id=hobbies-checkbox-2]").click();
//        $("[id=hobbies-checkbox-3]").click();
//        $("[id=currentAddress]").setValue(currentAddress);
    }
}
