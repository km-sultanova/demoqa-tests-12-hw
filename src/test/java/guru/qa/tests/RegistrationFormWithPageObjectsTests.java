package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String firstName = "first";
    String lastName = "last";
    String email = "mail@mail.com";
    String gender = "Female";
    String mobile = "7778889911";
    String date = "29 November,1992";
    String day = "29";
    String month = "November";
    String year = "1992";
    String subjects = "English";
    String hobbie1 = "Reading";
    String hobbie2 = "Music";
    String currentAddress = "address";
    String state = "NCR";
    String city = "Delhi";
    String image = "catImage.jpeg";

    @BeforeAll
    static void setUp(){
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest(){
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(mobile)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobby(hobbie1)
                .setHobby(hobbie2)
                .uploadPicture(image)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();


        registrationFormPage.checkResult("Student name", "Karina S");
        registrationFormPage.checkResult("Student email", "s");
        registrationFormPage.checkResult("Gender", "Female");


    }
}
