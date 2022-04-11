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
    String day = "29";
    String month = "November";
    String year = "1992";
    String subjects = "English";
    String hobby1 = "Reading";
    String hobby2 = "Music";
    String currentAddress = "address";
    String state = "NCR";
    String city = "Delhi";
    String image = "catImage.jpeg";

    //table
    String tableFirstColumnName = "Label";
    String tableSecondColumnName = "Values";
    String tableStudentName = "Student Name";
    String tableEmail = "Student Email";
    String tableGender = "Gender";
    String tableMobile = "Mobile";
    String tableDateOfBirth = "Date of Birth";
    String tableSubjects = "Subjects";
    String tableHobbies = "Hobbies";
    String tablePicture = "Picture";
    String tableAddress = "Address";
    String tableStateAndCity = "State and City";

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
                .setHobby(hobby1)
                .setHobby(hobby2)
                .uploadPicture(image)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationFormPage
                .checkResult(tableFirstColumnName, tableSecondColumnName)
                .checkResult(tableStudentName, firstName + " " + lastName)
                .checkResult(tableEmail, email)
                .checkResult(tableGender, gender)
                .checkResult(tableMobile, mobile)
                .checkResult(tableDateOfBirth, day + " " + month + "," + year)
                .checkResult(tableSubjects, subjects)
                .checkResult(tableHobbies, hobby1 + ", " + hobby2)
                .checkResult(tablePicture, image)
                .checkResult(tableAddress, currentAddress)
                .checkResult(tableStateAndCity, state + " " + city);

    }
}
